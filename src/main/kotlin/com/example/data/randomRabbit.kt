import com.example.data.HexoCode
import com.example.data.Rabbit
import com.example.data.Tutorial
import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File
import com.example.data.Tutorial.Shift
import com.example.ticket.Data.Shedule.getJsonDataFromAsset

private const val BASE_URL = "https://api25806.herokuapp.com"

private val rabbits = listOf(
    Rabbit("Carl","Brown rabbi","$BASE_URL/rabbits/rabbit1.png")
)

private val hexes = listOf (
    HexoCode("0xff3399","First"),
    HexoCode("0xff33FF","Second")
)

private val gson = Gson()
private val json = getJsonDataFromAsset()
private val topic = gson.fromJson(json, Shift::class.java)
fun Route.randomRabbit() {
    get("/randomRabbit") {
        call.respond(
            HttpStatusCode.OK,
        )
    }
    get("/") {
        call.respondText("HELLO WORLD I changed!...once again", contentType = ContentType.Text.Plain)
    }

    get("/test") {
        call.respondText("Message received",contentType = ContentType.Text.Plain)
    }
    get("/firstBall") {
        call.respond(HttpStatusCode.OK,hexes)
    }
    post("/postting") {
        call.respondText("yoooooooooo")
    }


}