package apresentacao.controller;

import apresentacao.model.TelaCalculaImpostoModel;
import apresentacao.model.TelaInicialModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.math.BigDecimal;

public class TelaCalculaImpostoController {

    public TextField nome;
    public TextField idade;
    public TextField cpf;
    public TextField dependentes;
    public TextField contrOficial;
    public TextField totalRendimentos;
    public Button enviar;
    public TelaCalculaImpostoModel telaCalculaImpostoModel = new TelaCalculaImpostoModel();


    @FXML
    public void initialize() {

    }

    public void clicarEnviar() throws Exception{
        if(nome.getText().isEmpty()||idade.getText().isEmpty()||cpf.getText().isEmpty()||dependentes.getText().isEmpty()||contrOficial.getText().isEmpty()||totalRendimentos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha o formulario corretamente.");
        }else {

            telaCalculaImpostoModel.cadastrarContribuinteCompleto(nome.getText(), cpf.getText(), Integer.parseInt(idade.getText()), Integer.parseInt(dependentes.getText()), new BigDecimal(contrOficial.getText()), new BigDecimal(totalRendimentos.getText()));
        }
    }
}
