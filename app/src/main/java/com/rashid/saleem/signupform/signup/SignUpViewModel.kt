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
            is SignUpAction.FirstNameOnValueChange -> firstNameOnValueChange(action.value)
            is SignUpAction.LastNameOnValueChange -> lastNameOnValueChange(action.value)
            is SignUpAction.AddressOnValueChange -> TODO()
            is SignUpAction.CityOnValueChange -> TODO()
            is SignUpAction.CountryOnValueChange -> TODO()
            is SignUpAction.EmailOnValueChange -> TODO()
            SignUpAction.NextOnClick -> nextOnClick()
            is SignUpAction.PasswordOnValueChange -> TODO()
            is SignUpAction.ReEnterPasswordOnValueChange -> TODO()
            SignUpAction.TogglePasswordVisibility -> TODO()
            SignUpAction.ToggleReEnterPasswordVisibility -> TODO()
            is SignUpAction.VerificationCodeOnValueChange -> TODO()
        }
    }

    private fun firstNameOnValueChange(value: String) {
        val updatedUiState = uiState.value.copy(
            firstName = value,
            firstNameErrorMessage = null
        )

        _uiState.update { updatedUiState }
    }

    private fun lastNameOnValueChange(value: String) {
        val updatedUiState = uiState.value.copy(
            lastName = value,
            lastNameErrorMessage = null
        )

        _uiState.update { updatedUiState }
    }



    private fun nextOnClick() {
        val currentViewState = uiState.value.viewState

        val nextViewState = when (currentViewState) {
            SignUpViewState.FullName -> handleFullNameNextOnClick()
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

    private fun handleFullNameNextOnClick(): SignUpViewState {
        val firstNameErrorMessage = if (uiState.value.firstName.isEmpty())
            "Please enter your first name."
        else
            null

        val lastNameErrorMessage = if (uiState.value.lastName.isEmpty())
            "Please enter your last name."
        else
            null

        if (firstNameErrorMessage != null || lastNameErrorMessage != null) {
            val updatedUiState = uiState.value.copy(
                firstNameErrorMessage = firstNameErrorMessage,
                lastNameErrorMessage = lastNameErrorMessage
            )
            _uiState.update { updatedUiState }

            return SignUpViewState.FullName
        }


        return SignUpViewState.Email
    }

}














