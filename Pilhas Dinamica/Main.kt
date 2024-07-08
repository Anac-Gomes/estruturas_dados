fun main() {
    var pilha: Empilhavel = PilhaDinamica(7)
    pilha.empilhar("Portal")
    pilha.empilhar("Online")
    println("Topo: ${pilha.espiar()}")
    pilha.empilhar("Serviços")
    pilha.empilhar("de")
    pilha.empilhar("Transporte")
    println("Topo: ${pilha.espiar()}")
    val conteudo = pilha.desempilhar()
    pilha.desempilhar()
    pilha.empilhar("Confira")
    pilha.empilhar("as")
    pilha.empilhar("Promoções")
    pilha.empilhar(conteudo)
    println("Pilha=${pilha.imprimir()}")
}
