package each.reabfacil.service

import each.reabfacil.exception.NotFoundException
import each.reabfacil.model.Unidade
import each.reabfacil.payload.Genero
import each.reabfacil.payload.UnidadePayload
import each.reabfacil.repository.UnidadeRepository
import org.springframework.stereotype.Service

@Service
class UnidadeService(val repository: UnidadeRepository) {
    fun searchBy(cidade: String?, estado: String?, atendimento: String?, genero: String?) : List<UnidadePayload> {
        val all = repository.findAll().toList()
        var result = all.map { it.toPayload() }

        println(all.size)

        if(!estado.isNullOrBlank()) {
            result = result.filter { it.estado == estado }
        }
        if(!cidade.isNullOrBlank()) {
            result = result.filter { it.cidade == cidade }
        }
        if(!atendimento.isNullOrBlank()) {
            result = result.filter { it.tiposDeTratamentos.any { it.nome == atendimento } }
        }
        if(!genero.isNullOrBlank()) {
            result = result.filter { it.genero == Genero.fromCode(genero!!) }
        }
        println(result.size)
        return result
    }

    fun findById(id: Long): UnidadePayload {
        return repository.findById(id)
                .orElseThrow { NotFoundException("Unidade de ID $id não encontrada") }
                .toPayload()
    }

}