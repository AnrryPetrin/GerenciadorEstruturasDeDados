import javax.swing.JOptionPane;

public class Main {

    private static void manipularFila(Fila fila) {
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
                        String elementoRemovido = fila.desenfileirar();
                        JOptionPane.showMessageDialog(null, "Elemento removido da fila: " + elementoRemovido);
                    }
                    break;
                case 0: JOptionPane.showMessageDialog(null, "Voltando...");
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
                case 3:
                    manipularFila(fila);
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }

        } while (opcao != 0);
    }
}