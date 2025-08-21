package com.rashid.saleem.signupform.signup

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.ViewModel
import com.rashid.saleem.signupform.useCases.EmailValidationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    private val emailValidationUseCase: EmailValidationUseCase = EmailValidationUseCase()

    fun onAction(action: SignUpAction) {
        when (action) {
            is SignUpAction.FirstNameOnValueChange -> firstNameOnValueChange(action.value)
            is SignUpAction.LastNameOnValueChange -> lastNameOnValueChange(action.value)
            is SignUpAction.AddressOnValueChange -> TODO()
            is SignUpAction.CityOnValueChange -> TODO()
            is SignUpAction.CountryOnValueChange -> TODO()
            is SignUpAction.EmailOnValueChange -> emailOnValueChange(action.value)
            is SignUpAction.VerificationCodeOnValueChange -> verificationCodeOnValueChange(action.value)
            SignUpAction.NextOnClick -> nextOnClick()
            is SignUpAction.PasswordOnValueChange -> TODO()
            is SignUpAction.ReEnterPasswordOnValueChange -> TODO()
            SignUpAction.TogglePasswordVisibility -> TODO()
            SignUpAction.ToggleReEnterPasswordVisibility -> TODO()
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

    private fun emailOnValueChange(value: String) {
        val updatedUiState = uiState.value.copy(
            email = value,
            emailErrorMessage = null
        )

        _uiState.update { updatedUiState }
    }

    private fun verificationCodeOnValueChange(value: String) {
        val updatedUiState = uiState.value.copy(
            verificationCode = value,
            verificationCodeErrorMessage = null
        )

        _uiState.update { updatedUiState }
    }







    private fun nextOnClick() {
        val currentViewState = uiState.value.viewState

        val nextViewState = when (currentViewState) {
            SignUpViewState.FullName -> handleFullNameNextOnClick()
            is SignUpViewState.Email -> handleEmailNextOnClick(currentViewState)
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

    private fun handleEmailNextOnClick(currentViewState: SignUpViewState.Email): SignUpViewState {

        if (currentViewState.showVerificationCode) {

            if (uiState.value.verificationCode == "1234") {
                return SignUpViewState.Password
            }

            val updatedUiState = uiState.value.copy(
                verificationCodeErrorMessage = "Incorrect code."
            )
            _uiState.update { updatedUiState }
            return currentViewState
        }

        val result = emailValidationUseCase.execute(uiState.value.email)

        if (!result.isSuccess) {
            val updatedUiState = uiState.value.copy(
                emailErrorMessage = "Please enter valid email."
            )

            _uiState.update { updatedUiState }
            return SignUpViewState.Email()
        }


        return SignUpViewState.Email(true)
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


        return SignUpViewState.Email()
    }

}














