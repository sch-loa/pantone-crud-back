package pantone.controller

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
class ColorCardController {
    @GetMapping("/greeting")
    @Operation(summary = "greeting")
    fun defaultGet(): String = "hello"
}