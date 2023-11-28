package com.sailsman.hyperspring

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LandingController {

    @GetMapping("/")
    fun landing(model: Model): String {
        model["title"] = "Landing"
        return "index"
    }

}