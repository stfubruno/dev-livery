/**
 * Represents a user's shopping cart.
 *
 * @RedisHash("ShoppingCart") tells Spring Data Redis to store this object
 * in Redis under a hash named "ShoppingCart".
 *
 * We implement Serializable because objects stored in Redis should be serializable
 * so they can be converted to a byte stream for storage and retrieval.
 */
@RedisHash("ShoppingCart")
data class ShoppingCart(
    // The @Id annotation marks this field as the primary key for the Redis hash.
    // We will use the user's ID as the cart's ID.
    @Id
    val userId: String,

    val items: MutableList<CartItem> = mutableListOf()
) : Serializable