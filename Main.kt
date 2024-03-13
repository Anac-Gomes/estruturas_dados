//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var pilha: Empilhavel = PilhaEstatica(6)

    pilha.empilhar(" Dois")
    pilha.empilhar("pratos")
    println("Topo: ${pilha.topo()}")

    pilha.empilhar("de ")
    pilha.empilhar("trigo ")
    pilha.empilhar("para ")
    pilha.empilhar("dois ")

    println("Topo: ${pilha.topo()}")

    val conteudo = pilha.desempilhar()

    pilha.desempilhar()
    pilha.empilhar("tigres ")
    pilha.empilhar("tristes ")
    pilha.empilhar(":( ")
    pilha.empilhar(pilha.desempilhar())
    pilha.empilhar(conteudo)

    print("Pilha = ${pilha.imprimir()}")
}