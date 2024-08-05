class Arquivo(nome: String, caminho: String) : No(nome, caminho) {
    override fun detalhes(): String {
        return "Arquivo: $nome, Caminho: $caminho"
    }
}
