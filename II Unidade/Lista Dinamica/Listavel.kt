interface Listavel {
    fun adicionar(dado: Any?)
    fun remover(dado: Any?): Boolean
    fun buscar(dado: Any?): No?
    fun imprimir(): String
}

class No(var dado: Any?) {
    var proximo: No? = null
}
