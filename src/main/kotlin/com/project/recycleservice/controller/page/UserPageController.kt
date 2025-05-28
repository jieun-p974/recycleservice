package com.project.recycleservice.controller.page

import com.project.recycleservice.dto.UserSignupDto
import com.project.recycleservice.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class UserPageController (
    private val userService: UserService
){
    @GetMapping("/signup")
    fun signupForm(model: Model): String {
        model.addAttribute("user", UserSignupDto("", "", ""))
        return "signup"
    }

    @PostMapping("/signup")
    fun signupSubmit(@ModelAttribute user: UserSignupDto, model: Model): String {
        userService.signup(user)
        model.addAttribute("nickname", user.nickname)
        return "signup-success"
    }

}