import java.util.*

fun main() {
    val cellStorage = CellStorage()

    while (true) {
        val input = readln().trim()
        val parts = input.split(" ")

        if (parts.isEmpty()) {
            println("ERROR")
            continue
        }

        val command = parts[0].lowercase(Locale.getDefault())
        val index = if (parts.size > 1) parts[1].toIntOrNull() else null
        val text = if (parts.size > 2) parts.subList(2, parts.size).joinToString(" ") else null


        when (command) {
            "get" -> {
                if (index != null) {
                    cellStorage.get(index)
                } else {
                    println("ERROR")
                }
            }

            "set" -> {
                if (index != null) {
                    if (text != null) {
                        cellStorage.set(index, text)
                    }
                } else {
                    println("ERROR")
                }
            }

            "delete" -> {
                if (index != null) {
                    cellStorage.delete(index)
                } else {
                    println("ERROR")
                }
            }

            "exit" -> return
            else -> println("ERROR")
        }
    }
}
