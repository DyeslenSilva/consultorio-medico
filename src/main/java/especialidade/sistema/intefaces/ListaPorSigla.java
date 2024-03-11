package especialidade.sistema.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import especialidade.sistema.dao.EspecialidadeDAO;
import especialidade.sistema.model.Especialidades;

public class ListaPorSigla {

	private JFrame listaPorSigla;
	private JLabel lbSigla;
	private JTextField txSigla;
	private JButton btBuscarSigla;
	private JTable tbListaPorSigla;
	private JScrollPane jScrollPane;
	private DefaultTableModel dtm;
	
	
	public ListaPorSigla() {
		listaPorSigla = new JFrame();
		
		lbSigla = new JLabel("Sigla");
		
		txSigla = new JTextField();
		
		tbListaPorSigla = new JTable();
		jScrollPane = new JScrollPane(tbListaPorSigla);
		dtm = new DefaultTableModel();
		
		btBuscarSigla = new JButton("Buscar Sigla");
	}
	
	public void setListaPorSigla() {
		listaPorSigla.setSize(1000, 600);
		listaPorSigla.setLayout(null);
		
		comps();
		
		listaPorSigla.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		listaPorSigla.setVisible(true);
	}

	private void comps() {
		listaPorSigla.add(lbSigla);
		listaPorSigla.add(txSigla);
		listaPorSigla.add(btBuscarSigla);
		listaPorSigla.add(jScrollPane);
		
		lbSigla.setBounds(10, 10, 100, 20);
		txSigla.setBounds(100, 10, 100, 20);
		btBuscarSigla.setBounds(250, 10, 160, 20);
		jScrollPane.setBounds(10, 52, 750, 450);
		
		btBuscarSigla.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String sigla = txSigla.getText();
				EspecialidadeDAO dao = new EspecialidadeDAO();
				Especialidades espec = dao.especPorSigla(sigla);
				
				dtm.addColumn("Sigla Especialidade");
				dtm.addColumn("Nome da Especialidade");
				
				if(espec != null) {
					Object[] row = {
							espec.getSiglaEspecialidade(),
							espec.getNomeEspecialidade()
					};
					dtm.addRow(row);
				}
				tbListaPorSigla.setModel(dtm);

			}
		});
		
	}
	
	
	public static void main(String[] args) {
		new ListaPorSigla().setListaPorSigla();
	}
	
}
