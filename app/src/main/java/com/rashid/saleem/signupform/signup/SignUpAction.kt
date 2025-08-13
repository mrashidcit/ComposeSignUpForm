package com.rashid.saleem.signupform.signup

sealed interface SignUpAction {

    data class FirstNameOnChange(val value: String): SignUpAction
    data class LastNameOnChange(val value: String): SignUpAction
    data class EmailOnChange(val value: String): SignUpAction
    data class VerificationCodeOnChange(val value: String): SignUpAction
    data class PasswordOnChange(val value: String): SignUpAction
    data class ReenterPasswordOnChange(val value: String): SignUpAction
    data class CountryOnChange(val value: String): SignUpAction
    data class CityOnChange(val value: String): SignUpAction
    data class AddressOnChange(val value: String): SignUpAction

    data object TogglePasswordVisibility: SignUpAction
    data object ToggleReenterPasswordVisibility: SignUpAction
    data object NextOnClick: SignUpAction
}