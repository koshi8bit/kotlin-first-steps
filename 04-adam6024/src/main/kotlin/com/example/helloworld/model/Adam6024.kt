package com.example.helloworld.model

import kotlin.random.Random

class Adam6024 : Thread() {
    val adc = FloatArray(4)
    val dac = FloatArray(2)
    val di = BooleanArray(2)
    val do1 = BooleanArray(2)

    init {
        start()
    }

    override fun run() {
        while (true) {
            changeFloat(adc)
            changeFloat(dac)
            changeBoolean(di)
            changeBoolean(do1)
            //println("Adam6024 изменил значения")
            sleep(100)
        }
    }

    private fun changeFloat(array: FloatArray) {
        for ((index) in array.withIndex()) {
            array[index] = (0..10).random().toFloat()
        }
    }

    private fun changeBoolean(array: BooleanArray) {
        for ((index) in array.withIndex()) {
            array[index] = Random.nextBoolean()
        }
    }
}