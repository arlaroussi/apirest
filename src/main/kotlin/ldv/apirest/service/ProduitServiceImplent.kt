package ldv.apirest.service

import ldv.apirest.model.Box
import ldv.apirest.repository.BoxRepository
import org.springframework.stereotype.Service

@Service
class BoxServiceImplent(private val boxRepository: BoxRepository) : BoxService {
    override
    fun afficherBoxes():MutableList<Box> {
        return boxRepository.findAll()
    }

    override fun creerBox(id: Long, box: Box) {

    }

}