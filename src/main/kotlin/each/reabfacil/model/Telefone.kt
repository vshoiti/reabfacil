package each.reabfacil.model

import each.reabfacil.payload.TelefonePayload
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "TELEFONE")
data class Telefone(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name= "ID_TELEFONE")
        val id: Long? = null,

        @ManyToOne
        @JoinColumn(name = "ID_UNIDADE")
        val unidade: Unidade? = null,

        @Column(name= "TELEFONE")
        val numero: String = ""
) {
        fun toPayload() : TelefonePayload {
                return TelefonePayload(numero)
        }
}