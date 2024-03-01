package medico.consultorio.interfaces.consultas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.Paciente;

public class AgendarConsultaMedica {

	
	private JFrame agendarConsultaMedica;
	private JLabel lbCPFPaciente, lbNomePaciente;
	private JTextField txCPF, txNomePaciente;
	private JButton btPesquisaPaciente;
	
	public AgendarConsultaMedica() {
		agendarConsultaMedica = new JFrame("Agendar Consulta Médica");
		
		lbCPFPaciente = new JLabel("CPF");
		lbNomePaciente = new JLabel("Nome do Paciente");
		
		txCPF = new JTextField();
		txNomePaciente = new JTextField();
		
		
		btPesquisaPaciente = new JButton("Pesquisa");
		
	}
	
	public void setAgendarConsultaMedica() {
		agendarConsultaMedica.setSize(500, 300);
		agendarConsultaMedica.setLayout(null);

		jLabel();
		jTextField();
		jButton();
		
		agendarConsultaMedica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		agendarConsultaMedica.setVisible(true);
	}


	private void jLabel() {
		agendarConsultaMedica.add(lbCPFPaciente);
		agendarConsultaMedica.add(lbNomePaciente);
		
		lbCPFPaciente.setBounds(10, 10, 100, 20);
		lbNomePaciente.setBounds(10, 40, 120, 20);
	}

	private void jTextField() {
		agendarConsultaMedica.add(txCPF);
		agendarConsultaMedica.add(txNomePaciente);
		
		txCPF.setBounds(150, 10, 130, 20);
		txNomePaciente.setBounds(150, 40, 130, 20);
	}

	
	private void jButton() {
		agendarConsultaMedica.add(btPesquisaPaciente);
		
		btPesquisaPaciente.setBounds(290, 10, 100, 20);
		
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
	}
		
	
	public static void main(String[] args) {
		new AgendarConsultaMedica().setAgendarConsultaMedica();
	}
	
}
	