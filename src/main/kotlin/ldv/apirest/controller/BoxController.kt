package ldv.apirest.controller

import ldv.apirest.dto.BoxDtoJson
import ldv.apirest.model.Box
import ldv.apirest.repository.BoxRepository
import ldv.apirest.service.BoxService
import ldv.apirest.util.fromBoxToBoxDtoJson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*

@RequestMapping("/api")
@RestController
class ApiController  @Autowired constructor(private val boxRepository: BoxRepository) {
    @GetMapping("/boxes")
    fun allBoxes(): ResponseEntity<List<BoxDtoJson>> {
        return ResponseEntity.ok(this.boxRepository.findAll().map { fromBoxToBoxDtoJson(it) })
    }

}
