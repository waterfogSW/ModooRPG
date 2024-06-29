dependencies {
    implementation(project(":support:common"))

    implementation(project(":user:domain"))
    implementation(project(":user:application"))
    implementation(project(":user:infrastructure:jpa"))

    implementation(libs.spring.boot.starter.web)
    implementation(libs.springdoc.openapi.starter.webmvc.ui)

    developmentOnly(libs.spring.boot.devtools)
    developmentOnly(libs.spring.boot.docker.compose)
}
