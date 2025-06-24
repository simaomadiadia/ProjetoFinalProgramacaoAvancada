package pt.ipg.listadetarefa.componentes

// Importações necessárias para layout e UI
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController

// Importa a cor do tema
import pt.ipg.listadetarefa.ui.theme.Purple80

// Importa a tela de salvar tarefa (ainda que não seja usada aqui, talvez você planeje usar)
import pt.ipg.listadetarefa.view.SalvaTarefa

// Composable reutilizável para criar botões personalizados
@Composable
fun Botao(
    onClick: () -> Unit,           // Ação ao clicar no botão
    modifier: Modifier = Modifier, // Modificador opcional para customizar o botão externamente
    texto: String                  // Texto exibido no botão
) {
    Button(
        onClick = onClick,         // Define a ação ao clicar
        modifier = modifier,       // Aplica o modificador recebido
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple80, // Cor de fundo do botão
            contentColor = Color.White // Cor do texto e ícones
        )
    ) {
        // Texto exibido dentro do botão
        Text(
            text = texto,
            fontWeight = FontWeight.Bold, // Texto em negrito
            fontSize = 18.sp              // Tamanho da fonte
        )
    }
}

// Função preview que permite ver o botão na pré-visualização do Android Studio
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BotaoPreview() {
    val navController = rememberNavController() // Criado aqui, mas não usado

    Botao(
        onClick = { /* Lógica para salvar a tarefa */ },  // Ação fictícia para o preview
        modifier = Modifier
            .fillMaxWidth() // Ocupa toda a largura disponível
            .padding(20.dp) // Espaçamento ao redor do botão
            .height(80.dp), // Altura do botão
        texto = "Salvar"     // Texto que aparecerá no botão
    )
}
