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

import medico.consultorio.database.dao.MedicoDAO;
import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.Medico;
import medico.consultorio.model.Paciente;

public class AgendarConsultaMedica {

	
	private JFrame agendarConsultaMedica;
	private JLabel lbCPFPaciente, lbNomePaciente, lbMedico,lbEspecialidade,lbDataConsulta;
	private JLabel lbHoraConsulta, lbEndereco, lbNLocal , lbCidadeConsulta , lbEstadoConsulta;
	private JTextField txCPF, txNomePaciente,txEspecialidade, txDataConsulta;
	private JTextField txHoraConsulta, txEndereco, txNLocal, txCidadeConsulta, txEstadoConsulta;
	private JButton btPesquisaPaciente, btCalendarioAnual, btHoraConsulta, btAgendarConsulta;
	private JComboBox<Medico> jcbMedicos;
	
	
	
	public AgendarConsultaMedica() {
		agendarConsultaMedica = new JFrame("Agendar Consulta Médica");
		
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
		
		txCPF = new JTextField();
		txNomePaciente = new JTextField();
		txEspecialidade = new JTextField();
		txDataConsulta = new JTextField();
		txHoraConsulta = new JTextField();
		txEndereco = new JTextField();
		txNLocal = new JTextField();
		txCidadeConsulta = new JTextField();
		txEstadoConsulta = new JTextField();
		
		jcbMedicos = new JComboBox<Medico>();
		
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
		jTextField();
		jButton();
		jComboBox();
		
		agendarConsultaMedica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		agendarConsultaMedica.setVisible(true);
	}


	private void jLabel() {
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
		
		lbCPFPaciente.setBounds(10, 10, 100, 20);
		lbNomePaciente.setBounds(10, 40, 120, 20);
		lbMedico.setBounds(10, 70, 100, 20);
		lbEspecialidade.setBounds(10,100,120,	20);
		lbDataConsulta.setBounds(10,130,120,20);
		lbHoraConsulta.setBounds(10, 160, 120, 20);
		lbEndereco.setBounds(10, 190, 120, 20);
		lbNLocal.setBounds(10, 220, 100, 20);
		lbCidadeConsulta.setBounds(10, 250, 120, 20);
		lbEstadoConsulta.setBounds(10, 280, 120, 20);
	}

	private void jTextField() {
		agendarConsultaMedica.add(txCPF);
		agendarConsultaMedica.add(txNomePaciente);
		agendarConsultaMedica.add(txEspecialidade);
		agendarConsultaMedica.add(txDataConsulta);
		agendarConsultaMedica.add(txHoraConsulta);
		agendarConsultaMedica.add(txEndereco);
		agendarConsultaMedica.add(txNLocal);
		agendarConsultaMedica.add(txCidadeConsulta);
		agendarConsultaMedica.add(txEstadoConsulta);
		
		txCPF.setBounds(150, 10, 130, 20);
		txNomePaciente.setBounds(150, 40, 130, 20);
		txEspecialidade.setBounds(150, 100, 130, 20);
		txDataConsulta.setBounds(150, 130, 130, 20);
		txHoraConsulta.setBounds(150, 160, 130, 20);
		txEndereco.setBounds(150, 190, 130, 20);
		txNLocal.setBounds(150, 220, 130, 20);
		txCidadeConsulta.setBounds(150, 250, 130, 20);
		txEstadoConsulta.setBounds(150, 280, 130, 20);
	}

	
	
	
	private void jButton() {
		agendarConsultaMedica.add(btPesquisaPaciente);
		agendarConsultaMedica.add(btCalendarioAnual);
		agendarConsultaMedica.add(btHoraConsulta);
		agendarConsultaMedica.add(btAgendarConsulta);
		
		btPesquisaPaciente.setBounds(290, 10, 190, 20);
		btCalendarioAnual.setBounds(290, 130, 190, 20);
		btHoraConsulta.setBounds(290, 160, 190, 20);
		btAgendarConsulta.setBounds(110, 330, 190, 40);
		
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
	}
	
	private void jComboBox() {
		agendarConsultaMedica.add(jcbMedicos);
		
		jcbMedicos.setBounds(150, 70, 130, 20);
		
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