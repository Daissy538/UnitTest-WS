package `classical-answer`.`unit-tests`

import `classical-answer`.fakes.StockRepositoryFake
import org.Hamer.core.Stock
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertNotNull

class AddProductsToTheShop {

    @Test
    fun `When product input is correct`(){

        //Arrange
        val name = "Rose"
        val price = 32.39

        val stockRepository = StockRepositoryFake()
        val stock = Stock(stockRepository)

        //Act
        stock.addProduct(name, price)

        //Assert
        val products =  stock.getProducts()
        assertEquals(1, products.size)
        assertEquals(name, products.first().name)
        assertEquals(price, products.first().price)
        assertNotNull(products.first().code)
    }


    @Test
    fun `Not when product price is negative`(){

        //Arrange
        val name = "Rose"
        val priceNegative = -32.39

        val stockRepository = StockRepositoryFake()
        val stock = Stock(stockRepository)

        //Act
        assertFails { stock.addProduct(name, priceNegative)}

        //Assert
        val products =  stock.getProducts()
        assertEquals(0, products.size)
    }
}