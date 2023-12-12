package pantone.repository

import org.springframework.stereotype.Repository
import pantone.domain.ColorCard
import pantone.domain.Texture

@Repository
class ColorCardsRepository {
    var collection: MutableSet<ColorCard> = mutableSetOf()

    fun getByID(id: Int) = collection.find { it.id == id }
    fun create(colorCard: ColorCard){
        if(isNew(colorCard)){
            colorCard.id = assignId()
            collection.add(colorCard)
        }
    }

    fun searchByTexture(texture: Texture)= collection.filter { it.texture == texture }.toMutableSet()

    fun searchByExpression(expression: String): MutableSet<ColorCard>{
        return collection.filter {
            it.code.toString().contains(expression) || it.hexaColor.contains(expression)
        }.toMutableSet()
    }

    fun searchByRange(min: String?, max: String?): MutableSet<ColorCard>{
        val filteredMin =  if(min != null) collection.filter { it.hexaColor.toInt(16) >= min.toInt(16) } else collection
        val filteredMax =  if(max != null) collection.filter { it.hexaColor.toInt(16) <= max.toInt(16) } else collection

        return filteredMin.intersect(filteredMax.toSet()).toMutableSet()
    }
    fun update(colorCard: ColorCard){
        val card = getByID(colorCard.id)
        if( card != null){
            card.code = colorCard.code
            card.texture = colorCard.texture
            card.hexaColor = colorCard.hexaColor
        }
    }

    fun delete(colorCard: ColorCard){ collection.remove(colorCard) }
    private fun assignId() = if(collection.isEmpty()) 1 else collection.maxOf { it.id } + 1
    private fun isNew(colorCard: ColorCard) = colorCard.id == 0
}