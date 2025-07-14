package me.klare.orderservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

/**
 * Represents a finalized order placed by a user.
 *
 * @Document("orders") marks this class to be stored in a MongoDB collection
 * named "orders".
 */
@Document("orders")
data class Order(
    @Id
    val id: String? = null,
    val userId: String,
    val items: List<CartItem>, // We can reuse the CartItem data class
    val totalPrice: Double,
    val status: OrderStatus,
    val orderDate: LocalDateTime = LocalDateTime.now()
)
