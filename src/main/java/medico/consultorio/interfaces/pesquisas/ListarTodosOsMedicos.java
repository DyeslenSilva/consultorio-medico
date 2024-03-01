package medico.consultorio.interfaces.pesquisas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import medico.consultorio.database.dao.MedicoDAO;
import medico.consultorio.model.Medico;

public class ListarTodosOsMedicos {

	private JFrame listarTodosOsMedicos;
	private JButton btListarTodosOsMedicos;
	private JTable todosOsMedicos;
	private DefaultTableModel dtmTodosOsMedicos;
	private JScrollPane jScrollPane;
	
	
	public ListarTodosOsMedicos() {
		listarTodosOsMedicos = new JFrame();
		
		btListarTodosOsMedicos = new JButton("Listar Todos os Medicos");
		
		todosOsMedicos = new JTable();
		dtmTodosOsMedicos = new DefaultTableModel();
		jScrollPane = new JScrollPane(todosOsMedicos);
	}
	
	public void setListarTodosOsMedicos() {
		listarTodosOsMedicos.setSize(2200, 600);
		listarTodosOsMedicos.setLayout(new FlowLayout());
		listarTodosOsMedicos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		componentes();
		
		jScrollPane.setPreferredSize(new Dimension(1200, 400));
		listarTodosOsMedicos.add(jScrollPane);
		listarTodosOsMedicos.setVisible(true);
	}
	
	private void componentes() {
		listarTodosOsMedicos.add(btListarTodosOsMedicos);
		
		btListarTodosOsMedicos.setBounds(10, 10, 190, 40);
			
		btListarTodosOsMedicos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MedicoDAO medicoDAO  = new MedicoDAO();
				List<Medico> listaDeMedicos = medicoDAO.listarTodosOsMedicos();
				DefaultTableModel dtm = dtmTodosOsMedicos;
				
				//dtm.setRowCount(0);
				
				dtm.addColumn("CRM");
				dtm.addColumn("Nome do Medico");
				dtm.addColumn("Especialidade");
				dtm.addColumn("DDD");
				dtm.addColumn("Telefone");
				dtm.addColumn("Email");
				dtm.addColumn("Cidade");
				dtm.addColumn("UF");
				
				
				
				for(Medico medicos : listaDeMedicos) {
					Object[] row =	{
							medicos.getCrm(),
							medicos.getNomeMedico(),
							medicos.getEspecialidade(),
							medicos.getDdd(),
							medicos.getTelefone(),
							medicos.getEmail(),
							medicos.getCidade(),
							medicos.getEstado()
					};
					dtm.addRow(row);
							
				}
				todosOsMedicos.setModel(dtm);
				ajusteTamanhoColuna();
			}
			
		});
	}
	  private void ajusteTamanhoColuna() {
	    	for(int i =0; i<todosOsMedicos.getColumnCount(); i++) {
	    		todosOsMedicos.getColumnModel().getColumn(i)
	    			.setPreferredWidth(150);
	    	}
	    }
	
	public static void main(String[] args) {
		new ListarTodosOsMedicos()
			.setListarTodosOsMedicos();
	}
	
}
