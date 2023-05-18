import javax.swing.*;

public class Main {

    public static void inserirValores(Pilha pilha, Fila fila, ListaEncadeada lista) {
        int valor;
        do {
            valor = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor inteiro (0 para sair)"));

            if (valor > 0) {
                if (valor % 2 == 0) fila.enfileirar(valor);
                else pilha.empilhar(valor);
            } else if (valor < 0) lista.insereNo_fim(new IntNoSimples(valor));

            if (valor == 0) JOptionPane.showMessageDialog(null, "Saindo...");
        } while (valor != 0);
        fila.exibeFila();
        pilha.exibePilha();
        lista.exibeLista();
    }

    public static void manipularFila(Fila fila) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    1 - Inserir elemento na fila
                    2 - Remover elemento na fila
                    0 - Voltar"""));

            switch (opcao) {
                case 1 -> {
                    int elemento = Integer.parseInt(JOptionPane.showInputDialog("Digite o elemento a ser inserido na fila:"));
                    fila.enfileirar(elemento);
                    JOptionPane.showMessageDialog(null, "Elemento inserido na fila!");
                }
                case 2 -> {
                    if (fila.vazia()) JOptionPane.showMessageDialog(null, "A fila está vazia!");
                    else JOptionPane.showMessageDialog(null, "Elemento removido da fila: " + fila.desenfileirar());
                }
                case 0 -> JOptionPane.showMessageDialog(null, "Voltando...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
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
                case 1 -> {
                    int elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "Escolha o valor a ser inserido: "));
                    pilha.empilhar(elemento);
                }
                case 2 -> {
                    if (pilha.vazia()) JOptionPane.showMessageDialog(null, "A pilha está vazia!");
                    else JOptionPane.showMessageDialog(null, "Elemento removido da pilha: " + pilha.desempilhar());
                }
                case 0 -> JOptionPane.showMessageDialog(null, "Voltando...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void manipularLista(ListaEncadeada lista) {
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
                    int posicao = Integer.parseInt(JOptionPane.showInputDialog("""
                        Em qual posição deseja inserir o elemento?
                        1 - Início
                        2 - Meio
                        3 - Fim"""));

                    IntNoSimples novoNo = new IntNoSimples(elemento);

                    switch (posicao) {
                        case 1: // Inserir no início
                            lista.insereNo_inicio(novoNo); //  // Cria um novo nó com o elemento fornecido pelo usuário
                            JOptionPane.showMessageDialog(null, "Elemento inserido no início da lista!");
                            break;
                        case 2: // Inserir no meio
                            int posicaoMeio = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do elemento no meio da lista:")); // Solicita ao usuário a posição em que deseja inserir o elemento no meio da lista
                            lista.insereNo_posicao(novoNo, posicaoMeio);  // Insere o novo nó na posição informada pelo usuário
                            JOptionPane.showMessageDialog(null, "Elemento inserido no meio da lista!");// mostra que foi colocado no meio da lista
                            break;
                        case 3: // Inserir no fim
                            lista.insereNo_fim(novoNo);
                            JOptionPane.showMessageDialog(null, "Elemento inserido no fim da lista");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "opcao invlida!");
                            break;
                    }

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
                        IntNoSimples primeiroNo = lista.primeiro; //  Armazena o primeiro elemento da lista na variável primeiroNo
                        JOptionPane.showMessageDialog(null,
                                "Primeiro elemento da lista: Valor " + primeiroNo.valor + ", Posicao 0");

                        // Exibe o último elemento da lista
                        IntNoSimples ultimoNo = lista.ultimo; // Armazena o último elemento da lista na variável ultimoNo
                        int posicaoUltimo = lista.ContarNos() - 1; //Calcula a posição do último elemento da lista, subtraindo 1 do total de nós na lista.
                        JOptionPane.showMessageDialog(null,
                                "Ultimo elemento da lista: Valor " + ultimoNo.valor + ", Posicao " + posicaoUltimo);
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
                        JOptionPane.showMessageDialog(null, "Média dos elementos da lista: " + media + "\n"
                                + "Moda: " + moda + "\n"
                                + "Frequência da moda: " + modaFrequencia);
                    }
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Voltando...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcao invalida!");
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
                case 1 -> inserirValores(pilha, fila, lista);
                case 2 -> manipularPilha(pilha);
                case 3 -> manipularFila(fila);
                case 4 -> manipularLista(lista);
                case 0 -> JOptionPane.showMessageDialog(null, "Saindo do programa...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }
}