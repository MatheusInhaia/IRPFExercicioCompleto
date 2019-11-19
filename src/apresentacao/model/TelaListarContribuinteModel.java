package apresentacao.model;

import apresentacao.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TelaListarContribuinteModel {

    public App app = new App();


    public ObservableList<PessoaImpostoGenerica> listaDeClientes() {
        ObservableList<PessoaImpostoGenerica> pessoas = FXCollections.observableArrayList();
        for(PessoaImposto p: RelacaoDePessoas.listarContas()){
            pessoas.add(new PessoaImpostoGenerica(p));
        }
        return pessoas;
    }

    public void voltarATelainicial()throws Exception{
        app.loadScene("FXML/TelaInicial.fxml", "Bem Vindo");
    }
}
