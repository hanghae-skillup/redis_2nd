dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.4.3")
    implementation("mysql:mysql-connector-java:8.0.33")

    implementation(project(":domain"))
}
