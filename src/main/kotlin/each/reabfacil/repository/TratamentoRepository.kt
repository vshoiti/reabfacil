package each.reabfacil.repository

import each.reabfacil.model.Tratamento
import each.reabfacil.model.Unidade
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TratamentoRepository : CrudRepository<Tratamento, Long> {
}