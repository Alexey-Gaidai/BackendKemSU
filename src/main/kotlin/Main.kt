import kotlinx.serialization.decodeFromString
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main(args: Array<String>) {
    getWeather()
}

fun getWeather(): Model {
    val client = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.openweathermap.org/data/2.5/forecast?&appid=625b6fd5c5be3e9c809460446a1fd3e9&q=Kemerovo&units=metric"))
        .build()
    val response = client.send(request, HttpResponse.BodyHandlers.ofString())
    println(response.body())

    val json = response.body()
    val weather = kotlinx.serialization.json.Json.decodeFromString<Model>(json)
    return weather
}
