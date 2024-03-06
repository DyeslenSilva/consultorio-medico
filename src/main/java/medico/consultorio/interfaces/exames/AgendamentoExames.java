package medico.consultorio.interfaces.exames;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.JXDatePicker;

import medico.consultorio.database.dao.AgendaExameDAO;
import medico.consultorio.database.dao.ExameDAO;
import medico.consultorio.database.dao.MedicoDAO;
import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.Exame;
import medico.consultorio.model.GeradorToken;
import medico.consultorio.model.MarcaExame;
import medico.consultorio.model.Medico;
import medico.consultorio.model.Paciente;

public class AgendamentoExames {
	
	private JFrame agendamentoExames;
	private JLabel lbTokenExame,  lbCPF,lbNomePaciente, lbNomeDoExame, lbMedicoSolicitante;
	private JLabel lbDescricao, lbDataExame, lbHoraExame;
	private JTextField txTokenExame , txCPF,txNomePaciente;
	private JComboBox<String> cbNomeExame, cbMedicoSolicitante;
	private JTextField txDataExame, txHoraExame;
	private JTextArea taDescricao;
	private JButton btAgendarExames, btEncontrarPaciente,btDataExame, btHoraExame;
	private JButton btGerarToken;
	
	public AgendamentoExames() {
		agendamentoExames = new JFrame();
		
		lbTokenExame = new JLabel("Token do Exame");
		lbCPF = new JLabel("CPF");
		lbNomePaciente = new JLabel("Nome do Paciente");
		lbNomeDoExame = new JLabel("Nome do Exame");
		lbMedicoSolicitante = new JLabel("Medico Solicitante");
		lbDescricao = new JLabel("Descricao");
		lbDataExame = new  JLabel("Data de exame");
		lbHoraExame = new JLabel("Hora do exame");
		
		txTokenExame = new JTextField();
		txCPF = new JTextField();
		txNomePaciente = new JTextField();
		txDataExame = new JTextField();
		txHoraExame = new JTextField();
		
		taDescricao = new JTextArea();
		
		cbNomeExame = new JComboBox<String>();
		cbMedicoSolicitante = new JComboBox<String>();
		
		btEncontrarPaciente = new JButton("Encontrar Paciente");
		btGerarToken = new JButton("Gerar Token");
		btAgendarExames = new JButton("Agendar Exame");
		btDataExame = new JButton("Data de Exame");
		btHoraExame = new JButton("Hora do Exame");
		
	}
	
	
	public void setAgendamentoExames() {
		agendamentoExames.setSize(600, 400);
		agendamentoExames.setLayout(null);
			jLabel();
			jTextField();
			jTextArea();
			jComboBox();
			jButton();
		agendamentoExames.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		agendamentoExames.setVisible(true);
	}

	private void jLabel() {
		agendamentoExames.add(lbTokenExame);
		agendamentoExames.add(lbCPF);
		agendamentoExames.add(lbNomePaciente);
		agendamentoExames.add(lbNomeDoExame);
		agendamentoExames.add(lbMedicoSolicitante);
		agendamentoExames.add(lbDescricao);
		agendamentoExames.add(lbDataExame);
		agendamentoExames.add(lbHoraExame);
		
		lbTokenExame.setBounds(10, 10, 100, 20);
		lbCPF.setBounds(10, 40, 100, 20);
		lbNomePaciente.setBounds(10, 70, 150, 20);
		lbNomeDoExame.setBounds(10, 100, 100, 20);
		lbMedicoSolicitante.setBounds(10, 130, 150, 20);
		lbDataExame.setBounds(10, 160, 100, 20);
		lbHoraExame.setBounds(10, 190, 100, 20);
		lbDescricao.setBounds(10, 220, 100, 20);

	}

	private void jTextField() {
		agendamentoExames.add(txTokenExame);
		agendamentoExames.add(txCPF);
		agendamentoExames.add(txNomePaciente);
		agendamentoExames.add(txDataExame);
		agendamentoExames.add(txHoraExame);
		
		txTokenExame.setBounds(150, 10, 130, 20);
		txCPF.setBounds(150, 40, 130, 20);
		txNomePaciente.setBounds(150, 70, 130, 20);
		txDataExame.setBounds(150, 160, 130, 20);
		txHoraExame.setBounds(150, 190, 130, 20);
	}

	
	private void jComboBox() {
		agendamentoExames.add(cbMedicoSolicitante);
		agendamentoExames.add(cbNomeExame);
		
		cbMedicoSolicitante.setBounds(150, 130, 130, 20);
		cbNomeExame.setBounds(150, 100, 130, 20);
		
		carregarMedicos();
		carregarExames();
		
		cbNomeExame.addActionListener(e -> {
			String selectExame = (String) cbNomeExame.getSelectedItem();
			updateDescricao(selectExame);
		});
	}


	private void jTextArea() {
		agendamentoExames.add(taDescricao);
		
		taDescricao.setBounds(150, 220, 130, 60);
	}

	
	private void jButton() {
		agendamentoExames.add(btEncontrarPaciente);
		agendamentoExames.add(btGerarToken);
		agendamentoExames.add(btAgendarExames);
		agendamentoExames.add(btDataExame);
		agendamentoExames.add(btHoraExame);
		
		btEncontrarPaciente.setBounds(290, 40, 160, 20);
		btGerarToken.setBounds(290,10,160,20);
		btAgendarExames.setBounds(40, 310, 160, 20);
		btDataExame.setBounds(290, 160, 160, 20);
		btHoraExame.setBounds(290, 190, 160, 20);
		
		btGerarToken.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String token = UUID.randomUUID().toString().substring(0,6);
				txTokenExame.setText(token);
			}
		});	
		
		btEncontrarPaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cpf = txCPF.getText();
				PacienteDAO pacienteDAO = new PacienteDAO();
				Paciente pac = pacienteDAO.consultaClientePorCPF(cpf);
				txNomePaciente.setText(pac.getNomePaciente());
			}
		});
		
		btDataExame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				calendarioAnual();
			}
		});
		
		
		btHoraExame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame horaDoExame = new JFrame();
				horaDoExame.setSize(300, 300);
				horaDoExame.setLayout(new BorderLayout());
				
				SpinnerDateModel horaSpinner = 
							new SpinnerDateModel(new Date(), null, null, Calendar.HOUR_OF_DAY);
				JSpinner spinner = new JSpinner(horaSpinner);
				DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm");
				spinner.setEditor(editor);
				
				JButton confirmarHorario = new JButton("Confirmar Horario");
				
				confirmarHorario.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Date horarioSelecionado = (Date) spinner.getValue();
						
						SimpleDateFormat sdf= new SimpleDateFormat("HH:mm");
						String horaFormatada = sdf.format(horarioSelecionado);
						txHoraExame.setText(horaFormatada);
						
						horaDoExame.dispose();
					
					}
				});
				
				horaDoExame.add(spinner , BorderLayout.CENTER);
				horaDoExame.add(confirmarHorario , BorderLayout.SOUTH);
				horaDoExame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				horaDoExame.setVisible(true);
				
			}
		});
		
		btAgendarExames.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tokenAgendamento = txTokenExame.getText();
				String cpf = txCPF.getText();
				String nome = txNomePaciente.getText();
				String medicoSolicitante = cbMedicoSolicitante.getSelectedItem().toString();
				String nomeExame = cbNomeExame.getSelectedItem().toString();
				String dataExame = txDataExame.getText();
				String horaExame = txHoraExame.getText();
				String descricao = taDescricao.getText();
				
				MarcaExame exame = new MarcaExame();
				AgendaExameDAO ageDAO = new AgendaExameDAO();
				
				
				exame.setTokenExame(tokenAgendamento);
				exame.setCpf(cpf);
				exame.setNomePaciente(nome);
				exame.setMedicoSolicitante(medicoSolicitante);
				exame.setNomeDoExame(nomeExame);
				exame.setDataExame(dataExame);
				exame.setHoraExame(horaExame);
				exame.setDescricaoExame(descricao);
				
				
				
				ageDAO.agendarExame(exame);
				
				agendamentoExames.dispose();
				
			}
		});
	}
	

	
	private void carregarMedicos() {
		MedicoDAO medicosDAO = new MedicoDAO();
		List<Medico> listaDeMedicos = medicosDAO.listarTodosOsMedicos();
		for(Medico medicos: listaDeMedicos) {
			String nomeMedico = medicos.getNomeMedico();
			cbMedicoSolicitante.addItem(nomeMedico);
		}
 	}
	
	private void carregarExames() {
		ExameDAO examesDAO = new ExameDAO();
		List<Exame> listaExame  = examesDAO.listarTodosExames();
		for(Exame exames : listaExame) {
			String nomeExame = exames.getNomeDoExame();
			cbNomeExame.addItem(nomeExame);
		}
	}
	
	
	private void updateDescricao(String selectExame) {
		ExameDAO exameDAO = new ExameDAO();
		String descricao = exameDAO.descricaoPorNome(selectExame);
		taDescricao.setText(descricao);
	}
	
	
	private void calendarioAnual() {
		JFrame calendarioAnual = new JFrame();
		calendarioAnual.setSize(300, 300);
		
		Calendar calendar = Calendar.getInstance();
		
		JPanel painelCalendario = new JPanel(new GridLayout(3,4,10,10));
		JPanel calendarioPainel = criarCalendario(calendar);
		
		painelCalendario.add(calendarioPainel);
		
		calendarioAnual.add(painelCalendario);
		calendarioAnual.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		calendarioAnual.setVisible(true);
	}
	
	
	private JPanel criarCalendario(Calendar calendar) {
		JPanel painel = new JPanel(new BorderLayout());
		
		JXDatePicker datePicker = new JXDatePicker();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		JButton escolherData = new JButton("Escolher Data");
		
		escolherData.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date date = datePicker.getDate();
				String dataFormatada = sdf.format(date);
				txDataExame.setText(dataFormatada);
				
				Window wp = SwingUtilities.getWindowAncestor(escolherData);
				
				if(wp != null) {
					wp.dispose();
				}
			}
		});
		
		painel.add(datePicker , BorderLayout.CENTER);
		painel.add(escolherData , BorderLayout.EAST);
		return painel;
	}


	public static void main(String[] args) {
		new AgendamentoExames()
				.setAgendamentoExames();
	}



}
