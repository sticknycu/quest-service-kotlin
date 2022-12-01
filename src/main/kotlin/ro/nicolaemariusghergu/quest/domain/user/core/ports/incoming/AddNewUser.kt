package ro.nicolaemariusghergu.quest.domain.user.core.ports.incoming

import ro.nicolaemariusghergu.quest.domain.user.core.model.AddUserCommand
import java.util.*

interface AddNewUser {
    fun handle(addUserCommand: AddUserCommand): UUID
}