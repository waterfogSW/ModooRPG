rootProject.name = "ModooRPG"

// support
include(":support:common")
project(":support:common").projectDir = file("support/common")

// user-service
include(":user:domain")
project(":user:domain").projectDir = file("user/domain")

include(":user:application")
project(":user:application").projectDir = file("user/application")

include(":user:infrastructure:jpa")
project(":user:infrastructure:jpa").projectDir = file("user/infrastructure/jpa")

include(":user:bootstrap:api")
project(":user:bootstrap:api").projectDir = file("user/bootstrap/api")
