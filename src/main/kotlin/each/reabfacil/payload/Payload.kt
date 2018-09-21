package each.reabfacil.payload

data class UnidadePayload(
        val nome: String,

        val tiposDeTratamentos: List<TratamentoPayload>,

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
    AMBOS("MF");

    companion object {
        fun fromCode(code: String): Genero {
            return when (code) {
                "M" -> HOMEM
                "F" -> MULHER
                "MF" -> AMBOS
                else -> throw RuntimeException("No genre found for code $code")
            }
        }
    }
}

data class TratamentoPayload(
        val nome: String
)

data class TelefonePayload(
        val numero: String
)

data class ClinicaPayload(
        val nome: String,
        val unidades: List<UnidadePayload>,
        val link: String
)

data class AvaliacaoPayload(
        val comentario: String?,

        val nota: Int,

        val foiUsuario: Boolean
)