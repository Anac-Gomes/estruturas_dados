

        fun main() {
            val lista = ListaDinamica()
            var opcao: Int

            do {
                exibirMenu()
                print("Escolha uma opção: ")
                opcao = readLine()?.toIntOrNull() ?: 0 // Lê a opção do usuário

                when (opcao) {
                    1 -> {
                        print("Digite o valor a ser adicionado: ")
                        val valor = readLine()
                        lista.adicionar(valor)
                    }
                    2 -> {
                        print("Digite o valor a ser removido: ")
                        val valor = readLine()
                        if (lista.remover(valor)) {
                            println("Valor removido com sucesso!")
                        } else {
                            println("Valor não encontrado.")
                        }
                    }
                    3 -> {
                        print("Digite o valor a ser buscado: ")
                        val valor = readLine()
                        val noEncontrado = lista.buscar(valor)
                        if (noEncontrado != null) {
                            println("Valor encontrado: ${noEncontrado.dado}")
                        } else {
                            println("Valor não encontrado.")
                        }
                    }
                    4 -> println("Lista: ${lista.imprimir()}")
                    0 -> println("Encerrando...")
                    else -> println("Opção inválida!")
                }

            } while (opcao != 0)
        }

        fun exibirMenu() {
            println("###### MENU ######")
            println("1. Adicionar valor")
            println("2. Remover valor")
            println("3. Buscar valor")
            println("4. Imprimir lista")
            println("0. Sair")
        }