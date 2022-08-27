package com.oopchoi4.adminkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdminKotlinApplication

fun main(args: Array<String>) {
	runApplication<AdminKotlinApplication>(*args)

	println("test")
}
