package medico.consultorio.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import medico.consultorio.interfaces.pesquisas.ConsultaPacinetePorCPF;
import medico.consultorio.interfaces.pesquisas.MenuConsultaPacientes;

public class MenuPesquisa {

	
	private JFrame menuPesquisa;
	private JButton pesquisaPaciente, pesquisaConsulta;
	private JButton pesquisaExames , listaTodosPacientes;
	
	
	public MenuPesquisa() {
		menuPesquisa = new JFrame("Pesquisas no Banco");
		
		pesquisaPaciente = new JButton("Pesquisa de Pacientes");
		pesquisaConsulta = new JButton("Pesquisa de Consultas");
		pesquisaExames = new JButton("Pesquisa De Exames");
		listaTodosPacientes = new  JButton("Lista todos os Paciente");
	}
	
	public void setMenuPesquisa() {
		menuPesquisa.setSize(600, 400);
		menuPesquisa.setLayout(null);
		
		botoes();
		menuPesquisa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPesquisa.setVisible(true);
	}
	
	
	private void botoes() {
		menuPesquisa.add(pesquisaPaciente);
		menuPesquisa.add(pesquisaConsulta);
		menuPesquisa.add(pesquisaExames);
		menuPesquisa.add(listaTodosPacientes);
		pesquisaPaciente.setBounds(10, 10, 200, 40);
		pesquisaPaciente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MenuConsultaPacientes().setMenuConsulta();
			}
		});
		
		pesquisaConsulta.setBounds(220, 10, 200, 40);
		pesquisaExames.setBounds(10, 110, 200, 40);
		listaTodosPacientes.setBounds(220, 110, 200, 40);
	}

	public static void main(String[] args) {
		new MenuPesquisa().setMenuPesquisa();
	}
}
