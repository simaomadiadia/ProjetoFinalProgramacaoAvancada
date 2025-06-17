package pt.ipg.listadetarefa.view

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import pt.ipg.listadetarefa.ui.theme.Purple80
import androidx.navigation.NavController as NavController1


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaTarefas(navController : NavController1){

    Scaffold (
        topBar ={
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple80 // ou MaterialTheme.colorScheme.primary
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
        containerColor = Color.Black // Cor de fundo do Scaffold

    ){

    }
}


