package apresentacao.model;

import apresentacao.App;
import negocio.IrpfFachada;

import javax.swing.*;
import java.math.BigDecimal;

public class TelaCalculaImpostoModel {

    public App main = new App();


    public boolean cadastrarContribuinteCompleto(String nome, String cpf, int idade, int dependentes, BigDecimal contr, BigDecimal rendimentos)throws Exception{

        IrpfFachada fachada  = new IrpfFachada();

        try {
            fachada.adicionarContribuinteCompleto(nome, cpf, idade, dependentes, contr, rendimentos);
            return true;
        }catch(Exception e){
            throw new Exception("Falha ao adicionar pessoa!", e);
        }
    }

    public void voltarATelainicial()throws Exception{
        main.loadScene("FXML/TelaInicial.fxml", "Bem Vindo");
    }
}
