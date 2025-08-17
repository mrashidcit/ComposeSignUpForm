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
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@Composable
fun FullNameContainer(
    modifier: Modifier = Modifier,
    uiState: SignUpUiState,
    onAction: (SignUpAction) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        TextField(
            value = uiState.firstName,
            onValueChange = {
                onAction(SignUpAction.FirstNameOnValueChange(it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("First Name")
            },
            isError = (uiState.firstNameErrorMessage != null)
        )
        uiState.firstNameErrorMessage?.let { errorMessage ->
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            value = uiState.lastName,
            onValueChange = {
                onAction(SignUpAction.LastNameOnValueChange(it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Last Name")
            },
            isError = (uiState.lastNameErrorMessage != null)
        )
        uiState.lastNameErrorMessage?.let { errorMessage ->
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}

@Preview
@Composable
private fun FullNameContainerPreview() {
    val uiState = remember {
        SignUpUiState()
    }

    SignUpFormTheme {
        Surface {
            FullNameContainer(
                uiState = uiState,
                onAction = { }
            )
        }
    }
}













