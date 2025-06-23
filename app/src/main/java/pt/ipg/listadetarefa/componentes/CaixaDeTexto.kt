package pt.ipg.listadetarefa.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation.Companion.keyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import pt.ipg.listadetarefa.ui.theme.ShapeEditeText



@Composable
fun Caixatexto(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        maxLines =   maxLines,
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Color.Black,
            focusedTextColor = Color.Blue,
            unfocusedLabelColor = Color.Black,
            unfocusedTextColor = Color.Black,
            cursorColor = Color.Blue

        ),
        shape = ShapeEditeText.small,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)

    )
}

@Composable
@Preview(showBackground = true)
fun CaixaDeTextoPreview() {
    Caixatexto(
        value = "Ana",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        label = "Descricao da Tarefa",
        maxLines = 1,
        keyboardType = KeyboardType.Text
    )
}
