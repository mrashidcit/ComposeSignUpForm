package com.rashid.saleem.signupform.signup.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@Composable
fun EmailContainer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Email")
            }
        )
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Verification Code")
            }
        )
    }
}

@Preview
@Composable
private fun EmailContainerPreview() {
    SignUpFormTheme {
        Surface {
            EmailContainer()
        }
    }
}











