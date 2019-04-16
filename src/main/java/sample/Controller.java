package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField itogIProdajiRub, itogIProdajiKop, itogIProizvodRub, itogIProizvodKop;

    @FXML
    private TextField summaZaObshieProdRub, summaZaObshieProdKop,
            summaZaPorcProdRub, summaZaPorcProdKop,
            summaZaObediProdRub, summaZaObediProdKop;

    @FXML
    private TextField summaZaObshieProizvodRub, summaZaObshieProizvodKop,
            summaZaPorcProizvodRub, summaZaPorcProizvodKop,
            summaZaObediProizvodRub, summaZaObediProizvodKop;

    @FXML
    private TextField sotrudPoCenamRub, sotrudPoCenamKop,
            sotrudPoProizvodRub, sotrudPoProizvodKop,
            filialCenamRub, filialCenamKop,
            filialProizvodRub, FilialProizvodKop;

    @FXML
    private TextField topFinalProdRub, topFinalProdKop,
            topFinalProizvRub, topFinalProizvKop;

    @FXML
    public void initialize () {

    }

    @FXML
    public void update () {
        updateIIchetvert();
        updateIchetvrert();
        updateSubTotal();
    }

    private void updateSubTotal() {
        int allKop = convertVoid(itogIProdajiKop) + convertVoid(sotrudPoCenamKop) +
                convertVoid(filialCenamKop);
        topFinalProdKop.setText(String.valueOf(allKop % 100));
        int rub = convertVoid(itogIProdajiRub) + convertVoid(sotrudPoCenamRub) +
                convertVoid(filialCenamRub) + allKop / 100;
        topFinalProdRub.setText(String.valueOf(rub));
        allKop = convertVoid(itogIProizvodKop) + convertVoid(sotrudPoProizvodKop) +
                convertVoid(FilialProizvodKop);
        topFinalProizvKop.setText(String.valueOf(allKop % 100));
        rub = convertVoid(itogIProizvodRub) + convertVoid(sotrudPoProizvodRub) +
                convertVoid(filialProizvodRub) + allKop / 100;
        topFinalProizvRub.setText(String.valueOf(rub));
    }

    private void updateChetvert (TextField[] textFields) {
        int allKop = convertVoid(textFields[0]) + convertVoid(textFields[1]) + convertVoid(textFields[2]);
        int realKop = allKop % 100;
        int ostKop = allKop / 100;
        int rub = convertVoid(textFields[3]) + convertVoid(textFields[4]) +
                convertVoid(textFields[5]) + ostKop;
        textFields[6].setText(String.valueOf(rub));
        textFields[7].setText(String.valueOf(realKop));
    }

    private void updateIIchetvert () {
        TextField[] textFields = new TextField[] {
                summaZaObshieProdKop,
                summaZaPorcProdKop,
                summaZaObediProdKop,
                summaZaObshieProdRub,
                summaZaPorcProdRub,
                summaZaObediProdRub,
                itogIProdajiRub,
                itogIProdajiKop
        };
        updateChetvert(textFields);
    }

    private void updateIchetvrert () {
        TextField[] textFields = new TextField[] {
                summaZaObshieProizvodKop,
                summaZaPorcProizvodKop,
                summaZaObediProizvodKop,
                summaZaObshieProizvodRub,
                summaZaPorcProizvodRub,
                summaZaObediProizvodRub,
                itogIProizvodRub,
                itogIProizvodKop
        };
        updateChetvert(textFields);
    }

    private int convertVoid (TextField textField) {
        if (textField.getText().equals("")) {
            return 0;
        } else {
            return Integer.parseInt(textField.getText());
        }
    }
}
