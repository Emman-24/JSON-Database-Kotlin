class CellStorage {
    var cellValues = mutableMapOf<Int, String>()

    fun get(index: Int) {
        if (index < 1 || index > 100 || cellValues[index - 1] == null) {
            println("ERROR")
        } else {
            println(cellValues[index - 1])
        }
    }

    fun set(index: Int, text: String) {
        if (index < 1 || index > 100) {
            println("ERROR")
            return
        }
        cellValues[index - 1] = text
        println("OK")
    }

    fun delete(index: Int) {
        if (index < 1 || index > 100) {
            println("ERROR")
            return
        }
        cellValues.remove(index - 1)
        println("OK")
    }
}