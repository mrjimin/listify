plugins {
    kotlin("jvm") version "2.3.0"
    kotlin("plugin.spring") version "2.3.0"
    id("org.springframework.boot") version "4.0.2"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "kr.mrjimin"
version = "0.0.1-SNAPSHOT"
description = "listify"

tasks.bootJar {
    destinationDirectory.set(file("$rootDir/out"))
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("se.michaelthelin.spotify:spotify-web-api-java:9.4.0")
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.1")

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-security-oauth2-client")

    implementation("org.springframework.boot:spring-boot-starter-webmvc")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("tools.jackson.module:jackson-module-kotlin")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict", "-Xannotation-default-target=param-property")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//val frontendDir = "$projectDir/frontend"
//val isWindows = System.getProperty("os.name").lowercase().contains("windows")
//val npmPath = if (isWindows) "npm.cmd" else "/Users/mrjimin/.nvm/versions/node/v24.13.0/bin/npm"
//sourceSets {
//    main {
//        resources {
//            srcDirs("${projectDir}/src/main/resources")
//        }
//    }
//}
//
//tasks.processResources {
//    dependsOn("copyReactBuildFiles")
//    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
//}
//
//tasks.register<Exec>("npmAuditFix") {
//    group = BasePlugin.BUILD_GROUP
//    workingDir = file(frontendDir)
//    inputs.dir(frontendDir)
//
//    commandLine(npmPath, "audit", "fix")
//}
//
//tasks.register<Exec>("installReact") {
//    group = BasePlugin.BUILD_GROUP
//    dependsOn("npmAuditFix")
//    workingDir = file(frontendDir)
//    inputs.dir(frontendDir)
//
//    commandLine(npmPath, "install")
//}
//
//tasks.register<Exec>("buildReact") {
//    group = BasePlugin.BUILD_GROUP
//    dependsOn("installReact")
//    workingDir = file(frontendDir)
//    inputs.dir(frontendDir)
//
//    commandLine(npmPath, "run", "build")
//}
//
//tasks.register<Copy>("copyReactBuildFiles") {
//    dependsOn("buildReact")
//    from("$frontendDir/dist")
//    into("${projectDir}/src/main/resources/static")
//}