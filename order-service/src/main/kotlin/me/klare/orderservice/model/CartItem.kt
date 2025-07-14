package me.klare.orderservice.model

import java.io.Serializable

/**
 * Represents a single item within a shopping cart.
 *
 * This class must also be Serializable because it will be stored as part of
 * the ShoppingCart object in Redis.
 */
data class CartItem(
    val productId: String, // This would be the ID of a MenuItem from the restaurant-service
    val productName: String,
    val quantity: Int,
    val price: Double
) : Serializable
