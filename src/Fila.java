import javax.swing.*;

public class Fila {
    int tamanho;
    int inicio;
    int fim;
    int total;
    int vetor[];
    public Fila(int tam){
        inicio = 0;
        fim = 0;
        total = 0;
        tamanho = tam;
        vetor = new int [tam];
    }
    public boolean vazia() {
        if (total == 0)
            return true;
        else
            return false;
    }
    public boolean cheia() {
        if (total >= tamanho)
            return true;
        else
            return false;
    }
    public void enfileirar(int elem) {
        if (!cheia())
        {
            vetor[fim] = elem;
            fim++;
            total++;
            if (fim >= tamanho)
                fim = 0;
        }
        else
            System.out.println("Fila Cheia");
    }
    public String desenfileirar(){
        String elem ;
        if (vazia() == false)
        {
            elem = String.valueOf(vetor[inicio]);
            inicio++;
            if (inicio >= tamanho)
                inicio = 0;
            total --;
        }else
            elem = "Fila vazia";
        return elem;
    }
    public void exibeFila() {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("VALORES NA FILA\n");
        for (int i = 0; i < total; i++) {
            mensagem.append("Posição: ").append(i).append(" Valor: ").append(vetor[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

}
