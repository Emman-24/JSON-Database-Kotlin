import java.io.DataInputStream
import java.io.DataOutputStream
import java.net.InetAddress
import java.net.Socket

//const val ADDRESS = "127.0.0.1"
//const val PORT = 23456

class Client(address: String, port: Int) {
    private val socket = Socket(InetAddress.getByName(address), port).also {
        println("Client started!")
    }
    private val input = DataInputStream(socket.getInputStream())
    private val output = DataOutputStream(socket.getOutputStream())

    fun send(request: String) = output.writeUTF(request).also {
        println("Sent: $request")
    }

    fun receive(): String = input.readUTF().also {
        println("Received: $it")
    }
}

fun main() {
    Client(ADDRESS, PORT).apply {
        send("Give me a record # 12")
        receive()
    }
}