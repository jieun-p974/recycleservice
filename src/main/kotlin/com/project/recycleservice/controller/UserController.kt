package com.project.recycleservice.controller

import com.project.recycleservice.dto.UserDto
import com.project.recycleservice.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController (
    private val userService: UserService
){
    @GetMapping
    fun getAllUsers(): ResponseEntity<List<UserDto>>{
        val users = userService.getAllUsers()
        return ResponseEntity.ok(users)
    }
}