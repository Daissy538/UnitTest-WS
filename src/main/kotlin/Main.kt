package org.Hamer

import application.FlowerShop

fun main() {
    run()
}

private fun run() {
    val flowerShop = FlowerShop()

    val running = true
    while(running){

        flowerShop.selectionMenu()

    }
    println("Hello World!")
}