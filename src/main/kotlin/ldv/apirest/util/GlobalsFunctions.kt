package ldv.apirest.util

import ldv.apirest.dto.AlimentBoxDtoJson
import ldv.apirest.dto.BoxDtoJson
import ldv.apirest.model.Box

fun fromBoxToBoxDtoJson(box: Box): BoxDtoJson {
    return BoxDtoJson(
        box.id,
        box.pieces,
        box.nom,
        box.image,
        box.prix,
        HashSet(box.saveurs.stream().map { it.nom }.toList()),
        box.alimentBoxes.stream().map { AlimentBoxDtoJson(it.aliment.nom, it.quantite) }.toList()
    )
}