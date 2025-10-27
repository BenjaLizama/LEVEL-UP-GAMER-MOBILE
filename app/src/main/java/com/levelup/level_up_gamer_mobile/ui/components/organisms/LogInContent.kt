package com.levelup.level_up_gamer_mobile.ui.components.organisms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.levelup.level_up_gamer_mobile.ui.theme.ColorAcento
import com.levelup.level_up_gamer_mobile.viewmodel.AuthUiState

@Composable
fun LogInContent(
    uiState: AuthUiState,
    onEmailChange: (String) -> Unit,
    onPassChange: (String) -> Unit,
    onLogInClicked: () -> Unit,
    onNavigateToSingUp: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Iniciar sesión",
            color = Color.White,
            fontSize = 8.em,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = uiState.loginEmail,
            onValueChange = onEmailChange,
            label = {Text("Correo electronico")},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedLabelColor = ColorAcento,
                focusedIndicatorColor = ColorAcento,

                unfocusedTextColor = Color.LightGray,
                unfocusedLabelColor = Color.LightGray,
                unfocusedIndicatorColor = Color.LightGray,

                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = ColorAcento
            ),
            isError = uiState.loginEmailError != null,
            supportingText = {
                if (uiState.loginEmailError != null) {
                    Text(
                        text = uiState.loginEmailError,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )

        OutlinedTextField(
            value = uiState.loginPass,
            onValueChange = onPassChange,
            label = {Text("Contraseña")},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedLabelColor = ColorAcento,
                focusedIndicatorColor = ColorAcento,

                unfocusedTextColor = Color.LightGray,
                unfocusedLabelColor = Color.LightGray,
                unfocusedIndicatorColor = Color.LightGray,

                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = ColorAcento
            ),
            isError = uiState.loginPassError != null,
            supportingText = {
                if (uiState.loginPassError != null) {
                    Text(
                        text = uiState.loginPassError,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )


        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
        ) {
            OutlinedButton (
                onClick = onNavigateToSingUp,
                enabled = true,
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, ColorAcento),
            ) {
                Text("Registrarme", color = ColorAcento)
            }

            Spacer(modifier = Modifier.width(5.dp))

            Button(
                onClick = onLogInClicked,
                enabled = uiState.isLoginButtonEnabled && !uiState.isLoginLoading,
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorAcento
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                if (uiState.isLoginLoading) {
                    CircularProgressIndicator(modifier = Modifier.size(24.dp))
                } else {
                    Text("Acceder")
                }
            }
        }
    }
}