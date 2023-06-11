import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

group = "com.doljae"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.kotlinReflect)
    implementation(Dependencies.jacksonKotlin)

    implementation(Dependencies.springBootStarterWeb)
    implementation(Dependencies.springBootStarterJpa)
    implementation(Dependencies.springBootStarterActuator)
    implementation(Dependencies.springBootStarterTest)

    implementation(Dependencies.springBootConfigurationProcessor)
    implementation(Dependencies.springBootTestContainers)
    implementation(Dependencies.springBootDevTools)

    implementation(Dependencies.testContainersJunitJupiter)
    implementation(Dependencies.testContainersMySql)

    implementation(Dependencies.mySqlConnector)

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
