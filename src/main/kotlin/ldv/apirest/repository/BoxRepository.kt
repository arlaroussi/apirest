package ldv.apirest.repository

import ldv.apirest.model.Box
import org.springframework.data.jpa.repository.JpaRepository

interface BoxRepository : JpaRepository<Box, Long>{
}