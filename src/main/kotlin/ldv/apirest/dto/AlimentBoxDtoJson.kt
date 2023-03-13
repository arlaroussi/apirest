package ldv.apirest.dto

class AlimentBoxDtoJson (
    var nom: String,
    var quantite: Float) {

        override fun toString(): String {
            return "AlimentBoxDtoJson(nom='$nom', quantite=$quantite)"
        }
}