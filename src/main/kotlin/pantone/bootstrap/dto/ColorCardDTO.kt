package pantone.bootstrap.dto

import pantone.domain.ColorCard
import pantone.domain.Texture

class ColorCardDTO(val id: Int, val code: Int, val type: String, val hexaColor: String)

fun ColorCard.toDTO() = ColorCardDTO(this.id, this.code, this.texture.name, this.hexaColor)
fun ColorCardDTO.fromDTO() = ColorCard(this.id, this.code, Texture.valueOf(this.type), this.hexaColor)