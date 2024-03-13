package medico.cirurgias.intefaces;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.JXDatePicker;

import medico.cirurgias.dao.AgendaCirurgiaDAO;
import medico.cirurgias.dao.CirurugiaDAO;
import medico.cirurgias.dao.MedicoCirurgiaoDAO;
import medico.cirurgias.model.AgendaCirurgias;
import medico.cirurgias.model.Cirurgias;
import medico.cirurgias.model.MedicoCirurgiao;
import medico.consultorio.database.dao.MedicoDAO;
import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.GeradorToken;
import medico.consultorio.model.Medico;
import medico.consultorio.model.Paciente;

public class AgendarCirurgia {

	private JFrame agendarCirurgia;
	private JLabel lbToken, lbCPF, lbNomeDoPaciente, lbNomeCirurgia,lbTipoCirurgia, lbRiscoCirurgia;
	private JLabel lbDataCirurgia, lbHoraCirurgia;
	private JLabel lbMedicoRequirente, lbMedicoCirurgiao;
	private JTextField txToken, txCPF, txNomeDoPaciente, txTipoCirurgia, txRiscoCirurgia;
	private JTextField txDataCirurgia, txHoraCirurgia;
	private JComboBox<String> medicoRequirente;
	private JComboBox<String> medicoCirurgiao;
	private JComboBox<String> cirurgias;
	private JButton btAgendaCirurgia,btBuscaCPF, dataCirurgia, horaCirurgia , btGerarToken;
	
	
	public AgendarCirurgia() {
		agendarCirurgia = new JFrame("Agedar Cirurgia");
		
		lbToken = new JLabel("Token");
		lbCPF = new JLabel("CPF");
		lbNomeDoPaciente = new JLabel("Nome do Paciente");
		lbNomeCirurgia = new JLabel("Nome da Cirurgia");
		lbMedicoRequirente = new JLabel("Medico Requirente");
		lbMedicoCirurgiao = new JLabel("Medico Cirurgiao");
		lbTipoCirurgia = new JLabel("Tipo de Cirurgia");
		lbRiscoCirurgia = new JLabel("Risco de Cirurgia");
		lbDataCirurgia = new JLabel ("Data da Cirurgia");
		lbHoraCirurgia = new JLabel("Hora da Cirurgia");
		
		txToken = new JTextField();
		txCPF = new JTextField();
		txNomeDoPaciente = new  JTextField();
		txTipoCirurgia = new JTextField();
		txRiscoCirurgia = new JTextField();
		txDataCirurgia = new JTextField();
		txHoraCirurgia = new JTextField();
		
		cirurgias  =new JComboBox<String>();		
		medicoCirurgiao = new JComboBox<String>();
		medicoRequirente = new JComboBox<String>();
		
		btAgendaCirurgia  = new JButton("Agendar Cirurgia");
		btBuscaCPF = new JButton("Buscar CPF");
		btGerarToken = new JButton("Gerar Token");
		dataCirurgia = new JButton("Data da Cirurgia");
		horaCirurgia = new  JButton("Hora da Cirurgia");
	}
	
	
	public void setAgendarCirurgia() {
		agendarCirurgia.setSize(1000, 600);
		agendarCirurgia.setLayout(null);
		
		jLabel();
		jTextField();
		combobox();
		jButton();
		agendarCirurgia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		agendarCirurgia.setVisible(true);
	}

	private void jLabel() {
		agendarCirurgia.add(lbToken);
		agendarCirurgia.add(lbCPF);
		agendarCirurgia.add(lbNomeDoPaciente);
		agendarCirurgia.add(lbMedicoRequirente);
		agendarCirurgia.add(lbMedicoCirurgiao);
		agendarCirurgia.add(lbNomeCirurgia);
		agendarCirurgia.add(lbTipoCirurgia);
		agendarCirurgia.add(lbRiscoCirurgia);
		agendarCirurgia.add(lbDataCirurgia);
		agendarCirurgia.add(lbHoraCirurgia);
		
		lbToken.setBounds(10, 10, 100, 20);
		lbCPF.setBounds(10, 40, 100, 20);
		lbNomeDoPaciente.setBounds(10, 70, 150, 20);
		lbMedicoRequirente.setBounds(10, 100, 150, 20);
		lbMedicoCirurgiao.setBounds(10, 130, 150, 20);
		lbNomeCirurgia.setBounds(10, 160, 100, 20);
		lbTipoCirurgia.setBounds(10, 190, 100, 20);
		lbRiscoCirurgia.setBounds(10, 220, 100, 20);
		lbDataCirurgia.setBounds(10, 250, 100, 20);
		lbHoraCirurgia.setBounds(10, 280, 100, 20);
	}
	

	private void jTextField() {
		agendarCirurgia.add(txToken);
		agendarCirurgia.add(txCPF);
		agendarCirurgia.add(txNomeDoPaciente);
		agendarCirurgia.add(txTipoCirurgia);
		agendarCirurgia.add(txRiscoCirurgia);
		agendarCirurgia.add(txDataCirurgia);
		agendarCirurgia.add(txHoraCirurgia);
		
		txToken.setBounds(190, 10, 150, 20);
		txCPF.setBounds(190, 40, 150, 20);
		txNomeDoPaciente.setBounds(190, 70, 150, 20);
		txTipoCirurgia.setBounds(190, 190, 150, 20);
		txRiscoCirurgia.setBounds(190, 220, 150, 20);
		txDataCirurgia.setBounds(190, 250, 150, 20);
		txHoraCirurgia.setBounds(190, 280, 150, 20);
	}



	private void combobox() {
		agendarCirurgia.add(cirurgias);
		agendarCirurgia.add(medicoRequirente);
		agendarCirurgia.add(medicoCirurgiao);
		
		cirurgias.setBounds(190, 160, 150, 20);
		medicoRequirente.setBounds(190, 100, 150, 20);
		medicoCirurgiao.setBounds(190, 130, 150, 20);
		
		carregarCirurgias();
		carregarCirurgiao();
		carregarMedReq();
		
		cirurgias.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cirurgiaSelecionada  = cirurgias.getSelectedItem().toString();
				
				CirurugiaDAO cirurugiaDAO = new CirurugiaDAO();
				
				Cirurgias cir  = cirurugiaDAO.listaCirurgiaPorNome(cirurgiaSelecionada);
				
				
				txTipoCirurgia.setText(cir.getTipoCirurgia());
				txRiscoCirurgia.setText(cir.getRiscoCirurgia());
			}
		});
		
	}
	
	private void jButton() {
		agendarCirurgia.add(btBuscaCPF);
		agendarCirurgia.add(btGerarToken);
		agendarCirurgia.add(dataCirurgia);
		agendarCirurgia.add(horaCirurgia);
		agendarCirurgia.add(btAgendaCirurgia);
		
		btAgendaCirurgia.setBounds(30, 320, 130, 20);
		btBuscaCPF.setBounds(380,40,150,20);
		btGerarToken.setBounds(380, 10, 150,20);
		dataCirurgia.setBounds(380, 250, 150, 20);
		horaCirurgia.setBounds(380, 280, 150, 20);
		
		btGerarToken.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String token  = GeradorToken.gerarToken(5);
				txToken.setText(token);
			}
		});
		
		
		btBuscaCPF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cpf = JOptionPane.showInputDialog("Entre com o CPF");
				
				if(cpf != null) {
					PacienteDAO pacienteDAO = new PacienteDAO();
					Paciente pac = pacienteDAO.consultaClientePorCPF(cpf);
					if(pac !=null) {
						txCPF.setText(pac.getCpf());
						txNomeDoPaciente.setText(pac.getNomePaciente());
					}
				}else {
					JOptionPane.showMessageDialog(null, "Paciente nao encontrado");
				}
			}
		});
		
		
		dataCirurgia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calendarioAnual();
			}
		});
		
		
		horaCirurgia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame horMinuto = new JFrame();
				horMinuto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				horMinuto.setSize(200,200);
				
				SpinnerModel horaModel = new SpinnerNumberModel(0,0,23,1);
				JSpinner horaSpinner = new JSpinner(horaModel);
				
				SpinnerModel minutoModel = new SpinnerNumberModel(0,0,59,1);
				JSpinner minutoSpinner = new JSpinner(minutoModel);
				
				JButton confirmarHora = new JButton("Confirmar Hora");
				confirmarHora.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int hora = (int) horaSpinner.getValue();
						int min = (int) minutoModel.getValue();
						txHoraCirurgia.setText(String.format("%02d:%02d", hora, min));
						horMinuto.dispose();
					}
				});
				
				horMinuto.setLayout(new GridLayout(3,1));
				horMinuto.add(horaSpinner);
				horMinuto.add(minutoSpinner);
				horMinuto.add(confirmarHora);
				horMinuto.setVisible(true);
				
			}
		});
		
		btAgendaCirurgia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AgendaCirurgias agCir = new AgendaCirurgias();
				AgendaCirurgiaDAO agCiDAO = new AgendaCirurgiaDAO();
				
				String token = txToken.getText();
				String cpf = txCPF.getText();
				String nomePaciente = txNomeDoPaciente.getText();
				String medRequirente = medicoRequirente.getSelectedItem().toString();
				String medCirurgiao = medicoCirurgiao.getSelectedItem().toString();
				String nomeCirurgia = cirurgias.getSelectedItem().toString();
				String tipoCirurgia = txTipoCirurgia.getText();
				String riscoCirurgia = txRiscoCirurgia.getText();
				String dataCirurgia = txDataCirurgia.getText();
				String horaCirurgia = txHoraCirurgia.getText();
				
				agCir.setToken(token);
				agCir.setCpf(cpf);
				agCir.setNomePaciente(nomePaciente);
				agCir.setMedicoRequerente(medRequirente);
				agCir.setMedicoCirurgiao(medCirurgiao);
				agCir.setNomeCirurgia(nomeCirurgia);
				agCir.setTipoCirurgia(tipoCirurgia);
				agCir.setRiscoCirurgia(riscoCirurgia);
				agCir.setDataCirurgia(dataCirurgia);
				agCir.setHoraCirurgia(horaCirurgia);
				
				agCiDAO.agendarCirurgia(agCir);
			}
		});	
	}
	
	private void carregarCirurgiao() {
		MedicoCirurgiaoDAO medCirDAO = new MedicoCirurgiaoDAO();
		List<MedicoCirurgiao> listaMedCir = medCirDAO. listaMedicosCirurgia();
		for(MedicoCirurgiao medCir : listaMedCir) {
			medicoCirurgiao.addItem(medCir.getNomeMedico());
		}
	}
	
	
	private void carregarCirurgias() {
		CirurugiaDAO cirDAO = new CirurugiaDAO();
		List<Cirurgias> listaCir = cirDAO.listaTodasAsCirurgias();
		for(Cirurgias cirurgias : listaCir) {
			this.cirurgias.addItem(cirurgias.getNomeCirurgia());
		}
	}
	
	private void carregarMedReq() {
		MedicoDAO medDAO = new MedicoDAO();
		List<Medico> listaMedico = medDAO.listarTodosOsMedicos();
		for(Medico med : listaMedico) {
			medicoRequirente.addItem(med.getNomeMedico());
		}
	}
	
	
	private void calendarioAnual() {
		JFrame calendario = new JFrame();
		calendario.setSize(300, 300);
		
		JPanel painel = new JPanel(new GridLayout(3,4,10,10));
		Calendar calendar = Calendar.getInstance();
		
		JPanel panelCalendar = criarPainelDoCalendario(calendar);
		painel.add(panelCalendar);
		
		calendario.add(painel);
		calendario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		calendario.setVisible(true);
	}
	
	
	private JPanel criarPainelDoCalendario(Calendar calendar) {
		JPanel  painelCalendario = new JPanel();		JXDatePicker datePicker = new JXDatePicker();
		datePicker.setDate(calendar.getTime());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		datePicker.setPreferredSize(new Dimension(120,20));
		
		JButton escolherData = new JButton("Escolher Data");
		
		escolherData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date = datePicker.getDate();
				String formDate = sdf.format(date);
				txDataCirurgia.setText(formDate);
				
				Window parWindow = SwingUtilities.getWindowAncestor(escolherData);
				if(parWindow != null) {
					parWindow.dispose() ;
				}
			}
		});
		painelCalendario.add(datePicker, BorderLayout.CENTER);
		painelCalendario.add(escolherData , BorderLayout.EAST);
		return painelCalendario;
		}


	public static void main(String[] args) {
		new AgendarCirurgia()
			.setAgendarCirurgia();
	}
	
}
