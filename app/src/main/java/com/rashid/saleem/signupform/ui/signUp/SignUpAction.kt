package com.rashid.saleem.signupform.ui.signUp

sealed interface SignUpAction {
    data class UpdateFirstName(val value: String) : SignUpAction
    data class UpdateLastName(val value: String) : SignUpAction
    data class UpdateEmail(val value: String) : SignUpAction
    data class UpdateVerificationCode(val value: String) : SignUpAction
    data class UpdatePassword(val value: String) : SignUpAction
    data class UpdateReenterPassword(val value: String) : SignUpAction
    data class UpdateCity(val value: String) : SignUpAction
    data class UpdateAddress(val value: String) : SignUpAction
    data class UpdateCountry(val value: String) : SignUpAction
    data object NextOnClick: SignUpAction
}