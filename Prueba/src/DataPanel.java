import javax.swing.*;
import java.awt.*;

public class DataPanel extends JPanel {
    private JButton btnPlay;
    private JLabel radio;
    private JLabel velocity;
    private JTextArea radioInput;
    private JTextArea velocityInput;

    public DataPanel() {
        btnPlay = new JButton("Play");
        radio = new JLabel("Radio");
        velocity = new JLabel("Velocidad");
        radioInput = new JTextArea();
        velocityInput = new JTextArea();

        setPreferredSize(new Dimension(250, 400)); // Ajusta el ancho del panel

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Fila 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(radio, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        radioInput.setPreferredSize(new Dimension(150, 30)); // Ajusta el tamaño del JTextArea
        add(radioInput, gbc);

        // Fila 2
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(velocity, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        velocityInput.setPreferredSize(new Dimension(150, 30)); // Ajusta el tamaño del JTextArea
        add(velocityInput, gbc);

        // Fila 3
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnPlay, gbc);
    }

    public JButton getBtnPlay() {
        return btnPlay;
    }

    public void setBtnPlay(JButton btnPlay) {
        this.btnPlay = btnPlay;
    }

    public JLabel getRadio() {
        return radio;
    }

    public void setRadio(JLabel radio) {
        this.radio = radio;
    }

    public JLabel getVelocity() {
        return velocity;
    }

    public void setVelocity(JLabel velocity) {
        this.velocity = velocity;
    }

    public JTextArea getRadioInput() {
        return radioInput;
    }

    public void setRadioInput(JTextArea radioInput) {
        this.radioInput = radioInput;
    }

    public JTextArea getVelocityInput() {
        return velocityInput;
    }

    public void setVelocityInput(JTextArea velocityInput) {
        this.velocityInput = velocityInput;
    }
}
