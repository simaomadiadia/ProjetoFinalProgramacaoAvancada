package pt.ipg.listadetarefa.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.ipg.listadetarefa.ui.theme.ShapeEditeText



@Composable
fun CaixaDetexto(
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
            focusedTextColor = Color.Blue,           // Cor do texto quando o campo está focado
            unfocusedTextColor = Color.DarkGray,     // Cor do texto quando não está focado
            disabledTextColor = Color.LightGray,     // Cor do texto quando o campo está desativado

            focusedLabelColor = Color.Black,         // Cor do label quando focado
            unfocusedLabelColor = Color.Gray,        // Cor do label quando não está focado

            cursorColor = Color.Blue,                // Cor do cursor de texto
            focusedContainerColor = Color.White,     // Cor de fundo com foco
            unfocusedContainerColor = Color.White,   // Cor de fundo sem foco
            disabledContainerColor = Color.LightGray // Cor de fundo desabilitado

        ),
        shape = ShapeEditeText.small,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)

    )
}

@Preview(showBackground = true)
@Composable
fun CaixaDeTextoPreview() {
    CaixaDetexto(
        value = "Anas",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), // Adiciona margem
        label = "Descrição da Tarefa",
        maxLines = 1,
        keyboardType = KeyboardType.Text
    )
}

