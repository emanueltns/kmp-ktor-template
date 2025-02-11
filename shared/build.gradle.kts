import com.android.tools.r8.internal.kt
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import java.util.Properties
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.sqlDelight)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            api(libs.kotlin.serialization)
            api(libs.kotlinx.datetime)

            api(libs.ktor.client.core)
            api(libs.ktor.resources)
            api(libs.ktor.content.negotiation)
            api(libs.ktor.json.serialization)
            api(libs.ktor.logging)

            api(libs.koin.core)

            api(libs.sqldelight.runtime)
            api(libs.sqldelight.coroutines.extensions)


            //Date time format for both iOS and Android
            //https://github.com/RaedGhazal/kotlinx-datetime-ext
            api(libs.kotlinx.datetime.ext)

            //Key value storage for both iOS and Android
            //https://github.com/russhwolf/multiplatform-settings
            api(libs.multiplatform.settings.no.arg)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
            implementation(libs.androidx.core.ktx)
            implementation(libs.appauth)
            implementation(libs.sql.delight.android.driver)
            implementation(libs.koin.android)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.drawin)
            implementation(libs.sql.delight.native.driver)
        }
    }
}

android {
    namespace = "ai.freeapp.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
