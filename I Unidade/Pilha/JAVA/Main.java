public class Main {
    public static void main(String args[]) {
        pilhaEstatica pilha = new pilhaEstatica(6);
        pilha.empilhar("Bianca");
        pilha.empilhar("Bittencourt");
        pilha.empilhar("Santos");
        String conteudo = (String) pilha.desempilhar();
        System.out.println("Pilha: " + pilha.imprimir());
    }
}
