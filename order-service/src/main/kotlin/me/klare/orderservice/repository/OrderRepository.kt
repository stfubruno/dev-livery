package me.klare.orderservice.repository

import me.klare.orderservice.model.Order
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 * Repository interface for Order entities.
 *
 * By extending MongoRepository, we get a number of standard methods for
 * working with Orders in MongoDB, such as save(), findById(), and findAll().
 */
@Repository
interface OrderRepository : MongoRepository<Order, String> {    }
