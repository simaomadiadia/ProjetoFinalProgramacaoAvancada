package pt.ipg.listadetarefa

// Importações necessárias para a Activity, Compose, navegação e ViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import pt.ipg.listadetarefa.ui.theme.ListaDeTarefaTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pt.ipg.listadetarefa.view.ListaTarefas
import pt.ipg.listadetarefa.view.SalvaTarefa
import pt.ipg.listadetarefa.viewmodel.TarefaViewModel

// Classe principal da aplicação que herda ComponentActivity
class MainActivity : ComponentActivity() {

    // Método chamado quando a Activity é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ativa o modo Edge-to-Edge para a UI ocupar toda a tela, inclusive áreas como barra de status
        enableEdgeToEdge()

        // Define o conteúdo da Activity usando Compose
        setContent {
            // Aplica o tema personalizado da aplicação
            ListaDeTarefaTheme {

                // Cria um controlador de navegação para gerenciar as telas
                val navController = rememberNavController()

                // Obtém a instância do ViewModel para gerenciamento das tarefas
                val viewModel: TarefaViewModel = viewModel()

                // Configuração do NavHost, definindo as rotas e telas da navegação
                NavHost(navController, startDestination = "ListaTarefas") {

                    // Tela inicial: lista de tarefas
                    composable("ListaTarefas") {
                        ListaTarefas(navController, viewModel)  // Passa navController e ViewModel para a tela
                    }

                    // Tela para salvar/editar tarefas
                    composable("SalvaTarefas") {
                        SalvaTarefa(navController, viewModel)   // Passa navController e ViewModel para a tela
                    }
                }
            }
        }
    }
}
