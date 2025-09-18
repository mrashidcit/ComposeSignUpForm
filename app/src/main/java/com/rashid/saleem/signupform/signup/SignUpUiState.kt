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
    val emailErrorMessage: String? = null,
    val verificationCodeErrorMessage: String? = null,
    val passwordErrorMessage: String? = null,
    val reEnterPasswordErrorMessage: String? = null,
    val cityErrorMessage: String? = null,
    val countryErrorMessage: String? = null,

    val isPasswordVisible: Boolean = false,
    val isReEnterPasswordVisible: Boolean = false,
    val passwordStrength: PasswordStrength = PasswordStrength(),
    val viewState: SignUpViewState = SignUpViewState.FullName
)

data class PasswordStrength(
    val hasMinLength6: Boolean = false,
    val hasUppercase: Boolean = false,
    val hasLowercase: Boolean = false,
    val hasNumber: Boolean = false,
    val hasSpecialCharacter: Boolean = false,
) {

    fun isAllCheckPassed(): Boolean {
        return hasMinLength6 && hasUppercase && hasLowercase && hasNumber && hasSpecialCharacter
    }

}


sealed interface SignUpViewState {
    data object FullName: SignUpViewState
    data class Email(val showVerificationCode: Boolean = false): SignUpViewState
    data object Password: SignUpViewState
    data object Address: SignUpViewState
    data object Success: SignUpViewState
}

















