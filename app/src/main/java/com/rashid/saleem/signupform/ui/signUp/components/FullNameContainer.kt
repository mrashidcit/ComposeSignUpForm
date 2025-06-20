package com.rashid.saleem.signupform.ui.signUp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashid.saleem.signupform.ui.signUp.SignUpAction
import com.rashid.saleem.signupform.ui.signUp.SignUpUiState
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@Composable
fun FullNameContainer(
    uiState: SignUpUiState,
    onAction: (SignUpAction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = uiState.firstName,
            onValueChange = {
                onAction(SignUpAction.UpdateFirstName(it))
                            },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("First Name") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            value = uiState.lastName,
            onValueChange = {
                onAction(SignUpAction.UpdateLastName(it))
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Last Name")
            },
            singleLine = true
        )
    }
}

@Preview
@Composable
private fun FullNameContainerPreview() {
    SignUpFormTheme {
        Surface {
            val uiState = remember {
                SignUpUiState()
            }
            FullNameContainer(
                uiState = uiState,
                onAction = { }
            )
        }
    }
}