package weather.json;

import javax.swing.*;
import java.awt.*;

public class TemperatureSign extends JComponent {

    public static final int CAR_WIDTH = 20;
    public static final int CAR_HEIGHT = 60;
    private double temperature;
    private double angle = 0;

    public TemperatureSign() {
        setPreferredSize(new Dimension(200, 400));
    }

    @Override
    protected void paintComponent(Graphics g1) {
        super.paintComponent(g1);

        Graphics2D g = (Graphics2D) g1;

        if (temperature > 50) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLUE);
        }

        int width = getWidth();
        int height = getHeight();

        g.drawLine(0, 0, width, height);
        g.drawLine(0, height, width, 0);

        g.drawOval(0, 0, width, height);

        g.setColor(Color.RED);

        //move origin
        g.translate(width / 2, height / 2);

        g.rotate(Math.toRadians(angle));
        angle+= 0.1;

        g.fillRect( -CAR_WIDTH / 2,  -CAR_HEIGHT / 2, 20, 60);

        repaint();

    }

    public void setTemperature(double temperature){
        this.temperature = temperature;
        repaint();
    }
}
