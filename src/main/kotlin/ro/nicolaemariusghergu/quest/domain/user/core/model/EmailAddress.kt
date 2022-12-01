package ro.nicolaemariusghergu.quest.domain.user.core.model

import jakarta.persistence.Column

import jakarta.persistence.Embeddable
import jakarta.validation.constraints.Pattern

@Embeddable
data class EmailAddress(

    @Column(name = "email")
    @Pattern(regexp = "^(.+)@(.+)$")
    var value: String
)
