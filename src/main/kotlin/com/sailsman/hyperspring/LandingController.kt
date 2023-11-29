package com.sailsman.hyperspring

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class LandingController {

    var products: List<Product> = mutableListOf(
        Product("dsroute", "DSRoute - HyperSpring Edition")
    )

    @GetMapping("/")
    fun landing(model: Model): String {
        model["title"] = "Landing"
        model["products"] = products
        return "index"
    }
}

data class Product(
    var viewName: String,
    var displayName: String
)