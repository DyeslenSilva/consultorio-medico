package medico.consultorio.interfaces.cadastro;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastroDeClients {

	private JFrame cadastroDeClientes;
	private JLabel lbCPF, lbNomePaciente,lbTelefone,lbEndereco, lbnCasa, lbCidade,lbEsdao;
	private JTextField txCPF, txNomePaciente,txTelefone,txEndereco,txNCasa,txCidade,txEstado;
	private JButton btCadastroDeCliente;
	
	public CadastroDeClients() {
		cadastroDeClientes = new JFrame("Cadastro de Cliente");
		
	}
	
}
