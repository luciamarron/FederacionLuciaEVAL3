package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import DAO.AtletaDAO;
import DAO.MetalDAO;
import DAO.PatrocinadorDAO;
import DAO.PruebaDAO;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import entidades.Atleta;
import entidades.Bronce;
import entidades.Lugar;
import entidades.Metal;
import entidades.Oro;
import entidades.Patrocinador;
import entidades.Plata;
import entidades.Prueba;
import entidades.Resultado;
import utils.ConexBD;
import utils.Datos;
import validaciones.Validaciones;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JCheckBox;

public class CerrarPrueba extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private final ButtonGroup buttonGroupTipo = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int idprueba = 1;
					CerrarPrueba frame = new CerrarPrueba(idprueba);
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
	public CerrarPrueba(int idprueba) {
		setForeground(Color.WHITE);
		setTitle("CerrarPrueba1");
		PruebaDAO pDAO = new PruebaDAO(ConexBD.getCon());
		Prueba prueba = pDAO.buscarPorID(idprueba);
		if (prueba != null) {
			setTitle("Cerrar Prueba" + idprueba);
		} else
			setTitle("Cerrar Prueba INDETERMINADA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(
				new TitledBorder(null, "Datos de la prueba", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 21, 424, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblIdPrueba = new JLabel("IdPrueba:");
		lblIdPrueba.setBounds(22, 21, 77, 14);
		panel_1.add(lblIdPrueba);

		textField = new JTextField("" + prueba.getId());
		textField.setBounds(86, 14, 86, 20);
		panel_1.add(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 48, 77, 14);
		panel_1.add(lblNombre);

		textFieldNombre = new JTextField(prueba.getNombre());
		textFieldNombre.setBounds(86, 41, 261, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(22, 73, 46, 14);
		panel_1.add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(200, 73, 46, 14);
		panel_1.add(lblLugar);

		JComboBox comboBoxLugar = new JComboBox();
		comboBoxLugar.setBounds(245, 69, 169, 22);
		panel_1.add(comboBoxLugar);
		comboBoxLugar.setEnabled(false);
		comboBoxLugar.setModel(new DefaultComboBoxModel(Lugar.values()));

		JPanel panel = new JPanel();
		panel.setBounds(22, 98, 210, 52);
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tipo de Prueba:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JRadioButton rbIndividual = new JRadioButton("Individual");

		rbIndividual.setEnabled(false);
		buttonGroupTipo.add(rbIndividual);
		panel.add(rbIndividual);

		JRadioButton rbEquipos = new JRadioButton("Por Equipos");
		rbEquipos.setEnabled(false);
		buttonGroupTipo.add(rbEquipos);
		panel.add(rbEquipos);
		if (prueba.isIndividual())
			rbIndividual.setSelected(true);
		else
			rbEquipos.setSelected(true);

		JLabel lblPatrocinador = new JLabel("Patrocinador:");
		lblPatrocinador.setBounds(22, 161, 87, 14);
		panel_1.add(lblPatrocinador);

		JLabel lblprimerpuesto = new JLabel("Primer puesto *:");
		lblprimerpuesto.setBounds(20, 235, 109, 14);
		contentPane.add(lblprimerpuesto);

		JLabel lblsegundopuesto = new JLabel("Segundo puesto *:");
		lblsegundopuesto.setBounds(20, 331, 109, 14);
		contentPane.add(lblsegundopuesto);

		JLabel lbltercerpuesto = new JLabel("Tercer puesto *:");
		lbltercerpuesto.setBounds(20, 445, 109, 14);
		contentPane.add(lbltercerpuesto);

		DefaultComboBoxModel<Atleta> atletasModel = new DefaultComboBoxModel<Atleta>();
		AtletaDAO aDAO = new AtletaDAO(ConexBD.getCon());
		ArrayList<Atleta> atletassList = (ArrayList<Atleta>) aDAO.buscarTodos();
		/// Pero el modelo de comboBox básico requiere Strings
		// En vez de devolver toda la lista de los Atletas devuelve solamente 100
		String[] atletasStr = new String[100];
		for (int i = 0; i < 100; i++) {
			System.out.println(atletassList.get(i).getPersona().data());
			atletasStr[i] = atletassList.get(i).getPersona().data();
		}

		JComboBox<Atleta> comboBoxPuesto1 = new JComboBox<Atleta>();
		comboBoxPuesto1.setModel(new DefaultComboBoxModel(atletasStr));
		lblprimerpuesto.setLabelFor(comboBoxPuesto1);
		comboBoxPuesto1.setBounds(139, 231, 287, 22);
		contentPane.add(comboBoxPuesto1);

		JComboBox<Atleta> comboBoxPuesto2 = new JComboBox<Atleta>();
		comboBoxPuesto2.setModel(new DefaultComboBoxModel(atletasStr));
		lblsegundopuesto.setLabelFor(comboBoxPuesto2);
		comboBoxPuesto2.setBounds(139, 327, 287, 22);
		contentPane.add(comboBoxPuesto2);

		JComboBox<Atleta> comboBoxPuesto3 = new JComboBox<Atleta>();
		comboBoxPuesto3.setModel(new DefaultComboBoxModel(atletasStr));
		lbltercerpuesto.setLabelFor(comboBoxPuesto3);
		comboBoxPuesto3.setBounds(139, 441, 287, 22);
		contentPane.add(comboBoxPuesto3);

		LocalDate hoyMas1MesLD = LocalDate.now().plusMonths(1);
		java.util.Date hoyMas1Mes = new Date(hoyMas1MesLD.getYear() - 1900, hoyMas1MesLD.getMonthValue() - 1,
				hoyMas1MesLD.getDayOfMonth());

		/// Las siguientes lineas seria lo deseable: trabajar diectamente con objetos en
		/// el model del comboBox
		DefaultComboBoxModel<Patrocinador> patrocinadoresModel = new DefaultComboBoxModel<Patrocinador>();
		JComboBox<Patrocinador> comboBoxPatrocinador = new JComboBox<Patrocinador>(patrocinadoresModel);
		PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
		ArrayList<Patrocinador> patrocinadoresList = (ArrayList<Patrocinador>) patDAO.buscarTodos();
		for (Patrocinador pat : patrocinadoresList)
			comboBoxPatrocinador.addItem(pat);

		/// Pero el modelo de comboBox básico requiere Strings
		String[] patrocinadoresStr = new String[patrocinadoresList.size()];
		for (int i = 0; i < patrocinadoresList.size(); i++)
			patrocinadoresStr[i] = patrocinadoresList.get(i).mostrarBasico();
		comboBoxPatrocinador.setModel(new DefaultComboBoxModel(patrocinadoresStr));
		comboBoxPatrocinador.setBounds(96, 157, 261, 22);
		panel_1.add(comboBoxPatrocinador);
		comboBoxPatrocinador.setEnabled(false);

		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(86, 69, 86, 20);
		panel_1.add(spinnerFecha);
		spinnerFecha.setEnabled(false);
		spinnerFecha.setModel(new SpinnerDateModel(hoyMas1Mes, hoyMas1Mes, null, Calendar.DAY_OF_YEAR));

		JSpinner spinner = new JSpinner();
		spinner.setBounds(70, 263, 30, 20);
		contentPane.add(spinner);

		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setBounds(30, 266, 46, 14);
		contentPane.add(lblHoras);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(169, 264, 30, 20);
		contentPane.add(spinner_1);

		JLabel lblMinutos = new JLabel("Minutos");
		lblMinutos.setBounds(125, 266, 46, 14);
		contentPane.add(lblMinutos);

		JLabel lblSegundos = new JLabel("Segundos");
		lblSegundos.setBounds(218, 266, 46, 14);
		contentPane.add(lblSegundos);

		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setBounds(265, 264, 30, 20);
		contentPane.add(spinner_1_1);

		JSpinner spinner_1_1_1 = new JSpinner();
		spinner_1_1_1.setBounds(369, 264, 30, 20);
		contentPane.add(spinner_1_1_1);

		JLabel lblSegundos_1 = new JLabel("Centésimas");
		lblSegundos_1.setBounds(313, 266, 46, 14);
		contentPane.add(lblSegundos_1);

		JLabel lblIdoro = new JLabel("IdOro*:");
		lblIdoro.setBounds(30, 306, 46, 14);
		contentPane.add(lblIdoro);

		JComboBox comboBox_Oro = new JComboBox();
		comboBox_Oro.setBounds(80, 298, 49, 22);
		contentPane.add(comboBox_Oro);

		JLabel lblHoras_1 = new JLabel("Horas");
		lblHoras_1.setBounds(30, 368, 46, 14);
		contentPane.add(lblHoras_1);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(70, 365, 30, 20);
		contentPane.add(spinner_2);

		JLabel lblMinutos_1 = new JLabel("Minutos");
		lblMinutos_1.setBounds(125, 368, 46, 14);
		contentPane.add(lblMinutos_1);

		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setBounds(169, 365, 30, 20);
		contentPane.add(spinner_1_2);

		JLabel lblSegundos_2 = new JLabel("Segundos");
		lblSegundos_2.setBounds(218, 368, 46, 14);
		contentPane.add(lblSegundos_2);

		JSpinner spinner_1_1_2 = new JSpinner();
		spinner_1_1_2.setBounds(265, 365, 30, 20);
		contentPane.add(spinner_1_1_2);

		JLabel lblSegundos_1_1 = new JLabel("Centésimas");
		lblSegundos_1_1.setBounds(313, 368, 46, 14);
		contentPane.add(lblSegundos_1_1);

		JSpinner spinner_1_1_1_1 = new JSpinner();
		spinner_1_1_1_1.setBounds(369, 365, 30, 20);
		contentPane.add(spinner_1_1_1_1);

		JLabel lblIdplata = new JLabel("IdPlata*:");
		lblIdplata.setBounds(30, 406, 46, 14);
		contentPane.add(lblIdplata);

		JComboBox comboBox_Plata = new JComboBox();
		comboBox_Plata.setBounds(80, 402, 49, 22);
		contentPane.add(comboBox_Plata);

		JLabel lblHoras_1_1 = new JLabel("Horas");
		lblHoras_1_1.setBounds(30, 485, 46, 14);
		contentPane.add(lblHoras_1_1);

		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setBounds(70, 482, 30, 20);
		contentPane.add(spinner_2_1);

		JLabel lblMinutos_1_1 = new JLabel("Minutos");
		lblMinutos_1_1.setBounds(125, 485, 46, 14);
		contentPane.add(lblMinutos_1_1);

		JSpinner spinner_1_2_1 = new JSpinner();
		spinner_1_2_1.setBounds(169, 482, 30, 20);
		contentPane.add(spinner_1_2_1);

		JLabel lblSegundos_2_1 = new JLabel("Segundos");
		lblSegundos_2_1.setBounds(218, 485, 46, 14);
		contentPane.add(lblSegundos_2_1);

		JSpinner spinner_1_1_2_1 = new JSpinner();
		spinner_1_1_2_1.setBounds(265, 482, 30, 20);
		contentPane.add(spinner_1_1_2_1);

		JLabel lblSegundos_1_1_1 = new JLabel("Centésimas");
		lblSegundos_1_1_1.setBounds(313, 485, 46, 14);
		contentPane.add(lblSegundos_1_1_1);

		JSpinner spinner_1_1_1_1_1 = new JSpinner();
		spinner_1_1_1_1_1.setBounds(369, 482, 30, 20);
		contentPane.add(spinner_1_1_1_1_1);

		JLabel lblIdoro_1_1 = new JLabel("IdBronce*:");
		lblIdoro_1_1.setBounds(30, 526, 58, 14);
		contentPane.add(lblIdoro_1_1);

		JComboBox comboBox_Bronce = new JComboBox();
		comboBox_Bronce.setBounds(92, 522, 49, 22);
		contentPane.add(comboBox_Bronce);

		JLabel lblNewLabel = new JLabel("Establecer como DEFINITIVO:");
		lblNewLabel.setBounds(30, 566, 155, 14);
		contentPane.add(lblNewLabel);

		JCheckBox definitivo = new JCheckBox("");
		definitivo.setBounds(182, 566, 30, 23);
		contentPane.add(definitivo);
		
		//Asignamos el metal oro al primero, la plata al segundo y el bronce al tercero
		
		ArrayList<Metal> m = new ArrayList();
		Connection met = ConexBD.establecerConexion();
		MetalDAO metDAO = new MetalDAO(met);
		m = (ArrayList<Metal>) metDAO.buscarTodos();



		for (int i = 0; i < m.size(); i++) {
		if (m.getClass().equals(Oro.class) && (m.get(i).isAsignada())) {
		ArrayList<Metal> o = new ArrayList();
		o.add(m.get(i));
		comboBox_Oro.setModel((ComboBoxModel) o);



		} else if (m.getClass().equals(Plata.class) && (m.get(i).isAsignada())) {
		ArrayList<Metal> p = new ArrayList();
		p.add(m.get(i));
		comboBox_Plata.setModel((ComboBoxModel) p);



		} else if (m.getClass().equals(Bronce.class) && (m.get(i).isAsignada())) {
		ArrayList<Metal> b = new ArrayList();
		b.add(m.get(i));
		comboBox_Bronce.setModel((ComboBoxModel) b);
		}
		

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean valido = false;
				
				String errores="";
				String titulo="";
				String msj="";
				valido = errores.isEmpty();
				Resultado nuevo = new Resultado();
				
				long idOro = comboBox_Oro.getSelectedIndex();
				float pureza = 0.0F;
				Oro o= new Oro(idOro,pureza);
				valido = Validaciones.validarId(idOro);
				if(!valido) {
					errores+= "El id del oro no es correcto.\n";
				}else
					nuevo.setPrimero(o);
					valido=false;
				
				long idPlata = comboBox_Plata.getSelectedIndex();
				float pureza_2 = 0.0F;
				Plata p = new Plata(idPlata,pureza_2);
				valido = Validaciones.validarId(idPlata);
				if(!valido) {
					errores+= "El id de la plata no es correcto.\n";
				}else
					nuevo.setSegundo(p);
					valido=false;
				
				long idBronce = comboBox_Bronce.getSelectedIndex();
				float pureza_3 = 0.0F;
				Bronce b = new Bronce(idBronce,pureza_3);
				valido = Validaciones.validarId(idBronce);
				if(!valido) {
					errores+= "El id del bronce no es correcto.\n";
				}else
					nuevo.setTercero(b);
					valido=false;
				
				
				if(!definitivo.isSelected()) {
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
				}
				nuevo.setDefinitivo(definitivo.isSelected());
				
				Prueba prueba = new Prueba();
				prueba.setResultado(nuevo);
				
				
				
				if (!valido) {
					titulo = "ERROR: Campos inválidos";
					msj = "ERROR: los siguientes campos NO son válidos:\n\n";
					if (!errores.isEmpty())
						msj += errores + "\n";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
					return;
				}

				/// Si todos los datos son correctos, llamar a PruebaDAO para insertar en la BD
				PruebaDAO pruebadao = new PruebaDAO(ConexBD.establecerConexion());
				boolean correcto = pruebadao.modificar(prueba);
				/// Tanto si la inserción de la nueva prueba tiene éxito como si no, avisar al
				/// usuario
				if (!correcto) {
					// hubo error al insertar en BD y no se generó la nueva prueba
					titulo = "ERROR al cerrar la Prueba en la BD";
					msj = "Hubo un error y NO se ha cerrado la prueba en la BD.";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
				} else {
					titulo = "Prueba " + prueba.getId() + " cerrada en la BD";
					msj = "Se ha cerrado correctamente la  prueba:\n" + prueba.toString();
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
					/// Aqui se redirigiría al usuario hacia la pantalla principal
					/// TODO
				}

			}
			
		//No me ha dado tiempo a terminarlo	

//			public static void exportarDatosFicheroTexto() {
//				
//				
//				System.out.println("Guardando en resultado_prueba<idPrueba>.txt");
//
//				File fOut = new File("resultado_prueba<idPrueba>.txt");
//				FileWriter fw = null;
//				BufferedWriter bw = null;
//
//				try {
//					fw = new FileWriter(fOut);
//					bw = new BufferedWriter(fw);
//					
//					for () {
//						Resultado r = new Resultado();
//						bw.write(resultPrueba + PrimerPuesto + SegundoPuesto + TercerPuesto + resultado);
//					}
//
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				} finally {
//					try {
//						if (bw != null)
//							bw.close();
//						if (fw != null)
//							fw.close();
//
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//			}
			
//			
//			String resultPrueba = "";
//			String PrimerPuesto = "";
//			String SegundoPuesto = "";
//			String TercerPuesto= "";
//			String resultado = "";
//			
//				resultPrueba = "Resultado de la prueba" + prueba.getId() + prueba.getNombre() + "celebrada el pasado"+ 
//						prueba.getFecha() + "en" + prueba.getLugar();
//				
//				PrimerPuesto = "Primer puesto para" + prueba.getParticipantes() + "(" + nif + ",con un tiempo de " +
//				tiempo +".Se le otorga el oro" + oro + "de pureza" + pureza+"%.";
//			
//				SegundoPuesto = "Primer puesto para" + nombre + "(" + nif + ",con un tiempo de " +
//						tiempo +".Se le otorga la plata" + oro + "de pureza" + pureza+"%.";
//				
//				TercerPuesto = "Tercer puesto para" + nombre + "(" + nif + ",con un tiempo de " +
//					tiempo +".Se le otorga el bronce" + oro + "de pureza" + pureza+"%.";
//			
//				return resultPrueba;
//				return PrimerPuesto;
//				return SegundoPuesto;
//				return TercerPuesto;
//				return resultado;
			});
	
		
		buttonAceptar.setBounds(243, 582, 89, 23);
		contentPane.add(buttonAceptar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = "Cerrar ventana";
				String msj = "¿Realmente desea cerrar la ventana?";
				int opcion = JOptionPane.showConfirmDialog(null, msj, titulo, JOptionPane.OK_CANCEL_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					/// Aqui se redirigiría al usuario hacia la pantalla principal o se saldria
					System.exit(0); /// SALIR directamente
				}

			}
		});
		buttonCancelar.setBounds(342, 582, 89, 23);
		contentPane.add(buttonCancelar);

	}
}
}
