package pt.ipg.listadetarefa.componentes

// Importações necessárias para layout, campos de texto e configuração de teclado
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

// Importa um formato de borda customizado (Shape)
import pt.ipg.listadetarefa.ui.theme.ShapeEditeText

// Função Composable que define um campo de texto reutilizável com estilo e comportamento personalizados
@Composable
fun CaixaDetexto(
    value: String,                          // Texto atual do campo
    onValueChange: (String) -> Unit,        // Função que será chamada sempre que o texto mudar
    modifier: Modifier,                     // Modificador para personalização externa (largura, margem, etc.)
    label: String,                          // Label que aparece dentro do campo
    maxLines: Int,                          // Número máximo de linhas permitidas
    keyboardType: KeyboardType              // Tipo de teclado a ser exibido (ex: texto, numérico)
) {
    OutlinedTextField(
        value = value,                      // Valor atual do campo
        onValueChange = onValueChange,      // Ação a executar ao modificar o texto
        label = { Text(text = label) },     // Label do campo, exibido dentro da borda
        maxLines = maxLines,                // Limita o número de linhas do campo
        modifier = modifier,                // Aplica modificadores (ex: padding, largura total)
        colors = TextFieldDefaults.colors(  // Personalização das cores do campo
            focusedTextColor = Color.Blue,            // Cor do texto quando o campo está em foco
            unfocusedTextColor = Color.DarkGray,      // Cor do texto quando o campo não está em foco
            disabledTextColor = Color.LightGray,      // Cor do texto quando desabilitado

            focusedLabelColor = Color.Black,          // Cor da label quando em foco
            unfocusedLabelColor = Color.Gray,         // Cor da label quando fora de foco

            cursorColor = Color.Blue,                 // Cor do cursor de digitação
            focusedContainerColor = Color.White,      // Fundo branco quando em foco
            unfocusedContainerColor = Color.White,    // Fundo branco fora de foco
            disabledContainerColor = Color.LightGray  // Fundo cinza quando desabilitado
        ),
        shape = ShapeEditeText.small,       // Borda arredondada personalizada
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType     // Define o tipo de teclado a ser mostrado
        )
    )
}

// Função de preview para mostrar como o componente fica no Android Studio
@Preview(showBackground = true)
@Composable
fun CaixaDeTextoPreview() {
    CaixaDetexto(
        value = "Anas",                     // Valor inicial mostrado
        onValueChange = {},                 // Não faz nada ao alterar (apenas para o preview)
        modifier = Modifier
            .fillMaxWidth()                 // Ocupa a largura total disponível
            .padding(16.dp),                // Adiciona espaçamento em volta
        label = "Descrição da Tarefa",      // Label do campo
        maxLines = 1,                       // Apenas uma linha de texto permitida
        keyboardType = KeyboardType.Text    // Teclado padrão de texto
    )
}
