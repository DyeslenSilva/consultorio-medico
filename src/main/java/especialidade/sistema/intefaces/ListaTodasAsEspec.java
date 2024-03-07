package especialidade.sistema.intefaces;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListaTodasAsEspec {

	private JFrame listaTodasAsEspec;
	private JButton btListarTodasAsEspec;
	private JTable todasAsEspec;
	private JScrollPane jScrollPane;
	private DefaultTableModel dtm;
	
	
	public ListaTodasAsEspec() {
		listaTodasAsEspec = new JFrame();
		
		btListarTodasAsEspec = new JButton();
		
		todasAsEspec = new JTable();
		
		jScrollPane = new JScrollPane(todasAsEspec);
	}
	
	public void setListaTodasAsEspec() {
		listaTodasAsEspec.setSize(300, 300);
		listaTodasAsEspec.setLayout(null);
		listaTodasAsEspec.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		listaTodasAsEspec.setVisible(true);
	}
	
}
