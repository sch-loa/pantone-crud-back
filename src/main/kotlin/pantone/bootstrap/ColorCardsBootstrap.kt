package pantone.bootstrap

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import pantone.domain.ColorCard
import pantone.domain.Texture
import pantone.repository.ColorCardsRepository

@Service
class ColorCardsBootstrap: InitializingBean {
    @Autowired
    private lateinit var colorCardsRepository: ColorCardsRepository

    fun createColorCards(){
        val cards = mutableSetOf(
            ColorCard(107, Texture.U, "ffb6b3"),
            ColorCard(134, Texture.C, "e67e22"),
            ColorCard(156, Texture.C, "8c564b"),
            ColorCard(161, Texture.U, "c6913d"),
            ColorCard(179, Texture.C, "a6522d"),
            ColorCard(192, Texture.C, "d2b48c"),
            ColorCard(230, Texture.C, "b87333"),
            ColorCard(241, Texture.C, "6d4c41"),
            ColorCard(294, Texture.C, "85987f"),
            ColorCard(330, Texture.C, "4c5c62"),
            ColorCard(349, Texture.C, "83DCB0"),
            ColorCard(572, Texture.C, "eebbc6"),
            ColorCard(7558, Texture.C, "e7b77f"),
            ColorCard(268, Texture.C, "663399"),
            ColorCard(518, Texture.C, "997D9B"),
            ColorCard(264, Texture.C, "CD91EE"),
            ColorCard(186, Texture.C, "C40233"),
            ColorCard(199, Texture.C, "DC2628"),
            ColorCard(2304, Texture.U, "00AAEE"),
            ColorCard(521, Texture.U, "209"),
            ColorCard(286, Texture.C, "003366"),
            ColorCard(675, Texture.C, "A8A8C0"),
            ColorCard(1224, Texture.C, "24F5"),
            ColorCard(1205, Texture.C, "FFFA65"),
            ColorCard(117, Texture.U, "075"),
            ColorCard(116, Texture.C, "FFF943")
        )

        cards.forEach{ colorCardsRepository.create(it) }
    }

    override fun afterPropertiesSet() { createColorCards() }
}