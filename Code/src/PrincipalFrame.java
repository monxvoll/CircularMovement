import javax.swing.*;
import java.awt.*;

public class PrincipalFrame extends JFrame {
    private BtnController btnController;

    Main mainPanel;
    DataPanel dataPanel;

    public PrincipalFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Instanciar Main y DataPanel
        mainPanel = new Main();
        dataPanel = new DataPanel();
        btnController = new BtnController(dataPanel , mainPanel);


        // Configurar el diseño del frame
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        add(dataPanel, BorderLayout.WEST);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PrincipalFrame());
    }
}
