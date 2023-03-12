package ldv.apirest.repository

import ldv.apirest.model.BoxSaveur
import org.springframework.data.jpa.repository.JpaRepository

interface BoxSaveurRepository :JpaRepository<BoxSaveur, Long> {
}