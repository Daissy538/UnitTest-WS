package `london-answer`.`unit-tests`

import core.FlowerStockImpl
import core.outputPort.StockRepository
import core.entities.Product
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class FlowerStockTests {

    @Mock
    lateinit var stockRepository: StockRepository

    @Test
    fun `Add a new flower`() {
        // Given
        val flowerName = "Rose"
        val price = 10.0
        val sut = FlowerStockImpl(stockRepository) //sut = system under test

        // When
        sut.addFlower(flowerName, price)

        // Then
        verify(stockRepository).addProduct(Product(flowerName, price))
    }
}