package me.klare.orderservice.repository

import me.klare.orderservice.model.ShoppingCart
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 * The @Repository annotation marks this as a Spring component for data access.
 *
 * This interface extends CrudRepository for handling ShoppingCart entities.
 * Spring Data Redis will automatically provide the implementation for basic
 * CRUD (Create, Read, Update, Delete) operations.
 *
 * CrudRepository<ShoppingCart, String> means:
 * - It's a repository for the "ShoppingCart" class.
 * - The type of the ID for the ShoppingCart class is "String" (which is the userId).
 */
@Repository
interface ShoppingCartRepository : CrudRepository<ShoppingCart, String> {   }
