package ro.nicolaemariusghergu.quest.domain.user.core.model

import ro.nicolaemariusghergu.quest.domain.user.application.model.User

fun toEntity(addUserCommand: AddUserCommand) : User {
    return User(email = EmailAddress(addUserCommand.email), firstName = addUserCommand.firstName, lastName = addUserCommand.lastName)
}

fun toDto(user: User) : AddUserCommand {
    return AddUserCommand(firstName = user.firstName, lastName = user.lastName, email = user.email.value)
}