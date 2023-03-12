package ldv.apirest.repository

import ldv.apirest.model.Saveur
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface SaveurRepository : JpaRepository<Saveur, Long> {

    @Query("select count(*) from saveur where nom = :nom", nativeQuery = true)
    fun findSaveurByName(nom: String) : Int?

    @Query("select id from saveur where nom=:nom", nativeQuery=true)
    fun findSaveurIdByName(nom: String): Long
}