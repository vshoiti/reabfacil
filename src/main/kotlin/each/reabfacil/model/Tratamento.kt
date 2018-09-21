package each.reabfacil.model

import each.reabfacil.payload.TratamentoPayload
import javax.persistence.*


@Entity
@Table(name = "TRATAMENTO")
data class Tratamento(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_TRATAMENTO")
        val id: Long? = null,

        @Column(name = "NOME")
        val nome: String = ""
) {
        fun toPayload() : TratamentoPayload {
                return TratamentoPayload(id!!, nome)
        }
}
