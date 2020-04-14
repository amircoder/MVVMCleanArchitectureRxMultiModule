import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
    "common_app.gradle.kts"
}
// Required since Gradle 4.10+.
repositories {
    jcenter()
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}