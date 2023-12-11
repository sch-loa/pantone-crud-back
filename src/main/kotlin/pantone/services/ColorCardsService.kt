package pantone.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pantone.domain.ColorCard
import pantone.repository.ColorCardsRepository

@Service
class ColorCardsService{
    @Autowired
    private lateinit var colorCardsRepository: ColorCardsRepository

    fun colorCards(filters: Map<String, String>) = colorCardsRepository.collection

    fun createColorCard(card: ColorCard){
        colorCardsRepository.create(card)
    }
    fun deleteColorCard(id: Int){
        val card = colorCardsRepository.getByID(id)
        colorCardsRepository.delete(card!!)
    }
}