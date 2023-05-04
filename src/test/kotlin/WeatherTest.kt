import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class WeatherTest {

    @Test
    fun testModelDeserialization() {
        val weatherPath = "src\\test\\kotlin\\weather_json.txt"
        val json = java.io.File(weatherPath).readText(Charsets.UTF_8)
        val model = Json.decodeFromString<Model>(json)
        assertEquals("Kemerovo", model.city.name)
        assertEquals(40, model.cnt)
        assertEquals("200", model.cod)
        assertEquals(1503901, model.city.id)
    }

    @Test
    fun testModelSerialization() {
        val model = getWeather()
        val json = Json.encodeToString(Model.serializer(), model)
        val model2 = Json.decodeFromString<Model>(json)
        assertEquals(model, model2)
    }
}
