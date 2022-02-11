package com.example.helloworld

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("adc01/")
class Controller {

    @GetMapping("temperature")
    fun temperature(): ResponseEntity<Int> {
        return ResponseEntity.ok((0..200).random())
    }

    @GetMapping("voltage")
    fun voltage(): ResponseEntity<Int> {
        return ResponseEntity.ok((0..2300000).random())
    }

    @GetMapping()
    fun temperatureAndVoltage(): ResponseEntity<String> {
        return ResponseEntity.ok("Temperature: ${(0..200).random()} & Voltage: ${(0..2300000).random()}")
    }
}