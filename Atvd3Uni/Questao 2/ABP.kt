package q2

class ABP: Arborizavel {

    private var raiz: NoTriplo? = null

    override fun getRaiz(): NoTriplo? {
        return raiz
    }

    override fun limpar() {
        raiz = null
    }

    override fun inserir(dado: Any?) {
        val novoNo = NoTriplo(dado)
        if (raiz == null) {
            raiz = novoNo
        } else {
            var noAuxiliar = raiz
            while (noAuxiliar != null) {
                if ((noAuxiliar.dado as Int) > (dado as Int)) {
                    if (noAuxiliar.esquerda != null) {
                        noAuxiliar = noAuxiliar.esquerda
                    } else {
                        noAuxiliar.esquerda = novoNo
                        novoNo.genitor = noAuxiliar
                        break
                    }
                } else {
                    if (noAuxiliar.direita != null) {
                        noAuxiliar = noAuxiliar.direita
                    } else {
                        noAuxiliar.direita = novoNo
                        novoNo.genitor = noAuxiliar
                        break
                    }
                }
            }
        }
    }

    override fun apagar(dado: Any?): Boolean {
        val noParaRemover = buscar(dado ?: return false)
        return if (noParaRemover != null) {
            removerNo(noParaRemover)
            true
        } else {
            false
        }
    }

    private fun removerNo(no: NoTriplo) {
        if (no.esquerda == null && no.direita == null) {
            substituirNo(no, null)
        } else if (no.esquerda != null && no.direita != null) {
            val sucessor = encontrarMinimo(no.direita!!)
            no.dado = sucessor.dado
            removerNo(sucessor)
        } else {
            val filho = if (no.esquerda != null) no.esquerda else no.direita
            substituirNo(no, filho)
        }
    }

    private fun substituirNo(noAntigo: NoTriplo, noNovo: NoTriplo?) {
        if (noAntigo == raiz) {
            raiz = noNovo
        } else {
            val pai = noAntigo.genitor
            if (pai?.esquerda == noAntigo) {
                pai.esquerda = noNovo
            } else {
                pai?.direita = noNovo
            }
        }
        noNovo?.genitor = noAntigo.genitor
    }

    private fun encontrarMinimo(no: NoTriplo): NoTriplo {
        var atual = no
        while (atual.esquerda != null) {
            atual = atual.esquerda!!
        }
        return atual
    }

    override fun buscar(dado: Any): NoTriplo? {
        var noAtual = raiz
        while (noAtual != null) {
            if (noAtual.dado == dado) {
                return noAtual
            }
            noAtual = if ((noAtual.dado as Int) > (dado as Int)) noAtual.esquerda else noAtual.direita
        }
        return null
    }

    override fun existe(dado: Any?): Boolean {
        return buscar(dado ?: return false) != null
    }

    override fun imprimirPreOrdem(): String {
        return formataSaida(imprimirPreOrdemRec(raiz))
    }

    override fun imprimirEmOrdem(): String {
        return formataSaida(imprimirEmOrdemRec(raiz))
    }

    override fun imprimirPosOrdem(): String {
        return formataSaida(imprimirPosOrdemRec(raiz))
    }

    private fun imprimirPreOrdemRec(raiz: NoTriplo?): String {
        var resultado = ""
        if (raiz != null)
            resultado = "${raiz.dado} ${imprimirPreOrdemRec(raiz.esquerda)} ${imprimirPreOrdemRec(raiz.direita)}"
        return resultado
    }

    private fun imprimirEmOrdemRec(raiz: NoTriplo?): String {
        var resultado = ""
        if (raiz != null)
            resultado = "${imprimirEmOrdemRec(raiz.esquerda)} ${raiz.dado} ${imprimirEmOrdemRec(raiz.direita)}"
        return resultado
    }

    private fun imprimirPosOrdemRec(raiz: NoTriplo?): String {
        var resultado = ""
        if (raiz != null)
            resultado = "${imprimirPosOrdemRec(raiz.esquerda)} ${imprimirPosOrdemRec(raiz.direita)} ${raiz.dado}"
        return resultado
    }

    private fun formataSaida(msg: String): String {
        var resultado: String
        var mensagem = msg
        do {
            resultado = mensagem
            mensagem = mensagem.replace("  ", " ")
        } while (mensagem != resultado)
        mensagem = mensagem.trim()
        mensagem = mensagem.replace(" ", ",")
        return "[$mensagem]"
    }
}
