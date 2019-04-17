package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Controller {
    public static String rukovoditel, proveril, cassir, brigadir, sotr2, sotr3;

    @FXML
    private TextField itogIProdajiRub, itogIProizvodRub;

    @FXML
    private TextField summaZaObshieProdRub,
            summaZaPorcProdRub,
            summaZaObediProdRub;

    @FXML
    private TextField summaZaObshieProizvodRub,
            summaZaPorcProizvodRub,
            summaZaObediProizvodRub;

    @FXML
    private TextField sotrudPoCenamRub,
            sotrudPoProizvodRub,
            filialCenamRub,
            filialProizvodRub;

    @FXML
    private TextField topFinalProdRub,
            topFinalProizvRub;

    @FXML
    private TextField percentOfSpec, percentOfSol,
            specRub, solRub,
            solTotalRub, finalResult;
    @FXML
    public void initialize () {
    }

    @FXML
    public void update () {
        updateIIchetvert();
        updateIchetvrert();
        updateSubTotal();
        updateSpec();
        updateSault();
        updateSolTotal();
        finalUpdate();
    }

    private void finalUpdate() {
        double result = convertVoidDouble(topFinalProdRub) + convertVoidDouble(topFinalProizvRub);
        finalResult.setText(String.valueOf(new BigDecimal(result).setScale(2, RoundingMode.UP).doubleValue()));
    }

    private void updateSubTotal() {
        double rub = convertVoidDouble(itogIProdajiRub) + convertVoidDouble(sotrudPoCenamRub) +
                convertVoidDouble(filialCenamRub);
        topFinalProdRub.setText(String.valueOf(rub));

        rub = convertVoidDouble(itogIProizvodRub) + convertVoidDouble(sotrudPoProizvodRub) +
                convertVoidDouble(filialProizvodRub);
        topFinalProizvRub.setText(String.valueOf(rub));
    }

    private void updateSolTotal () {
        double rub = convertVoidDouble(solRub) + convertVoidDouble(specRub);
        solTotalRub.setText(String.valueOf(rub));
    }

    private void updateSault () {
        double spec = convertVoidDouble(percentOfSol);
        double res = Double.parseDouble(topFinalProizvRub.getText());
        res = res / 100 * spec;
        int rub = (int) res;
        int kop = (int)(res * 100) % 100;
        solRub.setText(String.valueOf(rub));
    }

    private void updateSpec () {
        double spec = convertVoidDouble(percentOfSpec);
        double res = Double.parseDouble(topFinalProizvRub.getText());
        res = res / 100 * spec;
        int rub = (int) res;
        int kop = (int)(res * 100) % 100;
        specRub.setText(String.valueOf(rub));
    }

    private void updateChetvert (TextField[] textFields) {
        double rub = convertVoidDouble(textFields[0]) + convertVoidDouble(textFields[1]) +
                convertVoidDouble(textFields[2]);
        textFields[3].setText(String.valueOf(rub));
    }

    private void updateIIchetvert () {
        TextField[] textFields = new TextField[] {
                summaZaObshieProdRub,
                summaZaPorcProdRub,
                summaZaObediProdRub,
                itogIProdajiRub
        };
        updateChetvert(textFields);
    }

    private void updateIchetvrert () {
        TextField[] textFields = new TextField[] {
                summaZaObshieProizvodRub,
                summaZaPorcProizvodRub,
                summaZaObediProizvodRub,
                itogIProizvodRub
        };
        updateChetvert(textFields);
    }

    private double convertVoidDouble (TextField textField) {
        String text = textField.getText();
        text = text.replace(' ', '.');
        text = text.replace(',', '.');
        if (text.equals("")) {
            return 0;
        } else {
            double value = Double.parseDouble(text);
            double newDouble = new BigDecimal(value).setScale(2, RoundingMode.DOWN).doubleValue();
            return newDouble;
        }
    }

    @FXML
    private void showPeopleAddForm() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addPeople.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PeopleController peopleController = fxmlLoader.getController();
        peopleController.setController(this);
        Stage selectStage = new Stage();
        selectStage.initModality(Modality.APPLICATION_MODAL);
        selectStage.setTitle("Ответственные люди");
        selectStage.setScene(new Scene(root, 754, 403));
        selectStage.show();
    }

    @FXML
    private TextField organization, OKPO, podrazdel, OKDP;

    @FXML
    public void addMaveric () {
        organization.setText("ООО Маверик");
        OKPO.setText("12321");
    }

    @FXML
    public void addMuravei () {
        organization.setText("ЗАО Муравейник");
        OKPO.setText("12325");
    }

    @FXML
    public void addZ () {
        podrazdel.setText("Отдел З");
        OKDP.setText("123");
    }

    @FXML
    public void addM () {
        podrazdel.setText("Отдел М");
        OKDP.setText("124");
    }



}
