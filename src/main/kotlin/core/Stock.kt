package org.Hamer.core

import org.springframework.stereotype.Service
import java.util.*


@Service
class Stock(private val stockRepository: StockRepository) {
     fun addProduct(name: String, price: Double) {
        val product = Product(name, price)

        stockRepository.addProduct(product)
    }

    fun getProducts(): List<Product> {
        return stockRepository.getProducts()
    }

    fun getPriceOfProduct(code: UUID): Double {
        val product = stockRepository.getProduct(code)

        if(product == null){
            throw Exception("Product $code not found")
        }

        return product.price
    }

    fun totalStockPrice(): Double {
        val products = stockRepository.getProducts();

        return products.sumOf { it.price }
    }

}