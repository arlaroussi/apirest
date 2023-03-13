package ldv.apirest.service

import ldv.apirest.model.Box
import ldv.apirest.repository.BoxRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class BoxService(val boxRepository: BoxRepository) {

    fun getAll(): MutableList<Box> = boxRepository.findAll()

    fun getById(id: Long): Box = boxRepository.findByIdOrNull(id) ?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun create(box: Box): Box = boxRepository.save(box)

    fun remove(id: Long) {
        if (boxRepository.existsById(id)) boxRepository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun update(id: Long, player: Box): Box {
        return if (boxRepository.existsById(id)) {
            player.id = id
            boxRepository.save(player)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}