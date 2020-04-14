// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()

    }

    dependencies {
        classpath(GradlePluginId.GRADLE_PLUGIN)
        classpath(GradlePluginId.GRADLE_KOTLIN_PLUGIN)
    }

}

allprojects {
    repositories {
        maven("https://www.jitpack.io")
        maven("https://maven.google.com")
        google()
        jcenter()
        maven("http://dl.bintray.com/twistedequations/maven")

    }
}

tasks.register("clean").configure {
    delete("build")
}
