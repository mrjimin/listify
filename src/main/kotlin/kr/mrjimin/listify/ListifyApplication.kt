package kr.mrjimin.listify

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class ListifyApplication

fun main(args: Array<String>) {
    runApplication<ListifyApplication>(*args)
}