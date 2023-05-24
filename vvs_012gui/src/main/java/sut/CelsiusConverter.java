package sut;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import sampleGUI.MainWindow;


/**
 * A simple application to convert Celsius degrees into Fahrenheit and back.
 * This is an adapted version from a similar example by Robi Malik
 * which itself was an adapted version from a similar example in the
 * Swing Tutorial.
 * 
 * ref: https://www.cs.waikato.ac.nz/~bernhard/204/code/week8/example3/CelsiusConverter.java
 */
@SuppressWarnings("serial")
public class CelsiusConverter extends JFrame
{

	/**
	 * The labels for the text fields.
	 * They always display the word "Celsius" / "Fahrenheit".
	 */
	private JLabel _celsiusLabel;
	private JLabel _fahrenheitLabel;
	
	/**
	 * The text fields for entering the number of degrees to be converted.
	 */
	private JTextField _inputC;
	private JTextField _inputF;

	/**
	 * The <STRONG>Convert</STRONG> buttons.
	 * When clicked, the Celsius / Fahrenheit value is read from the 
	 * correspondin text field and converted.
	 */
	private JButton _convertC2FButton;
	private JButton _convertF2CButton;


  /**
   * Creates a Celsius Converter window and initialises all its
   * components.
   */
  CelsiusConverter() {
    super("Convert Celsius to Fahrenheit and back");

    Container content = getContentPane();
    LayoutManager layout = new GridLayout(3, 2);
    content.setLayout(layout);

    _celsiusLabel = new JLabel("Celsius");
    _fahrenheitLabel = new JLabel("Fahrenheit");
    _inputC = new JTextField(10);
    _inputC.setName("inputC");
    _inputF = new JTextField(10);
    _inputF.setName("inputF");
    _convertC2FButton = new JButton("C->F");
    _convertF2CButton = new JButton("F->C");

    Font font = new Font("SansSerif", 0, 20);
    content.setFont(font);
    _inputC.setFont(null);
    _inputF.setFont(null);
    _celsiusLabel.setFont(null);
    _fahrenheitLabel.setFont(null);
    _convertC2FButton.setFont(null);
    _convertF2CButton.setFont(null);


    Border borderCelsius = BorderFactory.createEmptyBorder(2, 5, 1, 0);
    _celsiusLabel.setBorder(borderCelsius);
    Border borderFahrenheit = BorderFactory.createEmptyBorder(1, 5, 2, 0);
    _fahrenheitLabel.setBorder(borderFahrenheit);

    ActionListener celsiusListener = new ConvertCelsiusListener();
    _convertC2FButton.addActionListener(celsiusListener);
    _inputC.addActionListener(celsiusListener);

    ActionListener fahrenheitListener = new ConvertFahrenheitListener();
    _convertF2CButton.addActionListener(fahrenheitListener);
    _inputF.addActionListener(fahrenheitListener);

    content.add(_celsiusLabel);
    content.add(_fahrenheitLabel);
    content.add(_inputC);
    content.add(_inputF);
    content.add(_convertC2FButton);
    content.add(_convertF2CButton);

  }


  /**
   * A main method to show and run the Celsius Converter.
   *
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
	  public void run() {
	    CelsiusConverter gui = new CelsiusConverter();
	    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gui.pack();
	    gui.setVisible(true);
	  }
        }
	);
  }*/
  
  
  public static void main(String[] args) {
      showWindow();
  }

  /**
   * Internal standard method to initialize the view, returning the main JFrame (also to be used in automated tests).
   *
   * @return initialized JFrame instance
   */
  public static CelsiusConverter showWindow() {
	  CelsiusConverter mainWindow = new CelsiusConverter();
	  mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  mainWindow.pack();
	  mainWindow.setVisible(true);
	  return mainWindow;
  }  


  /**
   * An action listener for the <STRONG>Convert</STRONG> button.
   * This action listener is associated both with the <STRONG>Convert</STRONG>
   * button and with the converter's text field, so the Fahrenheit display
   * gets updated whenever the button is pressed, or the user hits
   * <CODE>&lt;Enter&gt;</CODE> on the text field.
   */
  private class ConvertCelsiusListener implements ActionListener {

    /**
     * Called when the <STRONG>Convert</STRONG> button is pressed.
     * This method reads the contents of the text field, converts
     * the number from Celsius degrees to Fahrenheit, and displays
     * the result in the Fahrenheit label.
     */
    public void actionPerformed(ActionEvent event) {
      String celsiusText = _inputC.getText();
      double celsius = Double.parseDouble(celsiusText);
      double fahrenheit = celsius * 9 / 5 + 32;
      String fahrenheitText = String.format("%.1f",fahrenheit);
      _inputF.setText(fahrenheitText);
    }
  }

  private class ConvertFahrenheitListener implements ActionListener {

    /**
     * Called when the <STRONG>Convert</STRONG> button is pressed.
     * This method reads the contents of the text field, converts
     * the number from Celsius degrees to Fahrenheit, and displays
     * the result in the Fahrenheit label.
     */
    public void actionPerformed(ActionEvent event) {
      String fahrenheitText = _inputF.getText();
      double fahrenheit = Double.parseDouble(fahrenheitText);
      double celsius = (fahrenheit-32) * 5 / 9;
      String celsiusText = String.format("%.1f",celsius);
      _inputC.setText(celsiusText);
    }
  }
  
}
