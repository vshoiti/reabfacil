package each.reabfacil

import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.hibernate.jpa.AvailableSettings.JDBC_URL



@SpringBootApplication
class ReabfacilApplication

fun main(args: Array<String>) {
    val flyway = Flyway()
    flyway.setDataSource("jdbc:h2:mem:reabfacil", "sa", "")
    flyway.migrate()
    runApplication<ReabfacilApplication>(*args)
}
