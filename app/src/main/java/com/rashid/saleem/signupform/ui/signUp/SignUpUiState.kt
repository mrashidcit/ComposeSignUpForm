package com.rashid.saleem.signupform.ui.signUp

data class SignUpUiState(
    val viewState: SignUpViewState = SignUpViewState.FullName,
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val password: String = "",
    val reEnterPassword: String = "",
    val verificationCode: String = "",
    val city: String = "",
    val address: String = "",
    val country: String = "",
    val enableNextButton: Boolean = false
)

sealed interface SignUpViewState {
    data object FullName: SignUpViewState
    data class Email(
        val isVerificationCodeSent: Boolean = false,
        val emailErrorMessage: String? = null,
        val verificationCodeErrorMessage: String? = null,
    ): SignUpViewState
    data object Password: SignUpViewState
    data object Address: SignUpViewState
    data object Success: SignUpViewState
}