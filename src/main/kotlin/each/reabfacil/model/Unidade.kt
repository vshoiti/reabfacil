package each.reabfacil.model

data class Unidade(
        val id: Long,
        //TODO RELACIONAMENTO CLINICA
        val clinica: Clinica,
        val rua: String,
        val nome: String,
        val genero: Genero,
        val cnpj: String,
        val cep: String,
        val uf: String,
        val cidade: String
)

enum class Genero(val genero: String) {
    HOMEM("H"),
    MULHER("M"),
    AMBOS("AMBOS")
}