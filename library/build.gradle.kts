import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
    alias(libs.plugins.kotlinCocoapods)
}

kotlin {
    val xcframeworkName = "Uptime"
    val xcf = XCFramework(xcframeworkName)

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            baseName = xcframeworkName

            binaryOption("bundleId", "dev.vladimirj.${xcframeworkName}")
            xcf.add(this)
            isStatic = true
        }
    }

    cocoapods {
        summary = "Uptime library for Apple targets"
        homepage = "https://github.com/LinkedInLearning/kotlin-multiplatform-libraries-5950102"

        version = "1.0.0"
        ios.deploymentTarget = "14.1"

        name = "Uptime"

        framework {
            baseName = "Uptime"
            isStatic = true
        }
    }

    jvm()
    androidTarget {
        publishLibraryVariants("release")
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    sourceSets {
        val androidUnitTest by getting {
            dependencies {
                implementation(libs.robolectric)
            }
        }

        val androidInstrumentedTest by getting {
            dependencies {
                implementation(libs.junit)
                implementation(libs.androidx.junit.ktx)
                implementation(libs.androidx.runner)
                implementation(libs.androidx.rules)
            }
        }

        val commonMain by getting {
            dependencies {

            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        val wasmJsMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
            }
        }
        val wasmJsTest by getting
    }
}

android {
    namespace = "dev.vladimirj.kmplib"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates(
        "dev.vladimirj",
        "uptime",
        "1.0.0"
    )

    pom {
        name = "Uptime library"
        description = "Uptime library provides a cross-platform function to retrieve the system's uptime in seconds."
        inceptionYear = "2025"
        url = "https://github.com/LinkedInLearning/kotlin-multiplatform-libraries-5950102"
        licenses {
            license {
                name = "The Apache License, Version 2.0"
                url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
            }
        }
        developers {
            developer {
                id = "VladimirWrites"
                name = "Vladimir Jovanovic"
                url = "https://vladimirj.dev"
            }
        }
        scm {
            url = "https://github.com/LinkedInLearning/kotlin-multiplatform-libraries-5950102"
        }
    }
}
