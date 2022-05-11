package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AtletaDAO;
import DAO.EquipoDAO;
import entidades.Atleta;
import entidades.Equipo;
import entidades.Lugar;
import entidades.Patrocinador;
import utils.ConexBD;
import validaciones.Validaciones;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NuevoAtleta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoAtleta frame = new NuevoAtleta();
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
	public NuevoAtleta() {
		setBackground(Color.WHITE);
		setTitle("Nuevo Atleta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre*:");
		lblNewLabel.setBounds(30, 38, 60, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(109, 35, 277, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Documentación *");
		lblNewLabel_1.setBounds(40, 66, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Selecciona la opción");
		lblNewLabel_2.setBounds(50, 91, 105, 14);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("NIF");
		rdbtnNewRadioButton.setBounds(169, 87, 52, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("NIE");
		rdbtnNewRadioButton_1.setBounds(223, 87, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Introduzca el valor");
		lblNewLabel_3.setBounds(50, 118, 105, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 116, 126, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Teléfono:");
		lblNewLabel_4.setBounds(40, 175, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(96, 172, 112, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha Nacimiento *:");
		lblNewLabel_5.setBounds(223, 175, 97, 14);
		contentPane.add(lblNewLabel_5);
		
		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(334, 172, 90, 20);
		contentPane.add(spinnerFecha);
		spinnerFecha.setModel(new SpinnerDateModel(new Date(-315622800000L), null, null, Calendar.DAY_OF_YEAR));
		
		JLabel lblNewLabel_6 = new JLabel("Datos Personales");
		lblNewLabel_6.setBounds(26, 13, 97, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Datos físicos");
		lblNewLabel_7.setBounds(30, 214, 90, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Altura*:");
		lblNewLabel_8.setBounds(44, 243, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Peso*:");
		lblNewLabel_9.setBounds(44, 272, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("m. (en formato xx,xx)");
		lblNewLabel_10.setBounds(203, 242, 154, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Kg.(en formato xx,xx)");
		lblNewLabel_11.setBounds(203, 271, 117, 14);
		contentPane.add(lblNewLabel_11);
		
		textField_3 = new JTextField();
		textField_3.setBounds(96, 241, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(96, 268, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Equipo:");
		lblNewLabel_12.setBounds(30, 311, 46, 14);
		contentPane.add(lblNewLabel_12);
		
		DefaultComboBoxModel<Equipo> equipoModel = new DefaultComboBoxModel<Equipo>();
		JComboBox<Equipo> comboBoxAtleta = new JComboBox<Equipo>(equipoModel);
		EquipoDAO eqDAO = new EquipoDAO(ConexBD.getCon());
		ArrayList<Equipo> equiposList = (ArrayList<Equipo>) eqDAO.buscarTodos();

		for (Equipo eq : equiposList)
		comboBoxAtleta.addItem(eq);
		
		
		JComboBox comboBoxEquipo = new JComboBox();
		comboBoxEquipo.setModel(new DefaultComboBoxModel()); 
		//aquí habría que hacer algo similar que con la 
		//entidad lugar pero sin usar un values() ya que ésta no es una enumeración.
		//Deberemos usar los datos de nuestra base de datos.
		comboBoxEquipo.setBounds(96, 307, 264, 22);
		contentPane.add(comboBoxEquipo);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atleta nuevo = new Atleta();
				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";
				String nombre = textFieldNombre.getText();
				
				//Nombre
				valido = Validaciones.validarNombre(nombre);
				if (!valido) {
					errores += "El nombre del atleta no es válido (1-50 caracteres).\n";
				} else
					nuevo.setNombreAtleta(nombre);
				valido = false;
				
				//no me ha dado tiempo a arreglarlo pero aqui habría que acceder a datos persona
				//para poder validar campos como telefono o fecha de nacimiento
				
//				//Teléfono
//				valido = Validaciones.validarTelefono(telefono);
//				if (!valido) {
//					errores += "El nombre del atleta no es válido (1-50 caracteres).\n";
//				} else
//					nuevo.set;
//				valido = false;
//				
//				//Fecha
//				java.util.Date fecha = (java.util.Date) spinnerFecha.getValue();
//				valido = Validaciones.validarFecha(fecha);
//				if (!valido) {
//					errores += "La fecha de la prueba no es válido (posterior a 1 mes desde hoy).\n";
//	
//				} else {
//					LocalDate fechaLD = LocalDate.of(fecha.getYear() + 1900, fecha.getMonth() + 1, fecha.getDate());
//					nuevo.setFechaNac(fechaLD);
//				}
//				valido = false;
				
				if (!valido) {
					titulo = "ERROR: Campos inválidos";
					msj = "ERROR: los siguientes campos de Nuevo Atleta NO son válidos:\n\n";
					if (!errores.isEmpty())
						msj += errores + "\n";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
					return;
				}	
				
				/// Si todos los datos son correctos, llamar a PruebaDAO para insertar en la BD
				AtletaDAO adao = new AtletaDAO(ConexBD.establecerConexion());
				long idatletanuevo = adao.insertarSinID(nuevo);
				/// Tanto si la inserción de la nueva prueba tiene éxito como si no, avisar al
				/// usuario
				if (idatletanuevo <= 0) {
					// hubo error al insertar en BD y no se generó la nueva prueba
					titulo = "ERROR al insertar la Nueva Prueba en la BD";
					msj = "Hubo un error y NO se ha insertado la nueva prueba en la BD.";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
				} else {
					nuevo.setId(idatletanuevo);
					titulo = "Nueva Prueba insertada en la BD";
					msj = "Se ha insertado correctamente la nueva prueba:\n" + nuevo.toString();
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
					///Aqui se redirigiría al usuario hacia la pantalla principal
					///TODO
				}
				
			}
		});
		btnNewButton.setBounds(218, 361, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "¿Realmente desea cerrar la ventana?","Aceptar o Cancelar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		});
		buttonCancelar.setBounds(335, 361, 89, 23);
		contentPane.add(buttonCancelar);
	}
}
