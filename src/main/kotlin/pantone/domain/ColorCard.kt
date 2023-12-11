package pantone.domain

class ColorCard(val id: Int, val code: Int, val texture: Texture, val hexaColor: String)

enum class Texture{ C, U }