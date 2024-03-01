package medico.consultorio.interfaces.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.GeradorCPF;
import medico.consultorio.model.GerarCPF;
import medico.consultorio.model.Paciente;

public class CadastroDeClients {

	private JFrame cadastroDeClientes;
	private JLabel lbCPF, lbNomePaciente,lbTelefone,lbEndereco, lbnCasa, lbCidade,lbEstado;
	private JLabel lbDDD;
	private JTextField txCPF, txNomePaciente,txTelefone,txEndereco,txNCasa,txCidade,txEstado;
	private JTextField txDDD;
	private JButton btCadastroDeCliente, btGerarCPF;
	
	public CadastroDeClients() {
		cadastroDeClientes = new JFrame("Cadastro de Cliente");
		
		lbCPF = new JLabel("CPF");
		lbNomePaciente = new JLabel("Nome do Paciente");
		lbDDD = new JLabel("DDD");
		lbTelefone = new JLabel("Telefone");
		lbEndereco = new JLabel("Endereco");
		lbnCasa = new JLabel("N Casa");
		lbCidade = new JLabel("Cidade");
		lbEstado = new JLabel("Estado");
		
		txCPF = new JTextField();
		txNomePaciente = new JTextField();
		txDDD = new JTextField();
		txTelefone = new JTextField();
		txEndereco = new JTextField();
		txNCasa = new JTextField();
		txCidade = new JTextField();
		txEstado = new JTextField();
		
		btCadastroDeCliente = new JButton("Cadastrar");
		btGerarCPF = new JButton("Gerar CPF");
		
	}
	
	public void setCadastroDeClientes() {
		cadastroDeClientes.setSize(440, 400);
		cadastroDeClientes.setLayout(null);
		jLabel();
		jTextField();
		jButton();
		cadastroDeClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cadastroDeClientes.setVisible(true);
	}
	
	
	private void jLabel() {
		cadastroDeClientes.add(lbCPF);
		cadastroDeClientes.add(lbNomePaciente);
		cadastroDeClientes.add(lbDDD);
		cadastroDeClientes.add(lbTelefone);
		cadastroDeClientes.add(lbEndereco);
		cadastroDeClientes.add(lbnCasa);
		cadastroDeClientes.add(lbCidade);
		cadastroDeClientes.add(lbEstado);
		
		lbCPF.setBounds(10, 10, 100, 20);
		lbNomePaciente.setBounds(10, 40, 120, 20);
		lbDDD.setBounds(10, 70, 100, 20);
		lbTelefone.setBounds(10, 100, 100, 20);
		lbEndereco.setBounds(10, 130, 100, 20);
		lbnCasa.setBounds(10, 160, 100, 20);
		lbCidade.setBounds(10, 190, 100, 20);
		lbEstado.setBounds(10, 220, 100, 20);
		
	}
	
	private void jTextField() {
		cadastroDeClientes.add(txCPF);
		cadastroDeClientes.add(txNomePaciente);
		cadastroDeClientes.add(txDDD);
		cadastroDeClientes.add(txTelefone);
		cadastroDeClientes.add(txEndereco);
		cadastroDeClientes.add(txNCasa);
		cadastroDeClientes.add(txCidade);
		cadastroDeClientes.add(txEstado);
		
		txCPF.setBounds(130, 10, 140, 20);
		txNomePaciente.setBounds(130, 40, 140, 20);
		txDDD.setBounds(130, 70, 140, 20);
		txTelefone.setBounds(130, 100, 140, 20);
		txEndereco.setBounds(130, 130, 140, 20);
		txNCasa.setBounds(130, 160, 140, 20);
		txCidade.setBounds(130, 190, 140, 20);
		txEstado.setBounds(130, 220, 140, 20);
		
	}
	
	private void jButton() {
		cadastroDeClientes.add(btCadastroDeCliente);
		cadastroDeClientes.add(btGerarCPF);
		btCadastroDeCliente.setBounds(50, 250, 100, 40);
		btGerarCPF.setBounds(280, 10, 100, 20);

		btGerarCPF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//GeradorCPF geradorCPF = new GeradorCPF();
				txCPF.setText(GeradorCPF.gerarCPF());
			}
		});
		
		
		btCadastroDeCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String cpf = txCPF.getText();
				String nomePaciente = txNomePaciente.getText();
				Integer ddd = Integer.parseInt(txDDD.getText());
				String telefone = txTelefone.getText();
				String endereco = txEndereco.getText();
				Integer nCasa = Integer.parseInt(txNCasa.getText());
				String cidade = txCidade.getText();
				String estado = txEstado.getText();
				
				Paciente paciente = new Paciente();
				
				paciente.setCpf(cpf);
				paciente.setNomePaciente(nomePaciente);
				paciente.setDdd(ddd);
				paciente.setTelefone(telefone);
				paciente.setEndereco(endereco);
				paciente.setNCasa(nCasa);
				paciente.setCidade(cidade);
				paciente.setEstado(estado);
				
				PacienteDAO pacienteDAO = new PacienteDAO();
				
				pacienteDAO.salvarPaciente(paciente);
				
				limparCaixaDeTexto();
				fecharJanela();
			}
		});
	}
	
	private void fecharJanela() {
		cadastroDeClientes.dispose();
	}
	
	private void limparCaixaDeTexto() {
		String vazio = "";
		txCPF.setText(vazio);
		txNomePaciente.setText(vazio);
		txTelefone.setText(vazio);
		txEndereco.setText(vazio);
		txNCasa.setText(vazio);
		txCidade.setText(vazio);
		txEstado.setText(vazio);
	}
	
	
	
	public static void main(String[] args) {
		new CadastroDeClients().setCadastroDeClientes();
	}
}
