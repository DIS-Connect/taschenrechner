import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Advanced extends JFrame {

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
	private int status; // 0=+, 1=- 2=*, 3=/ 4=^, 5=root
	private JRadioButton keepInput = new JRadioButton();
	private JRadioButton keepNothing = new JRadioButton();
	private JRadioButton keepresult2 = new JRadioButton();
	private JRadioButton keepresult1 = new JRadioButton();
	private ButtonGroup keepRadioGroup = new ButtonGroup();
	private JButton wurzelKnopf = new JButton();
	private boolean wurzel;
	private JRadioButton keepresult = new JRadioButton();
	private JTextField ergebnisFeld = new JTextField();
	private JPanel advanced = new JPanel();

	public Advanced() {

		super();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 550;
		int frameHeight = 300;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setTitle("Advanced");
		setResizable(false);

		advanced.setLayout(null);
		// Anfang Komponenten

		fOperant1.setBounds(20, 40, 80, 40);
		advanced.add(fOperant1);
		operator.setBounds(120, 40, 40, 40);
		operator.setFont(new Font("Dialog", Font.PLAIN, 20));
		operator.setHorizontalAlignment(SwingConstants.CENTER);
		advanced.add(operator);
		fOperant2.setBounds(180, 40, 80, 41);
		advanced.add(fOperant2);
		ergebnisKnopf.setBounds(280, 40, 50, 40);
		ergebnisKnopf.setText("=");
		ergebnisKnopf.setMargin(new Insets(2, 2, 2, 2));
		ergebnisKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ergebnis_ActionPerformed(evt);

			}
		});
		ergebnisKnopf.setFont(new Font("Dialog", Font.BOLD, 20));
		advanced.add(ergebnisKnopf);

		plusKnopf.setBounds(25, 125, 50, 50);
		plusKnopf.setText("+");
		plusKnopf.setMargin(new Insets(2, 2, 2, 2));
		plusKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				status = 0;
				setOperator();
			}
		});
		plusKnopf.setFont(new Font("Dialog", Font.BOLD, 20));
		advanced.add(plusKnopf);

		minusKnopf.setBounds(25, 200, 50, 50);
		minusKnopf.setText("-");
		minusKnopf.setMargin(new Insets(2, 2, 2, 2));
		minusKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				status = 1;
				setOperator();
			}
		});
		minusKnopf.setFont(new Font("Dialog", Font.BOLD, 20));
		advanced.add(minusKnopf);
		malKnopf.setBounds(100, 125, 50, 50);
		malKnopf.setText("X");
		malKnopf.setMargin(new Insets(2, 2, 2, 2));
		malKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				status = 2;
				setOperator();
			}
		});
		malKnopf.setHorizontalTextPosition(SwingConstants.CENTER);
		malKnopf.setFont(new Font("Dialog", Font.BOLD, 18));
		advanced.add(malKnopf);
		teilKnopf.setBounds(100, 200, 50, 50);
		teilKnopf.setText("/");
		teilKnopf.setMargin(new Insets(2, 2, 2, 2));
		teilKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				status = 3;
				setOperator();
			}
		});
		teilKnopf.setFont(new Font("Dialog", Font.BOLD, 18));
		advanced.add(teilKnopf);
		hoch.setBounds(175, 125, 50, 50);
		hoch.setText("^");
		hoch.setMargin(new Insets(2, 2, 2, 2));
		hoch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				status = 4;
				setOperator();
			}
		});
		hoch.setHorizontalTextPosition(SwingConstants.CENTER);
		hoch.setFont(new Font("Dialog", Font.BOLD, 20));
		advanced.add(hoch);

		wurzelKnopf.setBounds(175, 200, 50, 50);
		wurzelKnopf.setText("√");
		wurzelKnopf.setMargin(new Insets(2, 2, 2, 2));
		wurzelKnopf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				status = 5;
				setOperator();
			}
		});
		keepresult2.setBounds(350, 125, 180, 25);
		keepresult2.setOpaque(false);
		keepresult2.setText("keep result in field 2");
		keepresult2.setActionCommand("2");
		advanced.add(keepresult2);
		keepRadioGroup.add(keepresult2);

		keepresult1.setBounds(350, 100, 180, 25);
		keepresult1.setOpaque(false);
		keepresult1.setText("keep result in field 1");
		keepresult1.setActionCommand("1");
		keepRadioGroup.add(keepresult1);
		advanced.add(keepresult1);
		wurzelKnopf.setFont(new Font("Dialog", Font.BOLD, 18));
		advanced.add(wurzelKnopf);

		keepInput.setBounds(350, 50, 180, 25);
		keepInput.setOpaque(false);
		keepInput.setActionCommand("keep Input");
		keepInput.setText("keep input");
		advanced.add(keepInput);
		keepRadioGroup.add(keepInput);

		keepNothing.setBounds(350, 75, 180, 25);
		keepNothing.setOpaque(false);
		keepNothing.setActionCommand("3");
		keepNothing.setText("keep nothing");
		keepNothing.setSelected(true);
		advanced.add(keepNothing);
		keepRadioGroup.add(keepNothing);

		keepresult.setBounds(350, 150, 180, 25);
		keepresult.setOpaque(false);
		keepresult.setActionCommand("4");
		keepresult.setText("keep result");
		keepresult.setSelected(true);
		advanced.add(keepresult);
		keepRadioGroup.add(keepresult);

		ergebnisFeld.setBounds(350, 175, 90, 40);
		advanced.add(ergebnisFeld);
		// Ende Komponenten

		setVisible(true);
		add(advanced);
	} // end of public Advanced

	// Anfang Methoden

	public static void main(String[] args) {
		new Advanced();
	} // end of main

	public void responseFunktion(String ergebnisB) {

		JOptionPane.showMessageDialog(Advanced.this, "Ergebnis: " + ergebnisB, "Berechnung",
				JOptionPane.INFORMATION_MESSAGE);

	}

	// end of ergebnis_ActionPerformed

	public JLabel getOperator() {
		return operator;
	}

	public void setOperator() {
		switch (status) {
		case 0:
			operator.setText("+");
			break;
		case 1:
			operator.setText("-");
			break;
		case 2:
			operator.setText("X");
			break;
		case 3:
			operator.setText("/");
			break;
		case 4:
			operator.setText("^");
			break;
		case 5:
			operator.setText("root");
			break;
		default:
			operator.setText("");
		}
	}

	public void ergebnis_ActionPerformed(ActionEvent evt) {
		double op1;
		double op2;
		double ergebnisZ = 0;

		op1 = Double.parseDouble(fOperant1.getText());
		op2 = Double.parseDouble(fOperant2.getText());

		switch (status) {
		case 0:
			ergebnisZ = op1 + op2;
			break;
		case 1:
			ergebnisZ = op1 - op2;
			break;
		case 2:
			ergebnisZ = op1 * op2;
			break;
		case 3:
			if(op2==0) {
			responseFunktion("Stell dir vor, du hast " +(op1==1?"einen":op1)+ " Keks"+(op1==1?"":"e")+" und verteilst "+(op1==1?"ihn":"sie")+" gleichmäßig auf " + fOperant2.getText() +
					" Freunde. Wie viele Kekse bekommt jeder? Siehst du? Das macht keinen Sinn! Und du bist traurig weil du keine Freunde hast!");
			}
			ergebnisZ = op1 / op2;
			break;
		case 4:
			ergebnisZ = Math.pow(op1, op2);
			break;
		case 5:
			ergebnisZ = Math.pow(op1, 1 / op2);
			break;
		default:

		}
		responseFunktion(Double.toString(ergebnisZ));

		if (keepRadioGroup.getSelection().getActionCommand() == "1") {
			fOperant1.setText(Double.toString(ergebnisZ));
			System.out.println(Double.toString(ergebnisZ));
			fOperant2.setText("");
			operator.setText("");
		} else if (keepRadioGroup.getSelection().getActionCommand() == "2") {
			fOperant2.setText(Double.toString(ergebnisZ));
			fOperant1.setText("");
			operator.setText("");
		} else if ((keepRadioGroup.getSelection().getActionCommand() == "3")) {
			fOperant1.setText("");
			fOperant2.setText("");
			operator.setText("");
		} else if ((keepRadioGroup.getSelection().getActionCommand() == "4")) {

			ergebnisFeld.setText(Double.toString(ergebnisZ));
			fOperant1.setText("");
			fOperant2.setText("");
			operator.setText("");
		}
	}

	// Ende Methoden
} // end of class Advanced
