package each.reabfacil.model

import javax.persistence.Column
import javax.persistence.Table

@Table(name = "AVALIACAO")
data class Avaliacao(
        @Column(name= "ID_AVALIACAO")
        val id: Long,

        // TODO relacionamento
        val unidade: Unidade,

        @Column(name= "COMENTARIO")
        val comentario: String?,

        @Column(name= "NOTA")
        val nota: Int,

        @Column(name= "USUARIO")
        val foiUsuario: Boolean
)