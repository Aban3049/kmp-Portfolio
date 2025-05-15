import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.compose.reload.ComposeHotRun
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    id("org.jetbrains.compose.hot-reload") version "1.0.0-alpha09"
}

kotlin {
    jvm("desktop")

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        moduleName = "composeApp"
        browser {
            val rootDirPath = project.rootDir.path
            val projectDirPath = project.projectDir.path
            commonWebpackConfig {
                outputFileName = "composeApp.js"
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
                    static = (static ?: mutableListOf()).apply {
                        // Serve sources to debug inside browser
                        add(rootDirPath)
                        add(projectDirPath)
                    }
                }
            }
        }
        binaries.executable()
    }

    sourceSets {
        val desktopMain by getting
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation("network.chaintech:sdp-ssp-compose-multiplatform:1.0.6")
            implementation(libs.material.icons.core)
            implementation(libs.material.icons.extended)
        }
        desktopMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutines.swing)
        }


    }
}

tasks.register<Copy>("copyWasmArtifacts") {
    dependsOn("wasmJsBrowserDistribution")

    from(layout.buildDirectory.dir("dist/wasmJs/productionExecutable"))
    into(layout.projectDirectory.dir("site"))
}


compose.desktop {
    application {
        mainClass = "com.abanapps.abanportfolio.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.abanapps.abanportfolio"
            packageVersion = "1.0.0"
        }
    }
}

composeCompiler {
    featureFlags.add(ComposeFeatureFlag.OptimizeNonSkippingGroups)
}

tasks.withType<ComposeHotRun>().configureEach {
    mainClass.set("com.abanapps.abanportfolio.MainKt")
}

