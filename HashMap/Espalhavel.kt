interface Espalhavel {
    fun adicionar(mapa: Mapa)
    fun remover(chave: Any): Any?
    fun buscar(chave: Any): Any?
    fun estaVazia(): Any


    fun imprimir(): String
    fun tamanho(): Int
    fun contemChave(chave: Any): Boolean
}

