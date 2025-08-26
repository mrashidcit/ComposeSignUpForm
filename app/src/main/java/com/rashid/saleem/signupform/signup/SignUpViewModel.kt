package com.rashid.saleem.signupform.signup

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.ViewModel
import com.rashid.saleem.signupform.useCases.EmailValidationUseCase
import com.rashid.saleem.signupform.useCases.PasswordValidationUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    private val emailValidationUseCase: EmailValidationUseCase = EmailValidationUseCase()
    private val passwordValidationUseCase = PasswordValidationUseCase()

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
            is SignUpAction.PasswordOnValueChange -> passwordOnValueChange(action.value)
            is SignUpAction.ReEnterPasswordOnValueChange -> reEnterPasswordOnValueChange(action.value)
            SignUpAction.TogglePasswordVisibility -> togglePasswordVisibility()
            SignUpAction.ToggleReEnterPasswordVisibility -> toggleReEnterPasswordVisibility()
        }
    }

    private fun togglePasswordVisibility() {
        val updatedUiState = uiState.value.copy(
            isPasswordVisible = uiState.value.isPasswordVisible.not()
        )
        _uiState.update { updatedUiState }
    }

    private fun toggleReEnterPasswordVisibility() {
        val updatedUiState = uiState.value.copy(
            isReEnterPasswordVisible = uiState.value.isReEnterPasswordVisible.not()
        )
        _uiState.update { updatedUiState }
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

    private fun passwordOnValueChange(value: String) {

        val result = passwordValidationUseCase.execute(value)

        val updatedUiState = uiState.value.copy(
            password = value,
            passwordErrorMessage = null,
            passwordStrength = result
        )

        _uiState.update { updatedUiState }
    }

    private fun reEnterPasswordOnValueChange(value: String) {
        val updatedUiState = uiState.value.copy(
            reEnterPassword = value,
            reEnterPasswordErrorMessage = null
        )

        _uiState.update { updatedUiState }
    }









    private fun nextOnClick() {
        val currentViewState = uiState.value.viewState

        val nextViewState = when (currentViewState) {
            SignUpViewState.FullName -> handleFullNameNextOnClick()
            is SignUpViewState.Email -> handleEmailNextOnClick(currentViewState)
            SignUpViewState.Password -> handlePasswordNextOnClick(currentViewState)
            SignUpViewState.Address -> SignUpViewState.Success
            SignUpViewState.Success -> return  // Navigate to next screen
        }

        _uiState.update {
            it.copy(
                viewState = nextViewState
            )
        }
    }

    private fun handlePasswordNextOnClick(viewState: SignUpViewState): SignUpViewState {

        val result = passwordValidationUseCase.execute(uiState.value.password)

        if (!result.isAllCheckPassed()) {
            val updatedUiSTate = uiState.value.copy(
                passwordErrorMessage = "Please enter strong password"
            )

            _uiState.update { updatedUiSTate }

            return viewState
        }

        val password = uiState.value.password
        val reEnterPassword = uiState.value.reEnterPassword
        if (password != reEnterPassword) {
            val updatedUiSTate = uiState.value.copy(
                reEnterPasswordErrorMessage = "Both passwords didn't match."
            )

            _uiState.update { updatedUiSTate }

            return viewState
        }


        return SignUpViewState.Address
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














