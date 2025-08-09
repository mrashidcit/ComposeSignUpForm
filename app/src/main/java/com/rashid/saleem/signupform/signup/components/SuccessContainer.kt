package com.rashid.saleem.signupform.signup.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashid.saleem.signupform.R
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@Composable
fun SuccessContainer(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.baseline_check_circle_24),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            tint = Color.Green
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text("Account Successfully Created.")
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










