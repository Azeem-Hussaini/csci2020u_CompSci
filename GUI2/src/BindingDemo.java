import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BindingDemo {

    public static void main(String[] args) {
        DoubleProperty d1 = new SimpleDoubleProperty(1);
        DoubleProperty d2 = new SimpleDoubleProperty(2);

        System.out.println(d1.getValue());
        System.out.println(d2.getValue());
        d1.bind(d2.multiply(2));

        d2.setValue(4);
        System.out.println(d1.getValue());
        System.out.println(d2.getValue());

//        d1.setValue(8);
//
//        System.out.println(d1.getValue());
//        System.out.println(d2.getValue());

    }
}
