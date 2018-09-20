package each.reabfacil.model

import javax.persistence.Column
import javax.persistence.Table

@Table(name = "UNIDADE")
data class Unidade(
        @Column(name= "ID_UNIDADE")
        val id: Long,

        //TODO RELACIONAMENTO CLINICA
        val clinica: Clinica,

        @Column(name= "ENDERECO")
        val endereco: String,

        @Column(name= "NOME")
        val nome: String,

        @Column(name= "GENERO")
        val genero: Genero,

        @Column(name= "CNPJ")
        val cnpj: String,

        @Column(name= "CEP")
        val cep: String,

        @Column(name= "ESTADO")
        val estado: String,

        @Column(name= "CIDADE")
        val cidade: String
)

enum class Genero(val genero: String) {
    HOMEM("H"),
    MULHER("M"),
    AMBOS("AMBOS")
}