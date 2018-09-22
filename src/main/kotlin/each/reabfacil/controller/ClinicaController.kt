package each.reabfacil.controller

import each.reabfacil.payload.ClinicaPayload
import each.reabfacil.payload.TratamentoPayload
import each.reabfacil.repository.ClinicaRepository
import each.reabfacil.service.ClinicaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ClinicaController(val service: ClinicaService) {

    @GetMapping("/clinica")
    fun listaTodos(): List<ClinicaPayload> {
        return service.findAll()
    }

    @GetMapping("/clinica/{id}")
    fun listaPorId(@PathVariable("id") id: Long): ClinicaPayload {
        return service.findById(id)
    }
}