package pantone.repository

import org.springframework.stereotype.Repository
import pantone.domain.ColorCard

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