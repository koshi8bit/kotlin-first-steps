import java.util.ArrayList

class Adc() : Thread(), IPublisher<IDevice> {
    override val observers: ArrayList<IDevice> = ArrayList()

    private fun dataReady(sender: Adc) {
        observers.forEach { it.newData(sender) }
    }

    var temperature  = 0
    var voltage  = 0

    override fun run() {
        while (true) {
            sleep(500)
            temperature = (0..200).random()
            voltage = (0..2300000).random()
            println("ADC t=$temperature; v=$voltage")
            dataReady(this)
        }
    }

}