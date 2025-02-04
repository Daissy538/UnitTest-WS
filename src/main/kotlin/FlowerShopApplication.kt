package org.Hamer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class FlowerShopApplication

fun main(args: Array<String>) {
    runApplication<FlowerShopApplication>(*args)
}