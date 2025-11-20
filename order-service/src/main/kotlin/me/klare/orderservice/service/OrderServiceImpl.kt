package me.klare.orderservice.service

import me.klare.orderservice.model.Order
import me.klare.orderservice.model.OrderStatus
import me.klare.orderservice.repository.OrderRepository
import me.klare.orderservice.repository.ShoppingCartRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import kotlin.jvm.optionals.getOrNull

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val shoppingCartRepository: ShoppingCartRepository
) : OrderService {

    override fun placeOrder(userId: String): Order {
        // 1. Retrieve the user's cart from Redis
        val cartOptional = shoppingCartRepository.findById(userId)
        
        if (cartOptional.isEmpty || cartOptional.get().items.isEmpty()) {
            throw IllegalStateException("Cannot place an order with an empty cart.")
        }

        val cart = cartOptional.get()

        // 2. Calculate the total price
        // In a production app, we would verify these prices with restaurant-service here.
        val totalPrice = cart.items.sumOf { it.price * it.quantity }

        // 3. Create the Order object
        val newOrder = Order(
            userId = userId,
            items = cart.items,
            totalPrice = totalPrice,
            status = OrderStatus.PENDING,
            orderDate = LocalDateTime.now()
        )

        // 4. Save Order to MongoDB
        val savedOrder = orderRepository.save(newOrder)

        // 5. Clear the Shopping Cart in Redis (Checkout complete)
        shoppingCartRepository.delete(cart)

        return savedOrder
    }

    override fun getOrdersByUserId(userId: String): List<Order> {
        // Note: You might need to add findByUserId to your OrderRepository interface
        // For now, we will filter manually or assume the repo update is coming next
        return orderRepository.findAll().filter { it.userId == userId }
    }
    
    override fun getOrderById(orderId: String): Order {
        return orderRepository.findById(orderId).orElseThrow { 
            NoSuchElementException("Order not found with ID: $orderId") 
        }
    }
}