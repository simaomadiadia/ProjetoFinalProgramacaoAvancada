package pt.ipg.listadetarefa.view

import TarefaIntem
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pt.ipg.listadetarefa.R
import pt.ipg.listadetarefa.ui.theme.Purple80
import androidx.navigation.NavController as NavController1
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import pt.ipg.listadetarefa.model.Tarefa

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaTarefas(navController : NavController1){

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple80
                ),
                title = {
                    Text(
                        text = "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                }
            )
        },
        containerColor = Color.Black,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("SalvaTarefas")
                },
                containerColor = Purple80
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_add_24),
                    contentDescription = "Adicionar"
                )
            }
        }
    ) { paddingValues ->  // <- USE ISSO AQUI

        val listatarefas: MutableList<Tarefa> = mutableListOf(
            Tarefa("Tarefa 1", "Descrição da Tarefa 1", "10/10/2023"),
            Tarefa("Tarefa 2", "Descrição da Tarefa 2", "11/10/2023"),
            Tarefa("Tarefa 3", "Descrição da Tarefa 3", "12/10/2023"),
            Tarefa("Tarefa 3", "Descrição da Tarefa 3", "12/10/2023"),
            Tarefa("Tarefa 3", "Descrição da Tarefa 3", "12/10/2023"),
            Tarefa("Tarefa 3", "Descrição da Tarefa 3", "12/10/2023"),
            Tarefa("Tarefa 3", "Descrição da Tarefa 3", "12/10/2023"),
            Tarefa("Tarefa 3", "Descrição da Tarefa 3", "12/10/2023"),
            Tarefa("Tarefa 3", "Descrição da Tarefa 3", "12/10/2023"),
            Tarefa("Tarefa 3", "Descrição da Tarefa 3", "12/10/2023"),
            Tarefa("Tarefa 3", "Descrição da Tarefa 3", "12/10/2023"),
            Tarefa("Tarefa 3", "Descrição da Tarefa 3", "12/10/2023"),
            Tarefa("Tarefa 3", "Descrição da Tarefa 3", "12/10/2023")
        )

        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            itemsIndexed(listatarefas) { position, _ ->
                TarefaIntem(position, listatarefas)
            }
        }
    }

}

