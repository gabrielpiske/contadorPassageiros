
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

    public static void main(String[] args) throws IOException {
        try {
            //recupera todos arquivos de texto
            recuperarOnibus();
            recuperarViagem();
            recuperarLinha();
        } catch (Exception e) {
            System.err.println("Erro ao recuperar arquivos: " + e.getMessage());
        }

        int opcao;
        do {
            //Menu
            System.out.println("Menu: ");
            System.out.println("1 - Cadastro Onibus");
            System.out.println("2 - Cadastro Linha");
            System.out.println("3 - Cadastro Viagem");
            System.out.println("4 - Sair");
            System.out.print("Entrada: ");
            opcao = ler.nextInt();
            try {
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
                    default:
                        System.out.println("Opcao Inavlida, Tente Novamente");
                }
            } catch (IOException | InputMismatchException e) {
                System.err.println("Erro: " + e.getMessage());
                ler.next(); // Limpa a entrada incorreta do Scanner
            }

        } while (opcao != 4);

    }

    //Tela para cadastramento do objeto onibus e já colocando-o na lista
    public static void cadastrarOnibus() throws IOException {
        try {
            System.out.println("Cadastrar Onibus: ");
            System.out.println("Informe a Placa do Onibus: ");
            String placa = ler.next();
            System.out.println("Informe a Capacidade máxima do Onibus: ");
            int cpMax = ler.nextInt();
            Onibus onibus = new Onibus(placa, cpMax);
            listaOnibus.add(onibus);
            System.out.println("Onibus Cadastrado com sucesso!");

            FileWriter arquivo = new FileWriter("registroOnibus.txt", true);
            PrintWriter gravador = new PrintWriter(arquivo);
            //gravador.println(onibus);
            gravador.println(placa + "," + cpMax);
            gravador.close();
        } catch (InputMismatchException e) {
            System.err.println("Erro de entrada, insira um numero valido.");
            ler.next();
        }

    }

    //Tela para cadastramento do objeto linha e já colocando-a na lista
    public static void cadastrarLinha() throws IOException {
        try {
            System.out.println("Cadastrar Linha: ");
            System.out.println("Informe o terminal da Linha: ");
            String terminal = ler.next();
            System.out.println("Informe o numero de paradas: ");
            int nmParadas = ler.nextInt();
            Linha linha = new Linha(nmParadas, terminal);
            listaLinha.add(linha);
            System.out.println("Linha Cadastrada com sucesso!");

            FileWriter arquivo = new FileWriter("registroLinha.txt", true);
            PrintWriter gravador = new PrintWriter(arquivo);
            gravador.println(nmParadas + "," + terminal);
            //gravador.println(linha);
            gravador.close();
        } catch (InputMismatchException e) {
            System.err.println("Erro de entrada, insira um numero valido.");
            ler.next();
        }

    }

    //Tela para cadastramento do objeto viagem já puxando onibus e linha correspondente e adicionando a lista no final
    public static void cadastrarViagem() throws IOException {
        try {
            System.out.println("Cadastrar Viagem: ");

            //Selecionando o onibus correspondente
            if (listaOnibus.isEmpty()) {
                System.err.println("Nao ha onibus Cadastrados.");
                return;
            }
            System.out.println("Selecione o Onbus: ");
            for (int i = 0; i < listaOnibus.size(); i++) {
                System.out.println((i + 1) + "." + listaOnibus.get(i).getPlaca());
            }
            System.out.print("Entrada: ");
            int onibusSelect = ler.nextInt();
            Onibus onibus = listaOnibus.get(onibusSelect - 1);

            //Selecionando a linha correpondente
            if (listaLinha.isEmpty()) {
                System.err.println("Nao ha linhas Cadastradas.");
                return;
            }
            System.out.println("Selecione a Linha: ");
            for (int i = 0; i < listaLinha.size(); i++) {
                System.out.println((i + 1) + "." + listaLinha.get(i).getTerminal());
            }
            System.out.print("Entrada: ");
            int linhaSelect = ler.nextInt();
            Linha linha = listaLinha.get(linhaSelect - 1);

            //Input da data e hora para o cadrasto
            System.out.println("Informe a Data da Viagem: ");
            String data = ler.next();
            System.out.println("Informe a Hora da Viagem: ");
            String hora = ler.next();
            Viagem viagem = new Viagem(data, hora, onibus, linha);
            listaViagem.add(viagem);
            System.out.println("Viagem Cadastrada com Sucesso!");

            Viagem viagemRetornado = decorrerViagem();

            FileWriter arquivo = new FileWriter("registroViagem.txt", true);
            PrintWriter gravador = new PrintWriter(arquivo);
            gravador.println(data + "," + hora + "," + onibus.getPlaca() + "," + onibus.getCapacidadeMaxima() + "," + linha.getTerminal() + "," + linha.getNmParadas());
            //gravador.println(viagemRetornado);
            gravador.close();
        } catch (InputMismatchException e) {
            System.err.println("Erro de entrada, insira um numero valido.");
            ler.next();
        }

    }

    //Faz a parte lógica do decorrimento da viagem instanciando os onibus/linhas próprio da viagem
    public static Viagem decorrerViagem() {
        try {
            System.out.println("Decorer Viagem: ");

            System.out.println("Selecione a Viagem:");
            for (int i = 0; i < listaViagem.size(); i++) {
                Viagem viagem = listaViagem.get(i);
                System.out.println((i + 1) + "- Data: " + viagem.getData() + ", Hora: " + viagem.getHora() + ", Onibus: " + viagem.getOnibus().getPlaca() + ", Linha: " + viagem.getLinha().getTerminal());
            }
            System.out.print("Entrada: ");
            int viagemSele = ler.nextInt();
            Viagem viagem = listaViagem.get(viagemSele - 1);

            Onibus onibus = viagem.getOnibus();
            Linha linha = viagem.getLinha();

            int totalSubiram = 0;
            int totalDesceram = 0;

            for (int i = 0; i < linha.getNmParadas(); i++) {
                System.out.println("Parada " + (i + 1) + ": ");

                //Subida
                System.out.println("Quantos Passageiros Subiram? ");
                int subiram = ler.nextInt();
                if (onibus.getPassageirosAtual() + subiram > onibus.getCapacidadeMaxima()) {
                    System.out.println("Impossivel Subir Todos os Passageiros");
                    subiram = onibus.getCapacidadeMaxima() - onibus.getPassageirosAtual();
                }
                onibus.setPassageirosAtual(onibus.getPassageirosAtual() + subiram);
                totalSubiram += subiram;

                // Descida
                int desceram = 0;
                if (i == 0) {
                    System.out.println("Primeira parada: Ninguem pode descer");
                } else if (i == linha.getNmParadas() - 1) {
                    desceram = onibus.getPassageirosAtual();
                    System.out.println("Ultima parada: Todos devem descer");
                } else {
                    System.out.println("Quantos Passageiros Desceram? ");
                    desceram = ler.nextInt();
                    if (desceram > onibus.getPassageirosAtual()) {
                        desceram = onibus.getPassageirosAtual();
                    }
                    totalDesceram += desceram;
                }

                onibus.setPassageirosAtual(onibus.getPassageirosAtual() - desceram);

                System.out.println("Passageiros Atuais no onibus: " + onibus.getPassageirosAtual());
            }
            // Balanço Geral
            System.out.println("Viagem Concluida!!!");
            System.out.println("Total de Passageiros que subiram: " + totalSubiram);
            System.out.println("Total de Passageiros que desceram: " + totalDesceram);
            System.out.println("Passageiros Atuais no Onibus: " + onibus.getPassageirosAtual());

            return viagem;
        } catch (InputMismatchException e) {
            System.err.println("Erro de entrada, insira um numero valido.");
            ler.next();
        }
        return null;
    }

    //Faz a recuperação dos Dados do Arquivo registroOnibus.txt para utilizar no programa
    private static void recuperarOnibus() throws IOException {
        String aarq = "registroOnibus.txt";
        String linha = "";
        File arq = new File(aarq);
        if (arq.exists()) {

            try {
                FileReader abrindo = new FileReader(aarq);
                BufferedReader leitor = new BufferedReader(abrindo);
                while (true) {
                    linha = leitor.readLine();
                    if (linha == null) {
                        break;
                    }
                    //separa dados da linha do arquivo de texto pela ,
                    String[] linhaAtualOnibusArquivo = linha.split(",");
                    //cria objeto onibus passando parametros do arquivo de texto parametro 0 é placa e 1 é capacidade máxima
                    Onibus onibus = new Onibus(linhaAtualOnibusArquivo[0], Integer.parseInt(linhaAtualOnibusArquivo[1]));
                    //adiciona na lista de onibus
                    listaOnibus.add(onibus);
                }
                leitor.close();
            } catch (Exception erro) {
                System.err.println("Erro ao recuperar dados do arquivo de ônibus: " + erro.getMessage());
            }

        }
    }

    //Faz a recuperação dos Dados do Arquivo registroViagem.txt para utilizar no programa
    private static void recuperarViagem() throws IOException {
        String aarq = "registroViagem.txt";
        String linha = "";
        File arq = new File(aarq);
        if (arq.exists()) {
            try {
                FileReader abrindo = new FileReader(aarq);
                BufferedReader leitor = new BufferedReader(abrindo);
                while (true) {
                    linha = leitor.readLine();
                    if (linha == null) {
                        break;
                    }
                    //separa dados da linha do arquivo de texto pela ,
                    String[] linhaAtualViagemArquivo = linha.split(",");
                    Linha linhaHist = new Linha(Integer.parseInt(linhaAtualViagemArquivo[5]), linhaAtualViagemArquivo[4]);
                    Onibus onibusHist = new Onibus(linhaAtualViagemArquivo[2], Integer.parseInt(linhaAtualViagemArquivo[3]));

                    //cria objeto onibus passando parametros do arquivo de texto parametro 0 é data e 1 é hora 2 é Objeto Onibus e 3 e Objeto Linha
                    Viagem viagem = new Viagem(linhaAtualViagemArquivo[0], linhaAtualViagemArquivo[1], onibusHist, linhaHist);
                    //adiciona na lista de onibus
                    listaViagem.add(viagem);
                }
                leitor.close();
            } catch (Exception erro) {
                System.err.println("Erro ao recuperar dados do arquivo de viagens: " + erro.getMessage());
            }

        }
    }

    //Faz a recuperação dos Dados do Arquivo registroLinha.txt para utilizar no programa
    private static void recuperarLinha() throws IOException {
        String aarq = "registroLinha.txt";
        String linha = "";
        File arq = new File(aarq);
        if (arq.exists()) {

            try {
                FileReader abrindo = new FileReader(aarq);
                BufferedReader leitor = new BufferedReader(abrindo);
                while (true) {
                    linha = leitor.readLine();
                    if (linha == null) {
                        break;
                    }
                    //separa dados da linha do arquivo de texto pela ,
                    String[] linhaAtualLinhaArquivo = linha.split(",");
                    //cria objeto onibus passando parametros do arquivo de texto parametro 0 é nmParads e 1 é terminal
                    Linha linhaHist = new Linha(Integer.parseInt(linhaAtualLinhaArquivo[0]), linhaAtualLinhaArquivo[1]);
                    //adiciona na lista de onibus
                    listaLinha.add(linhaHist);
                }
                leitor.close();
            } catch (Exception erro) {
                System.err.println("Erro ao recuperar dados do arquivo de viagens: " + erro.getMessage());
            }

        }
    }

}
