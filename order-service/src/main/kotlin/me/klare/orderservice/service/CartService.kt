package me.klare.orderservice.service

import me.klare.orderservice.model.CartItem
import me.klare.orderservice.model.ShoppingCart

/**
 * Interface for the shopping cart service.
 * Defines the business logic operations for managing user shopping carts.
 */
interface CartService {

    /**
     * Retrieves the shopping cart for a given user.
     * If a cart doesn't exist for the user, a new, empty one is created.
     *
     * @param userId The ID of the user.
     * @return The user's ShoppingCart.
     */
    fun getCart(userId: String): ShoppingCart

    /**
     * Adds an item to a user's shopping cart.
     *
     * @param userId The ID of the user whose cart is being modified.
     * @param item The CartItem to be added.
     * @return The updated ShoppingCart.
     */
    fun addItemToCart(userId: String, item: CartItem): ShoppingCart
}