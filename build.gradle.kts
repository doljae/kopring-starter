import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")

    id("org.jlleitschuh.gradle.ktlint")
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

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}

dependencies {
    implementation(Dependencies.kotlinReflect)
    implementation(Dependencies.jacksonKotlin)

    implementation(Dependencies.springBootStarterWeb)
    implementation(Dependencies.springBootStarterJpa)
    implementation(Dependencies.springBootStarterActuator)
    implementation(Dependencies.springBootStarterTest) {
        exclude(module = "mockito-core")
    }

    implementation(Dependencies.springBootConfigurationProcessor)
    implementation(Dependencies.springBootTestContainers)
    implementation(Dependencies.springBootDevTools)

    implementation(Dependencies.testContainersJunitJupiter)
    implementation(Dependencies.testContainersMySql)

    implementation(Dependencies.mySqlConnector)

    implementation(Dependencies.logging)

    testImplementation(Dependencies.kotestAssertions)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.springMockk)
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
