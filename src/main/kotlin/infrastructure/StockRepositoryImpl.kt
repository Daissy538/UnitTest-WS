package infrastructure

import org.Hamer.core.StockRepository
import org.Hamer.core.Product
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class StockRepositoryImpl: StockRepository {

    private val products: MutableList<Product> = mutableListOf()

    override fun addProduct(product: Product) {
        this.products.add(product)
    }

    override fun getProducts(): List<Product> {
        return products.toList()
    }

    override fun getProduct(id: UUID): Product?{
        return products.find { it.code == id }
    }

}