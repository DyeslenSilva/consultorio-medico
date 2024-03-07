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
import medico.consultorio.model.Exame;
import medico.consultorio.model.AgendaExames;

public class ListaExameAgendadoPorExame {

	
	private JFrame listaExameAgNoEx;
	private JLabel lbCodigoDoExame;
	private JTextField txNomeDoExame;
	private JButton btListarExame;
	private JTable listaDeExames;
	private JScrollPane jScrollPane;
	private DefaultTableModel dtm;
	
	
	public ListaExameAgendadoPorExame() {
		listaExameAgNoEx = new JFrame();
		
		lbCodigoDoExame = new JLabel("Nome do Exame");
		
		txNomeDoExame = new JTextField();
		
		btListarExame = new JButton("Listar Exame");
		
		listaDeExames = new JTable();
		jScrollPane = new JScrollPane(listaDeExames);
		dtm = new DefaultTableModel();
	}
	
	public void setListaExameAgNoEx() {
		listaExameAgNoEx.setSize(1000, 600);
		listaExameAgNoEx.setLayout(null);
		
		comps();
		
		listaExameAgNoEx.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		listaExameAgNoEx.setVisible(true);
	}

	private void comps() {
		listaExameAgNoEx.add(lbCodigoDoExame);
		listaExameAgNoEx.add(txNomeDoExame);
		listaExameAgNoEx.add(btListarExame);
		listaExameAgNoEx.add(jScrollPane);
		
		jScrollPane.setBounds(20, 50, 900, 400);
		lbCodigoDoExame.setBounds(10, 10, 100, 20);
		txNomeDoExame.setBounds(130, 10, 100, 20);
		btListarExame.setBounds(250, 10, 190, 20);
		
		btListarExame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String exame = txNomeDoExame.getText();
				AgendaExameDAO ageDAO = new AgendaExameDAO();
				List<AgendaExames> marcaExames = ageDAO.listaExamePorExame(exame);
				
				dtm.addColumn("Token Exame");
				dtm.addColumn("cpf");
				dtm.addColumn("Nome do Paciente");
				dtm.addColumn("Nome do Exame");
				dtm.addColumn("Medico Solicitante");
				dtm.addColumn("Descricao do Exame");
				dtm.addColumn("Data do Exame");
				dtm.addColumn("Hora do Exame");
				
				for(AgendaExames mce : marcaExames) {
					Object[] row = {
							mce.getTokenExame(),
							mce.getCpf(),
							mce.getNomePaciente(),
							mce.getNomeDoExame(),
							mce.getMedicoSolicitante(),
							mce.getDescricaoExame(),
							mce.getDataExame(),
							mce.getHoraExame()
					};
					
					dtm.addRow(row);
				}
				ajustarTamanho();
				listaDeExames.setModel(dtm);
				
			}
		});
		
		
		
	}
	private void ajustarTamanho() {
		for(int i = 0; i<listaDeExames.getColumnCount(); i++) {
			listaDeExames.getColumnModel().getColumn(i)
					.setPreferredWidth(150);
		}
	}
	public static void main(String[] args) {
		new ListaExameAgendadoPorExame()
			.setListaExameAgNoEx();
	}
	
}
