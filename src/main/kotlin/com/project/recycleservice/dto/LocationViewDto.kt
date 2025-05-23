package com.project.recycleservice.dto

data class LocationViewDto (
    val locationId: Long,
    val name: String,
    val address: String,
    val category: String,
    val phone: String,
    val views: Long
)