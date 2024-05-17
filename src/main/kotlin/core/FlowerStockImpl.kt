package core

import core.inputPort.FlowerStock
import core.outputPort.StockRepository
import core.entities.Product
import org.springframework.stereotype.Service

@Service
class FlowerStockImpl(private val flowerStockRepository: StockRepository): FlowerStock {
    override fun addFlower(flower: String, price: Double) {
        val product = Product(flower, price)

        flowerStockRepository.addProduct(product)
    }

    override fun getFlowers(): List<Product> {
        println("Print all flowers")
        return emptyList()
    }
}