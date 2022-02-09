class TemperatureSensor : Thread(), IDevice {
    override fun newData(sender: Adc) {
        if (sender.temperature > 150) {
            println("TemperatureSensor высокий показатель температуры: ${sender.temperature}")
        }
    }

    override fun run() {
        while (true) {
            //println("TemperatureSensor усердно работает")
            //sleep(7000)
        }
    }
}