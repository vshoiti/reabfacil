package each.reabfacil.model

data class Telefone(
        val id: Long,
        //TODO RELACIONAMENTO UNIDADE
        val unidade: Unidade,
        val numero: String
)