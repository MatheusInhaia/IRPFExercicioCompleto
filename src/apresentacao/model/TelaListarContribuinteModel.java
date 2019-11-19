package apresentacao.model;

import apresentacao.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import negocio.Contribuinte;
import negocio.IrpfFachada;

public class TelaListarContribuinteModel {

    public App app = new App();


    public ObservableList<Contribuinte> listaDeClientes() throws Exception {
        IrpfFachada irpfFachada = new IrpfFachada();
        ObservableList<Contribuinte> pessoas = FXCollections.observableArrayList();
        for(Contribuinte c: irpfFachada.buscarTodos() ){
            pessoas.add(new Contribuinte(c));
        }
        return pessoas;
    }

    public void voltarATelainicial()throws Exception{
        app.loadScene("FXML/TelaInicial.fxml", "Bem Vindo");
    }
}
