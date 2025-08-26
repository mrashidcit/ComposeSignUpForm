package com.rashid.saleem.signupform.signup.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rashid.saleem.signupform.R
import com.rashid.saleem.signupform.signup.SignUpAction
import com.rashid.saleem.signupform.signup.SignUpUiState
import com.rashid.saleem.signupform.ui.theme.SignUpFormTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PasswordContainer(
    modifier: Modifier = Modifier,
    uiState: SignUpUiState,
    onAction: (SignUpAction) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        TextField(
            value = uiState.password,
            onValueChange = {
                onAction(SignUpAction.PasswordOnValueChange(it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Enter Password")
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(
                        if (uiState.isPasswordVisible)
                            R.drawable.visibility_on
                        else
                            R.drawable.visibility_off
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            onAction(SignUpAction.TogglePasswordVisibility)
                        }
                )
            },
            visualTransformation = if (uiState.isPasswordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation()
        )
        uiState.passwordErrorMessage?.let { errorMessage ->
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            value = uiState.reEnterPassword,
            onValueChange = {
                onAction(SignUpAction.ReEnterPasswordOnValueChange(it))
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Re-enter Password")
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(
                        if (uiState.isReEnterPasswordVisible)
                            R.drawable.visibility_on
                        else
                            R.drawable.visibility_off
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            onAction(SignUpAction.ToggleReEnterPasswordVisibility)
                        }
                )
            },
            visualTransformation = if (uiState.isReEnterPasswordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation()
        )
        uiState.reEnterPasswordErrorMessage?.let { errorMessage ->
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            PasswordStrengthIndicator(uiState.passwordStrength.hasMinLength6, "Min Length 6")
            PasswordStrengthIndicator(uiState.passwordStrength.hasUppercase, "Uppercase Alphabet")
            PasswordStrengthIndicator(uiState.passwordStrength.hasLowercase, "Lowercase Alphabet")
            PasswordStrengthIndicator(uiState.passwordStrength.hasNumber, "Number")
            PasswordStrengthIndicator(uiState.passwordStrength.hasSpecialCharacter, "Special Character")
        }

    }
}

@Composable
private fun PasswordStrengthIndicator(
    isPassed: Boolean,
    label: String,
) {
    Row(
        modifier = Modifier
            .background(
                color = if (isPassed) Color.Gray else Color.LightGray,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
    ) {
        Icon(
            imageVector = if (isPassed) Icons.Filled.Check else Icons.Filled.Close,
            contentDescription = null,
            tint = if (isPassed) Color.Green else Color.Red
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(label)
    }
}


@Preview
@Composable
private fun PasswordContainerPreview() {

    val uiState = remember {
        SignUpUiState()
    }

    SignUpFormTheme {
        Surface {
            PasswordContainer(
                uiState = uiState,
                onAction = { }
            )
        }
    }
}









