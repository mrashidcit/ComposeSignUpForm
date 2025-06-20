package com.rashid.saleem.signupform.ui.signUp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rashid.saleem.signupform.ui.signUp.components.SignUpContent

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SignUpContent(
        uiState = uiState,
        onAction = viewModel::onAction
    )

}