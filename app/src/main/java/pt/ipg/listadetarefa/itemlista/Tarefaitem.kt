// Importações necessárias para layout, ícones, cores, visualização e dados
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import pt.ipg.listadetarefa.model.Tarefa
import pt.ipg.listadetarefa.ui.theme.black

// Função composable responsável por exibir um item de tarefa na interface
@Composable
fun TarefaIntem(
    position: Int,                  // Posição da tarefa na lista
    listatarefas: List<Tarefa>,    // Lista de tarefas a ser exibida
    onDelete: () -> Unit           // Função de callback para deletar a tarefa
) {
    // Recupera os dados da tarefa usando a posição fornecida
    val tituloTarefa = listatarefas[position].tarefa
    val descricaoTarefa = listatarefas[position].descricao
    val data = listatarefas[position].data

    // Card para conter visualmente os dados da tarefa, com cor e margem externa
    Card(
        colors = CardDefaults.cardColors(Color.LightGray),
        modifier = Modifier
            .fillMaxWidth() // O card ocupa toda a largura da tela
            .padding(top = 16.dp, start = 10.dp, end = 10.dp, bottom = 10.dp) // Margens externas
    ) {
        // Layout que permite posicionar os elementos com mais controle
        ConstraintLayout(modifier = Modifier.padding(20.dp)) {
            // Criação de referências para os elementos internos
            val (txtTitulo, txtDescricao, rowDataDelete) = createRefs()

            // Título da tarefa
            Text(
                text = tituloTarefa.toString(), // Exibe o título (mesmo que seja null, evita crash)
                modifier = Modifier.constrainAs(txtTitulo) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                },
                color = black
            )

            // Descrição da tarefa
            Text(
                text = descricaoTarefa.toString(), // Exibe a descrição
                modifier = Modifier.constrainAs(txtDescricao) {
                    top.linkTo(txtTitulo.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                },
                color = black
            )

            // Linha contendo a data da tarefa e o botão de deletar
            androidx.compose.foundation.layout.Row(
                modifier = Modifier.constrainAs(rowDataDelete) {
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                // Exibe a data da tarefa
                Text(
                    text = data.toString(), // Mostra a data
                    color = black,
                    modifier = Modifier.weight(1f) // Ocupa o espaço restante da linha
                )
                // Botão de deletar (ícone de lixeira)
                IconButton(onClick = onDelete) {
                    Icon(
                        imageVector = Icons.Default.Delete, // Ícone padrão de deletar
                        contentDescription = "Deletar",     // Acessibilidade
                        tint = Color.Red // Cor vermelha para indicar ação destrutiva
                    )
                }
            }
        }
    }
}

// Função de preview para visualizar o componente no Android Studio
@Preview
@Composable
private fun TarefaIntemPreview() {
    // Comentado — pode ser usado para testar a interface com dados fictícios
    // TarefaIntem(...)
}
