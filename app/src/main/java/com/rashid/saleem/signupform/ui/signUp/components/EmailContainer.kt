package com.rashid.saleem.signupform.ui.signUp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashid.saleem.signupform.ui.signUp.SignUpAction
import com.rashid.saleem.signupform.ui.signUp.SignUpUiState
import com.rashid.saleem.signupform.ui.signUp.SignUpViewState
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@Composable
fun EmailContainer(
    uiState: SignUpUiState,
    onAction: (SignUpAction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = uiState.email,
            onValueChange = {
                onAction(SignUpAction.UpdateEmail(it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Email")
            },
            singleLine = true
        )
        uiState.viewState.let { viewState ->
            if (viewState is SignUpViewState.Email && viewState.emailErrorMessage != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = viewState.emailErrorMessage,
                    color = Color.Red
                )
            }
        }

        if (uiState.viewState is SignUpViewState.Email && uiState.viewState.isVerificationCodeSent) {
            Box(modifier = Modifier.height(12.dp))
            TextField(
                value = uiState.verificationCode,
                onValueChange = {
                    onAction(SignUpAction.UpdateVerificationCode(it))
                },
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Center
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                label = {
                    Text(
                        text = "Verification Code"
                    )
                },
                singleLine = true
            )

            uiState.viewState.verificationCodeErrorMessage?.let { message ->
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = message,
                    color = Color.Red
                )
            }
        }
    }
}

@Preview
@Composable
fun EmailContainerPreview(modifier: Modifier = Modifier) {
    SignUpFormTheme {
        Surface {
            val uiState = remember {
                SignUpUiState(
                    viewState = SignUpViewState.Email(
                        isVerificationCodeSent = true,
                        emailErrorMessage = "Please enter email address.",
                        verificationCodeErrorMessage = "Please enter code."
                    )
                )
            }
            EmailContainer(
                uiState = uiState,
                onAction = { }
            )
        }
    }
}