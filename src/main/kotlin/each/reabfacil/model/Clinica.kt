package each.reabfacil.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "CLINICA")
data class Clinica(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_CLINICA")
        val id: Long,

        @Column(name = "NOME")
        val nome: String,

        @Column(name = "LINK")
        val link: String,

        @OneToMany(mappedBy = "clinica")
        val unidades: List<Unidade>
)