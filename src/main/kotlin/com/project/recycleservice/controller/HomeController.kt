package com.project.recycleservice.controller

import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    @GetMapping("/")
    fun home(session: HttpSession, model: Model):String{
        val user = session.getAttribute("user")
        model.addAttribute("loginUser", user)
        return "index"
    }
}