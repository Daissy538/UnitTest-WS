package org.Hamer.core

import java.util.UUID

interface StockRepository {
    fun addProduct(product: Product)
    fun getProducts(): List<Product>
    fun getProduct(id: UUID): Product?
}