package pantone.domain

class ColorCard(var code: Int, var texture: Texture, var hexaColor: String){
    var id = 0
}

enum class Texture{ C, U }