package each.reabfacil.model

import javax.persistence.Column
import javax.persistence.Table

@Table(name = "CLINICA")
data class Clinica(
        @Column(name= "ID_CLINICA")
        val id: Long,

        @Column(name= "NOME")
        val nome: String,

        @Column(name= "LINK")
        val link: String
)