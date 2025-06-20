package com.rashid.saleem.signupform.ui.signUp.useCase

import android.util.Patterns

class EmailValidationUseCase {

    fun execute(value: String): ValidationResult {
        if (value.isBlank())
            return ValidationResult(
                isSuccess = false,
                message = "Please enter email address."
            )

        val isEmailFormatValid = Patterns.EMAIL_ADDRESS.matcher(value).matches()
        return if (isEmailFormatValid) {
            ValidationResult(
                isSuccess = true,
            )
        } else {
            ValidationResult(
                isSuccess = false,
                message = "Please enter valid email address."
            )
        }
    }
}