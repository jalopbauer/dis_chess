plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.10"
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

