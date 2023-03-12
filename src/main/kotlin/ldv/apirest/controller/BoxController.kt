package ldv.apirest.controller

import ldv.apirest.model.Box
import ldv.apirest.repository.BoxRepository
import ldv.apirest.service.BoxService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("api/")
@RestController
class PlayerController(val boxService: BoxService) {

    @GetMapping("/boxes")
    fun getAllBoxes() = boxService.getAll()

    @GetMapping("/{id}")
    fun getBox(@PathVariable id: Long) = boxService.getById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun savePlayer(@RequestBody box: Box): Box = boxService.create(box)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePlayer(@PathVariable id: Long) = boxService.remove(id)

    @PutMapping("/{id}")
    fun updatePlayer(
        @PathVariable id: Long, @RequestBody player: Box
    ) = boxService.update(id, player)
}
