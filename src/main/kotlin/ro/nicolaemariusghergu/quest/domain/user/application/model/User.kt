package ro.nicolaemariusghergu.quest.domain.user.application.model

import jakarta.persistence.*
import ro.nicolaemariusghergu.quest.domain.user.core.model.EmailAddress
import java.util.*

@Entity
@Table(name = "users_table")
data class User(
    @Column(name = "email") var email: EmailAddress,
    @Column(name = "first_name") var firstName: String,
    @Column(name = "last_name") var lastName: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val uuid: UUID = UUID.randomUUID()
}