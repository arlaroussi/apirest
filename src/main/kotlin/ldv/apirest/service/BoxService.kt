package ldv.apirest.service

import ldv.apirest.model.Box

interface BoxService {

    fun afficherBoxes():MutableList<Box>

    fun creerBox(id:Long, box:Box)
}