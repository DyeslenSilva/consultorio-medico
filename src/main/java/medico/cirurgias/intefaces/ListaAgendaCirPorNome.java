package medico.cirurgias.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import medico.cirurgias.model.Cirurgias;

public class ListaAgendaCirPorNome {

	private JFrame listaCirNome;
	private JLabel lbNomeCirurgia;
	private JButton btListaCirurgia;
	private JComboBox<Cirurgias> cirurgias;
	private JTable tbListaAgenda;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;
	
	public ListaAgendaCirPorNome() {
		listaCirNome = new JFrame();
		
		lbNomeCirurgia = new JLabel("Nome da Cirurgia");
		
		btListaCirurgia = new JButton("Listar Cirurgia");
		
		cirurgias = new JComboBox<Cirurgias>();
		
		tbListaAgenda = new JTable();
		
		jScrollPane = new JScrollPane(tbListaAgenda);
		dtm = new DefaultTableModel();
	}
	
	
	public void setListaCirNome() {
		listaCirNome.setSize(1300, 600);
		listaCirNome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		comps();
		
		listaCirNome.setLayout(null);
		listaCirNome.setVisible(true);
	}


	private void comps() {
		listaCirNome.add(lbNomeCirurgia);
		listaCirNome.add(cirurgias);
		listaCirNome.add(btListaCirurgia);
		listaCirNome.add(jScrollPane);
		
		lbNomeCirurgia.setBounds(10, 10, 100, 20);
		cirurgias.setBounds(140, 10, 160, 20);
		btListaCirurgia.setBounds(320, 10, 140, 20);
		jScrollPane.setBounds(10, 40, 1000, 400);
		
		btListaCirurgia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	public static void main(String[] args) {
		new ListaAgendaCirPorNome()
				.setListaCirNome();
	}
	
}
