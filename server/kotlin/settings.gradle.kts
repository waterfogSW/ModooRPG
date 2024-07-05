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

// chat-service
include(":chat:domain")
project(":chat:domain").projectDir = file("chat/domain")

include(":chat:application")
project(":chat:application").projectDir = file("chat/application")

include(":chat:infrastructure:kafka")
project(":chat:infrastructure:kafka").projectDir = file("chat/infrastructure/kafka")

include(":chat:bootstrap:api")
project(":chat:bootstrap:api").projectDir = file("chat/bootstrap/api")
