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
import pt.ipg.listadetarefa.componentes.Botao
import pt.ipg.listadetarefa.componentes.CaixaDetexto
import pt.ipg.listadetarefa.model.Tarefa
import pt.ipg.listadetarefa.ui.theme.Purple80
import pt.ipg.listadetarefa.viewmodel.TarefaViewModel
import java.util.*

// Indica que estamos usando API experimental do Material3 para Scaffold e TopAppBar
@OptIn(ExperimentalMaterial3Api::class)
// Suprime um aviso sobre padding no Scaffold, pois estamos lidando manualmente com ele
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SalvaTarefa(
    navController: NavController,     // Controla a navegação entre telas
    viewModel: TarefaViewModel        // ViewModel para gerenciar dados e lógica
) {
    // Variáveis de estado para armazenar os valores dos campos do formulário
    var tituloTarefa by remember { mutableStateOf("") }
    var descricaoTarefa by remember { mutableStateOf("") }
    var dataSelecionada by remember { mutableStateOf("") }

    // Scaffold cria a estrutura básica da tela com TopBar e área de conteúdo
    Scaffold(
        topBar = {
            // Barra superior com título e cor customizada
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple80 // Cor roxa definida no tema
                ),
                title = {
                    Text(
                        text = "Salva Tarefa",          // Título da tela
                        fontSize = 18.sp,               // Tamanho da fonte
                        fontWeight = FontWeight.Bold,   // Peso da fonte em negrito
                        color = MaterialTheme.colorScheme.primaryContainer // Cor do texto
                    )
                }
            )
        },
        containerColor = Color.White // Cor de fundo da tela
    ) { paddingValues ->  // Recebe o padding aplicado pelo Scaffold (ex: para sistema UI)

        // === CRIAÇÃO DO DIALOG DE SELEÇÃO DE DATA ===

        // Obtém a data atual para iniciar o DatePickerDialog
        val calendario = Calendar.getInstance()
        val anoAtual = calendario.get(Calendar.YEAR)
        val mesAtual = calendario.get(Calendar.MONTH)
        val diaAtual = calendario.get(Calendar.DAY_OF_MONTH)

        // Cria o DatePickerDialog com o contexto da tela atual (via navController)
        val datePickerDialog = DatePickerDialog(
            navController.context,
            { _, year, month, dayOfMonth ->
                // Formata a data selecionada no formato dd/MM/yyyy
                dataSelecionada = "%02d/%02d/%d".format(dayOfMonth, month + 1, year)
            },
            anoAtual, mesAtual, diaAtual // Inicializa o diálogo com a data atual
        )

        // === CONTEÚDO PRINCIPAL ===

        Column(
            modifier = Modifier
                .fillMaxSize()                          // Ocupa toda a tela
                .verticalScroll(rememberScrollState()) // Permite scroll vertical se necessário
                .padding(paddingValues)                 // Aplica padding do Scaffold
        ) {
            // Campo para inserir o título da tarefa
            CaixaDetexto(
                value = tituloTarefa,
                onValueChange = { tituloTarefa = it },          // Atualiza o estado
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),       // Espaçamento ao redor
                label = "Titulo da Tarefa",                     // Texto do label
                maxLines = 1,                                   // Apenas uma linha
                keyboardType = KeyboardType.Text                // Tipo do teclado
            )

            // Campo para inserir a descrição da tarefa
            CaixaDetexto(
                value = descricaoTarefa,
                onValueChange = { descricaoTarefa = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)                            // Altura maior para texto maior
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Descricao da Tarefa",
                maxLines = 10,
                keyboardType = KeyboardType.Text
            )

            // Campo que mostra a data selecionada, somente leitura
            OutlinedTextField(
                value = dataSelecionada,
                onValueChange = {}, // Não permite editar manualmente
                label = { Text("Data da Tarefa") },
                readOnly = true,    // Bloqueia edição
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,      // Cor quando focado
                    unfocusedContainerColor = Color.White,    // Cor quando desfocado
                    disabledContainerColor = Color.LightGray  // Cor quando desabilitado
                ),
                trailingIcon = {
                    Text(text = "📅")                          // Ícone emoji calendário
                }
            )

            // Botão para abrir o seletor de data (DatePickerDialog)
            Button(
                onClick = { datePickerDialog.show() },          // Mostra o diálogo ao clicar
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                // Texto do botão muda conforme data selecionada
                Text(
                    text = if (dataSelecionada.isNotEmpty()) "Data: $dataSelecionada" else "Selecionar Data"
                )
            }

            // Botão customizado para salvar a tarefa
            Botao(
                onClick = {
                    // Valida se os campos não estão vazios
                    if (tituloTarefa.isNotBlank() && descricaoTarefa.isNotBlank() && dataSelecionada.isNotBlank()) {
                        // Adiciona a nova tarefa no ViewModel
                        viewModel.adicionarTarefa(
                            Tarefa(
                                tarefa = tituloTarefa,
                                descricao = descricaoTarefa,
                                data = dataSelecionada
                            )
                        )
                        // Volta para a tela anterior (lista de tarefas)
                        navController.popBackStack()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(80.dp),       // Altura maior para botão fácil de clicar
                texto = "Salvar"
            )
        }
    }
}

// Preview para visualizar a UI no Android Studio sem rodar o app
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SalvaTarefaPreview() {
    val navController = rememberNavController()
    // A chamada abaixo está comentada porque falta ViewModel no preview
    // SalvaTarefa(navController = navController)
}
