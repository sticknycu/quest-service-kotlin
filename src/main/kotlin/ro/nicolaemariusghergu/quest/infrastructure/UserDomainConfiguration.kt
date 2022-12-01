package ro.nicolaemariusghergu.quest.infrastructure

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import ro.nicolaemariusghergu.quest.domain.user.infrastructure.UserDatabaseAdapter
import ro.nicolaemariusghergu.quest.domain.user.infrastructure.UserRepository

@Component
class UserDomainConfiguration {

    @Bean
    fun userDatabase(userRepository: UserRepository) : UserDatabaseAdapter {
        return UserDatabaseAdapter(userRepository)
    }
}