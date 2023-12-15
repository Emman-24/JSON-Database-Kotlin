import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket

const val ADDRESS = "127.0.0.1"
const val PORT = 23456

class Server(address: String, port: Int) {

    private val server = ServerSocket(port, 50, InetAddress.getByName(address)).also {
        println("Server started!")
    }
    private val socket: Socket = server.accept()
    private val input = DataInputStream(socket.getInputStream())
    private val output = DataOutputStream(socket.getOutputStream())

    fun receive(): String = input.readUTF().also {
        println("Received: $it")
    }

    fun send(response: String) = println("Sent: $response").run {
        output.writeUTF(response)
    }
}

fun main() {
    Server(ADDRESS, PORT).apply {
        val recordId = receive().substringAfter("#").trim().toInt()
        send("A record # $recordId was sent!")
    }
}