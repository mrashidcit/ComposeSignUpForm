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
fun AddressContainer(
    uiState: SignUpUiState,
    onAction: (SignUpAction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = uiState.city,
            onValueChange = {
                onAction(SignUpAction.UpdateCity(it))
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("City")
            },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = uiState.address,
            onValueChange = {
                onAction(SignUpAction.UpdateAddress(it))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            label = {
                Text("Address")
            },
            maxLines = 5
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = uiState.country,
            onValueChange = {
                onAction(SignUpAction.UpdateCountry(it))
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Country")
            },
            singleLine = true
        )

    }
}


@Preview
@Composable
private fun AddressContainerPreview() {
    SignUpFormTheme {
        Surface {
            val uiState = remember {
                SignUpUiState()
            }
            AddressContainer(
                uiState = uiState,
                onAction = { }
            )
        }
    }
}









