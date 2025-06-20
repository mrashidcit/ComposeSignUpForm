package com.rashid.saleem.signupform.ui.signUp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashid.saleem.signupform.ui.signUp.SignUpAction
import com.rashid.saleem.signupform.ui.signUp.SignUpUiState
import com.rashid.saleem.signupform.ui.signUp.SignUpViewState
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@Composable
fun SignUpContent(
    uiState: SignUpUiState,
    onAction: (SignUpAction) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 20.dp,
                vertical = 20.dp
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(modifier = Modifier.weight(1f)) {
            when (uiState.viewState) {
                SignUpViewState.FullName -> FullNameContainer(
                    uiState = uiState,
                    onAction = onAction
                )
                is SignUpViewState.Email -> EmailContainer(
                    uiState = uiState,
                    onAction = onAction
                )
                SignUpViewState.Password -> PasswordContainer(
                    uiState = uiState,
                    onAction = onAction
                )
                SignUpViewState.Address -> AddressContainer(
                    uiState = uiState,
                    onAction = onAction
                )

                SignUpViewState.Success -> SuccessContainer(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Button(
            onClick = {
                onAction(SignUpAction.NextOnClick)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp
                ),
            enabled = uiState.enableNextButton
        ) { Text("Next") }
    }
}

@Preview
@Composable
private fun SignUpContentPreview() {
    SignUpFormTheme {
        val uiState = remember {
            SignUpUiState()
        }
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            SignUpContent(
                uiState = uiState
            ) { }
        }
    }
}