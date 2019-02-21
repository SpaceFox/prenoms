package fr.spacefox.prenoms.controller

import fr.spacefox.prenoms.model.FirstName
import fr.spacefox.prenoms.repository.FirstNameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
internal class FirstNameController {

    @Autowired
    lateinit var firstNameRepository: FirstNameRepository

    @CrossOrigin(origins = ["*"])
    @GetMapping("/firstNames")
    fun getFirstNames(pageable: Pageable): Page<FirstName> {
        return firstNameRepository.findAll(pageable)
    }

    @CrossOrigin(origins = ["*"])
    @GetMapping("/firstName/{name}")
    fun getFirstName(@PathVariable name: String, pageable: Pageable): Page<FirstName> {
        return firstNameRepository.findByFirstName(name.toUpperCase(Locale.FRANCE), pageable)
    }
}
