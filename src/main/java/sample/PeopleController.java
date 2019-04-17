package sample;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class PeopleController {
    private final String[] names = new String[]{
            "Попов Алексей Сергеевич",
            "Кустурица Антон Павлович",
            "Раевская Антонина Анатольевна",
            "Екатеринов Роман Валерьевич",
            "Тихая Александра Леонидовна"
    };

    private Controller controller;

    public void setController (Controller controller) {
        this.controller = controller;
    }

    @FXML
    private MenuButton ruk, prov, kass, brig, sot2, sot3;

    @FXML
    private TextField rukTxt, provTxt, kassTxt, brigTxt, sot2Txt, sot3Txt;

    @FXML
    public void initialize () {
        rukTxt.setText(controller.rukovoditel);
        provTxt.setText(controller.proveril);
        kassTxt.setText(controller.cassir);
        brigTxt.setText(controller.brigadir);
        sot2Txt.setText(controller.sotr2);
        sot3Txt.setText(controller.sotr3);

        MenuButton[] menuButtons = new MenuButton[] {
                ruk, prov, kass, brig, sot2, sot3
        };

        final TextField[] textFields = new TextField[] {
            rukTxt, provTxt, kassTxt, brigTxt, sot2Txt, sot3Txt
        };

        for (int i = 0; i < menuButtons.length; i++) {
            for (int j = 0; j < names.length; j++) {
                final MenuItem menuItem = new MenuItem(names[j]);
                final int finalI = i;
                menuItem.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        textFields[finalI].setText(menuItem.getText());
                    }
                });
                menuButtons[i].getItems().add(menuItem);
            }
        }
    }
}
