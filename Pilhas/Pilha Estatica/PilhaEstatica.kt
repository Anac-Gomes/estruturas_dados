class PilhaEstatica : Empilhavel {
    private var dados: Array<Any?>
    private var ponteiroTopo: Int

    constructor(tamanho: Int) {
        dados = arrayOfNulls(tamanho)
        ponteiroTopo = -1
    }

    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            ponteiroTopo++
            dados[ponteiroTopo] = dado
        } else {
            println("ERROR! Pilha está cheia!")
        }
    }

    override fun topo(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = dados[ponteiroTopo]
        } else {
            println("Pilha está vazia!")
        }
        return dadoTopo
    }

    override fun desempilhar(): Any? {
        var dadoTopo: Any? = null
        if (!estaVazia()) {
            dadoTopo = dados[ponteiroTopo]
            ponteiroTopo--
        } else {
            println("Pilha está vazia!")
        }
        return dadoTopo
    }

    override fun estaCheia(): Boolean {
        return ponteiroTopo == dados.size - 1
    }

    override fun estaVazia(): Boolean {
        return ponteiroTopo == -1
    }

    override fun imprimir(): String {
        var resultado = "["
        for (i in ponteiroTopo downTo 0) {
            resultado += "${dados[i]}"
        }
        return "$resultado]"
    }
}
