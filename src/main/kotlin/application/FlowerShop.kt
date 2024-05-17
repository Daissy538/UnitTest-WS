package application

class FlowerShop {

    fun selectionMenu(){
        val stringBuilder = StringBuilder();
        stringBuilder.append("Enter a command: ")
        stringBuilder.append("1: add a new flower\n")
        stringBuilder.append("2: get all flowers\n")
        stringBuilder.append("exit or e: exit the program\n")

        val input = readlnOrNull()

        when(input?.lowercase()) {
            "1" -> addNewFlower()
            "2" -> printAllFlowers()
            else -> println("Unknown command")
        }
    }

    private fun printAllFlowers() {
        println("Print all flowers")
    }

    private fun addNewFlower() {
        println("Adding new flower")
    }
}