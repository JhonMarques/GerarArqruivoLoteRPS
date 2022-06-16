import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GerarTxt {

    public static void gerarTxt(String caminhoArquivo, String texto) {

        try(

            //Cria o arquivo, o parâmetro true indica que se o arquivo já existir ele apenas escreve uma linha  após a última;
            FileWriter criadorArquivo = new FileWriter(caminhoArquivo, true);
            //Recebe o arquivo e escreve no buffer
            BufferedWriter buffer = new BufferedWriter(criadorArquivo);
            //Imprime o Arquivo
            PrintWriter escritorArquivo = new PrintWriter(buffer);

        ){

            escritorArquivo.append(texto + "\n");
            System.out.println("Buildou");

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}

