package ro.nicolaemariusghergu.quest.application

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QuestServiceController {

    @GetMapping
    fun applicationEntry(): String {
        return "Hello boyz!"
    }
}