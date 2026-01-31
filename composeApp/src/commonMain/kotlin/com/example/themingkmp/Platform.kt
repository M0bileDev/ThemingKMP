package com.example.themingkmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform