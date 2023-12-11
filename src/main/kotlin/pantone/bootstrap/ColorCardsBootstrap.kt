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
        colorCardsRepository.collection = mutableSetOf(
            ColorCard(1, 107, Texture.U, "ffb6b3"),
            ColorCard(2, 134, Texture.C, "e67e22"),
            ColorCard(3, 156, Texture.C, "8c564b"),
            ColorCard(4, 161, Texture.U, "c6913d"),
            ColorCard(5, 179, Texture.C, "a6522d"),
            ColorCard(6, 192, Texture.C, "d2b48c"),
            ColorCard(7, 230, Texture.C, "b87333"),
            ColorCard(8, 241, Texture.C, "6d4c41"),
            ColorCard(9, 294, Texture.C, "85987f"),
            ColorCard(10, 330, Texture.C, "4c5c62"),
            ColorCard(11, 349, Texture.C, "83DCB0"),
            ColorCard(12, 572, Texture.C, "eebbc6"),
            ColorCard(13, 7558, Texture.C, "e7b77f"),
            ColorCard(14, 268, Texture.C, "663399"),
            ColorCard(15, 518, Texture.C, "997D9B"),
            ColorCard(16, 264, Texture.C, "CD91EE"),
            ColorCard(17, 186, Texture.C, "C40233"),
            ColorCard(18, 199, Texture.C, "DC2628"),
            ColorCard(19, 2304, Texture.U, "00AAEE"),
            ColorCard(20, 521, Texture.U, "209"),
            ColorCard(21, 286, Texture.C, "003366"),
            ColorCard(22, 675, Texture.C, "A8A8C0"),
            ColorCard(23, 1224, Texture.C, "24F5"),
            ColorCard(24, 1205, Texture.C, "FFFA65"),
            ColorCard(25, 117, Texture.U, "075"),
            ColorCard(26, 116, Texture.C, "FFF943")
        )

    }

    override fun afterPropertiesSet() {
        createColorCards()
    }
}