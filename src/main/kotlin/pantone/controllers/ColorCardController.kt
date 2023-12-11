package pantone.controllers

import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pantone.bootstrap.dto.ColorCardDTO
import pantone.bootstrap.dto.fromDTO
import pantone.bootstrap.dto.toDTO
import pantone.services.ColorCardsService

@RestController
@CrossOrigin("*")
class ColorCardController {
    @Autowired
    private lateinit var colorCardsService: ColorCardsService

    @GetMapping("/pantone/colorCards")
    @Operation(summary = "returns all the color cards")
    fun colorCards(@RequestParam filters: Map<String, String>) = colorCardsService.colorCards(filters).map { it.toDTO() }

    @DeleteMapping("/pantone/deleteCard")
    @Operation(summary = "deletes the given color card")
    fun deleteColorCard(@RequestParam("id") id: Int){
        colorCardsService.deleteColorCard(id)
    }
}