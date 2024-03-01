package medico.consultorio.interfaces.pesquisas;

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

import medico.consultorio.database.dao.MedicoDAO;
import medico.consultorio.model.Medico;

public class ConsultaMedicoPorEstado {

	private JFrame consultaMedicoPorEstado;
	private JLabel lbEstado;
	private JTextField txEstado;
	private JButton btConsultaMedico;
	private JTable medicoPorEstado;
	private DefaultTableModel dtm;
	private JScrollPane jScrollPane;
	
	
	public ConsultaMedicoPorEstado() {
		consultaMedicoPorEstado = new JFrame();
		
		lbEstado = new JLabel("Estado");
		
		txEstado = new JTextField();
	
		btConsultaMedico = new JButton("Consultar Medico");
	
		medicoPorEstado = new JTable();
		jScrollPane = new JScrollPane(medicoPorEstado);
		
		dtm = new DefaultTableModel();
	}
	
	public void setConsultaMedicoPorEstado() {
		consultaMedicoPorEstado.setSize(600, 400);
		consultaMedicoPorEstado.setLayout(null);
		
		componentes();
		
		consultaMedicoPorEstado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		consultaMedicoPorEstado.setVisible(true);
	}
	
	private void componentes() {
		consultaMedicoPorEstado.add(lbEstado);
		consultaMedicoPorEstado.add(txEstado);
		consultaMedicoPorEstado.add(btConsultaMedico);
		consultaMedicoPorEstado.add(jScrollPane);
		
		lbEstado.setBounds(10, 10, 100, 20);	
		txEstado.setBounds(100, 10, 100, 20);
		btConsultaMedico.setBounds(205, 10, 200, 20);
		jScrollPane.setBounds(50, 40, 1000, 600);
		
		btConsultaMedico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String estado = txEstado.getText();
				MedicoDAO medicoDAO = new  MedicoDAO();
				List<Medico> listaMedico =medicoDAO.buscaMedicoPorEstado(estado);
				
				dtm.addColumn("CRM");
				dtm.addColumn("Nome do Medico");
				dtm.addColumn("Especialidade");
				dtm.addColumn("DDD");
				dtm.addColumn("Telefone");
				dtm.addColumn("Email");
				dtm.addColumn("Cidade");
				dtm.addColumn("Estado");
				
				for(Medico listaDeMedico: listaMedico) {
					Object[] row = {
							listaDeMedico.getCrm(),
							listaDeMedico.getNomeMedico(),
							listaDeMedico.getEspecialidade(),
							listaDeMedico.getDdd(),
							listaDeMedico.getTelefone(),
							listaDeMedico.getEmail(),
							listaDeMedico.getCidade(),
							listaDeMedico.getEstado(),
					};
					dtm.addRow(row);
				}
			}
		});
	}
	
	
	public static void main(String[] args) {
		new ConsultaMedicoPorEstado()
			.setConsultaMedicoPorEstado();
	}
}
