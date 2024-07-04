
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

    public String toString() {
        return this.getPlaca() + "," + this.capacidadeMaxima + "," + this.passageirosAtual;
    }
}
