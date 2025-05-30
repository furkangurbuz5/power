plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "dev.gurbuz"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.springframework.boot:spring-boot-starter-validation") //added validation dependency
	implementation("org.springframework.boot:spring-boot-starter-jdbc") //added jdbc
//	developmentOnly("org.springframework.boot:spring-boot-docker-compose") //added docker compose
	runtimeOnly("org.postgresql:postgresql") //added postgresql
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc") // added spring data
	implementation("com.h2database:h2:2.3.232")
}

tasks.withType<Test> {
	useJUnitPlatform()
}


