package each.reabfacil.controller

import each.reabfacil.payload.TratamentoPayload
import each.reabfacil.repository.TratamentoRepository
import each.reabfacil.repository.UnidadeRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class TratamentoController(val repository: TratamentoRepository) {

    @GetMapping("/tratamento")
    fun listaTodos(): List<TratamentoPayload> {
        return repository.findAll().map { it.toPayload() }
    }
}