package ldv.apirest.repository

import org.springframework.data.jpa.repository.JpaRepository
import ldv.apirest.model.Aliment
import org.springframework.data.jpa.repository.Query


interface AlimentRepository : JpaRepository<Aliment, Long> {
    @Query("select count(*) from aliment where nom = :nom", nativeQuery = true)
    fun findAlimentByName(nom: String) : Int?

    @Query("select id from aliment where nom=:nom", nativeQuery=true)
    fun finAlimentIdByName(nom: String): Long
}