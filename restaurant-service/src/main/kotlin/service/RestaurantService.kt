package me.klare.service

import me.klare.model.Restaurant
import java.util.Optional

interface RestaurantService {

    /**
     * Retrieves all restaurants, with an option to filter by cuisine type.
     * @param cuisineType An optional string to filter restaurants by their cuisine.
     * @return a list of Restaurant objects.
     */
    fun getAllRestaurants(cuisineType: String?): List<Restaurant>

    /**
     * Retrieves a single restaurant by its unique ID.
     * @param id The ID of the restaurant to find.
     * @return An Optional containing the restaurant if found, otherwise empty.
     */
    fun getRestaurantById(id: String): Optional<Restaurant>

    /**
     * Creates and saves a new restaurant.
     * @param restaurant The restaurant to be created.
     * @return The saved restaurant.
     */
    fun createRestaurant(restaurant: Restaurant): Restaurant

    /**
     * Deletes a restaurant by its unique ID.
     * @param id The ID of the restaurant to delete.
     */
    fun deleteRestaurant(id: String)
}