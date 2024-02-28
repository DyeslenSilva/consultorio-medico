package medico.consultorio.interfaces;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuPesquisa {

	
	private JFrame menuPesquisa;
	private JButton pesquisaPaciente, pesquisaConsulta;
	private JButton pesquisaExames;
	
	public MenuPesquisa() {
		menuPesquisa = new JFrame("Pesquisas no Banco");
		
		pesquisaPaciente = new JButton("Pesquisa de Pacientes");
		pesquisaConsulta = new JButton("Pesquisa de Consultas");
		pesquisaExames = new JButton("Pesquisa De Exames");
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
		pesquisaPaciente.setBounds(10, 10, 200, 40);
		pesquisaConsulta.setBounds(220, 10, 200, 40);
		pesquisaExames.setBounds(10, 110, 160, 40);
	}

	public static void main(String[] args) {
		new MenuPesquisa().setMenuPesquisa();
	}
}
