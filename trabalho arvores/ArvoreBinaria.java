public class ArvoreBinaria {

    public Node remover(Node node, int valor) {

        if (node == null) {
            return null;
        }

        if (valor < node.valor) {
            node.esquerda = remover(node.esquerda, valor);
        }

        else if (valor > node.valor) {
            node.direita = remover(node.direita, valor);
        }

        else {

            // Nó folha
            if (node.esquerda == null && node.direita == null) {
                return null;
            }

            // Nó com apenas um filho
            if (node.esquerda == null) {
                return node.direita;
            }

            if (node.direita == null) {
                return node.esquerda;
            }

            // Nó com dois filhos
            Node sucessor = menorValor(node.direita);

            node.valor = sucessor.valor;

            node.direita = remover(node.direita, sucessor.valor);
        }

        return node;
    }

    private Node menorValor(Node node) {

        while (node.esquerda != null) {
            node = node.esquerda;
        }

        return node;
    }
}