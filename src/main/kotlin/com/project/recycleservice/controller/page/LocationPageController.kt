package com.project.recycleservice.controller.page

import com.project.recycleservice.config.AppEnv
import com.project.recycleservice.domain.repository.RecycleLocationRepository
import com.project.recycleservice.domain.repository.ReviewRepository
import com.project.recycleservice.dto.LocationViewDto
import com.project.recycleservice.service.LocationViewService
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LocationPageController(
    private val locationRepository: RecycleLocationRepository,
    private val locationViewService: LocationViewService,
    private val reviewRepository: ReviewRepository,
    private val appEnv: AppEnv
) {
    @GetMapping("/locations")
    fun showLocations(@RequestParam(required = false) category: String?, @RequestParam(required = false) address: String?, model: Model, response: HttpServletResponse): String {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
        response.setHeader("Pragma", "no-cache")
        response.setDateHeader("Expires", 0)

        val locations = when{
            !category.isNullOrBlank() && !address.isNullOrBlank() -> locationRepository.findByCategoryAndAddressContaining(category, address)
            !category.isNullOrBlank() -> locationRepository.findByCategory(category)
            !address.isNullOrBlank() -> locationRepository.findByAddressContaining(address)
            else -> locationRepository.findAll()
        }

        // 카테고리 select 박스 넣기 전에 중복 제거
        val categories = locationRepository.findAll().mapNotNull { it.category }.distinct().sorted()

        val result = locations.map {
            LocationViewDto(
                locationId = it.locationId ?: 0,
                name = it.name ?: "",
                address = it.address ?: "",
                category = it.category ?: "",
                phone = it.phoneNumber ?: "",
                views = locationViewService.getViewCount(it.locationId ?: 0)
            )
        }
        model.addAttribute("locations",result)
        model.addAttribute("category", category)
        model.addAttribute("categories", categories)
        model.addAttribute("address", address)
        model.addAttribute("naverClientId", appEnv.naverClientId)
        return "location"
    }

    // 수거함 상세 + 조회수 + 로그인한 사용자의 해당 장소 즐겨찾기 여부
    @GetMapping("/locations/{id}")
    fun getLocationDetail(@PathVariable id: Long, model: Model, response: HttpServletResponse): String{
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate")
        response.setHeader("Pragma", "no-cache")
        response.setDateHeader("Expires", 0)

        val location = locationRepository.findById(id).orElseThrow()
        val views = locationViewService.increaseViewCount(id)
        val reviews = reviewRepository.findByLocation(location)
        val isFavorite = false // 로그인한 사용자의 즐겨찾기 여부

        model.addAttribute("location", location)
        model.addAttribute("views", views)
        model.addAttribute("reviews", reviews)
        model.addAttribute("isFavorite", isFavorite)

        return "location-detail"
    }
}