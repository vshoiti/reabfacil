package each.reabfacil.DAO

import each.reabfacil.payload.UnidadePayload
import javax.persistence.*

@Entity
@Table(name = "UNIDADE")
data class Unidade(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_UNIDADE")
        val id: Long? = null,

        @ManyToOne
        @JoinColumn(name = "ID_CLINICA")
        val clinica: Clinica? = null,

        @OneToMany(mappedBy = "unidade", fetch = FetchType.LAZY)
        val telefones: List<Telefone> = listOf(),

        @OneToMany(mappedBy = "unidade", fetch = FetchType.LAZY)
        val avaliacoes: List<Avaliacao> = listOf(),

        @Column(name = "ENDERECO")
        val endereco: String = "",

        @Column(name = "NOME")
        val nome: String = "",

        @Column(name = "GENERO")
        val genero: String = "",

        @Column(name = "CNPJ")
        val cnpj: String = "",

        @Column(name = "CEP")
        val cep: String = "",

        @Column(name = "ESTADO")
        val estado: String = "",

        @Column(name = "CIDADE")
        val cidade: String = "",

        @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        @JoinTable(
                name = "UNIxTRATAMENTO",
                joinColumns = [JoinColumn(name = "ID_UNIDADE")],
                inverseJoinColumns = [JoinColumn(name = "ID_TRATAMENTO")]
        )
        val tiposDeTratamentos: Set<Tratamento> = setOf()
) {
    fun toPayload(): UnidadePayload {
        return UnidadePayload(nome,
                tiposDeTratamentos.map { it.toPayload() },
                telefones.map { it.toPayload() },
                cnpj,
                avaliacoes.map { it.toPayload() },
                endereco,
                estado,
                cidade,
                genero)
    }
}