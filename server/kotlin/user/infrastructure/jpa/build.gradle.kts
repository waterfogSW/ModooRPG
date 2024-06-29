import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

dependencies {
    implementation(project(":support:common"))

    implementation(project(":user:domain"))
    implementation(project(":user:application"))

    implementation(libs.spring.boot.starter.data.jpa)
    runtimeOnly(libs.mysql.connector.java)
}
