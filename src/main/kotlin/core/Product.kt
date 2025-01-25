package org.Hamer.core

import java.util.UUID

data class Product(val name: String, val price: Double) {

    val code: UUID = UUID.randomUUID()

    init {
        if(price < 0){
            throw Exception("Price can't be negative")
        }
    }
}
