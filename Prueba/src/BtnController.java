import javax.swing.*;

public class BtnController {
    private DataPanel dataPanel;
    private Main panelSimulation;

    public BtnController(DataPanel dataPanel, Main panelSimulation) {
        this.dataPanel = dataPanel;
        this.panelSimulation = panelSimulation;
        listener();
    }

    public void listener(){
        dataPanel.getBtnPlay().addActionListener(e -> {
            try {
                Integer radio = Integer.parseInt(dataPanel.getRadioInput().getText());
                panelSimulation.setRadius(radio); // Set the new radius
                panelSimulation.repaint(); // Trigger repaint with the updated radius

                // Other actions based on velocity can be added here
            } catch (NumberFormatException ex) {
                // Handle the case when the input is not a valid integer
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
        });
    }


}
