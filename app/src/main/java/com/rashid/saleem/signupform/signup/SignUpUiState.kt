package com.rashid.saleem.signupform.signup

data class SignUpUiState(
    // TextFields values
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val verificationCode: String = "",
    val password: String = "",
    val reEnterPassword: String = "",
    val country: String = "",
    val city: String = "",
    val address: String = "",

    // Validation error messages
    val firstNameErrorMessage: String? = null,
    val lastNameErrorMessage: String? = null,

    val isPasswordVisible: Boolean = false,
    val isReEnterPasswordVisible: Boolean = false,
    val passwordStrength: PasswordStrength = PasswordStrength(),
    val viewState: SignUpViewState = SignUpViewState.FullName
)

data class PasswordStrength(
    val isMinLength6: Boolean = false,
    val isUppercase: Boolean = false,
    val isLowercase: Boolean = false,
    val isNumber: Boolean = false,
    val isSpecialCharacter: Boolean = false,
)

enum class SignUpViewState {
    FullName,
    Email,
    Password,
    Address,
    Success
}

















