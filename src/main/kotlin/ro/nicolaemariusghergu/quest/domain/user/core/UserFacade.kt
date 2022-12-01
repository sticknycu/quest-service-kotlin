package ro.nicolaemariusghergu.quest.domain.user.core

import org.springframework.stereotype.Service
import ro.nicolaemariusghergu.quest.domain.user.core.model.AddUserCommand
import ro.nicolaemariusghergu.quest.domain.user.core.model.toEntity
import ro.nicolaemariusghergu.quest.domain.user.core.ports.incoming.AddNewUser
import ro.nicolaemariusghergu.quest.domain.user.core.ports.outgoing.UserDatabase
import java.util.*

@Service
class UserFacade(private val userDatabase: UserDatabase) : AddNewUser {

    override fun handle(addUserCommand: AddUserCommand): UUID {
        val user = toEntity(addUserCommand)

        return userDatabase.save(user)
    }
}