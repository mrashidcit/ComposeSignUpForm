package com.rashid.saleem.signupform.signup

data class SignUpUiState(
    // field values
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val verificationCode: String = "",
    val password: String = "",
    val reEnterPassword: String = "",
    val country: String = "",
    val city: String = "",
    val address: String = "",

    val isPasswordVisible: Boolean = false,
    val isReEnterPasswordVisible: Boolean = false,
    val passwordStrength: PasswordStrength = PasswordStrength()


)

data class PasswordStrength(
    val hasLength6: Boolean = false,
    val hasUppercase: Boolean = false,
    val hasLowercase: Boolean = false,
    val hasNumber: Boolean = false,
    val hasSpecialCharacter: Boolean = false,
)
