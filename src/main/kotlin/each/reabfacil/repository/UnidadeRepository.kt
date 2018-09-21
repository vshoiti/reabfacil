package each.reabfacil.repository

import each.reabfacil.DAO.Clinica
import each.reabfacil.DAO.Unidade
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

@org.springframework.stereotype.Repository
interface UnidadeRepository : CrudRepository<Unidade, Long> {
    fun findByCidade(cidade: String): List<Unidade>

    fun findByEstado(estado: String): List<Unidade>

    // Os nomes e atributos aqui sao os de CLASSE, nao as colunas
    @Query("SELECT u FROM Unidade u " +
                 "WHERE u.clinica.nome = ?1")
    fun findByClinica(nome: String): List<Unidade>
}