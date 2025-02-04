package org.Hamer.api

import org.Hamer.core.Product
import org.Hamer.core.Stock
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.server.ResponseStatusException

@Controller
class FlowerShop(private val stock: Stock) {

    @GetMapping("/")
    fun GetProducts(): List<Product> {
        val products = stock.getProducts()
        return products
    }

    @PostMapping("/")
    fun AddProduct(name: String, price: Double){
        try {
            stock.addProduct(name, price)
        }catch (exception: Exception){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST)
        }
    }
}