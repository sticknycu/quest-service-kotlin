package ro.nicolaemariusghergu.quest.domain.user.infrastructure

import jakarta.persistence.EntityNotFoundException
import org.springframework.transaction.annotation.Transactional
import ro.nicolaemariusghergu.quest.domain.user.application.model.User
import ro.nicolaemariusghergu.quest.domain.user.core.ports.outgoing.UserDatabase
import java.util.*

open class UserDatabaseAdapter(private val userRepository: UserRepository) : UserDatabase {

    override fun save(user: User): UUID {
        val savedUser = userRepository.save(user)
        return savedUser.uuid
    }

    @Transactional
    override fun edit(id: String, user: User): User {
        val exitingUser = getUserById(id)
        exitingUser.firstName = user.firstName
        exitingUser.lastName = user.lastName
        exitingUser.email = user.email
        return exitingUser
    }

    private fun getUserById(id: String) : User {
        return userRepository.findById(UUID.fromString(id)).orElseThrow {
            EntityNotFoundException(
                String.format(
                    "Entity with id {} has not been found",
                    id))
        }
    }
}