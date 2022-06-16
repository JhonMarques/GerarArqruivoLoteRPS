import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class main {
    public static void main(String[] args) {

        StringBuilder texto = new StringBuilder();
        String textoLimpo = "";

        int incioCabecalho = 1;
        String versaoArquivo = "002";
        int tipoRegistro = 6;
        int inicioRodape = 9;
        String numeroLinhas = "1";
        String valorTotalNoTxt = "359.99";
        String valorTotalDeducoesNoTxt = "0.00";
        String inscMunicipalPrestador = "11590602";
        String codIbgePrestador = "3550308";
        String descricaoServico = "Venda de produtos diversos";
        String numero = "67";
        String inscMunicipalTomador = "5300108";
        String cpfCnpjTomador = "63658690704";
        String cepTomador = "20511200";
        String codigoServico = "04383";
        String inscEstadualTomador = "";
        LocalDateTime ultimoDiaMes = LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime primeiroDiaMes = LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime data = LocalDateTime.now();
        String serieRps = "1";
        String numRps = "436";
        String valorServico = "359.99";
        String dataEmissaoFormatada = "2022-05-17";
        String valorDeducoes = "0.00";
        String valorAliquota = "2.00";
        String issRetido = "2"; // 1 = Retido pelo Tomador, 2 = sem iss retido, 3 iss retido pelo intermediario
        String situacaoRps = "T";
        int cpfOuCnpj = 1;
        String pis = "0.65";
        String cofins = "3.00";
        String inss = "0.00";
        String ir = "15.00";
        String cssl = "9.00";
        String cargaTrib = "0";
        String cargaTribPorcent = "0";
        String cargaTribFonte = "0";
        String cei = "0";
        String matriculaObra = "0";
        String encapsulamento = "0";
        String campoReservado = " ";
        String valorTotalRecebido = "0";

        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("yyyyMM");
        String dataLanc = data.format(formatar);

        DateTimeFormatter formatarDia = DateTimeFormatter.ofPattern("dd");
        String primeiroDia = primeiroDiaMes.format(formatarDia);
        String ultimoDia = ultimoDiaMes.format(formatarDia);

        if (cpfCnpjTomador.length() > 11) {
            cpfOuCnpj = 2;
        } else if (cpfCnpjTomador.equals(null) || cpfCnpjTomador.isEmpty()) {
            cpfOuCnpj = 3;
        }

        texto.append(incioCabecalho).append(versaoArquivo);
        texto.append(inscMunicipalPrestador);
        texto.append("20220517");
        texto.append("20220517");
        texto.append("\r\n");


        texto.append(tipoRegistro).append("RPS  ");
        texto.append(completarFimDaString(5, " ", serieRps));
        texto.append(completarNoComecoDaString(12, "0", numRps));
        texto.append(dataEmissaoFormatada);
        texto.append(situacaoRps);
        texto.append(completarNoComecoDaString(15, "0", valorServico));
        texto.append(completarNoComecoDaString(15, "0", valorDeducoes));
        texto.append(codigoServico);
        texto.append(completarNoComecoDaString(4, "0", valorAliquota));
        texto.append(issRetido);
        texto.append(cpfOuCnpj);
        texto.append(completarNoComecoDaString(14, "0", cpfCnpjTomador));
        if (inscMunicipalPrestador.equals(inscMunicipalTomador)) {
            texto.append(completarNoComecoDaString(8, " ", inscMunicipalTomador));
        } else {
            texto.append(completarNoComecoDaString(8, " ", ""));
        }
        texto.append(completarNoComecoDaString(12, " ", inscEstadualTomador));
        texto.append(completarFimDaString(75, " ", "MARCIA MARQUES"));
        texto.append(completarFimDaString(53, " ", "RUA CONDE DE"));
        texto.append(completarFimDaString(10, " ", numero));
        texto.append(completarFimDaString(30, " ", "N/A"));
        texto.append(completarFimDaString(30, " ", "CENTRO"));
        texto.append(completarFimDaString(50, " ", "91"));
        texto.append(completarFimDaString(2, " ", "RJ"));
        texto.append(completarFimDaString(8, " ", cepTomador));
        texto.append(completarFimDaString(75, " ", " "));
        texto.append(completarFimDaString(15, "0", pis));
        texto.append(completarFimDaString(15, "0", cofins));
        texto.append(completarFimDaString(15, "0", inss));
        texto.append(completarFimDaString(15, "0", ir));
        texto.append(completarFimDaString(15, "0", cssl));
        texto.append(completarFimDaString(15, "0", cargaTrib));
        texto.append(completarFimDaString(5, "0", cargaTribPorcent));
        texto.append(completarFimDaString(10, "0", cargaTribFonte));
        texto.append(completarFimDaString(12, "0", cei));
        texto.append(completarFimDaString(12, "0", matriculaObra));
        if (situacaoRps.equals("T")) {
            texto.append(completarFimDaString(7, "0", "0"));
        }else{
            texto.append(completarFimDaString(7, "0", codIbgePrestador));
        }
        texto.append(completarFimDaString(10, "0", encapsulamento));
        texto.append(completarFimDaString(10, " ", campoReservado));
        texto.append(completarFimDaString(15, " ", valorTotalRecebido));
        texto.append(completarFimDaString(175, " ", campoReservado));
        texto.append(descricaoServico);
        texto.append("\r\n");
        texto.append(inicioRodape);
        texto.append(completarNoComecoDaString(7, "0", numeroLinhas));
        texto.append(completarNoComecoDaString(15, "0", valorTotalNoTxt));
        texto.append(completarNoComecoDaString(15, "0", valorTotalDeducoesNoTxt));
        texto.append("\r\n");

        textoLimpo = limparTexto(texto.toString());

        GerarTxt.gerarTxt("C:\\Users\\admin\\Desktop\\NotasFicais_", textoLimpo);


    }

    public static String limparTexto(String texto){
        texto = texto.replace(",", "")
            .replace("-", "")
            .replace(".", "");
        return texto;
    }

    public static String completarNoComecoDaString(int tamanho, String caracter, String texto) {
        texto = limparTexto(texto);
        while (texto.length() < tamanho || texto.equals(null)) {
            texto = texto.substring(0,0) + caracter + texto;

        }
        return texto;
    }


    public static String completarFimDaString(int tamanho, String caracter, String texto) {
        texto = limparTexto(texto);
        while (texto.length() < tamanho || texto.equals(null)) {
            texto = texto.concat(caracter);

        }
        return texto;
    }

}

