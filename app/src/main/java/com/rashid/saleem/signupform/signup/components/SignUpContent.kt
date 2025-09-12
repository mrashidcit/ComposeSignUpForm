package com.rashid.saleem.signupform.signup.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rashid.saleem.signupform.signup.SignUpAction
import com.rashid.saleem.signupform.signup.SignUpUiState
import com.rashid.saleem.signupform.signup.SignUpViewState
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@Composable
fun SignUpContent(
    uiState: SignUpUiState,
    onAction: (SignUpAction) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        when (uiState.viewState) {
            SignUpViewState.FullName ->
                FullNameContainer(
                    modifier = Modifier.weight(1f),
                    uiState = uiState,
                    onAction = onAction
                )

            is SignUpViewState.Email ->
                EmailContainer(
                    modifier = Modifier.weight(1f),
                    uiState = uiState,
                    viewState = uiState.viewState,
                    onAction = onAction
                )

            SignUpViewState.Password ->
                PasswordContainer(
                    modifier = Modifier.weight(1f),
                    uiState = uiState,
                    onAction = onAction
                )

            SignUpViewState.Address ->
                AddressContainer(
                    modifier = Modifier.weight(1f),
                    uiState = uiState,
                    onAction = onAction
                )

            SignUpViewState.Success ->
                SuccessContainer(
                    modifier = Modifier.weight(1f)
                )
        }


        Button(
            onClick = {
                onAction(SignUpAction.NextOnClick)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp
                )
        ) {
            Text("Next")
        }

    }

}

@Preview
@Composable
private fun SignUpContentPreview() {
    val uiState = remember {
        SignUpUiState(
            viewState = SignUpViewState.Success
        )
    }

    SignUpFormTheme {
        Surface {
            SignUpContent(
                uiState = uiState,
                onAction = { }
            )
        }
    }
}

















