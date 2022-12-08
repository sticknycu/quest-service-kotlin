package ro.nicolaemariusghergu.quest.domain.user.core.ports.incoming

import ro.nicolaemariusghergu.quest.domain.user.core.model.AddUserCommand
import ro.nicolaemariusghergu.quest.domain.user.core.model.EditUserCommand
import java.util.*

interface AddNewUser {
    fun handle(addUserCommand: AddUserCommand) : UUID
}

interface EditUser {
    fun handle(id: String, editUserCommand: EditUserCommand) : EditUserCommand
}