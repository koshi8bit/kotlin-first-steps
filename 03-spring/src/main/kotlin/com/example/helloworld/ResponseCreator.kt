package com.example.helloworld

import org.json.simple.JSONObject
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class ResponseCreator {
    private val json = JSONObject()

    fun makeJson(map: Map<String, Any>): JSONObject {
        json.clear()
        for ((key, value) in map) {
            json[key] = value
        }
        return json
    }

    fun makeResponse(json: JSONObject, status: HttpStatus,  headers: HttpHeaders = HttpHeaders()): ResponseEntity<JSONObject> {
        return ResponseEntity<JSONObject>(json, headers, status)
    }

    fun ok(json: JSONObject): ResponseEntity<JSONObject> {
        return ResponseEntity.ok(json)
    }

    fun ok(param: Any): ResponseEntity<Any> {
        return ResponseEntity.ok(param)
    }
}