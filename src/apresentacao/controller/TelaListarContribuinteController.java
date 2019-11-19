package apresentacao.controller;

import apresentacao.model.TelaListarContribuinteModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;

public class TelaListarContribuinteController {
    public TableView<PessoaImpostoGenerica> tabela;
    public TableColumn<PessoaImposto, String> Tnome;
    public TableColumn<PessoaImposto, String> Tcpf;
    public TableColumn<PessoaImposto, Integer> Tidade;
    public TableColumn<PessoaImposto, Integer> Tdep;
    public TableColumn<PessoaImposto, BigDecimal> Tcontr;
    public TableColumn<PessoaImposto, BigDecimal> TRendimentos;
    public TableColumn<PessoaImposto, BigDecimal> Tvalor;

    public Button voltar;


    public TelaListarContribuinteModel telaListarContribuinteModel = new TelaListarContribuinteModel();

    public void clicarVoltar()throws Exception{
        telaListarContribuinteModel.voltarATelainicial();
    }


    public void initialize(){
        Tnome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        Tcpf.setCellValueFactory(new PropertyValueFactory<>("Cpf"));
        Tidade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        Tdep.setCellValueFactory(new PropertyValueFactory<>("Dependentes"));
        Tcontr.setCellValueFactory(new PropertyValueFactory<>("Contribuição oficial"));
        TRendimentos.setCellValueFactory(new PropertyValueFactory<>("Total de rendimentos"));
        Tvalor.setCellValueFactory(new PropertyValueFactory<>("valor a pagar"));
        tabela.setItems(telaListarContribuinteModel.listaDeClientes());
    }
}
