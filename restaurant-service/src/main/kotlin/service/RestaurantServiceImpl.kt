package me.klare.service

import me.klare.repository.RestaurantRepository
import me.klare.model.Restaurant
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class RestaurantServiceImpl(
    private val restaurantRepository: RestaurantRepository
) : RestaurantService {

    override fun getAllRestaurants(cuisineType: String?): List<Restaurant> {
        return if (cuisineType != null) {
            restaurantRepository.findByCuisineType(cuisineType)
        } else {
            restaurantRepository.findAll()
        }
    }

    override fun getRestaurantById(id: String): Optional<Restaurant> {
        return restaurantRepository.findById(id)
    }

    override fun createRestaurant(restaurant: Restaurant): Restaurant {
        return restaurantRepository.save(restaurant)
    }

    override fun deleteRestaurant(id: String) {
        val restaurantExists = restaurantRepository.existsById(id)

        if (restaurantExists) {
            restaurantRepository.deleteById(id)
        }
    }

}
