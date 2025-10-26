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
import com.levelup.level_up_gamer_mobile.viewmodel.SingUpUiState
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em

@Composable
fun SingUpContent(
    uiState: SingUpUiState,
    onNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPassChange: (String) -> Unit,
    onConfirmPassChange: (String) -> Unit,
    onSingUpClicked: () -> Unit,
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
                value = uiState.name,
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
                isError = uiState.nameError != null,
                supportingText = {
                    if (uiState.nameError != null) {
                        Text(
                            text = uiState.nameError,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.width(5.dp))

            OutlinedTextField(
                value = uiState.lastName,
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
                isError = uiState.lastNameError != null,
                supportingText = {
                    if (uiState.lastNameError != null) {
                        Text(
                            text = uiState.lastNameError,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.email,
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
            isError = uiState.emailError != null,
            supportingText = {
                if (uiState.emailError != null) {
                    Text(
                        text = uiState.emailError,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.pass,
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
            isError = uiState.passError != null,
            supportingText = {
                if (uiState.passError != null) {
                    Text(
                        text = uiState.passError,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = uiState.confirmPass,
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
            isError = uiState.confirmPassError != null,
            supportingText = {
                if (uiState.confirmPassError != null) {
                    Text(
                        text = uiState.confirmPassError,
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
                onClick = {null},
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
                enabled = uiState.isRegisterButtonEnabled && !uiState.isLoading,
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorAcento
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                if (uiState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.size(24.dp))
                } else {
                    Text("Registrarme")
                }
            }
        }
    }
}