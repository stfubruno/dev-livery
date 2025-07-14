package me.klare.orderservice.model

/**
 * Represents the possible statuses of an order.
 */
enum class OrderStatus {
    PENDING,
    CONFIRMED,
    PREPARING,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELLED
}