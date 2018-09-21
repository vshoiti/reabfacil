package each.reabfacil.repository

import each.reabfacil.model.Unidade
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UnidadeRepository : CrudRepository<Unidade, Long> {
    fun findByCidade(cidade: String): List<Unidade>

    fun findByEstado(estado: String): List<Unidade>

    // Os nomes e atributos aqui sao os de CLASSE, nao as colunas
    @Query("SELECT u FROM Unidade u " +
                 "WHERE u.clinica.nome = ?1")
    fun findByClinica(nome: String): List<Unidade>
}