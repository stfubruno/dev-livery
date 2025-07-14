package me.klare.controller

import me.klare.service.RestaurantService
import me.klare.model.Restaurant
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * The @RestController annotation marks this class as a controller where every method
 * returns a domain object instead of a view. It's a shorthand for including
 * @Controller and @ResponseBody.
 *
 * @RequestMapping("/restaurants") maps all HTTP requests for "/restaurants" to this controller.
 */
@RestController
@RequestMapping("/restaurants")
class RestaurantController(
    private val restaurantService: RestaurantService
) {

    /**
     * Handles GET requests to "/restaurants".
     * It can optionally filter by cuisine type using a request parameter.
     * e.g., GET /restaurants
     * e.g., GET /restaurants?cuisine=Italian
     * @param cuisine The optional cuisine type to filter by.
     * @return A ResponseEntity containing the list of restaurants.
     */
    @GetMapping
    fun getAllRestaurants(@RequestParam(required = false) cuisine: String?): ResponseEntity<List<Restaurant>> {
        val restaurants = restaurantService.getAllRestaurants(cuisine)
        return ResponseEntity.ok(restaurants)
    }

    @GetMapping("/{id}")
    fun getRestaurantById(@PathVariable id: String): ResponseEntity<Restaurant> {
        return restaurantService.getRestaurantById(id)
            .map { restaurant -> ResponseEntity.ok(restaurant) }
            .orElse(ResponseEntity.notFound().build())
    }

    /**
     * Handles HTTP POST requests to "/restaurants".
     * Saves a new restaurant to the database.
     *
     * @param restaurant The Restaurant object from the request body.
     * @return The saved Restaurant object with an HTTP status of 201 (Created).
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createRestaurant(@RequestBody restaurant: Restaurant): Restaurant {
        return restaurantService.createRestaurant(restaurant)
    }

    /**
     * Handles HTTP DELETE requests to "/restaurants/{id}".
     * @param id The ID of the restaurant to delete.
     * @return A ResponseEntity with a 204 No Content status, indicating success.
     */
    @DeleteMapping("/{id}")
    fun deleteRestaurant(@PathVariable id: String): ResponseEntity<Void> {
        restaurantService.deleteRestaurant(id)
        return ResponseEntity.noContent().build() // Return 204 No Content
    }
}