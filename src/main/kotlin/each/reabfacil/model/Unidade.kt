package each.reabfacil.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "UNIDADE")
data class Unidade(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_UNIDADE")
        val id: Long,

        @ManyToOne
        @JoinColumn(name = "ID_CLINICA")
        val clinica: Clinica,

        @OneToMany(mappedBy = "unidade")
        val telefones: List<Telefone>,

        @OneToMany(mappedBy = "unidade")
        val avaliacoes: List<Avaliacao>,

        @Column(name = "ENDERECO")
        val endereco: String,

        @Column(name = "NOME")
        val nome: String,

        @Column(name = "GENERO")
        val genero: Genero,

        @Column(name = "CNPJ")
        val cnpj: String,

        @Column(name = "CEP")
        val cep: String,

        @Column(name = "ESTADO")
        val estado: String,

        @Column(name = "CIDADE")
        val cidade: String
)

enum class Genero(val genero: String) {
    HOMEM("H"),
    MULHER("M"),
    AMBOS("AMBOS")
}