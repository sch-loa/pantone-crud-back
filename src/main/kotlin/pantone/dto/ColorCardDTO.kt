package pantone.dto

import pantone.domain.ColorCard
import pantone.domain.Texture

class ColorCardDTO(val id: Int, val code: Int, val type: String, val hexaColor: String)

fun ColorCard.toDTO() = ColorCardDTO(this.id, this.code, this.texture.name, this.hexaColor)
fun ColorCardDTO.fromDTO(): ColorCard {
    val card = ColorCard(this.code, Texture.valueOf(this.type), this.hexaColor)
    card.id = this.id
    return card
}