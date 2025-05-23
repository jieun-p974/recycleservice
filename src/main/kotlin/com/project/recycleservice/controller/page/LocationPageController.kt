package com.project.recycleservice.controller.page

import com.project.recycleservice.domain.repository.RecycleLocationRepository
import com.project.recycleservice.dto.LocationViewDto
import com.project.recycleservice.service.LocationViewService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LocationPageController(
    private val locationRepository: RecycleLocationRepository,
    private val locationViewService: LocationViewService
) {
    @GetMapping("/locations")
    fun showLocations(
        @RequestParam(required = false) category: String?,
        model: Model
    ): String {
        val locations = if(category != null){
            locationRepository.findByCategory(category)
        }else{
            locationRepository.findAll()
        }

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
        return "location"
    }
}