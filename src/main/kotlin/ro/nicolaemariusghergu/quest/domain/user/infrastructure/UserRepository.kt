package ro.nicolaemariusghergu.quest.domain.user.infrastructure

import org.springframework.data.jpa.repository.JpaRepository
import ro.nicolaemariusghergu.quest.domain.user.application.model.User
import java.util.*

interface UserRepository : JpaRepository<User, UUID>