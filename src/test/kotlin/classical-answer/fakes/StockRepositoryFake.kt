package `classical-answer`.fakes

import org.Hamer.core.Product
import org.Hamer.core.StockRepository
import java.util.*

class StockRepositoryFake: StockRepository {
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