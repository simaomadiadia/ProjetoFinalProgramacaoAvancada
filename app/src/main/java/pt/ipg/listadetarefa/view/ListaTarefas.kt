package pt.ipg.listadetarefa.view

// Importa o componente de item de tarefa
import TarefaIntem

// Suprime o warning de Scaffold que não utiliza padding diretamente
import android.annotation.SuppressLint

// Importações necessárias para a interface e componentes do Jetpack Compose
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*  // Importa componentes como Scaffold, TopAppBar, etc.
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Recursos da aplicação (ícones, cores)
import pt.ipg.listadetarefa.R
import pt.ipg.listadetarefa.ui.theme.Purple80

// Alias para evitar conflito com outro NavController
import androidx.navigation.NavController as NavController1

// Importa o ícone vetorial de adicionar
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

// Modelo de dados da tarefa
import pt.ipg.listadetarefa.model.Tarefa

// ViewModel que gerencia a lista de tarefas
import pt.ipg.listadetarefa.viewmodel.TarefaViewModel

// Anotação que permite o uso de componentes experimentais do Material 3
@OptIn(ExperimentalMaterial3Api::class)
// Suprime warning relacionado ao uso do padding do Scaffold
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

// Função composable principal que exibe a lista de tarefas
@Composable
fun ListaTarefas(navController : NavController1, viewModel: TarefaViewModel) {
    // Observa a lista de tarefas a partir do ViewModel
    val tarefas = viewModel.listaTarefas

    // Scaffold: estrutura básica da tela, com TopAppBar e FAB
    Scaffold(
        topBar = {
            // Barra superior com título e cor personalizada
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple80
                ),
                title = {
                    Text(
                        text = "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primaryContainer // Cor do texto
                    )
                }
            )
        },

        // Cor de fundo da tela
        containerColor = Color.Black,

        // Botão flutuante para navegar até a tela de salvar nova tarefa
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("SalvaTarefas")  // Navega para tela de adicionar tarefa
                },
                containerColor = Purple80
            ) {
                // Ícone de adicionar dentro do botão flutuante
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_24),
                    contentDescription = "Adicionar"
                )
            }
        }
    ) { paddingValues -> // Espaçamento reservado pelo Scaffold

        // Lista rolável (LazyColumn) para exibir as tarefas
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            // Itera sobre a lista de tarefas com índice
            itemsIndexed(tarefas) { index, _ ->
                // Exibe o item de tarefa usando o componente reutilizável
                TarefaIntem(
                    position = index,
                    listatarefas = tarefas,
                    onDelete = { viewModel.removerTarefa(index) } // Ação de deletar
                )
            }
        }
    }
}
