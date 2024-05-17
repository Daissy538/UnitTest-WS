package org.Hamer.core.services

import core.entities.Product
import core.inputPort.Stock
import core.outputPort.StockRepository
import org.springframework.stereotype.Service


@Service
class StockImpl(private val stockRepository: StockRepository): Stock {
    override fun addProduct(name: String, price: Double) {
        val product = Product(name, price)

        stockRepository.addProduct(product)
    }

    override fun getProducts(): List<Product> {
        return stockRepository.getProducts()
    }
}