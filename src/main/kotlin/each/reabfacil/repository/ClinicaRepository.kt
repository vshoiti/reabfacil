package each.reabfacil.repository

import each.reabfacil.model.Clinica
import each.reabfacil.model.Tratamento
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClinicaRepository : CrudRepository<Clinica, Long> {
}