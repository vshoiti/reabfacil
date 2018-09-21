package each.reabfacil.controller

import each.reabfacil.payload.ClinicaPayload
import each.reabfacil.payload.TratamentoPayload
import each.reabfacil.repository.ClinicaRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ClinicaController(val repository: ClinicaRepository) {

    @GetMapping("/clinica")
    fun listaTodos(): List<ClinicaPayload> {
        return repository.findAll().map { it.toPayload() }
    }
}