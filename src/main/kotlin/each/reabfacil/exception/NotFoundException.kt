package each.reabfacil.exception

class NotFoundException(override var message:String) : RuntimeException(message) {
}