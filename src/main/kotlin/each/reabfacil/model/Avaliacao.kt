package each.reabfacil.model

data class Avaliacao(
        val id: Long,
        // TODO relacionamento
        val unidade: Unidade,
        val comentario: String?,
        val nota: Int,
        val foiUsuario: Boolean
)