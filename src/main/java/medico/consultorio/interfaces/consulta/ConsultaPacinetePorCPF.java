package medico.consultorio.interfaces.consulta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.Paciente;

public class ConsultaPacinetePorCPF {

	private JFrame consultaPacienteCPF;
	private JLabel lbCPF;
	private JTextField txCPF;
	private JButton btConsultaPaciente;
	
	
	public ConsultaPacinetePorCPF(){
		consultaPacienteCPF = new JFrame("Consulta de Pacientes");
		
		lbCPF = new JLabel("CPF");
		
		txCPF = new JTextField();
		
		btConsultaPaciente = new JButton("Consulta Paciente");
	}
	
	public void setConsultaClienteCPF() {
		consultaPacienteCPF.setSize(450, 100);
		consultaPacienteCPF.setLayout(null);
		
		componentesDaJanela();
		
		consultaPacienteCPF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consultaPacienteCPF.setVisible(true);
	}
	
	private void componentesDaJanela() {
		consultaPacienteCPF.add(lbCPF);
		consultaPacienteCPF.add(txCPF);
		consultaPacienteCPF.add(btConsultaPaciente);
		lbCPF.setBounds(10, 10, 100, 20);
		txCPF.setBounds(60, 10, 100, 20);
		btConsultaPaciente.setBounds(180, 10, 150, 20);
		
		btConsultaPaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					String cpf = txCPF.getText();
					PacienteDAO pacienteDAO = new PacienteDAO();
					Paciente paciente = pacienteDAO.consultaClientePorCPF(cpf);
					
					if(paciente !=null) {
						String mensagem = "CPF: "+paciente.getCpf() + "\nNome Completo: " 
									+ paciente.getNomePaciente() + "\nTelefone: " + paciente.getTelefone()+
									"\nEndereco: "+ paciente.getEndereco()+"\nN Casa: "+ paciente.getNCasa()+
									"\nCidade: "+paciente.getCidade()+ "\nEstado: "+paciente.getEstado();
						
						JOptionPane.showMessageDialog(null, mensagem);
					}else {
						JOptionPane.showMessageDialog(null, "Paciente não Encontrado");
					}
			}
		});
		
	}
	
	public static void main(String[] args) {
		new ConsultaPacinetePorCPF().setConsultaClienteCPF();
	}
	
}
