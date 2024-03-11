package especialidade.sistema.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import especialidade.sistema.dao.EspecialidadeDAO;
import especialidade.sistema.model.Especialidades;

public class ListaTodasAsEspec {

	private JFrame listaTodasAsEspec;
	private JButton btListarTodasAsEspec;
	private JTable todasAsEspec;
	private JScrollPane jScrollPane;
	private DefaultTableModel dtm;
	
	
	public ListaTodasAsEspec() {
		listaTodasAsEspec = new JFrame();
		
		btListarTodasAsEspec = new JButton("Listar Todas as Funcionalidades");
		
		todasAsEspec = new JTable();
		
		jScrollPane = new JScrollPane(todasAsEspec);
		dtm = new DefaultTableModel();
	}
	
	public void setListaTodasAsEspec() {
		listaTodasAsEspec.setSize(1300, 600);
		listaTodasAsEspec.setLayout(null);
		
		comps();
		
		listaTodasAsEspec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		listaTodasAsEspec.setVisible(true);
	}
	
	
	private void comps() {
		listaTodasAsEspec.add(btListarTodasAsEspec);
		listaTodasAsEspec.add(jScrollPane);
		
		btListarTodasAsEspec.setBounds(10, 10, 250, 40);
		jScrollPane.setBounds(10, 60, 1000, 450);
		
		btListarTodasAsEspec.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EspecialidadeDAO especDAO = new EspecialidadeDAO();
				List<Especialidades> listaEspec = especDAO.listaTodasEspecialidades();
				
				dtm.addColumn("Sigla Especialidade");
				dtm.addColumn("Nome da Especialidade");
				
				for(Especialidades espec : listaEspec) {
					Object[] row = {
						espec.getSiglaEspecialidade(),
						espec.getNomeEspecialidade(),
					};
					dtm.addRow(row);
				}
				todasAsEspec.setModel(dtm);
			}
		});
	}

	public static void main(String[] args) {
		new ListaTodasAsEspec()
			.setListaTodasAsEspec();
	}
	
}
