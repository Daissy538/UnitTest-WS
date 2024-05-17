package core.inputPort

import core.entities.Product

interface FlowerStock {
    fun addFlower(flower: String, price: Double)
    fun getFlowers(): List<Product>
}
