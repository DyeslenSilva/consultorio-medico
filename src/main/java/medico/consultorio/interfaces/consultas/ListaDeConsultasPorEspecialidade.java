package medico.consultorio.interfaces.consultas;

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

import medico.consultorio.database.dao.ConsultaDAO;
import medico.consultorio.model.ConsultaMedica;

public class ListaDeConsultasPorEspecialidade {

	private JFrame listaPorEspecialidade;
	private JLabel lbEspecialidade;
	private JTextField txEspecialidade;
	private JButton btBuscarEspecialidade;
	private JTable listaConsultaEspecialidade;
	private JScrollPane jScrollPane;
	private DefaultTableModel dtm;
	
	
	public ListaDeConsultasPorEspecialidade() {
		listaPorEspecialidade = new JFrame();
		
		lbEspecialidade = new JLabel("Especialidade");
		
		txEspecialidade = new JTextField();
		
		listaConsultaEspecialidade = new JTable();
		jScrollPane = new JScrollPane(listaConsultaEspecialidade);
		dtm = new DefaultTableModel();
		
		
		btBuscarEspecialidade = new JButton("Buscar Especialidade");
	}
	
	
	public void setListaPorEspecialidade() {
		listaPorEspecialidade.setSize(1000, 600);
		listaPorEspecialidade.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		comps();
		
		listaPorEspecialidade.setLayout(null);
		listaPorEspecialidade.setVisible(true);
	}
	
	private void comps() {
		listaPorEspecialidade.add(lbEspecialidade);
		listaPorEspecialidade.add(txEspecialidade);
		listaPorEspecialidade.add(btBuscarEspecialidade);
		listaPorEspecialidade.add(jScrollPane);
		
		
		lbEspecialidade.setBounds(10, 10, 100, 20);
		txEspecialidade.setBounds(100, 10, 100, 20);
		btBuscarEspecialidade.setBounds(360, 10, 160, 20);
		
		jScrollPane.setBounds(10, 60, 930, 400);
		
		
		btBuscarEspecialidade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String especialidade = txEspecialidade.getText();
				ConsultaDAO consDAO = new ConsultaDAO();
				List<ConsultaMedica> listaConsMed = consDAO.
								listaConsultaPorEspecialidade(especialidade);
				
				dtm.addColumn("Token");
				dtm.addColumn("CPF");
				dtm.addColumn("Nome do Paciente");
				dtm.addColumn("Nome do Medico");
				dtm.addColumn("Especialidade");
				dtm.addColumn("Data da Consulta");
				dtm.addColumn("Hora da Consulta");
				dtm.addColumn("Endereco");
				dtm.addColumn("N");
				dtm.addColumn("Cidade");
				dtm.addColumn("Estado");
				
				for(ConsultaMedica cm : listaConsMed) {
					Object[] row = {
							cm.getToken(),
							cm.getNomeDoPaciente(),
							cm.getNomeMedico(),
							cm.getEspecialidade(),
							cm.getDataDaConsulta(),
							cm.getHoraDaConsulta(),
							cm.getEndereco(),
							cm.getN(),
							cm.getCidade(),
							cm.getEstado()
					};
					
					dtm.addRow(row);
				}
				listaConsultaEspecialidade.setModel(dtm);
				ajustarTamanho();
 			}
		});
	}
	
	
	private void ajustarTamanho() {
		for(int i = 0; i<listaConsultaEspecialidade.getColumnCount(); i++) {
			listaConsultaEspecialidade.getColumnModel().getColumn(i)
					.setPreferredWidth(150);
		}
	}
	
	public static void main(String[] args) {
		new ListaDeConsultasPorEspecialidade()
			.setListaPorEspecialidade();
	}
	
}
