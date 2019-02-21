package fr.spacefox.prenoms.repository

import fr.spacefox.prenoms.model.FirstName
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FirstNameRepository: JpaRepository<FirstName, Long> {
    fun findByFirstName(name: String, pageable: Pageable): Page<FirstName>
}
