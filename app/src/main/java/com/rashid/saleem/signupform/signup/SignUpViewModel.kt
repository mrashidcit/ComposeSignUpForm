package com.rashid.saleem.signupform.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    private val uiState = _uiState.asStateFlow()

    fun onAction(action: SignUpAction) {
        when (action) {
            is SignUpAction.AddressOnChange -> TODO()
            is SignUpAction.CityOnChange -> TODO()
            is SignUpAction.CountryOnChange -> TODO()
            is SignUpAction.EmailOnChange -> TODO()
            is SignUpAction.FirstNameOnChange -> TODO()
            is SignUpAction.LastNameOnChange -> TODO()
            SignUpAction.NextOnClick -> TODO()
            is SignUpAction.PasswordOnChange -> TODO()
            is SignUpAction.ReenterPasswordOnChange -> TODO()
            SignUpAction.TogglePasswordVisibility -> TODO()
            SignUpAction.ToggleReenterPasswordVisibility -> TODO()
            is SignUpAction.VerificationCodeOnChange -> TODO()
        }
    }


}