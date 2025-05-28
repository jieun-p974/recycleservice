package com.project.recycleservice.config

import io.github.cdimascio.dotenv.dotenv
import org.springframework.stereotype.Component

@Component
class AppEnv {
    private val dotenv = dotenv()
    val naverClientId: String = dotenv["NAVER_CLIENT_ID"]
}