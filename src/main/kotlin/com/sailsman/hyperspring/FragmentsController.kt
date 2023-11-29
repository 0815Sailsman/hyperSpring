package com.sailsman.hyperspring

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class FragmentsController {

    @GetMapping("/products")
    fun getHome(): String {
        return "products"
    }
}