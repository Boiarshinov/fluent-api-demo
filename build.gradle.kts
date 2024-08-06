plugins {
    java
}

group = "dev.boiarshinov"
version = "1.0-SNAPSHOT"

subprojects {

    apply(plugin = "java")

    dependencies {
        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    tasks.test {
        useJUnitPlatform()
    }
}
