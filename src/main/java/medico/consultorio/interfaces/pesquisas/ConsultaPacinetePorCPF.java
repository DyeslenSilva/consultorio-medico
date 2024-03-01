package medico.consultorio.interfaces.pesquisas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.Paciente;

public class ConsultaPacinetePorCPF {

	private JFrame consultaPacienteCPF;
	private JLabel lbCPF;
	private JTextField txCPF;
	private JButton btConsultaPaciente;
	private JTable pacientePorCPF;
	private DefaultTableModel dtmPaciente;
	private JScrollPane jScrollPane;
	
	public ConsultaPacinetePorCPF(){
		consultaPacienteCPF = new JFrame("Consulta de Pacientes");
		
		lbCPF = new JLabel("CPF");
		
		txCPF = new JTextField();
		
		dtmPaciente = new DefaultTableModel();
		pacientePorCPF = new JTable();
		jScrollPane = new JScrollPane(pacientePorCPF);
		
		btConsultaPaciente = new JButton("Consulta Paciente");
	}
	
	public void setConsultaClienteCPF() {
		consultaPacienteCPF.setSize(700, 700);
		consultaPacienteCPF.setLayout(null);
		
		componentesDaJanela();
		
		consultaPacienteCPF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consultaPacienteCPF.setVisible(true);
	}
	
	private void componentesDaJanela() {
		consultaPacienteCPF.add(lbCPF);
		consultaPacienteCPF.add(txCPF);
		consultaPacienteCPF.add(btConsultaPaciente);
		consultaPacienteCPF.add(jScrollPane);
		
		lbCPF.setBounds(10, 10, 100, 20);
		txCPF.setBounds(60, 10, 100, 20);
		btConsultaPaciente.setBounds(180, 10, 150, 20);
		jScrollPane.setBounds(10, 40, 600,500);
		btConsultaPaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					String cpf = txCPF.getText();
					PacienteDAO pacienteDAO = new PacienteDAO();
					Paciente paciente = pacienteDAO.consultaClientePorCPF(cpf);
					
					dtmPaciente.addColumn("CPF");
	                dtmPaciente.addColumn("Nome Completo");
	                dtmPaciente.addColumn("DDD");
	                dtmPaciente.addColumn("Telefone");
	                dtmPaciente.addColumn("Endereco");
	                dtmPaciente.addColumn("N");
	                dtmPaciente.addColumn("Cidade");
	                dtmPaciente.addColumn("UF");	

						if(paciente !=null) {
							Object[] rowData = {
									paciente.getCpf(),
									paciente.getNomePaciente(),
									paciente.getDdd(),
									paciente.getTelefone(),
									paciente.getEndereco(),
									paciente.getNCasa(),
									paciente.getCidade(),
									paciente.getEstado()
							};
							dtmPaciente.addRow(rowData);
						}
						pacientePorCPF.setModel(dtmPaciente);
						ajusteColuna();
					
					}

		
		});
		
	}
	
	private void ajusteColuna() {
    	pacientePorCPF.getColumnModel().getColumn(0).setPreferredWidth(330); // CPF
        pacientePorCPF.getColumnModel().getColumn(1).setPreferredWidth(440);// Nome Completo
        pacientePorCPF.getColumnModel().getColumn(2).setPreferredWidth(100);//DDD
        pacientePorCPF.getColumnModel().getColumn(3).setPreferredWidth(350); // Telefone
        pacientePorCPF.getColumnModel().getColumn(4).setPreferredWidth(550); // Endereco
        pacientePorCPF.getColumnModel().getColumn(5).setPreferredWidth(50);  // N
        pacientePorCPF.getColumnModel().getColumn(6).setPreferredWidth(350); // Cidade
        pacientePorCPF.getColumnModel().getColumn(7).setPreferredWidth(50); // Estado

	}
	
	public static void main(String[] args) {
		new ConsultaPacinetePorCPF().setConsultaClienteCPF();
	}
	
}
