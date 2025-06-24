package pt.ipg.listadetarefa.viewmodel

// TarefaViewModel.kt

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import pt.ipg.listadetarefa.model.Tarefa

class TarefaViewModel : ViewModel() {
    val listaTarefas = mutableStateListOf<Tarefa>()

    fun adicionarTarefa(tarefa: Tarefa) {
        listaTarefas.add(tarefa)
    }

    fun removerTarefa(index: Int) {
        if (index in listaTarefas.indices) {
            listaTarefas.removeAt(index)
        }
    }
}
