package each.reabfacil.service

import each.reabfacil.payload.UnidadePayload
import each.reabfacil.repository.UnidadeRepository

class UnidadeService(val repository: UnidadeRepository) {
    fun searchBy(cidade: String?, estado: String?, atendimento: String?) : List<UnidadePayload> {
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
        println(result.size)
        return result
    }

}
}