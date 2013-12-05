package com.senac.Listas;

public class Lista {
        private Nodo primeira;
        private Nodo ultima;
        private int totalDeElementos;
        private String NomeCelula;

        public void adicionaNoComeco(Object elemento) {

                Nodo nova = new Nodo(this.primeira, elemento);
                this.primeira = nova;

                if (this.totalDeElementos == 0) {

                        this.ultima = this.primeira;
                }
                this.totalDeElementos++;
        }

        public void adicionaNoFim(Object elemento) {
                if (this.totalDeElementos == 0) {
                        this.adicionaNoComeco(elemento);
                } else {
                        Nodo nova = new Nodo(elemento);
                        this.ultima.setProxima(nova);
                        this.ultima = nova;
                        this.totalDeElementos++;
                }
        }
        
        private boolean posicaoOcupada(int posicao) {
                return posicao >= 0 && posicao < this.totalDeElementos;
        }
        
        private Nodo pegaCelula(int posicao) {
                if (!this.posicaoOcupada(posicao)) {
                        throw new IllegalArgumentException("Posi��o n�o existe");
                }

                Nodo atual = primeira;
                for (int i = 0; i < posicao; i++) {
                        atual = atual.getProxima();
                }
                return atual;
        }

        public void adicionaQualquerPosicao(int posicao, Object elemento) {
                if (posicao == 0) { // No come�o.
                        this.adicionaNoComeco(elemento);
                } else if (posicao == this.totalDeElementos) { // No fim.
                        this.adicionaNoFim(elemento);
                } else {
                        Nodo anterior = this.pegaCelula(posicao - 1);
                        Nodo nova = new Nodo(anterior.getProxima(), elemento);
                        anterior.setProxima(nova);
                        this.totalDeElementos++;
                }
        }

        public Object pegaElementoLista(int posicao) {
                return this.pegaCelula(posicao).getElemento();
        }

        public void removeDoComeco() {
                if (!this.posicaoOcupada(0)) {
                        throw new IllegalArgumentException("Posi��o n�o existe");
                }

                this.primeira = this.primeira.getProxima();
                this.totalDeElementos--;

                if (this.totalDeElementos == 0) {
                        this.ultima = null;
                }
        }
        
        public void removeDoFim() {
                if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
                throw new IllegalArgumentException("Posi��o n�o existe");
                }
                if (this.totalDeElementos == 1) {
                this.removeDoComeco();
                } else {
                Nodo penultima = this.ultima.getAnterior();
                penultima.setProxima(null);
                this.ultima = penultima;
                this.totalDeElementos--;
                }
                }
                
        public void remove(int posicao) {
                if (!this.posicaoOcupada(posicao)) {
                        throw new IllegalArgumentException("Posi��o n�o existe");
                }

                if (posicao == 0) {
                        this.removeDoComeco();
                } else if (posicao == this.totalDeElementos - 1) {
                        this.removeDoFim();
                } else {
                        Nodo anterior = this.pegaCelula(posicao - 1);
                        Nodo atual = anterior.getProxima();
                        Nodo proxima = atual.getProxima();

                        anterior.setProxima(proxima);
                        proxima.setAnterior(anterior);

                        this.totalDeElementos--;

                }
        }

        public boolean contem(Object elemento) {
                  Nodo atual = this.primeira;
                    
                  while (atual != null) {
                    if (atual.getElemento().equals(elemento)) {
                      return true;
                    }
                    atual = atual.getProxima();
                  }
                  return false;
                }
        
        public int tamanho() {
                return this.totalDeElementos;
        }

        public boolean eVazia() {
                return (this.primeira == null);
        }

        public String toString() {

                // Verificando se a Lista est� vazia
                if (this.totalDeElementos == 0) {
                        return "[]";
                }

                StringBuilder builder = new StringBuilder("[");
                Nodo atual = primeira;

                // Percorrendo at� o pen�ltimo elemento.
                for (int i = 0; i < this.totalDeElementos - 1; i++) {
                        builder.append(atual.getElemento());
                        builder.append(", ");
                        atual = atual.getProxima();
                }

                // �ltimo elemento
                builder.append(atual.getElemento());
                builder.append("]");

                return builder.toString();
        }
        

}