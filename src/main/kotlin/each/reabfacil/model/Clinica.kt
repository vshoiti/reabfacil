package each.reabfacil.model

import each.reabfacil.payload.ClinicaPayload
import javax.persistence.*

@Entity
@Table(name = "CLINICA")
data class Clinica(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_CLINICA")
        val id: Long? = null,

        @Column(name = "NOME")
        val nome: String = "",

        @Column(name = "LINK")
        val link: String = "",

        @OneToMany(mappedBy = "clinica", fetch = FetchType.LAZY)
        val unidades: List<Unidade> = listOf()
) {
        fun toPayload() : ClinicaPayload {
                return ClinicaPayload(id!!, nome, unidades.map { it.toPayload() }, link)
        }
}