package me.klare.model

import org.springframework.data.annotation.Id

data class Restaurant(
    @Id
    val id: String? = null,

    val name: String,
    val address: String,
    val cuisineType: String,
    val menuItems: List<MenuItem> = emptyList()
)
