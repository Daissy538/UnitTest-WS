package `londen-answer`.`unit-tests`

import org.Hamer.core.Product
import infrastructure.StockRepositoryImpl
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class StockRepositoryTests {

    @Test
    fun `Add a new product`() {
        // Arrange
        val flowerName = "Rose"
        val price = 10.0

        val product = Product(flowerName, price);
        val sut = StockRepositoryImpl() //sut = system under test

        // Act
        sut.addProduct(product)

        // Assert
        val afterSut = sut.getProduct(product.code)

        assertEquals(product, afterSut)
    }

    @Test
    fun `Retrieve correct product`(){
        // Arrange
        val flowerName = "Rose"
        val price = 10.0

        val product = Product(flowerName, price)

        val productIncorrect = Product("Wrong", price)

        val sut = StockRepositoryImpl() //sut = system under test

        // Act
        sut.addProduct(product)
        sut.addProduct(productIncorrect)

        // Assert
        val afterSut = sut.getProduct(product.code)

        assertEquals(product, afterSut)
        assertNotEquals(product, productIncorrect)
    }

    @Test
    fun `Retrieve all products`(){
        // Arrange
        val price = 10.0

        val product1 = Product("Rose1", price)
        val product2 = Product("Rose2", price)

        val sut = StockRepositoryImpl() //sut = system under test

        // Act
        sut.addProduct(product1)
        sut.addProduct(product2)

        // Assert
        val afterSut = sut.getProducts()

        assertEquals(2, afterSut.size)
        assertEquals(listOf(product1, product2), afterSut)
    }

}