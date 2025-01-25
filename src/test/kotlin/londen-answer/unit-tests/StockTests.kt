package `londen-answer`.`unit-tests`

import org.Hamer.core.Stock
import org.Hamer.core.StockRepository
import org.Hamer.core.Product
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.verify
import java.util.UUID
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@ExtendWith(MockitoExtension::class)
class StockTests {

    @Mock
    lateinit var stockRepository: StockRepository

    @Test
    fun `Add a new flower`() {
        // Arrange
        val flowerName = "Rose"
        val price = 10.0
        val sut = Stock(stockRepository) //sut = system under test

        // Act
        sut.addProduct(flowerName, price)

        // Assert
        verify(stockRepository).addProduct(Product(flowerName, price))
    }

    @Test
    fun `Get all flowers`() {
        // Arrange
        val product = Product("Rose", 10.0)
        val productsBeforeAct = listOf(product)

        doReturn(productsBeforeAct).`when`(stockRepository).getProducts()

        val sut = Stock(stockRepository)

        // Act
        val productAfterAct = sut.getProducts()

        // Assert
        assertEquals(productsBeforeAct, productAfterAct)
    }

    @Test
    fun `Should throw error when product is not in stock`(){
        // Arrange
        val id = UUID.randomUUID()

        doReturn(null).`when`(stockRepository).getProduct(id)

        val sut = Stock(stockRepository)

        // Act & Assert
        assertFailsWith<Exception>{sut.getPriceOfProduct(id)}
    }

    @Test
    fun `Get the price of a product`(){
        // Arrange
        val product = Product("Rose", 10.0)

        doReturn(product).`when`(stockRepository).getProduct(product.code)
        val sut = Stock(stockRepository) //sut = system under test

        // Act
        val priceAfterAct = sut.getPriceOfProduct(product.code)

        // Assert
        verify(stockRepository).getProduct(product.code)
        assertEquals(product.price, priceAfterAct)
    }

    @Test
    fun `Retrieve total product stock`(){
        // Arrange
        val product = Product("Rose", 10.0)
        val product2 = Product("Tree", 25.00)
        val productsBeforeAct = listOf(product, product2)

        val totalStockPriceBeforeAct = productsBeforeAct.sumOf { it.price }

        doReturn(productsBeforeAct).`when`(stockRepository).getProducts()

        val sut = Stock(stockRepository)

        // Act
        val totalStockPriceAfterAct = sut.totalStockPrice()

        // Assert
        assertEquals(totalStockPriceBeforeAct, totalStockPriceAfterAct)
    }
}