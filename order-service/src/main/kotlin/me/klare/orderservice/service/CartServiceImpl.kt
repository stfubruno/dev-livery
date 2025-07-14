package me.klare.orderservice.service

import me.klare.orderservice.model.CartItem
import me.klare.orderservice.model.ShoppingCart
import me.klare.orderservice.repository.ShoppingCartRepository
import org.springframework.stereotype.Service

/**
 * Implementation of the CartService interface.
 * The @Service annotation marks this as a Spring service bean.
 */
@Service
class CartServiceImpl(
    // We inject the ShoppingCartRepository to interact with Redis.
    private val shoppingCartRepository: ShoppingCartRepository
) : CartService {

    override fun getCart(userId: String): ShoppingCart {
        // Try to find the cart in Redis. If it's not found, create a new empty cart.
        // The orElseGet block is executed only if the Optional returned by findById is empty.
        return shoppingCartRepository.findById(userId)
            .orElseGet { ShoppingCart(userId = userId) }
    }

    override fun addItemToCart(userId: String, item: CartItem): ShoppingCart {
        // First, get the current cart for the user.
        val cart = getCart(userId)

        // Add the new item to the cart's list of items.
        cart.items.add(item)

        // Save the updated cart back to Redis.
        // The save method works for both creating a new cart and updating an existing one.
        return shoppingCartRepository.save(cart)
    }
}