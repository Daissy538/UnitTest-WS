package core.inputPort

import core.entities.Product

interface Stock {
    fun addProduct(name: String, price: Double)
    fun getProducts(): List<Product>
}