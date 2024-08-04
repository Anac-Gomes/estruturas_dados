package q1

interface ArvoreBinaria {
    fun inserir(valor: Int)
    fun imprimirPosOrdem()
}

class ArvoreBinariaPesquisa : ArvoreBinaria {
    private var raiz: BinPosordem? = null

    override fun inserir(valor: Int) {
        raiz = inserirRecursivo(raiz, valor)
    }

    private fun inserirRecursivo(no: BinPosordem?, valor: Int): BinPosordem {
        if (no == null) {
            return BinPosordem(valor)
        }
        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor)
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor)
        }
        return no
    }

    override fun imprimirPosOrdem() {
        imprimirPosOrdemRecursivo(raiz)
        println()
    }

    private fun imprimirPosOrdemRecursivo(no: BinPosordem?) {
        if (no != null) {
            imprimirPosOrdemRecursivo(no.esquerda)
            imprimirPosOrdemRecursivo(no.direita)
            print("${no.valor} ")
        }
    }
}
