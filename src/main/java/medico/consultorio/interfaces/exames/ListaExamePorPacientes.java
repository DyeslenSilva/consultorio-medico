package medico.consultorio.interfaces.exames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import medico.consultorio.database.dao.AgendaExameDAO;
import medico.consultorio.model.AgendaExames;

public class ListaExamePorPacientes {

	
	private JFrame janelaListaPacientesExame;
	private JLabel lbCPF , lbNome;
	private JTextField txCPF , txNome;
	private JButton listaExamesPacientes, listaExamePaciente;
	private JTable listaDeExamesPorPacientes;
	private JScrollPane jScrollPane;
	private DefaultTableModel dtm;
	
	
	public ListaExamePorPacientes() {
		janelaListaPacientesExame = new JFrame();
		
		lbCPF = new JLabel("CPF");
		lbNome = new JLabel("Nome");
		
		txCPF = new JTextField();
		txNome = new JTextField();
		
		listaExamesPacientes = new JButton("Listar Exames");
		listaExamePaciente = new JButton("Listar Exames");
		
		listaDeExamesPorPacientes = new JTable();
		jScrollPane = new JScrollPane(listaDeExamesPorPacientes);
		dtm = new DefaultTableModel();
	}
	
	public void setJanelaListaPacientesExame() {
		janelaListaPacientesExame.setSize(1000, 600);
		janelaListaPacientesExame.setLayout(null);
		
		comps();
		
		janelaListaPacientesExame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janelaListaPacientesExame.setVisible(true);
	}

	private void comps() {
		janelaListaPacientesExame.add(lbCPF);
		janelaListaPacientesExame.add(lbNome);
		janelaListaPacientesExame.add(txCPF);
		janelaListaPacientesExame.add(txNome);
		janelaListaPacientesExame.add(listaExamesPacientes);
		janelaListaPacientesExame.add(listaExamePaciente);
		janelaListaPacientesExame.add(jScrollPane);
		
		
		lbCPF.setBounds(10, 10, 100, 20);
		txCPF.setBounds(60, 10, 100, 20);
		lbNome.setBounds(410, 10, 100, 20);
		txNome.setBounds(470, 10, 130, 20);
		listaExamesPacientes.setBounds(200, 10, 150, 20);
		listaExamePaciente.setBounds(610, 10, 140, 20);
		jScrollPane.setBounds(20, 40, 950, 450);
		
		listaExamesPacientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cpf = txCPF.getText();
				AgendaExameDAO agendaExameDAO = new AgendaExameDAO();
				
				List<AgendaExames> listaExames = agendaExameDAO.listaExamePorCPF(cpf);
				
					dtm.addColumn("Token Exame");
					dtm.addColumn("cpf");
					dtm.addColumn("Nome do Paciente");
					dtm.addColumn("Nome do Exame");
					dtm.addColumn("Medico Solicitante");
					dtm.addColumn("Descricao do Exame");
					dtm.addColumn("Data do Exame");
					dtm.addColumn("Hora do Exame");
				
					for(AgendaExames age : listaExames) {
						Object[] row = {
							age.getTokenExame(),
							age.getCpf(),
							age.getNomePaciente(),
							age.getNomeDoExame(),
							age.getMedicoSolicitante(),
							age.getDescricaoExame(),
							age.getDataExame(),
							age.getHoraExame()
						};
						dtm.addRow(row);
					}
					
					listaDeExamesPorPacientes.setModel(dtm);
					ajustarTamanho();
			}
		});
		
		listaExamePaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String nomePaciente = txNome.getText();
				AgendaExameDAO ageDAO = new AgendaExameDAO();
				List<AgendaExames> exameListas = ageDAO
												.listaExamePorNomePaciente(nomePaciente);
				
				dtm.addColumn("Token Exame");
				dtm.addColumn("cpf");
				dtm.addColumn("Nome do Paciente");
				dtm.addColumn("Nome do Exame");
				dtm.addColumn("Medico Solicitante");
				dtm.addColumn("Descricao do Exame");
				dtm.addColumn("Data do Exame");
				dtm.addColumn("Hora do Exame");
				
				for(AgendaExames age : exameListas) {
					Object[] row = {
						age.getTokenExame(),
						age.getCpf(),
						age.getNomePaciente(),
						age.getNomeDoExame(),
						age.getMedicoSolicitante(),
						age.getDescricaoExame(),
						age.getDataExame(),
						age.getHoraExame()
					};
					dtm.addRow(row);
				}
				listaDeExamesPorPacientes.setModel(dtm);
				ajustarTamanho();
				
			}
		});
		
		
	}
	
	
	private void ajustarTamanho() {
		for(int i = 0; i<listaDeExamesPorPacientes.getColumnCount(); i++) {
			listaDeExamesPorPacientes.getColumnModel().getColumn(i)
					.setPreferredWidth(150);
		}
	}
	
	public static void main(String[] args) {
		new ListaExamePorPacientes()
				.setJanelaListaPacientesExame();
	}
}
