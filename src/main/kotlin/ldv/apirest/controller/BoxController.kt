package ldv.apirest.controller

import ldv.apirest.model.Box
import ldv.apirest.repository.BoxRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class BoxController(private val boxRepository: BoxRepository) {
    @GetMapping("/boxes")
    fun getAllArticles(): List<Box> =
        boxRepository.findAll()

    @GetMapping("/box/{id}")
    fun getArticleById(@PathVariable(value = "id") boxId: Long): ResponseEntity<Box> {
        return boxRepository.findById(boxId).map { box ->
            ResponseEntity.ok(box)
        }.orElse(ResponseEntity.notFound().build())
    }
}