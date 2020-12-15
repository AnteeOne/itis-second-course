import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WebController extends Application implements Initializable {

    @FXML private WebView webView;
    @FXML private Button onPreviousButton;
    @FXML private Button onNextButton;
    @FXML private Button onGoButton;
    @FXML private TextField addressBar;
    @FXML private Text statusBar;


    private enum StatusCodes{
        ERROR,
        OK,
        WRONG_URL,
        CONNECTION_ERROR
    }

    private final String DEFAULT_ADDRESS = "https://google.com";

    private ArrayList<String> historyNavigation = new ArrayList<>();
    private int currentPosition;


    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("web.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onStart();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void onStart(){
        loadURL(DEFAULT_ADDRESS);
        historyNavigation.add(DEFAULT_ADDRESS);
        updateAddressBar();
    }

    public void onPrevious(){
        if(currentPosition != 0){
            currentPosition--;
            loadURLFromHistory(currentPosition);
            updateAddressBar();
        }
    }

    public void onNext(){
        if(currentPosition != historyNavigation.size() - 1){
            currentPosition++;
            loadURLFromHistory(currentPosition);
            updateAddressBar();
        }
    }

    public void onGo(){
        String onGoURL = addressBar.getText();
        loadURL(onGoURL);
        historyNavigation.add(onGoURL);
        currentPosition = historyNavigation.size() - 1;
    }

    private void updateAddressBar(String text){
        addressBar.setText(text);
    }

    private void updateAddressBar(){
        addressBar.setText(historyNavigation.get(currentPosition));
    }

    private void updateStatusBar(String text){
        statusBar.setText(text);
    }

    private void loadURL(String url){
        try {
            URL urlFromString = new URL(url);
            webView.getEngine().load(url);
            updateStatusBar(StatusCodes.OK.name());
        }
        catch (MalformedURLException e){
            updateStatusBar(StatusCodes.WRONG_URL.name());
        }

    }

    private void loadURLFromHistory(int position){
        this.loadURL(historyNavigation.get(position));
    }
}
