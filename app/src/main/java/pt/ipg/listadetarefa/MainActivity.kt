package pt.ipg.listadetarefa

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


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaDeTarefaTheme {
                /*Configuracao de navegação */
                val navController = rememberNavController()
                val viewModel: TarefaViewModel = viewModel()

                NavHost(navController, startDestination = "ListaTarefas") {
                    composable("ListaTarefas") {
                        ListaTarefas(navController, viewModel)
                    }
                    composable("SalvaTarefas") {
                        SalvaTarefa(navController, viewModel)
                    }
                }
        }
    }
 }
}



