package com.project.recycleservice.controller

import com.project.recycleservice.domain.repository.UserRepository
import com.project.recycleservice.dto.LoginDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import jakarta.servlet.http.HttpSession

@Controller
class LoginController (
    private val userRepository: UserRepository
){
    @GetMapping("/login") // 로그인 페이지로 이동
    fun loginForm(model: Model): String{
        model.addAttribute("loginDto", LoginDto("",""))
        return "login"
    }

    @PostMapping("/login") // 입력받은 정보로 로그인
    fun login(
        @ModelAttribute loginDto: LoginDto,
        session: HttpSession,
        model: Model
    ): String{
        val user = userRepository.findByEmailAndPassword(
            loginDto.email,
            loginDto.password
        )

        return if (user != null){
            session.setAttribute("user", user)
            print("로그인 성공" + user.nickname + " " + session.id)
            "redirect:/" // 로그인 성공하면 메인화면으로 이동
        }else{
            model.addAttribute("loginError", true)
            "login"
        }
    }

    @GetMapping("/logout")
    fun logout(session: HttpSession): String{
        session.invalidate()
        return "redirect:/"
    }
}