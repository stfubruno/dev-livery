package me.klare.orderservice.controller

import me.klare.orderservice.model.Order
import me.klare.orderservice.service.OrderService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService
) {

    /**
     * POST /orders/{userId}/checkout
     * Triggers the checkout process: Redis Cart -> MongoDB Order
     */
    @PostMapping("/{userId}/checkout")
    fun checkout(@PathVariable userId: String): ResponseEntity<Order> {
        try {
            val order = orderService.placeOrder(userId)
            return ResponseEntity.status(HttpStatus.CREATED).body(order)
        } catch (e: IllegalStateException) {
            // Return 400 Bad Request if cart is empty
            return ResponseEntity.badRequest().build()
        }
    }

    /**
     * GET /orders/{userId}
     * History of orders for a user
     */
    @GetMapping("/user/{userId}")
    fun getOrdersByUser(@PathVariable userId: String): ResponseEntity<List<Order>> {
        return ResponseEntity.ok(orderService.getOrdersByUserId(userId))
    }
    
    /**
     * GET /orders/{orderId}
     * Specific order details
     */
    @GetMapping("/{orderId}")
    fun getOrderById(@PathVariable orderId: String): ResponseEntity<Order> {
        return try {
            ResponseEntity.ok(orderService.getOrderById(orderId))
        } catch (e: NoSuchElementException) {
            ResponseEntity.notFound().build()
        }
    }
}