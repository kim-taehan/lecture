plugins {
    id("java")
    id("com.github.spotbugs") version "6.2.3"
}
group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

var mockitoAgent: Configuration = configurations.create("mockitoAgent")

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
//    developmentOnly("org.springframework.security:spring-security-core")
    implementation("org.springframework.boot:spring-boot-starter-security")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.junit-pioneer:junit-pioneer:2.3.0")

    testImplementation("org.mockito:mockito-core:5.18.0")
    mockitoAgent("org.mockito:mockito-core:5.18.0") {
        isTransitive = false
    }
}

tasks.test {
    useJUnitPlatform()
    jvmArgs("-javaagent:${mockitoAgent.asPath}")
}

spotbugs {
    excludeFilter.set(file("${projectDir}/spotbugs-exclude-filter.xml"))
}