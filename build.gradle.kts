import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")

    id("org.jlleitschuh.gradle.ktlint")
}

group = "com.infcon"
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
    developmentOnly(Dependencies.springBootDockerCompose)

    kapt(Dependencies.springBootConfigurationProcessor)
    implementation(Dependencies.springBootTestContainers)
    implementation(Dependencies.springBootDevTools)

    implementation(Dependencies.testContainersJunitJupiter)
    implementation(Dependencies.testContainersMySql)

    implementation(Dependencies.mySqlConnector)
    runtimeOnly(Dependencies.h2db)
    implementation(Dependencies.logging)

    testImplementation(Dependencies.kotestCore)
    testImplementation(Dependencies.kotestAssertions)
    testImplementation(Dependencies.kotestExtensionsSpring)
    testImplementation(Dependencies.kotestExtensionsTestContainers)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.springMockk)
    testImplementation(Dependencies.fixtureMonkeyStarter)
    testImplementation(Dependencies.fixtureMonkeyJackson)
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
