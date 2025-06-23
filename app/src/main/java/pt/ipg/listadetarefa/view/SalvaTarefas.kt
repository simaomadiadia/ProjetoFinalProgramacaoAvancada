package pt.ipg.listadetarefa.view

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import java.util.*

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
                    containerColor = Purple80
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
        containerColor = Color.White
    ) { paddingValues ->

        var tituloTarefa by remember { mutableStateOf("") }
        var descricaoTarefa by remember { mutableStateOf("") }
        var dataSelecionada by remember { mutableStateOf("") }

        // Calendário e DatePickerDialog
        val calendario = Calendar.getInstance()
        val anoAtual = calendario.get(Calendar.YEAR)
        val mesAtual = calendario.get(Calendar.MONTH)
        val diaAtual = calendario.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            navController.context,
            { _, year, month, dayOfMonth ->
                dataSelecionada = "%02d/%02d/%d".format(dayOfMonth, month + 1, year)
            },
            anoAtual, mesAtual, diaAtual
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            // Campo Título
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

            // Campo Descrição
            CaixaDetexto(
                value = descricaoTarefa,
                onValueChange = { descricaoTarefa = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Descricao da Tarefa",
                maxLines = 10,
                keyboardType = KeyboardType.Text
            )

            // Campo de Data (somente leitura)
            OutlinedTextField(
                value = dataSelecionada,
                onValueChange = {}, // somente leitura
                label = { Text("Data da Tarefa") },
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    disabledContainerColor = Color.LightGray
                ),
                trailingIcon = {
                    Text(text = "📅")
                }
            )

            // Botão para abrir DatePicker
            Button(
                onClick = { datePickerDialog.show() },
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = if (dataSelecionada.isNotEmpty()) "Data: $dataSelecionada" else "Selecionar Data"
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SalvaTarefaPreview() {
    val navController = rememberNavController()
    SalvaTarefa(navController = navController)
}
