package com.rashid.saleem.signupform.useCases

import android.util.Patterns

class EmailValidationUseCase {

    fun execute(value: String): ValidationResult {

        val isValid = Patterns.EMAIL_ADDRESS.matcher(value).matches()

        if (!isValid) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = "Please enter valid email address"
            )
        }

        return ValidationResult(true)
    }

}



data class ValidationResult(
    val isSuccess: Boolean,
    val errorMessage: String? = null
)