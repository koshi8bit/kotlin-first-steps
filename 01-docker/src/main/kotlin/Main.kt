import java.io.FileWriter
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.*



fun main() {
    val envVar : String = System.getenv("LOG_PATH_CONTAINER")
        ?: throw Exception("Переменная окружения LOG_PATH_CONTAINER не найдена")

    val fileName = Paths.get(envVar, getFileName()).toString()
    println("Название файла: $fileName")
    while (true) {
        val fileWriter = FileWriter(fileName, true)
        fileWriter.write("${getDateAndTime()}\n")
        println(getDateAndTime())
        fileWriter.close()
        Thread.sleep(5000)
    }
}

fun getDateAndTime(): String {
    val today = Calendar.getInstance()
    val date = SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss").format(today.time)
    return date.toString()
}

fun getFileName(): String {
    val today = Calendar.getInstance()
    val date = SimpleDateFormat("YYYY-MM-dd'T'HH-mm-ss").format(today.time)
    return "$date.txt"
}