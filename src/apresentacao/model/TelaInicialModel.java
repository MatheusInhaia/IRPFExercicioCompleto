package apresentacao.model;

import apresentacao.App;

public class TelaInicialModel {


    public App app = new App();



    public void acessarCalculaImposto()throws Exception{
        app.loadScene("FXML/completo.fxml","Calculo completo");
    }

    public void acessarListarContribuinte()throws Exception{
        app.loadScene("FXML/Simplificado.fxml","Calculo simplificado");
    }



}
