package each.reabfacil.controller

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
            @RequestParam(value = "tratamento", required = false) tratamento: String?,
            @RequestParam(value = "genero", required = false) genero: String?
    ): List<UnidadePayload> {

        return service.searchBy(cidade, estado, tratamento, genero)
    }

    @GetMapping("/unidade/{id}")
    fun pegaPorId(@PathVariable("id") id: Long) : UnidadePayload {
        return service.findById(id)
    }
}