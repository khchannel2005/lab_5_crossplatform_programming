package com.example.gym

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GymApiApplication

fun main(args: Array<String>) {
    runApplication<GymApiApplication>(*args)
}