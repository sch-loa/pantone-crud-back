package pantone.repository

import org.springframework.stereotype.Repository
import pantone.domain.ColorCard

@Repository
class ColorCardsRepository {
    lateinit var collection: MutableSet<ColorCard>

    fun getByID(id: Int) = collection.find { it.id == id }
    fun delete(colorCard: ColorCard){ collection.remove(colorCard) }
}