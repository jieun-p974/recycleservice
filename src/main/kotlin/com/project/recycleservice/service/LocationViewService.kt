package com.project.recycleservice.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class LocationViewService (
    private val redisTemplate: RedisTemplate<String, String>
){
    fun increaseViewCount(locationId: Long): Long{
        val key = "views:location:$locationId"
        return  redisTemplate.opsForValue().increment(key) ?: 1
    }
    fun getViewCount(locationId: Long): Long{
        val key = "views:location:$locationId"
        return redisTemplate.opsForValue().get(key)?.toLong() ?:0
    }
}