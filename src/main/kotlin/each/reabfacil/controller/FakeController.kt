package each.reabfacil.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class FakeController {

    @GetMapping("/clinicas")
    fun listaClinicas(@RequestParam("estado") estado: String) : List<Clinica> {
        return listOf(Clinica("clinica1", "1112345678"),
                Clinica("clinica2", "1198765432"))
    }

}

data class Clinica(val nome: String, val telefone: String)

//class FakeRepository {
//    val clinicas = listOf(
//            Clinica(),
//            Clinica(),
//            Clinica(),
//            Clinica(),
//            Clinica(),
//            Clinica(),
//            Clinica(),
//            Clinica(),
//            Clinica()
//    )
//}