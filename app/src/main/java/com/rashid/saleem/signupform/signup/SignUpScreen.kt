package com.rashid.saleem.signupform.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rashid.saleem.signupform.signup.components.SignUpContent

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    SignUpContent(
        uiState =  uiState,
        onAction = viewModel::onAction
    )

}