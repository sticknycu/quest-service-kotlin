package ro.nicolaemariusghergu.quest.domain.user.application

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ro.nicolaemariusghergu.quest.domain.user.core.model.AddUserCommand
import ro.nicolaemariusghergu.quest.domain.user.core.model.EditUserCommand
import ro.nicolaemariusghergu.quest.domain.user.core.ports.incoming.AddNewUser
import ro.nicolaemariusghergu.quest.domain.user.core.ports.incoming.EditUser

@RestController
@RequestMapping("/api/users")
data class UserCommandController(private val addNewUser: AddNewUser,
                                 private val editUser: EditUser
) {

    @PostMapping
    fun addNewUser(@RequestBody addUserCommand: AddUserCommand): ResponseEntity<Any> {
        addNewUser.handle(addUserCommand)
        return ResponseEntity("New User has been added to the database", HttpStatus.CREATED)
    }

    @PatchMapping("/{id}")
    fun editUserInformation(@PathVariable("id") id: String, @RequestBody editUserCommand: EditUserCommand) : ResponseEntity<EditUserCommand> {
        editUser.handle(id, editUserCommand)
        return ResponseEntity(editUserCommand, HttpStatus.OK)
    }
}