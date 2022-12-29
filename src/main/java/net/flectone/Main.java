package net.flectone;

import com.formdev.flatlaf.*;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(580, 250));
        frame.add(new GeoPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Нахождение угла и расстояния между 2-мя прямыми в пространстве");
        frame.setIconImage(new ImageIcon(Main.class.getResource("/geo.png")).getImage());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}