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
import pt.ipg.listadetarefa.ui.theme.black

@Composable
fun TarefaIntem() {
    Card(
        colors = CardDefaults.cardColors(Color.LightGray),
        modifier = Modifier.fillMaxWidth().padding(10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (txtTitulo, txtDescricao, txtData, btDeletar) = createRefs()

            Text(
                text = "Tarefa 1",
                modifier = Modifier.constrainAs(txtTitulo) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                },
                color = black,
            )

            Text(
                text = "dbdbbndnbdbnd ddbhdhkdhdhd dbddhdh ",
                modifier = Modifier.constrainAs(txtDescricao) {
                    top.linkTo(txtTitulo.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                },
                color = black,
            )

            Text(
                text = "Data",
                modifier = Modifier.constrainAs(txtData) {
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                },
                color = black,
            )

            IconButton(
                onClick = { /* ação ao clicar em deletar */ },
                modifier = Modifier.constrainAs(btDeletar) {
                    top.linkTo(txtDescricao.bottom, margin = 5.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Deletar",
                    tint = Color.Red
                )
            }
        }
    }
}

@Preview
@Composable
private fun TarefaIntemPreview() {
    TarefaIntem()
}
