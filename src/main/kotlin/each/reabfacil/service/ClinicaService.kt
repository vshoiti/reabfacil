package each.reabfacil.service

import each.reabfacil.exception.NotFoundException
import each.reabfacil.model.Unidade
import each.reabfacil.payload.ClinicaPayload
import each.reabfacil.payload.Genero
import each.reabfacil.payload.UnidadePayload
import each.reabfacil.repository.ClinicaRepository
import each.reabfacil.repository.UnidadeRepository
import org.springframework.stereotype.Service

@Service
class ClinicaService(val repository: ClinicaRepository) {
    fun findById(id: Long): ClinicaPayload {
        return repository.findById(id)
                .orElseThrow { NotFoundException("Clinica de ID $id não encontrada") }
                .toPayload()
    }

    fun findAll() : List<ClinicaPayload> {
        return repository.findAll().map { it.toPayload() }
    }

}