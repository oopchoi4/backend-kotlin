package com.oopchoi4.adminkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

@SpringBootApplication
class AdminKotlinApplication

fun main(args: Array<String>) {
	configureApplication(SpringApplicationBuilder()).run(*args)
}

fun configureApplication(builder: SpringApplicationBuilder): SpringApplicationBuilder {
	return builder.sources(AdminKotlinApplication::class.java)
}
