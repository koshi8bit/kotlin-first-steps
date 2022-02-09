class Elv : Thread(), IDevice{
    override fun newData(sender: Adc) {
        if (sender.voltage > 2000000) {
            println("ELV слишком высокое напряжение: ${sender.voltage}")
        }
    }

    override fun run() {
//        while (true) {
//            //println("ELV усердно работает")
//            //sleep(7000)
//        }
    }
}