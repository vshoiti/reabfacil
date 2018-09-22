package each.reabfacil.payload

data class UnidadePayload(
        val id: Long,
        val idClinica: Long,
        val nome: String,

        val tratamentos: List<TratamentoPayload>,

        val telefones: List<TelefonePayload>,

        val cnpj: String,

        val avaliacoes: List<AvaliacaoPayload>,

        val endereco: String,
        val estado: String,
        val cidade: String,
        val genero: Genero

)

enum class Genero(val genero: String) {
    HOMEM("M"),
    MULHER("F"),
    AMBOS("MF"),
    NAO_INFORMADO("");

    companion object {
        fun fromCode(code: String): Genero {
            return when (code) {
                "M" -> HOMEM
                "F" -> MULHER
                "MF" -> AMBOS
                else -> NAO_INFORMADO
            }
        }
    }
}

data class TratamentoPayload(
        val id: Long,
        val nome: String
)

data class TelefonePayload(
        val numero: String
)

data class ClinicaPayload(
        val id: Long,
        val nome: String,
        val unidades: List<UnidadePayload>,
        val link: String
)

data class AvaliacaoPayload(
        val id: Long,
        val comentario: String?,

        val nota: Int,

        val foiUsuario: Boolean
)