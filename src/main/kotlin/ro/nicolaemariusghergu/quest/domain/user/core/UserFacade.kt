package ro.nicolaemariusghergu.quest.domain.user.core

import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import ro.nicolaemariusghergu.quest.domain.user.core.model.AddUserCommand
import ro.nicolaemariusghergu.quest.domain.user.core.model.EditUserCommand
import ro.nicolaemariusghergu.quest.domain.user.core.model.editToDto
import ro.nicolaemariusghergu.quest.domain.user.core.model.toEntity
import ro.nicolaemariusghergu.quest.domain.user.core.ports.incoming.AddNewUser
import ro.nicolaemariusghergu.quest.domain.user.core.ports.incoming.EditUser
import ro.nicolaemariusghergu.quest.domain.user.core.ports.outgoing.UserDatabase
import java.util.*

@Service
class UserFacade(private val userDatabase: UserDatabase) : AddNewUser, EditUser {

    override fun handle(addUserCommand: AddUserCommand): UUID {
        val user = toEntity(addUserCommand)

        return userDatabase.save(user)
    }

    @Transactional
    override fun handle(id: String, editUserCommand: EditUserCommand): EditUserCommand {
        val user = toEntity(editUserCommand)
        return editToDto(userDatabase.edit(id, user))
    }
}