package `classical-answer`.`unit-tests`

import `classical-answer`.fakes.StockRepositoryFake
import org.Hamer.core.Stock
import kotlin.test.Test
import kotlin.test.assertEquals

class CheckProductPrices {

    @Test
    fun `Check the prices of a specific product`(){
        //Arrange
        val name = "Rose"
        val price = 32.39

        val stockRepository = StockRepositoryFake()
        val stock = Stock(stockRepository)

        stock.addProduct(name, price)

        val products =  stock.getProducts()
        val product = products.first()

        //Act
        val totalPrice = stock.getPriceOfProduct(product.code)

        //Assert
        assertEquals(price, totalPrice)
    }

    @Test
    fun `Check the total stock price`(){
        //Arrange
        val name = "Rose"
        val price = 32.39

        val stockRepository = StockRepositoryFake()
        val stock = Stock(stockRepository)

        stock.addProduct(name, price)
        stock.addProduct(name, price)
        stock.addProduct(name, price)

        val expextedTotalPrice = price*3

        //Act
        val totalPrice = stock.totalStockPrice()

        //Assert
        assertEquals(expextedTotalPrice, totalPrice)


    }

}