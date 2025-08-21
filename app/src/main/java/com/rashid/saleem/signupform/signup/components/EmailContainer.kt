package com.rashid.saleem.signupform.signup.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashid.saleem.signupform.signup.SignUpAction
import com.rashid.saleem.signupform.signup.SignUpUiState
import com.rashid.saleem.signupform.signup.SignUpViewState
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@Composable
fun EmailContainer(
    modifier: Modifier = Modifier,
    uiState: SignUpUiState,
    viewState: SignUpViewState.Email,
    onAction: (SignUpAction) -> Unit
) {
    Column(
        modifier = modifier
    ) {

        if (viewState.showVerificationCode) {
            TextField(
                value = uiState.verificationCode,
                onValueChange = {
                    onAction(SignUpAction.VerificationCodeOnValueChange(it))
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Verification Code")
                }
            )
            uiState.verificationCodeErrorMessage?.let { errorMessage ->
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error
                )
            }
        } else {
            TextField(
                value = uiState.email,
                onValueChange = {
                    onAction(SignUpAction.EmailOnValueChange(it))
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Email")
                }
            )
            uiState.emailErrorMessage?.let { errorMessage ->
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }

    }
}

@Preview
@Composable
private fun EmailContainerPreview() {

    val uiState = remember {
        SignUpUiState()
    }

    SignUpFormTheme {
        Surface {
            EmailContainer(
                uiState = uiState,
                viewState = SignUpViewState.Email(),
                onAction = { }
            )
        }
    }
}











