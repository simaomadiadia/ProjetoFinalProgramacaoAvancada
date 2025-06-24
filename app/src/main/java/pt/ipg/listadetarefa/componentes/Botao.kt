package pt.ipg.listadetarefa.componentes

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
import pt.ipg.listadetarefa.ui.theme.Purple80
import pt.ipg.listadetarefa.view.SalvaTarefa

@Composable
fun Botao(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    texto: String
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Purple80 ,   // Novo nome para backgroundColor no Material3
            contentColor = Color.White
        )
    ) {
        Text(
            text = texto,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BotaoPreview() {
    val navController = rememberNavController()
   Botao(onClick = { /* Lógica para salvar a tarefa */ },
       modifier = Modifier
           .fillMaxWidth()
           .padding(20.dp)
           .height(80.dp),
       texto = "Salvar") ;
}