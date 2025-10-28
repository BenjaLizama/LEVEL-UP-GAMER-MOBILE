pluginManagement {
    repositories {
        // 👈 ELIMINA la sección 'content' restrictiva
        google()

        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        // También añade google() aquí para las dependencias (como Room)
        google()
        mavenCentral()
    }
}

rootProject.name = "LEVEL-UP-GAMER-MOBILE"
include(":app")
