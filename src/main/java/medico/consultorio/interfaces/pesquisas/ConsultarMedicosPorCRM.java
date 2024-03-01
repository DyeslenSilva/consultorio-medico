package medico.consultorio.interfaces.pesquisas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import medico.consultorio.database.dao.MedicoDAO;
import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.Medico;

public class ConsultarMedicosPorCRM {
	
	private JFrame consultarMedicosPorCRM;
	private JLabel lbCRM;
	private JTextField txCRM;
	private JButton btBuscar;
	private JTable medicosPorCRM;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;
	
	
	public ConsultarMedicosPorCRM() {
		consultarMedicosPorCRM = new JFrame();
		
		lbCRM = new JLabel("CRM");
		
		txCRM = new JTextField();
		 
		btBuscar = new JButton("Buscar");
		
		dtm = new DefaultTableModel();
		medicosPorCRM = new JTable();
		jScrollPane = new JScrollPane(medicosPorCRM);
		
		
	}

	public void setConsultarMedicosPorCRM() {
		consultarMedicosPorCRM.setSize(1050, 600);
		consultarMedicosPorCRM.setLayout(null);
		
		componentes();
		
		consultarMedicosPorCRM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consultarMedicosPorCRM.setVisible(true);
	}
	
	private void componentes() {
		consultarMedicosPorCRM.add(lbCRM);
		consultarMedicosPorCRM.add(txCRM);
		consultarMedicosPorCRM.add(btBuscar);
		consultarMedicosPorCRM.add(jScrollPane);
		
		lbCRM.setBounds(10, 10, 100, 20);
		txCRM.setBounds(60, 10, 100, 20);
		btBuscar.setBounds(190, 10, 100, 20);
		jScrollPane.setBounds(10, 70, 1000, 600);
		
		btBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String crm = txCRM.getText();
				MedicoDAO medicoDAO = new MedicoDAO();
				Medico medico =medicoDAO.buscaMedicoPorCRM(crm);
				
				dtm.addColumn("crm");
				dtm.addColumn("nomeDoMedico");
				dtm.addColumn("especialidade");
				dtm.addColumn("ddd");
				dtm.addColumn("telefone");
				dtm.addColumn("email");
				dtm.addColumn("cidade");
				dtm.addColumn("estado");

				if(medico !=null) {
					Object[] rowData = {
							medico.getCrm(),
							medico.getNomeMedico(),
							medico.getEspecialidade(),
							medico.getDdd(),
							medico.getTelefone(),
							medico.getEmail(),
							medico.getCidade(),
							medico.getEstado()
					};
					
					dtm.addRow(rowData);
				}
				
			}
		});
		medicosPorCRM.setModel(dtm);
		ajusteColuna();
		
	}
	
	
	private void ajusteColuna() {
			for(int i =0; i< medicosPorCRM.getColumnCount(); i++) {
				medicosPorCRM.getColumnModel().getColumn(i)
					.setPreferredWidth(150);
			}
	}
	
	
	public static void main(String[] args) {
		new ConsultarMedicosPorCRM()
				.setConsultarMedicosPorCRM();
	}
}