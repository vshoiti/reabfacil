package each.reabfacil.model

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
        val id: Long,

        @ManyToOne
        @JoinColumn(name = "ID_UNIDADE")
        val unidade: Unidade,

        @Column(name= "TELEFONE")
        val numero: String
)