import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JPanel implements ActionListener {

    private int centerX;
    private int centerY;
    private int squareSize;
    private int squareX;
    private int squareY;
    private int radius;
    private double angle = 0;
    private Timer timer;
    private final int divisions = 20; // Número de divisiones en cada eje

    private JButton startButton;
    private static DataPanel dataPanel;
    private boolean isRunning = false;

    public Main() {
        timer = new Timer(20, this);
        dataPanel = new DataPanel();

        startButton = new JButton("Iniciar");
        startButton.setPreferredSize(new Dimension(100, 40));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isRunning = !isRunning;
                if (isRunning) {
                    startButton.setText("Detener");
                    timer.start();
                } else {
                    startButton.setText("Iniciar");
                    timer.stop();
                }
            }
        });

        setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(startButton);

        setPreferredSize(new Dimension(800, 500));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Calcular el tamaño del cuadrado y sus coordenadas
        squareSize = Math.min(getWidth(), getHeight()) - 20;
        squareX = 10;
        squareY = (getHeight() - squareSize) / 2;

        // Dibujar el cuadrado
        g2d.setColor(Color.BLUE);
        g2d.drawRect(squareX, squareY, squareSize, squareSize);

        // Establecer el centro del cuadrado como (0, 0)
        centerX = squareX + squareSize / 2;
        centerY = squareY + squareSize / 2;

        // Dibujar plano cartesiano
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.drawLine(0, centerY, getWidth(), centerY); // Eje X
        g2d.drawLine(centerX, 0, centerX, getHeight()); // Eje Y

        // Calcular el radio del círculo
        radius = squareSize / 2;

        // Calcular el espaciado entre las divisiones
        int divisionSpacingX = squareSize / (divisions * 2);
        int divisionSpacingY = squareSize / (divisions * 2);

        // Dibujar divisiones y valores en el eje X
        for (int i = -divisions; i <= divisions; i += 2) {
            int x = centerX + i * divisionSpacingX;
            g2d.drawLine(x, centerY - 5, x, centerY + 5);
            g2d.drawString(String.valueOf(i), x - 5, centerY + 20);
        }

        // Dibujar divisiones y valores en el eje Y
        for (int i = -divisions; i <= divisions; i += 2) {
            int y = centerY - i * divisionSpacingY;
            g2d.drawLine(centerX - 5, y, centerX + 5, y);
            g2d.drawString(String.valueOf(i), centerX + 10, y + 5);
        }

        // Dibujar círculo en movimiento
        int x = (int) (centerX + radius * Math.cos(angle));
        int y = (int) (centerY - radius * Math.sin(angle)); // Resta en y porque la coordenada Y aumenta hacia abajo
        g2d.setColor(Color.RED);
        g2d.fillOval(x - 10, y - 10, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += 0.05;
        repaint();
    }

    /*public void main(String[] args) {

        JFrame frame = new JFrame("Circular Motion Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Main(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }*/

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getSquareSize() {
        return squareSize;
    }

    public void setSquareSize(int squareSize) {
        this.squareSize = squareSize;
    }

    public int getSquareX() {
        return squareX;
    }

    public void setSquareX(int squareX) {
        this.squareX = squareX;
    }

    public int getSquareY() {
        return squareY;
    }

    public void setSquareY(int squareY) {
        this.squareY = squareY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getDivisions() {
        return divisions;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public static DataPanel getDataPanel() {
        return dataPanel;
    }

    public static void setDataPanel(DataPanel dataPanel) {
        Main.dataPanel = dataPanel;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}