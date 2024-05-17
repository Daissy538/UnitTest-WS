package `london-answer`.`unit-tests`

import org.Hamer.core.services.StockImpl
import core.outputPort.StockRepository
import core.entities.Product
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.verify
import kotlin.test.Test
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class FlowerStockTests {

    @Mock
    lateinit var stockRepository: StockRepository

    @Test
    fun `Add a new flower`() {
        // Given
        val flowerName = "Rose"
        val price = 10.0
        val sut = StockImpl(stockRepository) //sut = system under test

        // When
        sut.addProduct(flowerName, price)

        // Then
        verify(stockRepository).addProduct(Product(flowerName, price))
    }

    @Test
    fun `Get all flowers`() {
        // Given
        val product = Product("Rose", 10.0)
        val productsBeforeAct = listOf(product)

        doReturn(productsBeforeAct).`when`(stockRepository).getProducts()

        val sut = StockImpl(stockRepository)

        // When
        val productAfterAct = sut.getProducts()

        // Then
        assertEquals(productsBeforeAct, productAfterAct)
    }
}