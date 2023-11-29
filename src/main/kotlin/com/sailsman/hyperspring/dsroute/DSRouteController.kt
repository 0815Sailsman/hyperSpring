package com.sailsman.hyperspring.dsroute

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class DSRouteController {

    @GetMapping("/dsroute")
    fun landing(model: Model): String {
        model["title"] = "DSRoute"
        return "dsroute/dsroute"
    }

}