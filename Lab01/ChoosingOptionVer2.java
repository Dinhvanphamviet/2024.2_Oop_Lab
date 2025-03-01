import javax.swing.JOptionPane;

public class ChoosingOptionVer2 {
    public static void main(String[] args) {
        Object[] options = {"Yes", "No"}; 

        int option = JOptionPane.showOptionDialog(null, 
                "Do you want to change to the first class ticket?", 
                "Choose Option",
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[0]);

        String chosenOption = (option == JOptionPane.YES_OPTION) ? "Yes" : "No"; 

        JOptionPane.showMessageDialog(null, "You've chosen: " + chosenOption);

        System.exit(0);
    }
}