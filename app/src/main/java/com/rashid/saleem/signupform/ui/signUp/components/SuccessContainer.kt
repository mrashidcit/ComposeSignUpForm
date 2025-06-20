package com.rashid.saleem.signupform.ui.signUp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashid.saleem.signupform.ui.theme.DarkGreen
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@Composable
fun SuccessContainer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            tint = DarkGreen
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Account Successfully Created."
        )
    }
}


@Preview
@Composable
private fun SuccessContainerPreview() {
    SignUpFormTheme {
        Surface {
            SuccessContainer()
        }
    }
}

















