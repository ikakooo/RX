import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    application
}
group = "me.ikakooo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
    implementation ("io.reactivex.rxjava2:rxkotlin:2.3.0")
    api ("io.reactivex.rxjava2:rxjava:2.2.0")
    testImplementation(kotlin("test-junit"))

}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
application {
    mainClassName = "MainKt"
}