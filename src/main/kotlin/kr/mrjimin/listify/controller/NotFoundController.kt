package kr.mrjimin.listify.controller

import org.springframework.boot.webmvc.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping



@Controller
class NotFoundController : ErrorController {
    @GetMapping()
    fun index(): String {
        return "index.html"
    }
}