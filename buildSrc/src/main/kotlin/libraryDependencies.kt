
object libraryDependency {
    const val autoValue = "com.google.auto.value:auto-value:${Version.auto_value}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin_version}"
    const val dagger = "com.google.dagger:dagger:${Version.daggerVersion}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Version.daggerVersion}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Version.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.daggerVersion}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Version.daggerVersion}"

    const val lifecycleExtensions = "androidx.lifecycle=lifecycle-extensions:${Version.archCompomentVersion}"

    const val fragment = "androidx.navigation:navigation-fragment:${Version.navigational_component}"
    const val ui = "androidx.navigation:navigation-ui:${Version.navigational_component}"
    const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Version.navigational_component}"
    const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigational_component}"

    const val chuck = "com.readystatesoftware.chuck:library:${Version.chuck}"
    const val chuckNoOp = "com.readystatesoftware.chuck:library-no-op:${Version.chuck}"

    const val appComponent = "androidx.appcompat:appcompat:${Version.appComponent}"

    const val roomRuntime = "androidx.room:room-runtime:${Version.room}"
    const val compiler = "androidx.room:room-compiler:${Version.room}"
    const val rx2 = "androidx.room:room-rxjava2:${Version.room}"
    const val common = "androidx.room:room-common:${Version.room}"

    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Version.rxJava}"
    const val rx2AndroidSchedulers = "com.twistedequations.rx2:rx2-android-schedulers:${Version.rxTwistedEquations}"
    const val saveState = "com.twistedequations.rx2:rx2-savestate:${Version.rxTwistedEquationsSaveState}"
    const val rxbindingSupport = "com.jakewharton.rxbinding2:rxbinding-support-v4:${Version.rxBinding}"
    const val rxbindingAppcompat = "com.jakewharton.rxbinding2:rxbinding-appcompat-v7:${Version.rxBinding}"
    const val rxbindingAppcompatKotlin = "com.jakewharton.rxbinding2=:rxbinding-appcompat-v7-kotlin:${Version.rxBinding}"
    const val rxbinding = "com.jakewharton.rxbinding2:rxbinding:${Version.rxBinding}"
    const val rxRelay = "com.jakewharton.rxrelay2:rxrelay:${Version.rxRelay}"

    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofitConverterGson}"
    const val retrofitRxjavaAdapter = "com.jakewharton.retrofit:retrofit2-rxjava2-adapter:${Version.retrofit2Rxjava2Adapter}"

    const val recyclerview = "androidx.recyclerview:recyclerview:${Version.androidX}"
    const val cardView = "androidx.cardview:cardview:${Version.androidX}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Version.androidConstraintlayout}"
    const val legacySupport = "androidx.legacy:legacy-support-v4:${Version.androidX}"
    const val appcompat = "androidx.appcompat:appcompat:${Version.androidX}"
    const val multidex = "androidx.multidex:multidex:${Version.multidex}"
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"

    const val picasso = "com.squareup.picasso:picasso:${Version.picasso}"
    const val dexter = "com.karumi:dexter:${Version.dexter}"
    const val play = "com.google.android.play:core:${Version.play}"
    const val jsr250 = "javax.annotation:jsr250-api:${Version.javax_annotation}"
    const val material = "com.google.android.material:material:${Version.material}"
}