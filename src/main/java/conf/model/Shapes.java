package conf.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlewicki on 3/29/2017.
 */
public class Shapes {

    public static void main(String[] args)
    {
        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();
        Shape shape3 = new Shape();

        List<Shape> test = new ArrayList<Shape>();
        test.add(shape1);
        test.add(shape2);
        test.add(shape3);

        for (Shape item : test) {
            item.draw();
        }


    }

}
