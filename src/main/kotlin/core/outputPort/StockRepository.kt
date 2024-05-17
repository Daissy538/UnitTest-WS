package core.outputPort

import core.entities.Product

interface StockRepository {
    fun addProduct(product: Product)
    fun getProducts(): List<Product>
}