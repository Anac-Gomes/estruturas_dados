class ListaDinamica : Listavel {

    private var cabeca: No? = null

    override fun adicionar(dado: Any?) {
        val novoNo = No(dado)
        if (cabeca == null) {
            cabeca = novoNo
        } else {
            var atual = cabeca
            while (atual?.proximo != null) {
                atual = atual.proximo
            }
            atual?.proximo = novoNo
        }
    }

    override fun remover(dado: Any?): Boolean {
        if (cabeca == null) return false

        if (cabeca?.dado == dado) {
            cabeca = cabeca?.proximo
            return true
        }

        var atual = cabeca
        while (atual?.proximo != null) {
            if (atual.proximo?.dado == dado) {
                atual.proximo = atual.proximo?.proximo
                return true
            }
            atual = atual.proximo
        }
        return false
    }

    override fun buscar(dado: Any?): No? {
        var atual = cabeca
        while (atual != null) {
            if (atual.dado == dado) return atual
            atual = atual.proximo
        }
        return null
    }

    override fun imprimir(): String {
        var atual = cabeca
        val resultado = StringBuilder("[")
        while (atual != null) {
            resultado.append("${atual.dado}")
            if (atual.proximo != null) resultado.append(", ")
            atual = atual.proximo
        }
        resultado.append("]")
        return resultado.toString()
    }
}