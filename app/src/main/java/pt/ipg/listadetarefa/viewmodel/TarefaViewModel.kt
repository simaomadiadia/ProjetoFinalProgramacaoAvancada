package pt.ipg.listadetarefa.viewmodel

// Importa componentes necessários para trabalhar com estado e arquitetura MVVM
import androidx.compose.runtime.mutableStateListOf  // Lista observável para Compose
import androidx.lifecycle.ViewModel                 // Base para o ViewModel
import pt.ipg.listadetarefa.model.Tarefa            // Classe de dados que representa uma tarefa

// Classe que gerencia os dados da interface relacionados às tarefas
class TarefaViewModel : ViewModel() {

    // Lista reativa de tarefas observável pela interface do usuário (UI)
    val listaTarefas = mutableStateListOf<Tarefa>()

    // Função para adicionar uma nova tarefa à lista
    fun adicionarTarefa(tarefa: Tarefa) {
        listaTarefas.add(tarefa)
    }

    // Função para remover uma tarefa com base no índice informado
    fun removerTarefa(index: Int) {
        // Garante que o índice seja válido antes de tentar remover
        if (index in listaTarefas.indices) {
            listaTarefas.removeAt(index)
        }
    }
}
