package com.rashid.saleem.signupform.signup

sealed interface SignUpAction {
    data class FirstNameOnValueChange(val value: String): SignUpAction
    data class LastNameOnValueChange(val value: String): SignUpAction
    data class EmailOnValueChange(val value: String): SignUpAction
    data class VerificationCodeOnValueChange(val value: String): SignUpAction
    data class PasswordOnValueChange(val value: String): SignUpAction
    data class ReEnterPasswordOnValueChange(val value: String): SignUpAction
    data class CountryOnValueChange(val value: String): SignUpAction
    data class CityOnValueChange(val value: String): SignUpAction
    data class AddressOnValueChange(val value: String): SignUpAction

    data object TogglePasswordVisibility: SignUpAction
    data object ToggleReEnterPasswordVisibility: SignUpAction
    data object NextOnClick: SignUpAction
}