
package timeraplikacija;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;
import javax.swing.Icon;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.colorchooser.AbstractColorChooserPanel;

/**
 *
 * @author Arijana Knezevic
 */
public class CustomizedChooserRGB extends AbstractColorChooserPanel {
    
JTextField r;
JTextField g;
JTextField b;
JButton chooseColor;
JLabel inputErrorReport;


public void CustomizedChooserRGB () {};
    @Override
    public void updateChooser() {
        
    }

    @Override
    protected void buildChooser() {
        r = new JTextField ("0", 3);
        g = new JTextField ("0", 3);
        b = new JTextField ("0", 3);
        chooseColor = new JButton("OK");
        inputErrorReport = new JLabel();
        Dimension errReport = new Dimension (400,60);
        inputErrorReport.setPreferredSize(errReport);
        chooseColor.addActionListener((ActionEvent event)->
                {
                    if (Pattern.matches("[0-9]{1,3}", r.getText()) && Pattern.matches("[0-9]{1,3}", g.getText()) && Pattern.matches("[0-9]{1,3}", b.getText())) {    
                    if (Integer.parseInt(r.getText())<256 && Integer.parseInt(g.getText())<256 && Integer.parseInt(b.getText())<256) {
                    getColorSelectionModel().setSelectedColor(new Color (
                    Integer.parseInt(r.getText()), Integer.parseInt(g.getText()), Integer.parseInt(b.getText()) )
                    );
                    }
                    else {inputErrorReport.setText("Please enter numbers between 0 and 255");}
                    }
                    else {inputErrorReport.setText("Please enter three numbers in each field");}
                }
        );
        
        add(r);
        add(g);
        add(b);
        add(chooseColor);
        add(inputErrorReport);
    }

    @Override
    public String getDisplayName() {
       return "RGB selector";
    }

    @Override
    public Icon getSmallDisplayIcon() {
       return null;
    }

    @Override
    public Icon getLargeDisplayIcon() {
       return null;
    }   
}
