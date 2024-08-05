package q2

fun main() {
    val dados = listOf(30, 38, 50, 26, 11, 10, 25, 46, 74, 9)


    val arvore: Arborizavel = ABP()

    dados.forEach { arvore.inserir(it) }

    println("Pós-Ordem: ${arvore.imprimirPosOrdem()}")

    val posOrdem = arvore.imprimirPosOrdem().removePrefix("[").removeSuffix("]").split(",").map { it.toInt() }
    val quartoElemento = posOrdem[3]
    val setimoElemento = posOrdem[6]

    arvore.apagar(quartoElemento)
    arvore.apagar(setimoElemento)

    println("Pré-Ordem após remoções: ${arvore.imprimirPreOrdem()}")

    val preOrdem = arvore.imprimirPreOrdem().removePrefix("[").removeSuffix("]").split(",").map { it.toInt() }
    println("5º elemento em Pré-Ordem: ${preOrdem[4]}")
}
