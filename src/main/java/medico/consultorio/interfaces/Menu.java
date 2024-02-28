package medico.consultorio.interfaces;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Menu {

	private JFrame menu;
	private JButton cadastroDePacientes, agendamentoDeConsultas;
	private JButton pesquisas;
	private JButton exames;
	
	public Menu() {
		menu = new JFrame();
		
		cadastroDePacientes = new JButton("Cadastro de Pacientes");
		agendamentoDeConsultas = new JButton("Agendamento de Consultas");
		pesquisas = new JButton("Pesquisas");
		exames = new JButton("Exames");
	}
	
	public void setMenu() {
		menu.setSize(480, 350);
		menu.setLayout(null);
		botoes();
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setVisible(true);
	}
	
	
	private void botoes() {
		menu.add(cadastroDePacientes);
		menu.add(agendamentoDeConsultas);
		menu.add(pesquisas);
		menu.add(exames);
		cadastroDePacientes.setBounds(10, 10, 180, 40);
		agendamentoDeConsultas.setBounds(210,10,200,40);
		pesquisas.setBounds(10, 80, 180, 40);
		exames.setBounds(210, 80, 200, 40);
	}
	
	
	public static void main(String[] args) {
		new Menu().setMenu();
	}
	
	
	
}
