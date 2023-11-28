package com.sailsman.hyperspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HyperSpringApplication

fun main(args: Array<String>) {
	runApplication<HyperSpringApplication>(*args)
}
