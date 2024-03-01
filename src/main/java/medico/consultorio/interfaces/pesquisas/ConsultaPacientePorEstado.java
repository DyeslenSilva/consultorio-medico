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

import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.Paciente;

public class ConsultaPacientePorEstado {

	private JFrame consultaPacientePorEstado;
	private JLabel lbEstado;
	private JTextField txEstado;
	private JButton btConsultar;
	private JTable pacientesPorEstado;
	private JScrollPane srollPane;
	private DefaultTableModel dtm;
	
	
	public ConsultaPacientePorEstado() {
		consultaPacientePorEstado = new JFrame();
		
		lbEstado = new JLabel("UF");
		txEstado = new JTextField();
		btConsultar = new JButton("Consultar");
		
		pacientesPorEstado = new JTable();
		srollPane = new JScrollPane(pacientesPorEstado);
		dtm = new DefaultTableModel();
		
		
        
        pacientesPorEstado.setModel(dtm);
	}
	
	public void setConsultaPacientePorEstado() {
		consultaPacientePorEstado.setSize(1600, 600);
		consultaPacientePorEstado.setLayout(null);
		
		componentes();
		
		consultaPacientePorEstado.
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		consultaPacientePorEstado.setVisible(true);
	}
	
	
	private void componentes() {
		consultaPacientePorEstado.add(lbEstado);
		consultaPacientePorEstado.add(txEstado);
		consultaPacientePorEstado.add(btConsultar);
		consultaPacientePorEstado.add(srollPane);
		
		
		lbEstado.setBounds(10, 10, 100, 20);
		txEstado.setBounds(50, 10, 100, 20);
		btConsultar.setBounds(180, 10, 100, 20);
		srollPane.setBounds(10, 40, 1400, 320);
		
		btConsultar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String uf = txEstado.getText();
				PacienteDAO pacienteDAO = new PacienteDAO();
				List<Paciente> listaPacientePorEstado =
							pacienteDAO.consultaPacientePorEstado(uf);
				
				dtm.addColumn("CPF");
		        dtm.addColumn("Nome Completo");
		        dtm.addColumn("DDD");
		        dtm.addColumn("Telefone");
		        dtm.addColumn("Endereco");
		        dtm.addColumn("N");
		        dtm.addColumn("Cidade");
		        dtm.addColumn("UF");

	                for(Paciente pacientesPorEstado :listaPacientePorEstado ) {
	                			Object[] row = {
	                					pacientesPorEstado.getCpf(),
	                					pacientesPorEstado.getNomePaciente(),
	                					pacientesPorEstado.getDdd(),
	                					pacientesPorEstado.getTelefone(),
	                					pacientesPorEstado.getEndereco(),
	                					pacientesPorEstado.getNCasa(),
	                					pacientesPorEstado.getCidade(),
	                					pacientesPorEstado.getEstado()
	                			};
	                			dtm.addRow(row);
	                }
			}
			
		});
		
		
	}
	

	
	
	public static void main(String[] args) {
		new ConsultaPacientePorEstado().
					setConsultaPacientePorEstado();
	}
	
}
