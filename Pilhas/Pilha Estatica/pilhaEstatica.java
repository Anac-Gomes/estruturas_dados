public class pilhaEstatica implements Empilhavel {
    private int ponteiroTopo;
    private Object[] dados;
    private int tamanho;

    public pilhaEstatica() {
        this(10);
    }

    public pilhaEstatica(int tamanho) {
        ponteiroTopo = -1;
        this.tamanho = tamanho;
        dados = new Object[tamanho];
    }

    public void empilhar(Object elemento) {
        if (!estaCheia()) {
            ponteiroTopo++;
            dados[ponteiroTopo] = elemento;
        } else {
            System.out.println("Stack is full!");
        }
    }

        public Object desempilhar() {
            Object elementoTopo = null;
            if(!estaVazia()) {
                elementoTopo = dados[ponteiroTopo];
                ponteiroTopo--;
            } else {
                System.out.println("Stack is empty!");
            }
            return elementoTopo;
        }


        public Object topo() {
            Object elementoTopo = null;
            if(!estaVazia()) {
                elementoTopo = dados[ponteiroTopo];
                ponteiroTopo--;
            } else {
                System.out.println("Stack is empty!");
            }
            return elementoTopo;
        }


        public boolean estaCheia() {
            return (ponteiroTopo == tamanho - 1);
        }
        public boolean estaVazia() {
            return (ponteiroTopo == -1);
        }
        public String imprimir() {
            String resultado = "[";
            for (int i = 0; i<= ponteiroTopo; i++) {
                resultado += dados[i]+ " ";
            }
            return resultado + "]";
        }
    }

