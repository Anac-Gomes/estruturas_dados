interface Arborizavel {
    fun getRaiz(): No?
    fun criarDiretorio(caminho: String, nome: String)
    fun criarArquivo(caminho: String, nome: String)
    fun remover(nome: String): Boolean
    fun buscar(nome: String): No?
    fun limpar()
    fun imprimirPreOrdem(): String
    fun imprimirEmOrdem(): String
    fun imprimirPosOrdem(): String
    fun imprimirCaminhoCompleto(nome: String): String
    fun imprimirArvoreCompleta(): String
}
