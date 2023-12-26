object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appcompat}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
    val composeUi by lazy { "androidx.compose.ui:ui" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.composeMaterial}" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }
    val material3WindowSize by lazy { "androidx.compose.material3:material3-window-size-class:${Versions.material3WindowSize}" }
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val testJunit by lazy { "androidx.test.ext:junit:${Versions.testJunit}" }
    val testEspresso by lazy { "androidx.test.espresso:espresso-core:${Versions.testEspresso}" }
    val testJunit4 by lazy { "androidx.compose.ui:ui-test-junit4" }
    val composeUiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val composeUiTest by lazy { "androidx.compose.ui:ui-test-manifest" }

    //Hilt
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hiltVersion}" }
    val kaptHilt by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}" }
    val hiltCompiler by lazy { "androidx.hilt:hilt-compiler:${Versions.hiltNavigationVersion}" }
    val hiltNavigationFragment by lazy { "androidx.hilt:hilt-navigation-fragment:${Versions.hiltNavigationVersion}" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navigationCompose}" }
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationVersion}" }

    //Retrofit
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}" }
    val okhttpBom by lazy { "com.squareup.okhttp3:okhttp-bom:${Versions.okhttpBom}" }
    val okhttp by lazy { "com.squareup.okhttp3:okhttp" }
    val loggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor" }
    val moshi by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshi}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}" }

    //Coroutine
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }

    //Coil
    val coil by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }

    //Splash Screen
    val splashScreen by lazy { "androidx.core:core-splashscreen:${Versions.splashScreen}" }
}

object Modules{
    const val utilities = ":utilities"
}