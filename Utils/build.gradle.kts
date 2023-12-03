plugins {
    alias(libs.plugins.kotlin.default)
    alias(libs.plugins.kotlinx.benchmark)
}

group = "advent.of.code.utils"

kotlin {
    explicitApi()
}

dependencies {
    implementation(libs.kotlinx.benchmark)
    implementation(libs.kotlinx.coroutines)
}