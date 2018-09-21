package each.reabfacil.model

import each.reabfacil.payload.AvaliacaoPayload
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "AVALIACAO")
data class Avaliacao(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name= "ID_AVALIACAO")
        val id: Long? = null,

        @ManyToOne
        @JoinColumn(name = "ID_UNIDADE")
        val unidade: Unidade? = null,

        @Column(name= "COMENTARIO")
        val comentario: String? = null,

        @Column(name= "NOTA")
        val nota: Int? = null,

        @Column(name= "USUARIO")
        val foiUsuario: Boolean? = null
) {
        fun toPayload() : AvaliacaoPayload {
                return AvaliacaoPayload(comentario, nota!!, foiUsuario!!)
        }
}