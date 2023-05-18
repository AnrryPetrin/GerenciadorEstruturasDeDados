import javax.swing.*;

public class Main {
    private static void manipularLista(ListaEncadeada lista) {
        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    1 - Inserir elemento na lista
                    2 - Remover elemento na lista
                    3 - Exibir primeiro e ultimo elemento na lista
                    4 - Calculo de media e Moda
                    0 - Voltar"""));

            switch (opcao) {
                case 1:// insere elemento na lista
                    int elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento a ser inserido na lista:"));
                    IntNoSimples novoNo = new IntNoSimples(elemento);
                    lista.insereNo_fim(novoNo);
                    JOptionPane.showMessageDialog(null, "Elemento inserido na lista!");
                    break;
                case 2:// remove elementos da lista
                    if (lista.numero_nos == 0) {
                        JOptionPane.showMessageDialog(null, "A lista esta vazia!");
                    } else {
                        // Remove o elemento do início da lista
                        IntNoSimples noRemovido = lista.primeiro;
                        lista.excluiNo(noRemovido.valor);

                        JOptionPane.showMessageDialog(null, "Elemento removido da lista: " + noRemovido.valor);

                    }
                    break;
                case 3: // exibe o primeiro e o ultimo elemento da lista
                    if (lista.numero_nos == 0) {
                        JOptionPane.showMessageDialog(null, "A lista esta vazia!");
                    } else {
                        // Exibe o primeiro elemento da lista
                        IntNoSimples primeiroNo = lista.primeiro;
                        JOptionPane.showMessageDialog(null, "Primeiro elemento da lista: Valor " + primeiroNo.valor + ", Posicao 0");

                        // Exibe o último elemento da lista
                        IntNoSimples ultimoNo = lista.ultimo;
                        int posicaoUltimo = lista.ContarNos() - 1;
                        JOptionPane.showMessageDialog(null, "Ultimo elemento da lista: Valor " + ultimoNo.valor + ", Posicao " + posicaoUltimo);
                    }
                    break;
                case 4: /// Calculo de media e moda
                    if (lista.numero_nos == 0) { // Verifica se a lista está vazia
                        JOptionPane.showMessageDialog(null, "A lista está vazia!");
                    } else {
                        // Cálculo da média
                        int soma = 0; // Variável para armazenar a soma dos valores
                        IntNoSimples tempNo = lista.primeiro; // Variável para percorrer a lista
                        // Loop para percorrer todos os elementos da lista e calcular a soma
                        while (tempNo != null) {
                            soma += tempNo.valor; // Adiciona o valor do elemento atual à soma
                            tempNo = tempNo.prox; // Avança para o próximo elemento
                        }
                        float media = (float) soma / lista.numero_nos; // Cálculo da média
                        JOptionPane.showMessageDialog(null, "Media dos elementos da lista: " + media);
                        // Cálculo da moda
                        IntNoSimples tempNo2 = lista.primeiro; // Outra variável para percorrer a lista
                        int moda = 0; // Variável para armazenar a moda
                        int modaFrequencia = 0; // Variável para armazenar a frequência da moda
                        // Loop para percorrer todos os elementos da lista e calcular a moda
                        while (tempNo2 != null) {
                            int frequencia = 0; // Variável para armazenar a frequência atual
                            IntNoSimples tempNo3 = lista.primeiro; // Variável auxiliar para percorrer a lista
                            // Loop para contar a frequência do valor atual
                            while (tempNo3 != null) {
                                if (tempNo3.valor == tempNo2.valor) {
                                    frequencia++; // Incrementa a frequência se houver uma correspondência
                                }
                                tempNo3 = tempNo3.prox; // Avança para o próximo elemento
                            }
                            if (frequencia > modaFrequencia) {
                                moda = tempNo2.valor; // Atualiza o valor da moda
                                modaFrequencia = frequencia; // Atualiza a frequência da moda
                            }
                            tempNo2 = tempNo2.prox; // Avança para o próximo elemento
                        }
                        JOptionPane.showMessageDialog(null, "Média dos elementos da lista: " + media + "\n" + "Moda: " + moda + "\n" + "Frequência da moda: " + modaFrequencia);
                    }
                case 0:
                    JOptionPane.showMessageDialog(null, "Voltando...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida!");
            }
        } while (opcao != 0);
    }

    public static void inserirValores(Pilha pilha, Fila fila, ListaEncadeada lista) {
        int valor;
        valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro (0 para sair)"));
        if (valor > 0) {
            if (valor % 2 == 0) {
                fila.enfileirar(valor);
            } else {
                pilha.empilhar(valor);
            }
        } else {
            lista.insereNo_inicio(new IntNoSimples(valor));
        }
    }

    public static void manipularFila(Fila fila) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    1 - Inserir elemento na fila
                    2 - Remover elemento na fila
                    0 - Voltar"""));

            switch (opcao) {
                case 1:
                    int elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento a ser inserido na fila:"));
                    fila.enfileirar(elemento);
                    JOptionPane.showMessageDialog(null, "Elemento inserido na fila!");
                    break;
                case 2:
                    if (fila.vazia()) {
                        JOptionPane.showMessageDialog(null, "A fila está vazia!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento removido da fila: " + fila.desenfileirar());
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Voltando...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void manipularPilha(Pilha pilha) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    1 - Inserir elemento na Pilha
                    2 - Remover elemento na Pilha
                    0 - Voltar"""));

            switch (opcao) {
                case 1:
                    int elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha o valor a ser inserido: "));
                    pilha.empilhar(elemento);
                    break;
                case 2:
                    if (pilha.vazia()) {
                        JOptionPane.showMessageDialog(null, "A pilha está vazia!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento removido da pilha: " + pilha.desempilhar());
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Voltando...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void main(String[] args) {
        ListaEncadeada lista = new ListaEncadeada();
        Fila fila = new Fila(10);
        Pilha pilha = new Pilha(10);
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    ::::::: GERENCIADOR DE ESTRUTURAS DE DADOS :::::::
                    1 - Inserir valores nas estruturas de dados
                    2 - Manipular uma pilha
                    3 - Manipular uma fila
                    4 - Manipular uma lista
                    0 - para sair"""));

            switch (opcao) {
                case 1:
                    inserirValores(pilha, fila, lista);
                case 2:
                    manipularPilha(pilha);
                case 3:
                    manipularFila(fila);
                case 4:
                    manipularLista(lista);
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 0);
    }
}