package me.klare.repository

import me.klare.model.Restaurant
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * The @Repository annotation tells Spring that this is a repository bean.
 *
 * We extend MongoRepository, which gives us a full set of standard CRUD
 * (Create, Read, Update, Delete) methods for our Restaurant objects.
 */
@Repository
interface RestaurantRepository : MongoRepository<Restaurant, String> {

    /**
     * This is a custom query method. Spring Data MongoDB will automatically
     * generate a query to find all restaurants that match the given cuisineType.
     * The method name "findByCuisineType" is parsed by Spring to create the query.
     *
     * @param cuisineType The type of cuisine to search for.
     * @return A list of restaurants matching the cuisine type.
     */
    fun findByCuisineType(cuisineType: String): List<Restaurant>
}