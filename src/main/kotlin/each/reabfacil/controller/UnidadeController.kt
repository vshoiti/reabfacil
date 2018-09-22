package each.reabfacil.controller

import each.reabfacil.model.Unidade
import each.reabfacil.payload.UnidadePayload
import each.reabfacil.service.UnidadeService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UnidadeController(val service: UnidadeService) {

    @GetMapping("/unidade")
    fun listaUnidades(
            @RequestParam(value = "estado", required = false) estado: String?,
            @RequestParam(value = "cidade", required = false) cidade: String?,
            @RequestParam(value = "atendimento", required = false) atendimento: String?,
            @RequestParam(value = "genero", required = false) genero: String?
    ): List<UnidadePayload> {

        return service.searchBy(cidade, estado, atendimento, genero)
    }

    @GetMapping("/unidade/{id}")
    fun pegaPorId(@PathVariable("id") id: Long) : UnidadePayload {
        return service.findById(id)
    }
}