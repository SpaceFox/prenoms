package fr.spacefox.prenoms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PrenomsApplication

fun main(args: Array<String>) {
	runApplication<PrenomsApplication>(*args)
}
