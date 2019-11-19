package apresentacao;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class App extends Application {
    public static Stage primaryStage;
    public static Class thisClass;

    public App(){

        this.thisClass = getClass();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("view/TelaInicial.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Bem Vindo");
        primaryStage.setScene(new Scene(root));//, 400, 230));
        primaryStage.show();
    }

    public void loadScene(String nameFile, String titlePage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nameFile));
        // Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle(titlePage);
        primaryStage.setScene(new Scene(root));//, 400, 230));
        primaryStage.show();




    }
    public static void main(String args[]){
        launch(args);
    }
}
