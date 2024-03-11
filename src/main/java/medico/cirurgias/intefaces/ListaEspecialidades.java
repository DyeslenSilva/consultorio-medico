package medico.cirurgias.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import medico.cirurgias.dao.EspecialidadeDAO;
import medico.cirurgias.model.Especialidades;

public class ListaEspecialidades {
	
	private JFrame listaEspecialialidade;
	private JButton listarEspecialidades;
	private JTable tbListaEspecialidade;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;
	
	public ListaEspecialidades() {
		listaEspecialialidade = new JFrame();
		
		listarEspecialidades = new JButton("Listar Especialidades");
		
		dtm = new DefaultTableModel();
		tbListaEspecialidade = new JTable(dtm);

		jScrollPane = new JScrollPane(tbListaEspecialidade);
	}
	
	
	public void setListaEspecialialidade() {
		listaEspecialialidade.setSize(1000,500);
		listaEspecialialidade.setLayout(null);
		comps();
		
		listaEspecialialidade.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		listaEspecialialidade.setVisible(true);
	}


	private void comps() {
		listaEspecialialidade.add(listarEspecialidades);
		listaEspecialialidade.add(jScrollPane);
		
		jScrollPane.setBounds(10, 55, 850, 356);
		listarEspecialidades.setBounds(10, 10, 190, 40);
		
		listarEspecialidades.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EspecialidadeDAO especDAO = new EspecialidadeDAO();
				
				List<Especialidades> listaEspec = especDAO.listaTodasEspecialidades();
				
				dtm.addColumn("Id Especialidade");
				dtm.addColumn("Nome da Especialidade");
				
				for(Especialidades especs: listaEspec) {
					Object[] rowData = {
							especs.getIdEspecialidade(),
							especs.getNomeEspecialidade()
					};
					
					dtm.addRow(rowData);	
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
		new ListaEspecialidades()
			.setListaEspecialialidade();
	}
	
	
	
}
