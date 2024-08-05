/* Questão 1: Qual o resultado da impressão desses dados em Pós-Ordem após serem inseridos em uma Árvore Binária de Pesquisa?
DADOS: [11, 70, 18, 00, 70, 66, 32, 24, 44, 87]
RESPOSTA: [0 24 44 32 66 18 87 70 11 ]*/
package q1

fun main() {
    val dados = listOf(11, 70, 18, 0, 70, 66, 32, 24, 44, 87)

    val arvore: ArvoreBinaria = ArvoreBinariaPesquisa()

    for (valor in dados) {
        arvore.inserir(valor)
    }

    println("Impressão Pós-Ordem:")
    arvore.imprimirPosOrdem()
}
