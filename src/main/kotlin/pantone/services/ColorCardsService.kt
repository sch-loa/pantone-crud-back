package pantone.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pantone.domain.ColorCard
import pantone.domain.Texture
import pantone.repository.ColorCardsRepository

@Service
class ColorCardsService{
    @Autowired
    private lateinit var colorCardsRepository: ColorCardsRepository

    private var filterCalls: Map<String, (String) -> MutableSet<ColorCard>> = mapOf(
        "texture" to { value -> colorCardsRepository.searchByTexture(Texture.valueOf(value)) },
        "search" to { value -> colorCardsRepository.searchByExpression(value) },
        "min_color" to { value -> colorCardsRepository.searchByRange(value, null)},
        "max_color" to { value -> colorCardsRepository.searchByRange(null, value)}
    )

    fun colorCards(filters: Map<String, String>): MutableSet<ColorCard> {
        val fetchedCards = filters.map { (key, value) -> filterCalls[key]?.invoke(value) ?: mutableSetOf() }
        return fetchedCards.reduce { accCards, cards -> accCards.intersect(cards).toMutableSet() }.toMutableSet()
    }

    fun createColorCard(card: ColorCard){
        colorCardsRepository.create(card)
    }

    fun updateColorCard(card: ColorCard){
        colorCardsRepository.update(card)
    }
    fun deleteColorCard(id: Int){
        val card = colorCardsRepository.getByID(id)
        colorCardsRepository.delete(card!!)
    }
}