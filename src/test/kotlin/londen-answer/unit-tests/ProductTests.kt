package `londen-answer`.`unit-tests`

import org.Hamer.core.Product
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertNotNull

@ExtendWith(MockitoExtension::class)
class ProductTests {

    @Test
    fun `Create new product`() {

        //Arrange
        val name = "Rose"
        val price = 32.43

        //Act
        val product = Product(name, price)

        //Assert
        assertEquals(name, product.name)
        assertEquals(price, product.price)
        assertNotNull(product.code)
    }

    @Test
    fun `Should not create product with negative number`() {

        //Arrange
        val name = "Rose"
        val price = -32.43

        //Act
        assertFails{Product(name, price)}
    }

}