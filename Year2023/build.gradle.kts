plugins {
    alias(libs.plugins.kotlin.default)
}

group = "advent.of.code.year2023"

dependencies {
    implementation(projects.utils)
    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotest)
}

tasks.withType<Test> {
    useJUnitPlatform()
}
