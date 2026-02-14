import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
}

subprojects {
    repositories {
        mavenCentral()
        google()
        maven("https://us-central1-maven.pkg.dev/varabyte-repos/public")
    }
}

abstract class ConfigureYarnResolutionsTask : DefaultTask() {
    @get:InputFile
    abstract val packageJsonFile: RegularFileProperty

    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    @TaskAction
    fun configure() {
        val file = packageJsonFile.get().asFile
        if (file.exists()) {
            val text = file.readText()
            val updatedText = text.replace(
                "\"resolutions\": {}",
                """
                "resolutions": {
                    "glob": "^11.0.0",
                    "rimraf": "^6.0.1",
                    "**/glob": "^11.0.0",
                    "**/rimraf": "^6.0.1"
                }
                """.trimIndent()
            )
            outputFile.get().asFile.writeText(updatedText)
        }
    }
}

gradle.projectsEvaluated {
    tasks.register<ConfigureYarnResolutionsTask>("configureYarnResolutions") {
        dependsOn("rootPackageJson")
        val pkgJsonFile = layout.buildDirectory.file("js/package.json")
        packageJsonFile.set(pkgJsonFile)
        outputFile.set(pkgJsonFile)
    }

    tasks.matching { it.name == "kotlinNpmInstall" }.configureEach {
        dependsOn("configureYarnResolutions")
    }
}
