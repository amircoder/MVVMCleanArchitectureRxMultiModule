object TestDependency {

    const val truth  = "com.google.truth:truth:${Version.truth}"
    const val mockitoInline = "org.mockito:mockito-inline:${Version.mockito_inline}"

    const val annotations =  "androidx.annotation:annotation:${Version.annotations}"
    const val testRunner = "androidx.test:runner:${Version.testRunner}"

    const val nharmanMockitoInline =  "com.nhaarman.mockitokotlin2:mockito-kotlin:${Version.mockito_kotlin}"
    const val coreTest = "androidx.arch.core=core-testing:${Version.archCompomentVersion}"

    // Set this dependency to use JUnit 4 rules
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val testRules = "androidx.test:rules:${Version.testRules}"
    const val junit = "androidx.test.ext:junit:${Version.junit}"


    const val powermockApiMockito2 = "org.powermock:powermock-api-mockito2:${Version.powermockVersion}"
    const val powermockJunit4 = "org.powermock:powermock-module-junit4:${Version.powermockVersion}"


    const val asserjCore =  "org.assertj:assertj-core:${Version.assertjVersion}"
    const val assertjAndroid = "com.squareup.assertj:assertj-android:${Version.assertjAndroidVersion}"

    const val robolectric = "org.robolectric:robolectric:${Version.robolectricVersion}"

    const val shadowsPlayServices = "org.robolectric:shadows-play-services:${Version.robolectricShadowsVersion}"

    const val mockk = "io.mockk:mockk:${Version.mockKVersion}"

    const val  mavenAntTask = "org.apache.maven:maven-ant-tasks:2.1.3"

}