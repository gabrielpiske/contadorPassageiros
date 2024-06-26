
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author gabriel_piske
 */
public class Main {

    //Variavéis Globais
    public static Scanner ler = new Scanner(System.in);
    public static ArrayList<Onibus> listaOnibus = new ArrayList<>();
    public static ArrayList<Linha> listaLinha = new ArrayList<>();
    public static ArrayList<Viagem> listaViagem = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            //Menu
            System.out.println("Menu: ");
            System.out.println("1 - Cadastro Onibus");
            System.out.println("2 - Cadastro Linha");
            System.out.println("3 - Cadastro Viagem");
            System.out.println("4 - Decorrer uma viagem");
            System.out.println("5 - Sair");
            System.out.print("Entrada: ");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarOnibus();
                    break;
                case 2:
                    cadastrarLinha();
                    break;
                case 3:
                    cadastrarViagem();
                    break;
            }

        } while (opcao != 5);
    }

    //Tela para cadastramento do objeto onibus e já colocando-o na lista
    public static void cadastrarOnibus() {
        System.out.println("Cadastrar Onibus: ");
        System.out.println("Informe a Placa do Onibus: ");
        String placa = ler.next();
        System.out.println("Informe a Capacidade máxima do Onibus: ");
        int cpMax = ler.nextInt();
        Onibus onibus = new Onibus(placa, cpMax);
        listaOnibus.add(onibus);
        System.out.println("Onibus Cadastrado com sucesso!");
    }

    //Tela para cadastramento do objeto linha e já colocando-a na lista
    public static void cadastrarLinha() {
        System.out.println("Cadastrar Linha: ");
        System.out.println("Informe o terminal da Linha: ");
        String terminal = ler.next();
        System.out.println("Informe o numero de paradas: ");
        int nmParadas = ler.nextInt();
        Linha linha = new Linha(nmParadas, terminal);
        listaLinha.add(linha);
        System.out.println("Linha Cadastrada com sucesso!");
    }

    //Tela para cadastramento do objeto viagem já puxando onibus e linha correspondente e adicionando a lista no final
    public static void cadastrarViagem() {
        System.out.println("Cadastrar Viagem: ");
        
        //Selecionando o onibus correspondente
        System.out.println("Selecione o Onbus: ");
        for (int i = 0; i < listaOnibus.size(); i++) {
            System.out.println((i + 1) + "." + listaOnibus.get(i).getPlaca());
        }
        int onibusSelect = ler.nextInt();
        Onibus onibus = listaOnibus.get(onibusSelect);
        
        //Selecionando a linha correpondente
        System.out.println("Selecione a Linha: ");
        for (int i = 0; i < listaLinha.size(); i++) {
            System.out.println((i + 1) + "." + listaLinha.get(i).getTerminal());
        }
        int linhaSelect = ler.nextInt();
        Linha linha = listaLinha.get(linhaSelect);
        
        //Input da data e hora para o cadrasto
        System.out.println("Informe a Data da Viagem: ");
        String data = ler.next();
        System.out.println("Informe a Hora da Viagem: ");
        String hora = ler.next();
        Viagem viagem = new Viagem(data, hora, onibus, linha);
        listaViagem.add(viagem);
        System.out.println("Viagem Cadastrada com Sucesso!");
    }
    
}
