package me.klare.orderservice.controller

import me.klare.orderservice.model.CartItem
import me.klare.orderservice.model.ShoppingCart
import me.klare.orderservice.service.CartService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * The @RestController annotation marks this class as a controller for handling RESTful requests.
 *
 * @RequestMapping("/carts") maps all HTTP requests for "/carts" to this controller.
 */
@RestController
@RequestMapping("/carts")
class CartController(
    // Spring injects an instance of our CartService.
    private val cartService: CartService
) {

    /**
     * Handles HTTP GET requests to "/carts/{userId}".
     * Retrieves the shopping cart for a specific user.
     *
     * @param userId The ID of the user, extracted from the URL path.
     * @return A ResponseEntity containing the user's ShoppingCart.
     */
    @GetMapping("/{userId}")
    fun getCartByUserId(@PathVariable userId: String): ResponseEntity<ShoppingCart> {
        val cart = cartService.getCart(userId)
        return ResponseEntity.ok(cart)
    }

    /**
     * Handles HTTP POST requests to "/carts/{userId}/items".
     * Adds a new item to the specified user's shopping cart.
     *
     * @param userId The ID of the user, extracted from the URL path.
     * @param cartItem The CartItem object from the request body.
     * @return A ResponseEntity containing the updated ShoppingCart.
     */
    @PostMapping("/{userId}/items")
    fun addItemToCart(
        @PathVariable userId: String,
        @RequestBody cartItem: CartItem
    ): ResponseEntity<ShoppingCart> {
        val updatedCart = cartService.addItemToCart(userId, cartItem)
        return ResponseEntity.ok(updatedCart)
    }
}