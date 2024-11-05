import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    java
}

repositories {
    mavenCentral()
}

dependencies {
    val junitVersion = "5.11.2"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.test {
    useJUnitPlatform()
    testLogging { events(*TestLogEvent.values()) }
    testLogging.showStandardStreams = true
}
