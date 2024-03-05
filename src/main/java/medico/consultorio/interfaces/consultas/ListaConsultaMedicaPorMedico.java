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

public class ListaConsultaMedicaPorMedico {
	
	private JFrame listaConsultaPorMedico;
	private JLabel lbNomeMedico;
	private JTextField txNomeMedico;
	private JButton btPesquisarConsulta;
	private JScrollPane jScrollPane;
	private JTable tbListaConsultaPorMedico;
	
	
	public ListaConsultaMedicaPorMedico() {
		listaConsultaPorMedico = new JFrame();
		
		lbNomeMedico = new JLabel("Nome do Médico");
		
		txNomeMedico = new JTextField();
		
		btPesquisarConsulta = new JButton("Pesquisar Consulta");
		
		tbListaConsultaPorMedico = new JTable();
		jScrollPane = new JScrollPane(tbListaConsultaPorMedico);

	}
	
	public void setListaConsultaPorMedico() {
		listaConsultaPorMedico.setSize(1200, 600);
		listaConsultaPorMedico.setLayout(null);
		
		comps();
		
		listaConsultaPorMedico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		listaConsultaPorMedico.setVisible(true);
	}

	private void comps() {
		listaConsultaPorMedico.add(lbNomeMedico);
		listaConsultaPorMedico.add(txNomeMedico);
		listaConsultaPorMedico.add(btPesquisarConsulta);
		listaConsultaPorMedico.add(jScrollPane);
		
		lbNomeMedico.setBounds(10, 10, 100, 20);
		txNomeMedico.setBounds(130, 10, 130, 20);
		btPesquisarConsulta.setBounds(270, 10, 150, 20);
		jScrollPane.setBounds(10, 50, 1150, 500);
		btPesquisarConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					String nomeMedico = txNomeMedico.getText();
					ConsultaDAO consDao = new ConsultaDAO();
					
					List<ConsultaMedica> cm = consDao.listaConsultaPorMedico(nomeMedico);
					DefaultTableModel dtm = new DefaultTableModel();
					tbListaConsultaPorMedico.setModel(dtm);
					
					dtm.addColumn("Token");
					dtm.addColumn("CPF");
					dtm.addColumn("Nome do Paciente");
					dtm.addColumn("Nome do Medico");
					dtm.addColumn("Especialidade");
					dtm.addColumn("Data da Consulta");
					dtm.addColumn("Hora de Consulta");
					dtm.addColumn("Endereco");
					dtm.addColumn("N");
					dtm.addColumn("Cidade");
					dtm.addColumn("Estado");
					
					for(ConsultaMedica consMed : cm) {
						Object[] row = {
								consMed.getToken(),
								consMed.getCpf(),
								consMed.getNomeDoPaciente(),
								consMed.getNomeMedico(),
								consMed.getEspecialidade(),
								consMed.getDataDaConsulta(),
								consMed.getHoraDaConsulta(),
								consMed.getEndereco(),
								consMed.getN(),
								consMed.getCidade(),
								consMed.getEstado()
						};
						dtm.addRow(row);
					}
					tbListaConsultaPorMedico.setModel(dtm);
					ajustarTamanhoDaColuna();
			}
		});
	}
	
	private void ajustarTamanhoDaColuna() {
		for(int i= 0; i<tbListaConsultaPorMedico.getColumnCount(); i++) {
			tbListaConsultaPorMedico.getColumnModel()
					.getColumn(i).setPreferredWidth(150);
		}
	}
	
	
	public static void main(String[] args) {
		new ListaConsultaMedicaPorMedico()
						.setListaConsultaPorMedico();
	}
	
	
}
