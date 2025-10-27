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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.levelup.level_up_gamer_mobile.ui.theme.ColorAcento
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em
import com.levelup.level_up_gamer_mobile.viewmodel.AuthUiState

@Composable
fun SingUpContent(
    uiState: AuthUiState,
    onNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPassChange: (String) -> Unit,
    onConfirmPassChange: (String) -> Unit,
    onSingUpClicked: () -> Unit,
    onLogInClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Crea tu cuenta",
            color = Color.White,
            fontSize = 8.em,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row (modifier = Modifier
            .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = uiState.signUpName,
                onValueChange = onNameChange,
                label = {Text("Nombre")},
                modifier = Modifier.weight(1f),
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
                isError = uiState.signUpNameError != null,
                supportingText = {
                    if (uiState.signUpNameError != null) {
                        Text(
                            text = uiState.signUpNameError,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.width(5.dp))

            OutlinedTextField(
                value = uiState.signUpLastName,
                onValueChange = onLastNameChange,
                label = {Text("Apellido")},
                modifier = Modifier.weight(1f),
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
                isError = uiState.signUpLastNameError != null,
                supportingText = {
                    if (uiState.signUpLastNameError != null) {
                        Text(
                            text = uiState.signUpLastNameError,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.signUpEmail,
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
            isError = uiState.signUpEmailError != null,
            supportingText = {
                if (uiState.signUpEmailError != null) {
                    Text(
                        text = uiState.signUpEmailError,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.signUpPass,
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
            isError = uiState.signUpPassError != null,
            supportingText = {
                if (uiState.signUpPassError != null) {
                    Text(
                        text = uiState.signUpPassError,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.signUpConfirmPass,
            onValueChange = onConfirmPassChange,
            label = {Text("Confirmar contraseña")},
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
            isError = uiState.signUpConfirmPassError != null,
            supportingText = {
                if (uiState.signUpConfirmPassError != null) {
                    Text(
                        text = uiState.signUpConfirmPassError,
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
                onClick = onLogInClicked,
                enabled = true,
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, ColorAcento),
            ) {
                Text("Acceder", color = ColorAcento)
            }

            Spacer(modifier = Modifier.width(5.dp))

            Button(
                onClick = onSingUpClicked,
                enabled = uiState.isSignUpButtonEnabled && !uiState.isSignUpLoading,
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorAcento
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                if (uiState.isSignUpLoading) {
                    CircularProgressIndicator(modifier = Modifier.size(24.dp))
                } else {
                    Text("Registrarme")
                }
            }
        }
    }
}