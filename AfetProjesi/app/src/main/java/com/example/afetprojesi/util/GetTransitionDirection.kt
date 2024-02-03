package com.example.afetprojesi.util

import androidx.compose.animation.AnimatedContentTransitionScope

//sayfa değişince oluşan animasyon için gerekli fonksiyon
fun getTransitionDirection(
    initialIndex: Int,
    targetIndex: Int
): AnimatedContentTransitionScope.SlideDirection {
    return if (targetIndex > initialIndex) {
        AnimatedContentTransitionScope.SlideDirection.Left
    } else {
        AnimatedContentTransitionScope.SlideDirection.Right
    }
}