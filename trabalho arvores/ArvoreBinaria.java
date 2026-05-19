public class ArvoreBinaria {

    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore Binária criada com sucesso!");
    }

    public void inserir(Integer conteudo) {

        No novoNo = new No(conteudo);

        if (estaVazia()) {
            this.raiz = novoNo;
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    public void inserirRecursivo(No novoNo, No atual) {

        if (atual.getConteudo() > novoNo.getConteudo()) {

            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }

        } else if (atual.getConteudo().equals(novoNo.getConteudo())) {

            System.out.println("Não é possível informar nós repetidos.");

        } else {

            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
            }
        }
    }

    public boolean estaVazia() {

        return this.raiz.getConteudo() == null;
    }

    private void preOrdem(No no) {

        if (no == null) {
            return;
        }

        System.out.println(no.getConteudo());

        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {

        if (no == null) {
            return;
        }

        emOrdem(no.getEsquerda());

        System.out.println(no.getConteudo());

        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {

        if (no == null) {
            return;
        }

        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());

        System.out.println(no.getConteudo());
    }

    public void exibir(String percurso) {

        switch (percurso) {

            case ("Pre"):
                preOrdem(this.raiz);
                break;

            case ("Em"):
                emOrdem(this.raiz);
                break;

            case ("Pos"):
                posOrdem(this.raiz);
                break;
        }
    }

    // MÉTODO DE REMOÇÃO

    public void remover(Integer valor) {
        this.raiz = removerRecursivo(this.raiz, valor);
    }

    private No removerRecursivo(No atual, Integer valor) {

        if (atual == null) {
            return null;
        }

        if (valor < atual.getConteudo()) {

            atual.setEsquerda(
                    removerRecursivo(atual.getEsquerda(), valor)
            );

        } else if (valor > atual.getConteudo()) {

            atual.setDireita(
                    removerRecursivo(atual.getDireita(), valor)
            );

        } else {

            // CASO 1 - Nó folha
            if (atual.getEsquerda() == null &&
                atual.getDireita() == null) {

                return null;
            }

            // CASO 2 - Nó com apenas um filho
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            }

            if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            // CASO 3 - Nó com dois filhos
            No sucessor = menorValor(atual.getDireita());

            atual.setConteudo(sucessor.getConteudo());

            atual.setDireita(
                    removerRecursivo(
                            atual.getDireita(),
                            sucessor.getConteudo()
                    )
            );
        }

        return atual;
    }

    // MÉTODO SUCESSOR
    private No menorValor(No atual) {

        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }

        return atual;
    }
}