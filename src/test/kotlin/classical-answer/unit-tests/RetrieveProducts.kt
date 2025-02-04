package `classical-answer`.`unit-tests`

import `classical-answer`.fakes.StockRepositoryFake
import org.Hamer.core.Stock
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RetrieveProducts {

    @Test
    fun `Retrieve all products`(){

        //Arrange
        val name = "Rose"
        val price = 32.39

        val stockRepository = StockRepositoryFake()
        val stock = Stock(stockRepository)

        //Act
        stock.addProduct(name, price)
        stock.addProduct(name, price)
        stock.addProduct(name, price)

        //Assert
        val products =  stock.getProducts()
        assertEquals(3, products.size)
    }
}