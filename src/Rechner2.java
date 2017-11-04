import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class Rechner2 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField fOperant1 = new JTextField();
	private JLabel operator = new JLabel();
	private JTextField fOperant2 = new JTextField();
	private JButton ergebnisKnopf = new JButton();
	private JButton plusKnopf = new JButton();
	private JButton minusKnopf = new JButton();
	private JButton hoch = new JButton();
	private JButton malKnopf = new JButton();
	private JButton teilKnopf = new JButton();
	private boolean plus;
	private boolean minus;
	private boolean mal;
	private boolean teil;
	private boolean hi;
	private JCheckBox keepInput = new JCheckBox();
	
	private JButton wurzelKnopf = new JButton();
	private boolean wurzel;

	public Rechner2() {

		super();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 500;
		int frameHeight = 300;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setTitle("Rechner2");
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);
		// Anfang Komponenten

		fOperant1.setBounds(20, 40, 80, 40);
		cp.add(fOperant1);
		operator.setBounds(120, 40, 40, 40);
		operator.setFont(new Font("Dialog", Font.PLAIN, 20));
		operator.setHorizontalAlignment(SwingConstants.CENTER);
		cp.add(operator);
		fOperant2.setBounds(180, 40, 80, 41);
		cp.add(fOperant2);
		ergebnisKnopf.setBounds(280, 40, 50, 40);
		ergebnisKnopf.setText("=");
		ergebnisKnopf.setMargin(new Insets(2, 2, 2, 2));
		ergebnisKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ergebnis_ActionPerformed(evt);
			}
		});
		ergebnisKnopf.setFont(new Font("Dialog", Font.BOLD, 20));
		cp.add(ergebnisKnopf);

		plusKnopf.setBounds(25, 125, 50, 50);
		plusKnopf.setText("+");
		plusKnopf.setMargin(new Insets(2, 2, 2, 2));
		plusKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				plusKnopf_ActionPerformed(evt);
			}
		});
		plusKnopf.setFont(new Font("Dialog", Font.BOLD, 20));
		cp.add(plusKnopf);

		minusKnopf.setBounds(25, 200, 50, 50);
		minusKnopf.setText("-");
		minusKnopf.setMargin(new Insets(2, 2, 2, 2));
		minusKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				minusKnopf_ActionPerformed(evt);
			}
		});
		minusKnopf.setFont(new Font("Dialog", Font.BOLD, 20));
		cp.add(minusKnopf);
		malKnopf.setBounds(100, 125, 50, 50);
		malKnopf.setText("X");
		malKnopf.setMargin(new Insets(2, 2, 2, 2));
		malKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				malKnopf_ActionPerformed(evt);
			}
		});
		malKnopf.setHorizontalTextPosition(SwingConstants.CENTER);
		malKnopf.setFont(new Font("Dialog", Font.BOLD, 18));
		cp.add(malKnopf);
		teilKnopf.setBounds(100, 200, 50, 50);
		teilKnopf.setText("/");
		teilKnopf.setMargin(new Insets(2, 2, 2, 2));
		teilKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				teilKnopf_ActionPerformed(evt);
			}
		});
		teilKnopf.setFont(new Font("Dialog", Font.BOLD, 18));
		cp.add(teilKnopf);
		hoch.setBounds(175, 125, 50, 50);
		hoch.setText("^");
		hoch.setMargin(new Insets(2, 2, 2, 2));
		hoch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				hoch_ActionPerformed(evt);
			}
		});
		hoch.setHorizontalTextPosition(SwingConstants.CENTER);
		hoch.setFont(new Font("Dialog", Font.BOLD, 20));
		cp.add(hoch);

		wurzelKnopf.setBounds(175, 200, 50, 50);
		wurzelKnopf.setText("√");
		wurzelKnopf.setMargin(new Insets(2, 2, 2, 2));
		wurzelKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				wurzelKnopf_ActionPerformed(evt);

			}
		});
		wurzelKnopf.setFont(new Font("Dialog", Font.BOLD, 18));
		cp.add(wurzelKnopf);
		
		keepInput.setBounds(350, 45, 89, 30);
	    keepInput.setOpaque(false);
	    keepInput.setText("keep input");
	    cp.add(keepInput);
		// Ende Komponenten

		setVisible(true);
	} // end of public Rechner2

	// Anfang Methoden

	public static void main(String[] args) {
		new Rechner2();
	} // end of main

	public void responseFunktion(String ergebnisB) {

		JOptionPane.showMessageDialog(Rechner2.this, "Ergebnis: " + ergebnisB, "Berechnung",
				JOptionPane.INFORMATION_MESSAGE);

	}

	// end of ergebnis_ActionPerformed

	public JLabel getOperator() {
		return operator;
	}

	public void setOperator(JLabel operator) {
		this.operator = operator;
	}

	public void plusKnopf_ActionPerformed(ActionEvent evt) {
		operator.setText("+");
		plus = true;
		minus = false;
		wurzel = false;
		mal = false;
		teil = false;
		hi = false;
	} // end of plusKnopf_ActionPerformed

	public void minusKnopf_ActionPerformed(ActionEvent evt) {
		operator.setText("-");
		minus = true;
		plus = false;
		mal = false;
		teil = false;
		hi = false;
		wurzel = false;
	} // end of minusKnopf_ActionPerformed

	public void malKnopf_ActionPerformed(ActionEvent evt) {
		operator.setText("X");
		mal = true;
		plus = false;
		minus = false;
		teil = false;
		hi = false;
		wurzel = false;
	} // end of malKnopf_ActionPerformed

	public void teilKnopf_ActionPerformed(ActionEvent evt) {
		operator.setText("/");
		teil = true;
		plus = false;
		minus = false;
		mal = false;
		hi = false;
		wurzel = false;
	}

	public void hoch_ActionPerformed(ActionEvent evt) {
		operator.setText("^");
		teil = false;
		plus = false;
		minus = false;
		mal = false;
		hi = true;
		wurzel = false;
	}// end of teilKnopf_ActionPerformed

	public void wurzelKnopf_ActionPerformed(ActionEvent evt) {
		operator.setText("âˆš");
		teil = false;
		plus = false;
		minus = false;
		mal = false;
		hi = false;
		wurzel = true;

	}

	public void ergebnis_ActionPerformed(ActionEvent evt) {
		int op1;
		int op2;
		double ergebnisZ = 0;

		op1 = Integer.parseInt(fOperant1.getText());
		op2 = Integer.parseInt(fOperant2.getText());
		if ( plus ) {

			ergebnisZ = op1 + op2;
			responseFunktion(Double.toString(ergebnisZ));
		} else if ( minus ) {
			ergebnisZ = op1 - op2;
			responseFunktion(Double.toString(ergebnisZ));
		} else if ( teil ) {
			if ( !(Integer.parseInt(fOperant2.getText()) == 0) ) {
				ergebnisZ = op1 / op2;
				responseFunktion(Double.toString(ergebnisZ));
			} else if ( (Integer.parseInt(fOperant2.getText()) == 0) ) {
				responseFunktion("Stell dir vor, du hast " + fOperant1.getText() + " Kekse und verteile sie gleichmäßig auf " + fOperant2.getText() + " Freunde. Wie viele Kekse bekommt jeder? Siehst du? Das macht keinen Sinn! Und du bist traurig weil du keine Freunde hast");
			}
		} else if ( mal ) {
			if ( !(Integer.parseInt(fOperant1.getText()) == 0 || Integer.parseInt(fOperant2.getText()) == 0) )
				ergebnisZ = op1 * op2;
			responseFunktion(Double.toString(ergebnisZ));

		} else if ( hi ) {
			ergebnisZ = Math.pow(op1, op2);
			responseFunktion(Double.toString(ergebnisZ));
		} else if ( wurzel ) {

			if ( op1 == 2 ) {

				ergebnisZ = Math.sqrt(op2);
				responseFunktion(Double.toString(ergebnisZ));
			} else if ( op1 == 3 ) {

				ergebnisZ = Math.cbrt(op2);
				responseFunktion(Double.toString(ergebnisZ));

			}

		}
		if ( !keepInput.isSelected() ) {
			fOperant1.setText("");
			fOperant2.setText("");
			operator.setText("");
		}

	}
		
		// Ende Methoden
} // end of class Rechner2
