
/**
 * @author gabriel_piske
 */
public class Linha {

    private int nmParadas;
    private String terminal;

    //Construtores
    public Linha() {

    }
    
    public Linha(int nmPar, String term) {
        this.nmParadas = nmPar;
        this.terminal = term;
    }

    //Gets e Sets
    public int getNmParadas() {
        return nmParadas;
    }

    public void setNmParadas(int nmParadas) {
        this.nmParadas = nmParadas;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    //Métodos
}
