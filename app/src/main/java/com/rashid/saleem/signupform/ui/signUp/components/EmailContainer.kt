package com.rashid.saleem.signupform.ui.signUp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@Composable
fun EmailContainer() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Email")
            }
        )

        Box(modifier = Modifier.height(12.dp))
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier.fillMaxWidth(),
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Center
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            placeholder = {
                Text(
                    text = "Verification Code",
                    style = LocalTextStyle.current.copy(
                        textAlign = TextAlign.Center
                    )
                )
            }
        )
    }
}

@Preview
@Composable
fun EmailContainerPreview(modifier: Modifier = Modifier) {
    SignUpFormTheme {
        Surface {
            EmailContainer()
        }
    }
}