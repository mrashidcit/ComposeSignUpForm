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
fun AddressContainer(
    modifier: Modifier = Modifier,
    uiState: SignUpUiState,
    onAction: (SignUpAction) -> Unit
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        TextField(
            value = uiState.city,
            onValueChange = {
                onAction(SignUpAction.CityOnValueChange(it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("City")
            }
        )
        uiState.cityErrorMessage?.let { errorMessage ->
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            value = uiState.country,
            onValueChange = {
                onAction(SignUpAction.CountryOnValueChange(it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Country")
            }
        )
        uiState.countryErrorMessage?.let { errorMessage ->
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            value = uiState.address,
            onValueChange = {
                onAction(SignUpAction.AddressOnValueChange(it))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
            ,
            placeholder = {
                Text("Address")
            }
        )
        Spacer(modifier = Modifier.height(6.dp))

    }
}


@Preview
@Composable
private fun AddressContainerPreview() {

    val uiState = remember {
        SignUpUiState()
    }
    SignUpFormTheme {
        Surface {
            AddressContainer(
                uiState = uiState,
                onAction = { }
            )
        }
    }
}



















