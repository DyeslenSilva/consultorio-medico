package medico.consultorio.interfaces.consultas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import medico.consultorio.database.dao.ConsultaDAO;
import medico.consultorio.model.ConsultaMedica;

public class ListaDeTodasConsultaMedica {

	private JFrame listaTodasAsConsultas;
	private JButton btListarConsultasMedicos;
	private JTable tbListaConsultasMedicas;
	private JScrollPane jScrollPane;
	private DefaultTableModel model;
	
	
	public ListaDeTodasConsultaMedica() {
		listaTodasAsConsultas = new JFrame("Lista de Todas as consultas");
		
		btListarConsultasMedicos = new JButton("Listar todas as Consultas");
		
		tbListaConsultasMedicas = new JTable();
		
		jScrollPane = new JScrollPane(tbListaConsultasMedicas);
	
		model = new DefaultTableModel();
	}
	
	
	
	public void setListaTodasAsConsultas() {
		listaTodasAsConsultas.setSize(2000, 600);
		listaTodasAsConsultas.setLayout(null);
		
		comps();
		
		listaTodasAsConsultas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		listaTodasAsConsultas.setVisible(true);
	}


	private void comps() {
		listaTodasAsConsultas.add(btListarConsultasMedicos);
		listaTodasAsConsultas.add(jScrollPane);
		
		btListarConsultasMedicos.setBounds(10, 10, 190, 40);
		jScrollPane.setBounds(10, 60, 1500, 400);
		
		btListarConsultasMedicos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsultaDAO consultaDAO = new ConsultaDAO();
				List<ConsultaMedica> listaConsultas = consultaDAO.listaTodasAsConsultas();
				//DefaultTableModel dtm = new DefaultTableModel();
				
				model.addColumn("Token");
				model.addColumn("CPF");
				model.addColumn("Nome do Paciente");
				model.addColumn("Nome do Medico");
				model.addColumn("Especialidade");
				model.addColumn("Data da Consulta");
				model.addColumn("Hora da Consulta");
				model.addColumn("Endereco");
				model.addColumn("N");
				model.addColumn("Municipio");
				model.addColumn("Estado");
				
				for(ConsultaMedica consMed : listaConsultas) {
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
					
					model.addRow(row);
					
				}
				tbListaConsultasMedicas.setModel(model);
				ajusteTamanhoDeColuna();
			}
		});
		
	}
	
	private void ajusteTamanhoDeColuna() {
		for(int i =0; i<tbListaConsultasMedicas.getColumnCount(); i++) {
			tbListaConsultasMedicas.getColumnModel()
						.getColumn(i).setPreferredWidth(150);
		}
	}
	
	
	public static void main(String[] args) {
		new ListaDeTodasConsultaMedica()
				.setListaTodasAsConsultas();
	}
	
}
