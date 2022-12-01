package ro.nicolaemariusghergu.quest.domain.user.infrastructure

import ro.nicolaemariusghergu.quest.domain.user.application.model.User
import ro.nicolaemariusghergu.quest.domain.user.core.ports.outgoing.UserDatabase
import java.util.*

data class UserDatabaseAdapter(private val userRepository: UserRepository) : UserDatabase {

    override fun save(user: User): UUID {
        val savedUser = userRepository.save(user)
        return savedUser.uuid
    }
}