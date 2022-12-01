package ro.nicolaemariusghergu.quest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuestServiceKotlinApplication

fun main(args: Array<String>) {
	runApplication<QuestServiceKotlinApplication>(*args)
}
