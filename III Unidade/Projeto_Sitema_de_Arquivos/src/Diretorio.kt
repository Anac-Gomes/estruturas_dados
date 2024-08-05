class Diretorio(nome: String, caminho: String) : No(nome, caminho) {
    override fun detalhes(): String {
        return "Diretório: $nome, Caminho: $caminho"
    }
}
