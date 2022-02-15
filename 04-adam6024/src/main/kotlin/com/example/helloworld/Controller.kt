package com.example.helloworld

import com.example.helloworld.model.Adam6024
import org.json.simple.JSONObject
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("adam6024/")
class Controller {
    val adam6024 = Adam6024()
    val json = JSONObject()

    @GetMapping
    fun adam(): ResponseEntity<JSONObject> {
        json.clear()
        json["ADC"] = adam6024.adc
        json["DAC"] = adam6024.dac
        json["DI"] = adam6024.di
        json["DO"] = adam6024.do1
        return ResponseEntity.ok(json)
    }

    @GetMapping("ADC")
    fun adc(): ResponseEntity<JSONObject> {
        json.clear()
        json["ADC"] = adam6024.adc
        return ResponseEntity.ok(json)
    }

    @GetMapping("ADC/{index}")
    fun adcWithIndex(@PathVariable index: Int): ResponseEntity<Any> {
        if (index >= adam6024.adc.size) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка: ADC с таким индексом отсутствует")
        }

        return ResponseEntity.ok(adam6024.adc[index])
    }

    @GetMapping("DAC")
    fun dac(): ResponseEntity<JSONObject> {
        json.clear()
        json["DAC"] = adam6024.dac
        return ResponseEntity.ok(json)
    }

    @GetMapping("DAC/{index}")
    fun dacWithIndex(@PathVariable index: Int): ResponseEntity<Any> {
        if (index >= adam6024.dac.size) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка: DAC с таким индексом отсутствует")
        }

        return ResponseEntity.ok(adam6024.dac[index])
    }

    @GetMapping("DI")
    fun di(): ResponseEntity<JSONObject> {
        json.clear()
        json["DI"] = adam6024.di
        return ResponseEntity.ok(json)
    }

    @GetMapping("DI/{index}")
    fun diWithIndex(@PathVariable index: Int): ResponseEntity<Any> {
        if (index >= adam6024.di.size) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка: DI с таким индексом отсутствует")
        }

        return ResponseEntity.ok(adam6024.di[index])
    }

    @GetMapping("DO")
    fun do1(): ResponseEntity<JSONObject> {
        json.clear()
        json["DO"] = adam6024.do1
        return ResponseEntity.ok(json)
    }

    @GetMapping("DO/{index}")
    fun doWithIndex(@PathVariable index: Int): ResponseEntity<Any> {
        if (index >= adam6024.do1.size) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ошибка: DO с таким индексом отсутствует")
        }

        return ResponseEntity.ok(adam6024.do1[index])
    }
}