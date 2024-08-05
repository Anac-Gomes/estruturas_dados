fun main() {
    val sistemaArquivos = SistemaArquivos()

    do {
        exibirMenu()
        val opcao = readLine()!!.toInt()
        when (opcao) {

            8 -> println("\nSistema encerrado!")

            1 -> {
                print("\nDigite o tipo (d - diretório, a - arquivo): ")
                val tipo = readLine()!!
                print("\nDigite o caminho onde será salvo (exemplo: C://users/documents): ")
                val caminho = readLine()!!
                print("\nDigite o nome: ")
                val nome = readLine()!!
                if (tipo == "d") {
                    sistemaArquivos.criarDiretorio(caminho, nome)
                } else if (tipo == "a") {
                    sistemaArquivos.criarArquivo(caminho, nome)
                } else {
                    println("\nEscolha uma opção válida!")
                }
            }
            2 -> {
                print("\nDigite o nome do item a ser removido: ")
                val nome = readLine()!!
                val removido = sistemaArquivos.remover(nome)
                if (removido) {
                    println("\n!!O item '$nome' foi removido!!")
                } else {
                    println("\nNão foi possível encontrar '$nome'")
                }
            }
            3 -> {
                print("\nDigite o nome do item que deseja localizar: ")
                val nome = readLine()!!
                val encontrado = sistemaArquivos.buscar(nome)
                if (encontrado != null) {
                    println("\nBusca: ${encontrado.detalhes()}")
                } else {
                    println("\nNão foi possível localizar '$nome'")
                }
            }
            5 -> {
                exibirMenuImprimir()
                val opcaoImprimir = readLine()!!.toInt()
                when (opcaoImprimir) {
                    1 -> println("\nEstrutura da Árvore:\n${sistemaArquivos.imprimirPreOrdem()}\n")
                    2 -> println("\nEstrutura da Árvore:\n${sistemaArquivos.imprimirEmOrdem()}\n")
                    3 -> println("\nEstrutura da Árvore:\n${sistemaArquivos.imprimirPosOrdem()}\n")
                    else -> println("\nOpção inválida.")
                }
            }
            7 -> {
                sistemaArquivos.limpar()
                println("\nÁrvore Limpa!")
            }
            4 -> {
                print("\nDigite o nome do item para imprimir o caminho completo: ")
                val nome = readLine()!!
                println("Caminho completo: ${sistemaArquivos.imprimirCaminhoCompleto(nome)}")
            }
            6 -> {
                println("\nEstrutura Completa da Árvore:\n${sistemaArquivos.imprimirArvoreCompleta()}\n")
            }
            else -> {
                println("\nOpção inválida! Tente novamente!")
            }
        }

    } while (opcao != 0)
}

fun exibirMenu() {
    println("\n-----------------------------------")
    println("     Sistema de Arquivos   ")
    println("1. Criar Diretório/Arquivo")
    println("2. Remover Diretório/Arquivo")
    println("3. Buscar Diretório/Arquivo")
    println("4. Visualizar detalhes")
    println("5. Visualizar em ordem")
    println("6. Visualizar árvore completa")
    println("7. Limpar tudo")
    println("8. SAIR")
        println("-----------------------------------")
    print("Escolha uma opção (0-8): ")
}

fun exibirMenuImprimir() {
    println("\n1. Imprimir Pre-Ordem")
    println("2. Imprimir Em-Ordem")
    println("3. Imprimir Pos-Ordem")
    print("Escolha uma opção (1-3): ")
}
