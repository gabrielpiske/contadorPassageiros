
/**
 * @author gabriel_piske
 */
public class Viagem {

    private String data;
    private String hora;
    private Onibus onibus;
    private Linha linha;
    private int qtdParadas;

    //Construtores
    public Viagem() {

    }

    public Viagem(String data, String hora, Onibus onibus, Linha linha) {
        this.data = data;
        this.hora = hora;
        this.onibus = onibus;
        this.linha = linha;
        this.qtdParadas = 0;
    }

    //Gets e Sets
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    public int getQtdParadas() {
        return qtdParadas;
    }

    public void setQtdParadas(int qtdParadas) {
        this.qtdParadas = qtdParadas;
    }

    @Override
    public String toString() {
        return data + "," + hora + "," + this.onibus + "," + this.linha ;
    }
}
