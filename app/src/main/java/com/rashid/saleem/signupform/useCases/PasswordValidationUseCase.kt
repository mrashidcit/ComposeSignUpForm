package com.rashid.saleem.signupform.useCases

import com.rashid.saleem.signupform.signup.PasswordStrength

class PasswordValidationUseCase {

    fun execute(value: String): PasswordStrength {

        val hasMinLength6 = value.length >= 6
        val hasUppercase = value.any { it.isUpperCase() }
        val hasLowercase = value.any { it.isLowerCase() }
        val hasNumber = value.any { it.isDigit() }
        val regex = Regex("[^a-zA-Z0-9]")
        val hasSpecialCharacter = regex.containsMatchIn(value)

        return PasswordStrength(
            hasMinLength6 = hasMinLength6,
            hasUppercase = hasUppercase,
            hasLowercase = hasLowercase,
            hasNumber = hasNumber,
            hasSpecialCharacter = hasSpecialCharacter
        )
    }

}