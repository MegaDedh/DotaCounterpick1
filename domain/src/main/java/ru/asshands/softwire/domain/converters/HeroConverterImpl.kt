package ru.asshands.softwire.domain.converters

import ru.asshands.softwire.data.remote.models.HeroApi
import ru.asshands.softwire.domain.models.Hero

class HeroConverterImpl {

    fun fromApiToUi(model: HeroApi): Hero {
        return Hero(
            id = model.id,
            title = model.localized_name,//.replace("npc_dota_hero_",""),
            icon = "",
            attackType = if (model.attack_type == "Melee") { //TODO переделать бы это уродство
                0
            } else {
                1
            }
        )
    }
}