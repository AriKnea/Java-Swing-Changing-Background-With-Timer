package timeraplikacija;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import javax.swing.JOptionPane;


public class TimerAplikacija {

    
    public static void main(String[] args) {
        
        int chosenButton = JOptionPane.showOptionDialog (null, "Choose option", "Option dialog", JOptionPane.YES_NO_CANCEL_OPTION
        , JOptionPane.QUESTION_MESSAGE, null, new String [] {"Settings", "Close"}, null);
        
        switch (chosenButton)  
        {
            case JOptionPane.YES_OPTION:
            JFrame form = new OptionsForm();
            form.setVisible(true);
            break;
                
            case JOptionPane.NO_OPTION:
            Frame parentFrame = JOptionPane.getRootFrame();
            parentFrame.dispatchEvent(new WindowEvent(parentFrame, WindowEvent.WINDOW_CLOSING));
            break;
        }
    } 
}