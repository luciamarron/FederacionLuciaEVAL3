package swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class FrameTiempo extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTiempo frame = new FrameTiempo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrameTiempo() {
		setTitle("Tiempo Participante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 269, 221);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Hora:");
		lblNewLabel.setBounds(10, 11, 36, 26);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Minutos:");
		lblNewLabel_1.setBounds(116, 11, 44, 26);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_1_1 = new JLabel("Segundos:");
		lblNewLabel_1_1.setBounds(10, 48, 54, 26);
		contentPane.add(lblNewLabel_1_1);
		JLabel lblNewLabel_1_2 = new JLabel("Centésimas");
		lblNewLabel_1_2.setBounds(10, 85, 80, 26);
		contentPane.add(lblNewLabel_1_2);
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(140, 122, 89, 23);
		contentPane.add(btnNewButton);
		JSpinner spinner_hora = new JSpinner();
		spinner_hora.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_hora.setBounds(44, 14, 44, 20);
		contentPane.add(spinner_hora);
		JSpinner spinner_minutos = new JSpinner();
		spinner_minutos.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spinner_minutos.setBounds(170, 14, 44, 20);
		contentPane.add(spinner_minutos);
		JSpinner spinner_segundos = new JSpinner();
		spinner_segundos.setBackground(Color.ORANGE);
		spinner_segundos.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spinner_segundos.setBounds(73, 51, 44, 20);
		contentPane.add(spinner_segundos);
		JSpinner spinner_centesimas = new JSpinner();
		spinner_centesimas.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner_centesimas.setBounds(83, 88, 44, 20);
		contentPane.add(spinner_centesimas);
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(20, 122, 89, 23);
		contentPane.add(btnCancelar);
	}
}
