package pt.ipg.listadetarefa.model

// Declaração de uma data class chamada Tarefa
data class Tarefa (
    val tarefa: String? = null,     // Nome ou título da tarefa (opcional)
    val descricao: String? = null,  // Descrição detalhada da tarefa (opcional)
    val data: String? = null        // Data associada à tarefa, no formato String (opcional)
)
