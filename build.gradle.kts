buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.0")
    }
}
plugins {
    kotlin("multiplatform").apply(false)
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.compose").apply(false)
}
