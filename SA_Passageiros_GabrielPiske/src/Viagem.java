
/**
 * @author gabriel_piske
 */
public class Viagem {

    private String data;
    private String hora;
    private int qtdPassageiros;
    private Onibus onibus;
    private Linha linha;
    
    //Construtores
    public Viagem() {
        this.qtdPassageiros = 0; 
    }

    public Viagem(String dt, String hr, Onibus onibus, Linha linha) {
        this.qtdPassageiros = 0;
        this.data = dt;
        this.hora = hr;
        this.onibus = onibus;
        this.linha = linha;
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
    
    
    //Métodos

}
