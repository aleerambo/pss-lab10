import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    java
    id("org.danilopianini.gradle-java-qa") version "1.77.0"
}

repositories {
    mavenCentral()
}

dependencies {
    val junitVersion = "5.11.3"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.test {
    useJUnitPlatform()
    testLogging { events(*TestLogEvent.values()) }
    testLogging.showStandardStreams = true
}
