package ldv.apirest.repository

import ldv.apirest.model.AlimentBox
import org.springframework.data.jpa.repository.JpaRepository

interface AlimentBoxRepository:JpaRepository<AlimentBox, Long> {
}
