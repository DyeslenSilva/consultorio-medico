package medico.consultorio.interfaces.pesquisas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuConsultaPacientes {
	private JFrame menuConsulta;
	private JButton consultaPorCPF, listaTodosOsPacietes,listaPacientePorEstado;
	
	
	public MenuConsultaPacientes(){
		menuConsulta = new JFrame();
		
		consultaPorCPF = new JButton("Consulta por CPF");
		listaPacientePorEstado = new JButton("Listar Paciente por Estado");
		listaTodosOsPacietes = new JButton("Listar Todos os Pacientes");
	}
	
	public void setMenuConsulta() {
		menuConsulta.setSize(500,200);
		menuConsulta.setLayout(null);
		jButton();
		
		menuConsulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuConsulta.setVisible(true);
	}
	
	private void jButton() {
		menuConsulta.add(consultaPorCPF);
		menuConsulta.add(listaPacientePorEstado);
		menuConsulta.add(listaTodosOsPacietes);
		
		consultaPorCPF.setBounds(10, 10, 150, 40);
		listaPacientePorEstado.setBounds(210, 10, 190, 40);
		listaTodosOsPacietes.setBounds(110, 70, 190, 40);
		
		consultaPorCPF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ConsultaPacinetePorCPF().setConsultaClienteCPF();
			}
		});
		
		
		listaPacientePorEstado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ConsultaPacientePorEstado cpe = new ConsultaPacientePorEstado();
				cpe.setConsultaPacientePorEstado();
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		new MenuConsultaPacientes().setMenuConsulta();
	}
	
}
