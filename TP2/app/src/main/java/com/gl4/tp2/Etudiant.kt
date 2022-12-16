package com.gl4.tp2


class Etudiant(
    var nom: String?,
    var prenom: String?,
    var genre: Genre,
    var present: Boolean,
) {

}

enum class Genre {
    MALE, FEMALE
}