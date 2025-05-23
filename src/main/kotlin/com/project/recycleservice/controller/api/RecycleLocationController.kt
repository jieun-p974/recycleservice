package com.project.recycleservice.controller.api

import com.project.recycleservice.domain.repository.RecycleLocationRepository
import com.project.recycleservice.service.LocationViewService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/locations") // 전체 수거함 목록
class RecycleLocationController(
    private val locationRepository: RecycleLocationRepository,
    private val locationViewService: LocationViewService
) {
    @GetMapping
    fun getAll(@RequestParam(required = false) category: String?): List<Map<String, Any>>{
        val list = if(category != null){
            locationRepository.findByCategory(category)
        }else{
            locationRepository.findAll()
        }
        return list.map {
            mapOf(
                "locationId" to it.locationId,
                "name" to it.name,
                "address" to it.address,
                "category" to it.category,
                "views" to locationViewService.getViewCount(it.locationId!!)
            )
        }
    }

    @GetMapping("/{locationId}") // 해당 수거함 상세  + ㅇ
    fun getById(@PathVariable locationId: Long): Map<String, Any>{
        val location = locationRepository.findById(locationId).orElseThrow()
        val views = locationViewService.increaseViewCount(locationId)

        return mapOf<String, Any>(
            "locationId" to location.locationId,
            "name" to (location.name ?: "이름없음"),
            "address" to (location.address ?: "주소없음"),
            "category" to (location.category ?: "카테고리없음"),
            "phone" to (location.phoneNumber ?: ""),
            "views" to views
        )
    }
}