
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author gabriel_piske
 */
public class Main {

    public static Scanner ler = new Scanner(System.in);
    //public static Onibus[] onibus = new Onibus[5];
    public static ArrayList<Onibus> listaOnibus = new ArrayList<>(5);
    public static ArrayList<Linha> linha = new ArrayList<>(5);
    public static ArrayList<Viagem> viagem = new ArrayList<>(5);

    public static void main(String[] args) {
        String placa;
        int cpMax;
        
        //Criando Onibus
        System.out.print("Entre com a placa do Onibus ?: ");
        placa = ler.nextLine();
        System.out.print("Qual a capacidade maxima do Onibus ?: ");
        cpMax = ler.nextInt();
        ler.nextLine(); //Limpar Scanner
        Onibus onibus = new Onibus(placa, cpMax);
        listaOnibus.add(onibus);
        
        //Criando Linhas
        linha.add(new Linha(2,"Linha 1"));
        linha.add(new Linha(3,"Linha 2"));
        linha.add(new Linha(4,"Linha 3"));
        linha.add(new Linha(5,"Linha 4"));
        linha.add(new Linha(6,"Linha 5"));
    }

}
