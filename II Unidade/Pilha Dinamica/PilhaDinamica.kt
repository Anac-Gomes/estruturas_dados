class PilhaDinamica(private val tamanho: Int = 10) : Empilhavel {

    private var ponteiroTopo: NoDuplo? = null
    private var quantidade = 0

    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            val noTemp = NoDuplo(dado)
            noTemp.anterior = ponteiroTopo
            if (!estaVazia())
                ponteiroTopo?.proximo = noTemp

            ponteiroTopo = noTemp
            quantidade++
        } else {
            println("Pilha Cheia!")
        }
    }

    override fun desempilhar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior
            quantidade--
            if (!estaVazia())
                ponteiroTopo?.proximo = null

        } else {
            println("Pilha Vazia!")
        }

        return dadoTopo
    }

    override fun espiar(): Any? {
        return if (!estaVazia()) {
            ponteiroTopo?.dado
        } else {
            println("Pilha Vazia!")
            null
        }
    }

    override fun atualizar(dado: Any?) {
        if (!estaVazia()) {
            ponteiroTopo?.dado = dado
        } else {
            println("Pilha Vazia!")
        }
    }

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }

    override fun estaVazia(): Boolean {
        return quantidade == 0
    }

    override fun imprimir(): String {
        var ponteiroAuxiliar = ponteiroTopo
        val resultado = StringBuilder("[")
        for (i in 0 until quantidade) {
            resultado.append(ponteiroAuxiliar?.dado)
            if (i != quantidade - 1) {
                resultado.append(", ")
            }
            ponteiroAuxiliar = ponteiroAuxiliar?.anterior
        }
        resultado.append("]")
        return resultado.toString()
    }
}

fun main() {
    val pilha: Empilhavel = PilhaDinamica(7)
    var opcao: Int?
    do {
        exibirMenu()
        print("Digite o numero da opção: ")
        opcao = readLine()?.toIntOrNull()

        when (opcao) {
            0 -> {
                print("Encerrando o sistema de serviços. ")
                println("Volte sempre!")
            }
            1 -> {
                print("Digite o serviço para adicionar ao estoque: ")
                val produto = readLine()
                pilha.empilhar(produto)
            }
            2 -> {
                print("Deseja remover o serviço do estoque [s/n]? ")
                val confirmacao = readLine()
                if (confirmacao.equals("s", ignoreCase = true)) {
                    pilha.desempilhar()
                }
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

fun exibirMenu() {
    println("***** SERVIÇOS *****")
    println("0. Encerrar")
    println("1. Adicionar serviço ao carrinho")
    println("2. Remover seviço do carrinho")
    println("3. Ver serviço no topo")
    println("4. Atualizar serviço no topo")
    println("5. Exibir todos os seviços do carrinho")
}
