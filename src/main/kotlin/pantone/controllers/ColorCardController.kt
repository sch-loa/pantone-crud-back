package pantone.controllers

import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import pantone.dto.ColorCardDTO
import pantone.dto.fromDTO
import pantone.dto.toDTO
import pantone.services.ColorCardsService

@RestController
@CrossOrigin("*")
class ColorCardController {
    @Autowired
    private lateinit var colorCardsService: ColorCardsService

    @GetMapping("/pantone/colorCards")
    @Operation(summary = "returns all the color cards")
    fun colorCards(@RequestParam filters: Map<String, String>) = colorCardsService.colorCards(filters).map { it.toDTO() }

    @PostMapping("/pantone/createColorCard")
    @Operation(summary = "creates a new color card")
    fun createColorCard(@RequestBody colorCard: ColorCardDTO){
        colorCardsService.createColorCard(colorCard.fromDTO())
    }

    @PutMapping("/pantone/updateColorCard")
    @Operation(summary = "updates an existing color card")
    fun updateColorCard(@RequestBody colorCard: ColorCardDTO){
        colorCardsService.updateColorCard(colorCard.fromDTO())
    }

    @DeleteMapping("/pantone/deleteCard")
    @Operation(summary = "deletes the given color card")
    fun deleteColorCard(@RequestParam("id") id: Int){
        colorCardsService.deleteColorCard(id)
    }
}