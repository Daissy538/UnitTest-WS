package `londen-answer`.`unit-tests`

import org.Hamer.api.FlowerShop
import org.Hamer.core.Product
import org.Hamer.core.Stock
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class FlowerShopTests {

    @Mock
    lateinit var stock: Stock

    @Test
    fun`Get all Products`(){

        //Arrange
        val products = listOf(Product("Rose", 33.43))
        val flowerShop = FlowerShop(stock)
        doReturn(products).`when`(stock).getProducts()

        //Act
        val productsAfterAct = flowerShop.GetProducts()

        //Assert
        assertEquals(products, productsAfterAct)

    }

}