package by.bsuir.lab1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    public Label isosceles;
    @FXML
    public Label equilateral;
    @FXML
    public Label rectangular;
    @FXML
    public TextField side1;
    @FXML
    public TextField side2;
    @FXML
    public TextField side3;
    @FXML
    private Label info;

    private static final String YES = "Да";
    private static final String NO = "Нет";

    @FXML
    protected void onCheckButtonClick() {
        try {
            int sideOneIntValue = Integer.parseInt(side1.getText());
            int sideTwoIntValue = Integer.parseInt(side2.getText());
            int sideThreeIntValue = Integer.parseInt(side3.getText());

            if (!(sideOneIntValue + sideTwoIntValue > sideThreeIntValue &&
                    sideOneIntValue + sideThreeIntValue > sideTwoIntValue &&
                    sideTwoIntValue + sideThreeIntValue > sideOneIntValue)) {
                throw new IllegalArgumentException("Треугольник с такими сторонами не существует!");
            }

            rectangular.setText(isRectangular(sideOneIntValue, sideTwoIntValue, sideThreeIntValue) ?
                    YES :
                    NO
                    );
            isosceles.setText(isIsosceles(sideOneIntValue, sideTwoIntValue, sideThreeIntValue) ?
                    YES :
                    NO
            );
            equilateral.setText(isEquilateral(sideOneIntValue, sideTwoIntValue, sideThreeIntValue) ?
                    YES :
                    NO
            );

        } catch (NumberFormatException e) {
            info.setText("Проверьте что все поля заполнены только числами! " + e.getMessage());
        } catch (IllegalArgumentException e) {
            info.setText(e.getMessage());
        }
    }


    private boolean isIsosceles(int a, int b, int c) {
        return a == b || b == c || a == c;
    }

    private boolean isEquilateral(int a, int b, int c) {
        return a == b && b == c;
    }

    private boolean isRectangular(int a, int b, int c) {
        return (a*a == b*b + c*c) || (b*b == a*a + c*c) || (c*c == a*a + b*b);
    }
}