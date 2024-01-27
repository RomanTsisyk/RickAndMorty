pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "RickAndMorty"
include(":app")
include(":rickandmortyapimodule")
include(":rickandmortydatabasemodule")
include(":core-ui")
include(":rickandmortyapilib")
include(":rickandmortydatabaselib")
