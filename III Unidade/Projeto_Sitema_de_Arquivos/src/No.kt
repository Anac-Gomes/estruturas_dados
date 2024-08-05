open class No(val nome: String, val caminho: String) {
    var genitor: No? = null
    var esquerda: No? = null
    var direita: No? = null

    open fun detalhes(): String {
        return "Nome: $nome, Caminho: $caminho"
    }
}
