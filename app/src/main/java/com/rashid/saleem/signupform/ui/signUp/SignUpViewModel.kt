package com.rashid.saleem.signupform.ui.signUp

import androidx.lifecycle.ViewModel
import com.rashid.saleem.signupform.ui.signUp.useCase.EmailValidationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    val emailValidationUseCase = EmailValidationUseCase()

    fun onAction(action: SignUpAction) {
        when (action) {
            is SignUpAction.UpdateAddress -> updateAddress(action.value)
            is SignUpAction.UpdateCity -> updateCity(action.value)
            is SignUpAction.UpdateCountry -> updateCountry(action.value)
            is SignUpAction.UpdateEmail -> updateEmail(action.value)
            is SignUpAction.UpdateFirstName -> updateFirstName(action.value)
            is SignUpAction.UpdateLastName -> updateLastName(action.value)
            is SignUpAction.UpdatePassword -> updatePassword(action.value)
            is SignUpAction.UpdateReenterPassword -> updateReenterPassword(action.value)
            is SignUpAction.UpdateVerificationCode -> updateVerificationCode(action.value)
            SignUpAction.NextOnClick -> nextOnClick()
        }
    }

    private fun nextOnClick() {

        val currentViewState = uiState.value.viewState

        if ()

        val nextViewState = when (currentViewState) {
            SignUpViewState.FullName -> SignUpViewState.Email()
            is SignUpViewState.Email -> handleEmailContainerActions(currentViewState)
            SignUpViewState.Password -> SignUpViewState.Address
            SignUpViewState.Address -> SignUpViewState.Success
            SignUpViewState.Success -> return // Navigate to NextScreen
        }

        val newUiState = uiState.value.copy(
            viewState = nextViewState
        )
        updateUiState(newUiState)
    }

    private fun handleEmailContainerActions(currentViewState: SignUpViewState.Email): SignUpViewState {
        val shouldSendVerificationCodeRequest = !currentViewState.isVerificationCodeSent
        if (shouldSendVerificationCodeRequest) {
            val email = uiState.value.email
            val isEmailBlank = email.isBlank()
            val emailErrorMessage = if (isEmailBlank) {
                "Please enter valid email"
            } else {
                emailValidationUseCase
                    .execute(email)
                    .message
            }

            if (emailErrorMessage != null) {
                val nextViewState = SignUpViewState.Email(
                    emailErrorMessage = emailErrorMessage
                )
                return nextViewState
            }

            val nextViewState = SignUpViewState.Email(
                isVerificationCodeSent = true
            )
            return nextViewState
        }

        val verificationCode = uiState.value.verificationCode
        val verificationCodeErrorMessage = if (verificationCode.isBlank())
            "Please enter verification code."
        else
            null

        verificationCodeErrorMessage?.let { errorMessage ->
            val nextViewState = currentViewState.copy(
                verificationCodeErrorMessage = errorMessage
            )
            return nextViewState
        }

        if (uiState.value.verificationCode == "1234")
            return SignUpViewState.Password

        return currentViewState
    }

    private fun updateUiState(value: SignUpUiState) {
        _uiState.update { value }
    }

    private fun updateCity(value: String) {
        val newUiState = uiState.value.copy(
            city = value
        )
        updateUiState(newUiState)
    }

    private fun updateAddress(value: String) {
        val newUiState = uiState.value.copy(
            address = value
        )
        updateUiState(newUiState)
    }

    private fun updateCountry(value: String) {
        val newUiState = uiState.value.copy(
            country = value
        )
        updateUiState(newUiState)
    }

    private fun updateEmail(value: String) {
        val newUiState = uiState.value.copy(
            email = value
        )
        updateUiState(newUiState)
    }

    private fun updateFirstName(value: String) {

        val newUiState = uiState.value.copy(
            firstName = value
        )
        updateUiState(newUiState)

        val isFullNameValid = isFullNameValid()
        enableNextButton(isFullNameValid)

    }

    private fun updateLastName(value: String) {
        val newUiState = uiState.value.copy(
            lastName = value
        )
        updateUiState(newUiState)

        val isFullNameValid = isFullNameValid()
        enableNextButton(isFullNameValid)
    }

    private fun isFullNameValid(): Boolean {
        return uiState.value.let {
            it.firstName.isNotBlank() && it.lastName.isNotBlank()
        }
    }

    private fun enableNextButton(value: Boolean) {
        val newUiState = uiState.value.copy(
            enableNextButton = value
        )
        updateUiState(newUiState)
    }

    private fun updatePassword(value: String) {
        val newUiState = uiState.value.copy(
            password = value
        )
        updateUiState(newUiState)
    }

    private fun updateReenterPassword(value: String) {
        val newUiState = uiState.value.copy(
            reEnterPassword = value
        )
        updateUiState(newUiState)
    }

    private fun updateVerificationCode(value: String) {
        val newUiState = uiState.value.copy(
            verificationCode = value
        )
        updateUiState(newUiState)
    }
}