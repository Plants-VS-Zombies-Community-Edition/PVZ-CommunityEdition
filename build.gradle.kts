plugins {
    kotlin("jvm") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("io.freefair.lombok") version "6.4.3"
}

group = "pvz.community"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/groups/public")
    maven("https://repo.dmulloy2.net/repository/public/")
    maven("https://jitpack.io")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0") /*STDLIB of kotlin*/
    implementation("org.litote.kmongo:kmongo:4.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
    implementation("org.json:json:20220320")
    implementation("commons-io:commons-io:2.11.0")
}
