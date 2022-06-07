package com.example.helloworld.controllers

import com.example.helloworld.ResponseCreator
import com.example.helloworld.Adam6024
import org.json.simple.JSONObject
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("adam6024/")
class Controller {
    val adam6024 = Adam6024()
    val responseCreator = ResponseCreator()

    @GetMapping
    fun adam(): ResponseEntity<JSONObject> {
        return responseCreator.ok(
            responseCreator.makeJson(
                mapOf(
                    "ADC" to adam6024.adc,
                    "DAC" to adam6024.dac,
                    "DI" to adam6024.di,
                    "DO" to adam6024.do1
                )
            )
        )
    }

    @GetMapping("ADC")
    fun adc(): ResponseEntity<JSONObject> {
        return responseCreator.ok(
            responseCreator.makeJson(
                mapOf(
                    "ADC" to adam6024.adc
                )
            )
        )
    }

    @GetMapping("ADC/{index}")
    fun adcWithIndex(@PathVariable index: Int): ResponseEntity<out Any> {
        if ((index >= adam6024.adc.size) or (index < 0)) {
            return responseCreator.makeResponse(
                responseCreator.makeJson(
                    mapOf(
                        "status" to HttpStatus.BAD_REQUEST.value(),
                        "error" to "ADC с таким индексом отсутствует"
                    )
                ), HttpStatus.BAD_REQUEST
            )
        }

        return responseCreator.ok(adam6024.adc[index])
    }

    @GetMapping("DAC")
    fun dac(): ResponseEntity<JSONObject> {
        return responseCreator.ok(
            responseCreator.makeJson(
                mapOf(
                    "DAC" to adam6024.dac
                )
            )
        )
    }

    @GetMapping("DAC/{index}")
    fun dacWithIndex(@PathVariable index: Int): ResponseEntity<out Any> {
        if ((index >= adam6024.dac.size) or (index < 0)) {
            return responseCreator.makeResponse(
                responseCreator.makeJson(
                    mapOf(
                        "status" to HttpStatus.BAD_REQUEST.value(),
                        "error" to "DAC с таким индексом отсутствует"
                    )
                ), HttpStatus.BAD_REQUEST
            )
        }

        return responseCreator.ok(adam6024.dac[index])
    }

    @PostMapping("DAC/set")
    fun setDac(@RequestParam map: HashMap<String, String>): ResponseEntity<JSONObject> {
        val result = HashMap<Int, Float>()

        for ((key, value) in map) {
            val intKey = try {
                key.toInt()
            } catch (e: NumberFormatException) {
                return responseCreator.makeResponse(
                    responseCreator.makeJson(
                        mapOf(
                            "status" to HttpStatus.BAD_REQUEST.value(),
                            "error" to "На месте параметра $key ожидается целочисленное значение"
                        )
                    ), HttpStatus.BAD_REQUEST
                )
            }

            val floatValue = try {
                value.toFloat()
            } catch (e: NumberFormatException) {
                return responseCreator.makeResponse(
                    responseCreator.makeJson(
                        mapOf(
                            "status" to HttpStatus.BAD_REQUEST.value(),
                            "error" to "На месте параметра $value ожидается числовое значение"
                        )
                    ), HttpStatus.BAD_REQUEST
                )

            }


            if ((adam6024.dac.lastIndex >= intKey) and (intKey >= 0)) {
                result[intKey] = floatValue
            } else {
                return responseCreator.makeResponse(
                    responseCreator.makeJson(
                        mapOf(
                            "status" to HttpStatus.BAD_REQUEST.value(),
                            "error" to "Невалидный индекс: $intKey"
                        )
                    ), HttpStatus.BAD_REQUEST
                )
            }
        }

        for ((key, value) in result) {
            adam6024.dac[key] = value
        }

        return dac()
    }

    @GetMapping("DI")
    fun di(): ResponseEntity<JSONObject> {
        return responseCreator.ok(
            responseCreator.makeJson(
                mapOf(
                    "DI" to adam6024.di
                )
            )
        )
    }

    @GetMapping("DI/{index}")
    fun diWithIndex(@PathVariable index: Int): ResponseEntity<out Any> {
        if ((index >= adam6024.di.size) or (index < 0)) {
            return responseCreator.makeResponse(
                responseCreator.makeJson(
                    mapOf(
                        "status" to HttpStatus.BAD_REQUEST.value(),
                        "error" to "DI с таким индексом отсутствует"
                    )
                ), HttpStatus.BAD_REQUEST
            )
        }
        return responseCreator.ok(adam6024.di[index])
    }

    @GetMapping("DO")
    fun do1(): ResponseEntity<JSONObject> {
        return responseCreator.ok(
            responseCreator.makeJson(
                mapOf(
                    "DO" to adam6024.do1
                )
            )
        )
    }

    @GetMapping("DO/{index}")
    fun doWithIndex(@PathVariable index: Int): ResponseEntity<out Any> {
        if ((index >= adam6024.do1.size) or (index < 0)) {
            return responseCreator.makeResponse(
                responseCreator.makeJson(
                    mapOf(
                        "status" to HttpStatus.BAD_REQUEST.value(),
                        "error" to "DO с таким индексом отсутствует"
                    )
                ), HttpStatus.BAD_REQUEST
            )
        }
        return responseCreator.ok(adam6024.do1[index])
    }

    @PostMapping("DO/set")
    fun setDo(
        @RequestParam(name = "0", required = false) param0: Boolean?,
        @RequestParam(name = "1", required = false) param1: Boolean?
    ): ResponseEntity<JSONObject> {
        if (param0 != null) {
            adam6024.do1[0] = param0
        }
        if (param1 != null) {
            adam6024.do1[1] = param1
        }
        return do1()
    }
}