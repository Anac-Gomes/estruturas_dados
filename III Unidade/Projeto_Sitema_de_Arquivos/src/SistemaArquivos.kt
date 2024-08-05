class SistemaArquivos : Arborizavel {

    private var raiz: No? = null

    override fun getRaiz(): No? {
        return raiz
    }

    override fun criarDiretorio(caminho: String, nome: String) {
        val novoDiretorio = Diretorio(nome, "$caminho/$nome")
        inserir(novoDiretorio)
    }

    override fun criarArquivo(caminho: String, nome: String) {
        val novoArquivo = Arquivo(nome, "$caminho/$nome")
        inserir(novoArquivo)
    }

    private fun inserir(no: No) {
        if (raiz == null) {
            raiz = no
        } else {
            var noAuxiliar = raiz
            while (noAuxiliar != null) {
                if (no.nome > noAuxiliar.nome) {
                    if (noAuxiliar.direita != null) {
                        noAuxiliar = noAuxiliar.direita
                    } else {
                        noAuxiliar.direita = no
                        no.genitor = noAuxiliar
                        break
                    }
                } else {
                    if (noAuxiliar.esquerda != null) {
                        noAuxiliar = noAuxiliar.esquerda
                    } else {
                        noAuxiliar.esquerda = no
                        no.genitor = noAuxiliar
                        break
                    }
                }
            }
        }
    }

    override fun remover(nome: String): Boolean {
        var noAtual = buscar(nome) ?: return false

        fun substituirNo(noAntigo: No, noNovo: No?) {
            if (noAntigo.genitor == null) {
                raiz = noNovo
            } else if (noAntigo == noAntigo.genitor?.esquerda) {
                noAntigo.genitor?.esquerda = noNovo
            } else {
                noAntigo.genitor?.direita = noNovo
            }
            if (noNovo != null) {
                noNovo.genitor = noAntigo.genitor
            }
        }

        when {
            noAtual.esquerda == null && noAtual.direita == null -> {
                substituirNo(noAtual, null)
            }
            noAtual.esquerda == null -> {
                substituirNo(noAtual, noAtual.direita)
            }
            noAtual.direita == null -> {
                substituirNo(noAtual, noAtual.esquerda)
            }
            else -> {
                val noSucessor = noSucessor(noAtual)
                if (noSucessor != noAtual.direita) {
                    substituirNo(noSucessor, noSucessor.direita)
                    noSucessor.direita = noAtual.direita
                    noSucessor.direita?.genitor = noSucessor
                }
                substituirNo(noAtual, noSucessor)
                noSucessor.esquerda = noAtual.esquerda
                noSucessor.esquerda?.genitor = noSucessor
            }
        }
        return true
    }

    private fun noSucessor(no: No): No {
        var noSucessor = no.direita!!
        while (noSucessor.esquerda != null) {
            noSucessor = noSucessor.esquerda!!
        }
        return noSucessor
    }

    override fun buscar(nome: String): No? {
        var noAuxiliar = raiz
        while (noAuxiliar != null) {
            when {
                nome < noAuxiliar.nome -> noAuxiliar = noAuxiliar.esquerda
                nome > noAuxiliar.nome -> noAuxiliar = noAuxiliar.direita
                else -> return noAuxiliar
            }
        }
        return null
    }

    override fun limpar() {
        raiz = null
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

    private fun imprimirPreOrdemRec(no: No?): String {
        var resultado = ""
        if (no != null) {
            resultado = "${no.nome} ${imprimirPreOrdemRec(no.esquerda)} ${imprimirPreOrdemRec(no.direita)}"
        }
        return resultado
    }

    private fun imprimirEmOrdemRec(no: No?): String {
        var resultado = ""
        if (no != null) {
            resultado = "${imprimirEmOrdemRec(no.esquerda)} ${no.nome} ${imprimirEmOrdemRec(no.direita)}"
        }
        return resultado
    }

    private fun imprimirPosOrdemRec(no: No?): String {
        var resultado = ""
        if (no != null) {
            resultado = "${imprimirPosOrdemRec(no.esquerda)} ${imprimirPosOrdemRec(no.direita)} ${no.nome}"
        }
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

    override fun imprimirCaminhoCompleto(nome: String): String {
        val no = buscar(nome) ?: return "Não encontrado"
        return no.caminho
    }

    override fun imprimirArvoreCompleta(): String {
        return imprimirArvoreCompletaRec(raiz, "")
    }

    private fun imprimirArvoreCompletaRec(no: No?, prefixo: String): String {
        if (no == null) return ""
        val resultado = StringBuilder()
        resultado.append("${prefixo}${no.detalhes()}\n")
        val novoPrefixo = "$prefixo    "
        resultado.append(imprimirArvoreCompletaRec(no.esquerda, novoPrefixo))
        resultado.append(imprimirArvoreCompletaRec(no.direita, novoPrefixo))
        return resultado.toString()
    }
}
