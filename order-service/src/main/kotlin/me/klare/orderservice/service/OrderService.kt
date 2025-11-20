package me.klare.orderservice.service

import me.klare.orderservice.model.Order

interface OrderService {
    /**
     * Takes all items from the user's current shopping cart (Redis),
     * creates a persistent Order (MongoDB), and clears the cart.
     *
     * @param userId The ID of the user placing the order.
     * @return The created Order.
     */
    fun placeOrder(userId: String): Order

    /**
     * Retrieves all orders placed by a specific user.
     */
    fun getOrdersByUserId(userId: String): List<Order>
    
    /**
     * Retrieves a specific order details
     */
    fun getOrderById(orderId: String): Order
}