rootProject.name = "ModooRPG"

// user-service
include(":user:domain")
project(":user:domain").projectDir = file("user/domain")

include(":user:application")
project(":user:application").projectDir = file("user/application")

include(":user:infrastructure")
project(":user:infrastructure").projectDir = file("user/infrastructure")

include(":user:bootstrap")
project(":user:bootstrap").projectDir = file("user/bootstrap")
