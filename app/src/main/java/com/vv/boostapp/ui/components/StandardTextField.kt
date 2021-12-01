package com.vv.boostapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType


@Composable
fun StandardTextField(
    text: String = "",
    hint: String = "",
    textStyle: TextStyle = TextStyle(color = MaterialTheme.colors.onBackground),
    onvalueChange: (String) -> Unit,
    maxLines: Int = 1,
    keyboardType: KeyboardType = KeyboardType.Text
) {
        TextField(
            value = text, onValueChange = { onvalueChange(it) },
            textStyle = textStyle,
            maxLines = maxLines,
            placeholder = {
                Text(text = hint, style = MaterialTheme.typography.body1)
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            modifier = Modifier.fillMaxWidth()

        )

}