package kr.mrjimin.listify.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Date

@RestController
class ReactTestController {

    @GetMapping("/api/time")
    fun time(): Date {
        return Date()
        // return "안녕하세요. 현재 서버시간은 ${Date()} 입니다. :)"
    }

    @GetMapping("/api/hello")
    fun hello(): String {
        return "Hello World!"
    }
}