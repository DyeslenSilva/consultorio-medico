package medico.consultorio.interfaces.exames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import medico.consultorio.database.dao.ExameDAO;
import medico.consultorio.model.Exame;

public class ListaTodosExames {

	
	private JFrame listaTodosExames;
	private JButton btListaDeTodosExames;
	private JTable listaExames;
	private JScrollPane jScrollPane;
	private DefaultTableModel dtm;
	
	public ListaTodosExames() {
		listaTodosExames = new JFrame();
		
		btListaDeTodosExames = new JButton("Lista de Todos os Exames");
		
		listaExames = new JTable();
		
		dtm = new DefaultTableModel();
		
		jScrollPane = new JScrollPane(listaExames);
	}
	
	public void setListaTodosExames() {
		listaTodosExames.setSize(600, 400);
		listaTodosExames.setLayout(null);
		
		comps();
		
		listaTodosExames.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		listaTodosExames.setVisible(true);
	}

	private void comps() {
		listaTodosExames.add(btListaDeTodosExames);
		listaTodosExames.add(jScrollPane);
		
		btListaDeTodosExames.setBounds(10, 10, 250, 40);
		jScrollPane.setBounds(10, 60, 570, 340);
		
		btListaDeTodosExames.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ExameDAO exDAO = new ExameDAO();
				List<Exame> todosOsExames = exDAO.listarTodosExames();
				
				dtm.addColumn("Codigo do Exame");
				dtm.addColumn("Nome do Exame");
				dtm.addColumn("Descricao");
				
				for(Exame exm : todosOsExames) {
						Object[] row = {
								exm.getCodigoDoExame(),
								exm.getNomeDoExame(),
								exm.getDescricao()
						};
						dtm.addRow(row);
						listaExames.setModel(dtm);
				}
			}
		});
	}
	
	
	public static void main(String[] args) {
		new ListaTodosExames()
			.setListaTodosExames();
	}
}
