
/**
 * @author gabriel_piske
 */
public class Onibus {

    private String placa;
    private int capacidadeMaxima;
    private int passageirosAtual;

    //------------> Construtores
    public Onibus() {

    }

    public Onibus(String placa, int cpMax) {
        this.placa = placa;
        this.capacidadeMaxima = cpMax;
        this.passageirosAtual = 0;
    }

    public Onibus(int cpMax, String placa, int pasAtual) {
        this.capacidadeMaxima = cpMax;
        this.passageirosAtual = pasAtual;
        this.placa = placa;
    }

    //------------> Gets e Sets
    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getPassageirosAtual() {
        return passageirosAtual;
    }

    public void setPassageirosAtual(int passageirosAtual) {
        this.passageirosAtual = passageirosAtual;
    }

    //Subir passageiros
    /* public void entradaPassageiros(int qtdPessoas) {
        int resto;
        if (qtdPessoas > this.capacidadeMaxima - this.passageirosAtual) {
            resto = qtdPessoas - (this.capacidadeMaxima - this.passageirosAtual);
            this.passageirosAtual = this.capacidadeMaxima;
            System.err.println("Lotacao maxima do onibus. Ficaram de fora " + resto + " passageiros");
        } else {
            System.out.println("Subiram " + qtdPessoas + " passageiros.");
            this.passageirosAtual += qtdPessoas;
        }
    }

    //Descer Passageiros
    public void descidaPassageiros(int numero) {
        if (this.passageirosAtual == 0) {
            System.err.println("O onibus esta vazio.");
        } else {
            System.out.println("O passageiro desceu");
        }
    }*/
}
