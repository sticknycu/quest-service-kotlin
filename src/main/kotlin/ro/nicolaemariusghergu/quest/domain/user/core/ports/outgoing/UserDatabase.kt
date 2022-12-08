package ro.nicolaemariusghergu.quest.domain.user.core.ports.outgoing

import ro.nicolaemariusghergu.quest.domain.user.application.model.User
import java.util.*

interface UserDatabase {

    fun save(user: User): UUID

    fun edit(id: String, user: User) : User
}