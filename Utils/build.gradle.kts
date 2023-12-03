plugins {
    alias(libs.plugins.kotlin.default)
    alias(libs.plugins.kotlin.plugin.allopen)
    alias(libs.plugins.kotlinx.benchmark)
}

group = "advent.of.code.utils"

kotlin {
    explicitApi()
}

dependencies {
    implementation(libs.kotlinx.benchmark)
}

allOpen {
    annotations("org.openjdk.jmh.annotations.State")
}