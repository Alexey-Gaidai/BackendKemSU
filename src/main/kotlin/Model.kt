
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Model(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Weather>,
    val message: Int
) {
    @Serializable
    data class City(
        val coord: Coord,
        val country: String,
        val id: Int,
        val name: String,
        val population: Int,
        val sunrise: Int,
        val sunset: Int,
        val timezone: Int
    ) {
        @Serializable
        data class Coord(
            val lat: Double,
            val lon: Double
        )
    }

    @Serializable
    data class Weather(
        val clouds: Clouds,
        val dt: Int,
        @SerialName("dt_txt")
        val dtTxt: String,
        val main: Main,
        val pop: Double,
        val sys: Sys,
        val visibility: Int,
        val weather: List<Weather>,
        val wind: Wind
    ) {
        @Serializable
        data class Clouds(
            val all: Int
        )

        @Serializable
        data class Main(
            @SerialName("feels_like")
            val feelsLike: Double,
            @SerialName("grnd_level")
            val grndLevel: Int,
            val humidity: Int,
            val pressure: Int,
            @SerialName("sea_level")
            val seaLevel: Int,
            val temp: Double,
            @SerialName("temp_kf")
            val tempKf: Double,
            @SerialName("temp_max")
            val tempMax: Double,
            @SerialName("temp_min")
            val tempMin: Double
        )

        @Serializable
        data class Sys(
            val pod: String
        )

        @Serializable
        data class Weather(
            val description: String,
            val icon: String,
            val id: Int,
            val main: String
        )

        @Serializable
        data class Wind(
            val deg: Int,
            val gust: Double,
            val speed: Double
        )
    }
}