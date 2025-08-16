package com.rashid.saleem.signupform.signup

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    fun onAction(action: SignUpAction) {
        when (action) {
            is SignUpAction.AddressOnValueChange -> TODO()
            is SignUpAction.CityOnValueChange -> TODO()
            is SignUpAction.CountryOnValueChange -> TODO()
            is SignUpAction.EmailOnValueChange -> TODO()
            is SignUpAction.FirstNameOnValueChange -> TODO()
            is SignUpAction.LastNameOnValueChange -> TODO()
            SignUpAction.NextOnClick -> nextOnClick()
            is SignUpAction.PasswordOnValueChange -> TODO()
            is SignUpAction.ReEnterPasswordOnValueChange -> TODO()
            SignUpAction.TogglePasswordVisibility -> TODO()
            SignUpAction.ToggleReEnterPasswordVisibility -> TODO()
            is SignUpAction.VerificationCodeOnValueChange -> TODO()
        }
    }

    private fun nextOnClick() {
        val currentViewState = uiState.value.viewState

        val nextViewState = when (currentViewState) {
            SignUpViewState.FullName -> SignUpViewState.Email
            SignUpViewState.Email -> SignUpViewState.Password
            SignUpViewState.Password -> SignUpViewState.Address
            SignUpViewState.Address -> SignUpViewState.Success
            SignUpViewState.Success -> return  // Navigate to next screen
        }

        _uiState.update {
            it.copy(
                viewState = nextViewState
            )
        }
    }

}














