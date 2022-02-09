fun main() {
    val adam6024 = Adc()
    val elv = Elv()
    val temperatureSensor = TemperatureSensor()

    adam6024.addListener(elv)
    adam6024.addListener(temperatureSensor)

    elv.start()
    temperatureSensor.start()
    adam6024.start()
}
