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
@Table(name = "AVALIACAO")
data class Avaliacao(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name= "ID_AVALIACAO")
        val id: Long,

        @ManyToOne
        @JoinColumn(name = "ID_UNIDADE")
        val unidade: Unidade,

        @Column(name= "COMENTARIO")
        val comentario: String?,

        @Column(name= "NOTA")
        val nota: Int,

        @Column(name= "USUARIO")
        val foiUsuario: Boolean
)