package pt.ipg.listadetarefa.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pt.ipg.listadetarefa.componentes.CaixaDetexto
import pt.ipg.listadetarefa.ui.theme.Purple80

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SalvaTarefa(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple80 // ou MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        text = "Salva Tarefa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                }
            )
        },
        containerColor = Color.White //cor de fundo
    ) {paddingValues ->
        // Conteúdo da tela aqui

        var tituloTarefa by remember {
            mutableStateOf("")
        }

        var descricaoTarefa by remember {
            mutableStateOf("")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues) // AQUI está a correção
        ) {
            CaixaDetexto(
                value = tituloTarefa,
                onValueChange = { tituloTarefa = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Titulo da Tarefa",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )
            CaixaDetexto(
                value = descricaoTarefa ,
                onValueChange = { descricaoTarefa  = it },
                modifier = Modifier
                    .fillMaxWidth().height(200.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Descricao da Tarefa",
                maxLines = 10,
                keyboardType = KeyboardType.Text
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SalvaTarefaPreview() {
    val navController = rememberNavController()
    SalvaTarefa(navController = navController)
}
