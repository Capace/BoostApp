package com.vv.boostapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType


@ExperimentalComposeUiApi
@Composable
fun StandardTextField(
    text: String = "",
    hint: String = "",
    textStyle: TextStyle = TextStyle(color = MaterialTheme.colors.onBackground),
    onvalueChange: (String) -> Unit,
    maxLines: Int = 1,
    keyboardType: KeyboardType = KeyboardType.Text,
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
    focusManager: FocusManager = LocalFocusManager.current
) {

    TextField(
            value = text, onValueChange = { onvalueChange(it) },
            textStyle = textStyle,
            maxLines = maxLines,
            placeholder = {
                Text(text = hint, style = MaterialTheme.typography.body1)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(onDone = {focusManager.clearFocus();keyboardController?.hide() })
            ,
            modifier = Modifier.fillMaxWidth()

        )

}