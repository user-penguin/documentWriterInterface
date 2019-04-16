package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField itogIProdajiRub, itogIProdajiKop,
            itogIProizvodRub, itogIProizvodKop,
            summaZaObshieProdRub, summaZaObshieProdKop,
            summaZaPorcProdRub, summaZaPorcProdKop,
            summaZaObediProdRub, summaZaObediProdKop;

    @FXML
    public void initialize () {

    }

    @FXML
    public void update () {
        updateIIchetvert();
    }

    private void updateIIchetvert () {
        int allKop = convertVoid(summaZaObediProdKop) + convertVoid(summaZaPorcProdKop) + convertVoid(summaZaObshieProdKop);
        int realKop = allKop % 100;
        int ostKop = allKop / 100;
        int rub = convertVoid(summaZaObediProdRub) + convertVoid(summaZaPorcProdRub) +
                convertVoid(summaZaObshieProdRub) + ostKop;
        itogIProdajiRub.setText(String.valueOf(rub));
        itogIProdajiKop.setText(String.valueOf(realKop));
    }

    private int convertVoid (TextField textField) {
        if (textField.getText().equals("")) {
            return 0;
        } else {
            return Integer.parseInt(textField.getText());
        }
    }
}
