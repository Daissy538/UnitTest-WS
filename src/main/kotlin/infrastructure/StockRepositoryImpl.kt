package infrastructure

import core.outputPort.StockRepository
import core.entities.Product
import org.springframework.stereotype.Repository

@Repository
class StockRepositoryImpl: StockRepository {
    override fun addProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun getProducts(): List<Product> {
        TODO("Not yet implemented")
    }

}