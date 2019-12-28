package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.util.Util;


public class Controller {

    
    public TextField tfwidth;
    public TextField tfPath;
    public TextField tfHeight;
    public TextField tfPrefix;
    public Button btnFitGoole;
    public Button btnFitWH;
    public Button btnRename;
    public Button btnFeature;

    public Button[] btnList = new Button[]{
            btnFitGoole, btnFitWH, btnRename, btnFeature
    };

    public void generateGoogle(ActionEvent actionEvent) {
        System.out.println("actionEvent.getSource() = " + actionEvent.getSource());
      //  enableOnlyOne(0);
        String path = getPath();
        String res = ImagesController.fitGooglePlay(path);
        Util.showMessage(res);
      //  enableAll();
    }

    private String getPath() {
        return tfPath.getText();
    }

    public void generateFeature(ActionEvent actionEvent) {
        enableOnlyOne(3);
        String path = tfPath.getText();
        String res = ImagesController.resizeAsGraphicFeature(path);
        Util.showMessage(res);
        enableAll();
    }

    public void enableAll() {
        /*for (Button button : btnList) {
            button.setDisable(false);
        }*/
    }
    public void enableOnlyOne(int pos){
       /* for (int i = 0; i < btnList.length; i++) {
            if (pos != i){
                btnList[i].setDisable(true);
            }
        }*/
    }

    public void changeWithSpecWH(ActionEvent actionEvent) {
        String path = getPath();
        int w ;
        int h ;
        try {
            System.out.println(" = " +tfHeight.getText());
            w = Integer.parseInt(tfwidth.getText());
            h = Integer.parseInt(tfHeight.getText());
            String res = ImagesController.resize(path,w,h);
            Util.showMessage(res);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            Util.showMessage("Enter numeric data.!!");
        }
    }

    public void rename(ActionEvent actionEvent) {
        String path = getPath();
        String prefix = tfPrefix.getText();
        if (prefix.isEmpty()) {
            Util.showMessage("add prefix text");
            return;
        }
        String res = ImagesController.renameAll(path , prefix);
        Util.showMessage(res);

    }
}
