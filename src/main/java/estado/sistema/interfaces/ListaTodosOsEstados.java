package estado.sistema.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import estado.sistema.dao.EstadoDAO;
import estado.sistema.model.Estado;
import medico.consultorio.database.dao.PacienteDAO;

public class ListaTodosOsEstados {
	
	private JFrame listaEstados;
	private JButton listaTodosEstados;
	private JTable tabelaDeEstados;
	private DefaultTableModel dtm;
	private JScrollPane scrollPane;
	
	public ListaTodosOsEstados() {
		listaEstados = new JFrame();
		
		listaTodosEstados = new JButton("Lista de Estados");
		
		tabelaDeEstados = new JTable();
		scrollPane = new JScrollPane(tabelaDeEstados);
		
		dtm = new DefaultTableModel();
		
	}
	
	public void setListaEstados() {
		listaEstados.setSize(1000, 600);
		listaEstados.setLayout(null);
		
		componentes();
		
		listaEstados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		listaEstados.setVisible(true);
	}
	
	
	private void componentes() {
		listaEstados.add(listaTodosEstados);
		listaEstados.add(scrollPane);
		
		scrollPane.setBounds(10, 70, 500, 500);
		listaTodosEstados.setBounds(10, 10, 150, 40);
		
		listaTodosEstados.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EstadoDAO estadoDAO = new EstadoDAO();
				List<Estado> listaEstado = estadoDAO.listaTodosEstados();
				dtm = new DefaultTableModel();
				
				dtm.addColumn("UF");
				dtm.addColumn("Estado");
				
				for(Estado estadosLista: listaEstado) {
					Object[] row = {
							estadosLista.getUf(),
							estadosLista.getNomeEstado(),
						
					};
					dtm.addRow(row);
				}
				tabelaDeEstados.setModel(dtm);
				ajustarColuna();
			}
		});
		
	}
	
	private void ajustarColuna() {
		for(int i =0; i<tabelaDeEstados.getColumnCount(); i++) {
			tabelaDeEstados.getColumnModel().getColumn(i)
				.setPreferredWidth(150);
		}
	}
	
	
	public static void main(String[] args) {
		new ListaTodosOsEstados()
			.setListaEstados();
	}
	
}
