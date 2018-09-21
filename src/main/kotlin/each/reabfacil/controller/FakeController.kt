package each.reabfacil.controller

import each.reabfacil.payload.UnidadePayload
import each.reabfacil.repository.UnidadeRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class FakeController(val repository: UnidadeRepository) {

    @GetMapping("/clinicas")
    fun listaClinicas(@RequestParam("estado") estado: String): List<FakeClinica> {
        return listOf(FakeClinica("clinica1", "1112345678"),
                FakeClinica("clinica2", "1198765432"))
    }

    @GetMapping("/unidade")
    fun listaUnidades(
            @RequestParam(value = "estado", required = false) estado: String?,
            @RequestParam(value = "cidade", required = false) cidade: String?,
            @RequestParam(value = "atendimento", required = false) dependencia: String?
    ): List<UnidadePayload> {

        val all = repository.findAll().toList()
        var result = all.map { it.toPayload() }

        println(all.size)

        if(!estado.isNullOrBlank()) {
            result = result.filter { it.estado == estado }
        }
        if(!cidade.isNullOrBlank()) {
            result = result.filter { it.cidade == cidade }
        }
        if(!dependencia.isNullOrBlank()) {
            result = result.filter { it.tiposDeTratamentos.any { it.nome == dependencia } }
        }
        println(result.size)
        return result
    }

}

data class FakeClinica(
        val nome: String,
        val telefone: String
)