package Models;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Historico {
    private List<Conversor> valoresConvertidos;

    public Historico() {
        this.valoresConvertidos = new ArrayList<>();
    }

    public List<Conversor> getValoresConvertidos() {
        return valoresConvertidos;
    }


    public void adicionarConversao(Conversor conversor) {
        valoresConvertidos.add(conversor);
    }

    public void registrarNoHistorico() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dataAtual = new Date();
        String dataFormatada = formatter.format(dataAtual);

        try (PrintWriter writer = new PrintWriter(new FileWriter("historico.txt", true))) {
            Conversor conversor = getValoresConvertidos().get(getValoresConvertidos().size() - 1);
            writer.println(conversor.toString() + "Data e Hora da Conversão: " + dataFormatada + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibirHistorico() {
        File arquivo = new File("historico.txt");

        if (arquivo.exists() && arquivo.length() > 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    System.out.println(linha);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Não existe arquivo historico.txt ou não há nenhuma conversão a ser mostrada.");
        }
    }
}
