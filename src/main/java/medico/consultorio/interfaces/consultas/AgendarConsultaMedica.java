package medico.consultorio.interfaces.consultas;

import java.awt.BorderLayout;
import java.awt.Component;
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
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;

import org.jdesktop.swingx.JXDatePicker;

import especialidade.sistema.dao.EspecialidadeDAO;
import especialidade.sistema.model.Especialidades;
import estado.sistema.dao.EstadoDAO;
import medico.consultorio.database.dao.ConsultaDAO;
import medico.consultorio.database.dao.MedicoDAO;
import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.ConsultaMedica;
import medico.consultorio.model.GeradorToken;
import medico.consultorio.model.GerarCPF;
import medico.consultorio.model.Medico;
import medico.consultorio.model.Paciente;

public class AgendarConsultaMedica {

	
	private JFrame agendarConsultaMedica;
	private JLabel lbCPFPaciente, lbNomePaciente, lbMedico,lbEspecialidade,lbDataConsulta;
	private JLabel lbHoraConsulta, lbEndereco, lbNLocal , lbCidadeConsulta , lbEstadoConsulta;
	private JLabel lbTokenConsulta;
	private JTextField txCPF, txNomePaciente,txEspecialidade, txDataConsulta;
	private JTextField txHoraConsulta, txEndereco, txNLocal, txCidadeConsulta, txEstadoConsulta;
	private JTextField txTokenConsulta;
	private JButton btPesquisaPaciente, btCalendarioAnual, btHoraConsulta, btAgendarConsulta;
	private JButton btGerarToken;
	
	private JComboBox<Medico> jcbMedicos;
	private JComboBox<String>estados;
	private JComboBox<Especialidades> especialidades;
	
	
	
	public AgendarConsultaMedica() {
		agendarConsultaMedica = new JFrame("Agendar Consulta Médica");
		
		lbTokenConsulta = new JLabel("Token da Consulta");
		lbCPFPaciente = new JLabel("CPF");
		lbNomePaciente = new JLabel("Nome do Paciente");
		lbMedico = new JLabel("Medico");
		lbEspecialidade = new JLabel("Especialidade");
		lbDataConsulta = new JLabel("Data Da Consulta");
		lbHoraConsulta = new JLabel("Horario da Consulta");
		lbEndereco = new JLabel("Endereco");
		lbNLocal = new JLabel("N");
		lbCidadeConsulta = new  JLabel("Cidade");
		lbEstadoConsulta = new JLabel("Estado");
		
		txTokenConsulta = new JTextField();
		txCPF = new JTextField();
		txNomePaciente = new JTextField();
		txEspecialidade = new JTextField();
		txDataConsulta = new JTextField();
		txHoraConsulta = new JTextField();
		txEndereco = new JTextField();
		txNLocal = new JTextField();
		txCidadeConsulta = new JTextField();
		//txEstadoConsulta = new JTextField();
		
		especialidades = new JComboBox<Especialidades>();
		estados = new JComboBox<String>();
		jcbMedicos = new JComboBox<Medico>();
		estados = new JComboBox<String>();
		btGerarToken = new JButton("Gerar Token");
		btPesquisaPaciente = new JButton("Pesquisa");
		btCalendarioAnual = new JButton("Calendario");
		btHoraConsulta = new JButton("Hora da Consulta");
		btAgendarConsulta = new JButton("Agendar Consulta");
		
		carregarMedicos();
		
	}
	
	public void setAgendarConsultaMedica() {
		agendarConsultaMedica.setSize(500, 450);
		agendarConsultaMedica.setLayout(null);

		jLabel();
		comps();
		jButton();
		jComboBox();
		
		agendarConsultaMedica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		agendarConsultaMedica.setVisible(true);
	}


	private void jLabel() {
		agendarConsultaMedica.add(lbTokenConsulta);
		agendarConsultaMedica.add(lbCPFPaciente);
		agendarConsultaMedica.add(lbNomePaciente);
		agendarConsultaMedica.add(lbMedico);
		agendarConsultaMedica.add(lbEspecialidade);
		agendarConsultaMedica.add(lbDataConsulta);
		agendarConsultaMedica.add(lbHoraConsulta);
		agendarConsultaMedica.add(lbEndereco);
		agendarConsultaMedica.add(lbNLocal);
		agendarConsultaMedica.add(lbCidadeConsulta);
		agendarConsultaMedica.add(lbEstadoConsulta);
		
		lbTokenConsulta.setBounds(10, 10, 140, 20);
		lbCPFPaciente.setBounds(10, 40, 100, 20);
		lbNomePaciente.setBounds(10, 70, 120, 20);
		lbMedico.setBounds(10, 100, 100, 20);
		lbEspecialidade.setBounds(10,130,120,	20);
		lbDataConsulta.setBounds(10,160,120,20);
		lbHoraConsulta.setBounds(10, 190, 120, 20);
		lbEndereco.setBounds(10, 220, 120, 20);
		lbNLocal.setBounds(10, 250, 100, 20);
		lbCidadeConsulta.setBounds(10, 280, 120, 20);
		lbEstadoConsulta.setBounds(10, 310, 120, 20);
	}

	private void comps() {
		agendarConsultaMedica.add(txTokenConsulta);
		agendarConsultaMedica.add(txCPF);
		agendarConsultaMedica.add(txNomePaciente);
		agendarConsultaMedica.add(especialidades);
		agendarConsultaMedica.add(txDataConsulta);
		agendarConsultaMedica.add(txHoraConsulta);
		agendarConsultaMedica.add(txEndereco);
		agendarConsultaMedica.add(txNLocal);
		agendarConsultaMedica.add(txCidadeConsulta);
		
		txTokenConsulta.setBounds(150, 10, 130, 20);
		txCPF.setBounds(150, 40, 130, 20);
		txNomePaciente.setBounds(150, 70, 130, 20);
		especialidades.setBounds(150, 130, 130, 20);
		txDataConsulta.setBounds(150, 160, 130, 20);
		txHoraConsulta.setBounds(150, 190, 130, 20);
		txEndereco.setBounds(150, 220, 130, 20);
		txNLocal.setBounds(150, 250, 130, 20);
		txCidadeConsulta.setBounds(150, 280, 130, 20);
		
	}

	
	
	private void carregarEstados() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<String> listSiglas = estadoDAO.siglaEstado();
		for(String siglas : listSiglas) {
			estados.addItem(siglas);
		}
	}
	
	
	private void carregarEspecialidade() {
		EspecialidadeDAO especDAO = new EspecialidadeDAO();
		
	}
	
	
	private void jButton() {
		agendarConsultaMedica.add(btGerarToken);
		agendarConsultaMedica.add(btPesquisaPaciente);
		agendarConsultaMedica.add(btCalendarioAnual);
		agendarConsultaMedica.add(btHoraConsulta);
		agendarConsultaMedica.add(btAgendarConsulta);
		
		btGerarToken.setBounds(290, 10, 190, 20);
		btPesquisaPaciente.setBounds(290, 40, 190, 20);
		btCalendarioAnual.setBounds(290, 160, 190, 20);
		btHoraConsulta.setBounds(290, 190, 190, 20);
		btAgendarConsulta.setBounds(110, 360, 190, 40);
		
		btGerarToken.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String token = GeradorToken.gerarToken(10);
				txTokenConsulta.setText(token);
				
			}
		});	
		
		btPesquisaPaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cpf = txCPF.getText();
				PacienteDAO pacienteDAO = new PacienteDAO();
				Paciente paciente =pacienteDAO.consultaClientePorCPF(cpf);
				
				if(paciente !=null) {
					txNomePaciente.setText(paciente.getNomePaciente());
				}
			}
		});
		
		btCalendarioAnual.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					mostrarCalendarioAnual();
			}
		});
		
		btHoraConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame horaDaConsulta = new JFrame();
				horaDaConsulta.setSize(300, 200);
				horaDaConsulta.setLayout(new BorderLayout());
				
				SpinnerDateModel timeSpinnerModel = 
							new SpinnerDateModel(new Date(), null,null, Calendar.HOUR_OF_DAY);
				JSpinner timeSpinner = new JSpinner(timeSpinnerModel);
				DateEditor editor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
				timeSpinner.setEditor(editor);
				
				JButton btConfirmarHorario = new JButton("Confirmar Horario");
				
				btConfirmarHorario.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Date horarioSelecionado = (Date) timeSpinner.getValue();
						
						SimpleDateFormat horarioFormatado = new SimpleDateFormat("HH:mm");
						String horaFormatado = horarioFormatado.format(horarioSelecionado);
						txHoraConsulta.setText(horaFormatado);
						
						horaDaConsulta.dispose();
					}
				});
				
				horaDaConsulta.add(timeSpinner, BorderLayout.CENTER);
				horaDaConsulta.add(btConfirmarHorario, BorderLayout.SOUTH);
				horaDaConsulta.setVisible(true);
			}
		});
		
		btAgendarConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String token  = txTokenConsulta.getText();
				String cpf = txCPF.getText();
				String nome = txNomePaciente.getText();
				String medico = ((Medico) jcbMedicos.getSelectedItem()).getNomeMedico();
				String especialidade = txEspecialidade.getText();
				String dataDaConsulta = txDataConsulta.getText();
				String horaDaConsulta = txHoraConsulta.getText();
				String endereco = txEndereco.getText();
				Integer n = Integer.parseInt(txNLocal.getText());
				String cidade = txCidadeConsulta.getText();
				String estado = estados.getSelectedItem().toString();
				
				ConsultaMedica cm = new ConsultaMedica();
				cm.setToken(token);
				cm.setCpf(cpf);
				cm.setNomeDoPaciente(nome);
				cm.setNomeMedico(medico);
				cm.setEspecialidade(especialidade);
				cm.setDataDaConsulta(dataDaConsulta);
				cm.setHoraDaConsulta(horaDaConsulta);
				cm.setEndereco(endereco);
				cm.setN(n);
				cm.setCidade(cidade);
				cm.setEstado(estado);
				
				ConsultaDAO conDAO = new ConsultaDAO();
				conDAO.cadastroDeConsulta(cm);
				limparCaixaDeTexto();
				fecharJanela();
				
			}
		});
		
	}
	
	protected void fecharJanela() {
		agendarConsultaMedica.dispose();
	}

	protected void limparCaixaDeTexto() {
		String vazia = "";
		txTokenConsulta.setText(vazia);
		txCPF.setText(vazia);
		txNomePaciente.setText(vazia);
		txEspecialidade.setText(vazia);
		txDataConsulta.setText(vazia);
		txHoraConsulta.setText(vazia);
		txEndereco.setText(vazia);
		txNLocal.setText(vazia);
		txCidadeConsulta.setText(vazia);
		//txEstadoConsulta.setText(vazia);
	}

	private void jComboBox() {
		agendarConsultaMedica.add(jcbMedicos);
		agendarConsultaMedica.add(estados);
		
		estados.setBounds(150, 310, 130, 20);

		jcbMedicos.setBounds(150, 100, 130, 20);
		
		carregarEstados();
	}
	
	
	private void mostrarCalendarioAnual() {
		JFrame calendarioAnual = new JFrame();
		calendarioAnual.setSize(300,300);
		
		JPanel painel = new JPanel(new  GridLayout(3,4,10,10));
		
			Calendar calendar = Calendar.getInstance();
						
			JPanel painelCalendario = criarPainelCalendario(calendar);
			painel.add(painelCalendario);
		
		
		calendarioAnual.add(painel);
		calendarioAnual.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		calendarioAnual.setVisible(true);
	}
	

	 private JPanel criarPainelCalendario(Calendar calendar) {
	        JPanel painel = new JPanel(new BorderLayout());
	        
	        JXDatePicker datePicker = new JXDatePicker();
	        datePicker.setDate(calendar.getTime());

	        // Configurar o formato da data para "dd/MM/yyyy"
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        datePicker.setFormats(dateFormat);

	        datePicker.setPreferredSize(new Dimension(120,20));
	      
	        JButton escolherData = new JButton("Escolher Data");
	        
	        escolherData.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Date data = datePicker.getDate();
					String dataFormatada = dateFormat.format(data);
					txDataConsulta.setText(dataFormatada);
					
					Window parentWindow = SwingUtilities.getWindowAncestor(escolherData);
					
					if(parentWindow != null) {
						parentWindow.dispose();
					}
				}
			});
	        
	        painel.add(datePicker, BorderLayout.CENTER);
	        painel.add(escolherData, BorderLayout.EAST);
	        
	        return painel;
	    }

	private void carregarMedicos() {
		MedicoDAO medicoDAO = new MedicoDAO();
		List<Medico> medicosCB = medicoDAO.listarTodosOsMedicos();
		
		for(Medico medico: medicosCB) {
			jcbMedicos.addItem(medico);
		}
		
		jcbMedicos.setRenderer(new ListCellRenderer<Medico>() {
	        @Override
	        public Component getListCellRendererComponent(JList<? extends Medico> list,
	                                                      Medico value,
	                                                      int index,
	                                                      boolean isSelected,
	                                                      boolean cellHasFocus) {
	            JLabel label = new JLabel(value.getNomeMedico()); 	
	            if (isSelected) {
	                label.setBackground(list.getSelectionBackground());
	                label.setForeground(list.getSelectionForeground());
	            } else {
	                label.setBackground(list.getBackground());
	                label.setForeground(list.getForeground());
	            }
	            label.setOpaque(true);
	            return label;
	        }
	    });
		
		jcbMedicos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					Medico medicoSelecionado = (Medico) jcbMedicos.getSelectedItem();
					
					if(medicoSelecionado != null) {
						txEspecialidade.setText(medicoSelecionado.getEspecialidade());
					}
			}
		});		
	}

	public static void main(String[] args) {
		new AgendarConsultaMedica().setAgendarConsultaMedica();
	}
	
}