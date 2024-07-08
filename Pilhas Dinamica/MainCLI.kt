fun main() {
    var pilha: Empilhavel = PilhaDinamica(10)
    var opcao: Int? // Declare a variável opcao fora do loop
    do {
        exibirMenuCLI()
        print("Escolha uma opção (0-5): ")
        opcao = readLine()?.toIntOrNull()

        when(opcao) {
            0 -> {
                print("Encerrando o sistema de serviços. ")
                println("Até mais!")
            }
            1 -> {
                print("Digite o serviço para adicionar ao carrinho: ")
                val produto = readLine()
                pilha.empilhar(produto)
            }
            2 -> {
                print("Deseja remover o serviço do estoque [s/n]? ")
                val confirmacao = readLine()
                if (confirmacao == "s" || confirmacao == "S")
                    pilha.desempilhar()
            }
            3 -> println("Serviço no topo do estoque: ${pilha.espiar()}")
            4 -> {
                print("Digite o serviço topo: ")
                val novoProduto = readLine()
                pilha.atualizar(novoProduto)
            }
            5 -> println("Serviço no estoque: ${pilha.imprimir()}")
            else -> {
                print("Opção inválida. ")
                println("Tente novamente.")
            }
        }
    } while (opcao != 0)
}

fun exibirMenuCLI() {
    println("Bem-Vindo a Transportadora Venx! Escolha o serviço de acordo com o número abaixo:")
    println("0. SAIR")
    println("1. Adicionar produto ao estoque")
    println("2. Remover produto do estoque")
    println("3. Ver produto no topo")
    println("4. Atualizar produto no topo")
    println("5. Exibir todos os produtos no estoque")
}
