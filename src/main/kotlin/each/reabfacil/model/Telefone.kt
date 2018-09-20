package each.reabfacil.model

import javax.persistence.Column
import javax.persistence.Table

@Table(name = "TELEFONE")
data class Telefone(
        @Column(name= "ID_TELEFONE")
        val id: Long,
        //TODO RELACIONAMENTO UNIDADE
        val unidade: Unidade,

        @Column(name= "TELEFONE")
        val numero: String
)