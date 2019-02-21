package fr.spacefox.prenoms.model

import javax.persistence.*

@Entity
@Table(indexes = [
    Index(name = "i_sex", columnList = "sex"),
    Index(name = "i_firstName", columnList = "firstName"),
    Index(name = "i_birthYear", columnList = "birthYear"),
    Index(name = "i_department", columnList = "department"),
    Index(name = "i_count", columnList = "count")
])
 data class FirstName(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false) val sex: String,
        @Column(nullable = false) val firstName: String,
        @Column(nullable = false) val birthYear: String,
        @Column(nullable = false) val department: String,
        @Column(nullable = false) val count: Int,

        @Transient var decade: String,
        @Transient var firstLetter: Char
) {
    @PostLoad
    fun onLoad() {
        decade = birthYear.substring(0, 3)
        firstLetter = firstName[0]
    }
}
