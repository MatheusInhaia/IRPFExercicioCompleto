package apresentacao.controller;

import apresentacao.model.TelaInicialModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class TelaInicialController {

    public Pane telainicial;
    public Button calcular;
    public Button visualizar;
    public TelaInicialModel tim = new TelaInicialModel();

    @FXML
    public void initialize() {

    }

    public void clicarBotaoCalcular() throws Exception{
        tim.acessarCalculaImposto();
    }
}
