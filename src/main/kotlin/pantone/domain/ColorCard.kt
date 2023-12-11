package pantone.domain

class ColorCard(val code: Int, val texture: Texture, val hexaColor: String){
    var id = 0
}

enum class Texture{ C, U }