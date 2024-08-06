group = "dev.boiarshinov"
version = "1.0-SNAPSHOT"

dependencies {
    val springSecurityVersion = "6.0.0"

    implementation("org.springframework.security:spring-security-core:$springSecurityVersion")
    implementation("org.springframework.security:spring-security-web:$springSecurityVersion")
    implementation("org.springframework.security:spring-security-config:$springSecurityVersion")
}
