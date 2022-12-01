package ro.nicolaemariusghergu.quest.domain.user.application

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ro.nicolaemariusghergu.quest.domain.user.core.model.AddUserCommand
import ro.nicolaemariusghergu.quest.domain.user.core.ports.incoming.AddNewUser

@RestController
@RequestMapping("/api/users")
data class UserCommandController(private val addNewUser: AddNewUser) {

    @PostMapping
    fun addNewUser(@RequestBody addUserCommand: AddUserCommand): ResponseEntity<Any> {
        addNewUser.handle(addUserCommand)
        return ResponseEntity("New User has been added to the database", HttpStatus.CREATED)
    }
}