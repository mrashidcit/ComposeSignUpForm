package com.rashid.saleem.signupform.ui.signUp.useCase

data class ValidationResult(
    val isSuccess: Boolean,
    val message: String? = null,
)
