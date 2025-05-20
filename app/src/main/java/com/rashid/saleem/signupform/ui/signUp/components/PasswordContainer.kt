package com.rashid.saleem.signupform.ui.signUp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PasswordContainer() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Enter Password")
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Re-enter Password")
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ValidationCheckIndicator(
                text = "Min Length 6",
                isFulfilled = true
            )
            ValidationCheckIndicator(
                text = "Uppercase Alphabet",
                isFulfilled = false
            )
            ValidationCheckIndicator(
                text = "Lowercase Alphabet",
                isFulfilled = true
            )
            ValidationCheckIndicator(
                text = "Number",
                isFulfilled = false
            )
            ValidationCheckIndicator(
                text = "Character",
                isFulfilled = false
            )
        }
    }
}

@Composable
private fun ValidationCheckIndicator(
    text: String,
    isFulfilled: Boolean
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .background(
                color = if (isFulfilled) Color.Gray else Color.LightGray
            )
            .padding(
                vertical = 8.dp,
                horizontal = 12.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (isFulfilled) Icons.Default.Check else Icons.Default.Close,
            contentDescription = null,
            tint = if (isFulfilled) Color.Green else Color.Red
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text)
    }
}

@Preview
@Composable
private fun PasswordContainerPreview() {
    SignUpFormTheme {
        Surface {
            PasswordContainer()
        }
    }
}