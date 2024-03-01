package medico.consultorio.interfaces.cadastro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import medico.consultorio.database.dao.MedicoDAO;
import medico.consultorio.model.GerarCPF;
import medico.consultorio.model.GerarCRM;
import medico.consultorio.model.Medico;

public class CadastroProfissionalMedico {

	private JFrame cadProfissionarMedico;
	private JLabel lbCRM, lbNomeDoMedico, lbEspecialidade;
	private JLabel lbDDD, lbTelefone, lbEmail, lbCidade,lbEstado;
	private JTextField txCRM, txNomeDoMedico, txEspecialidade;
	private JTextField txDDD, txTelefone, txEmail, txCidade ,txEstado;
	private JButton btGerarCRM, btCadastrarMedico;
	
	
	public CadastroProfissionalMedico() {
		cadProfissionarMedico = new JFrame("Cadastro de Profissionais");
		
		lbCRM = new JLabel("CRM");
		lbNomeDoMedico = new JLabel("Nome do Médico");
		lbEspecialidade = new JLabel("Especialidade");
		lbDDD = new JLabel("DDD");
		lbTelefone = new JLabel("Telefone");
		lbEmail = new JLabel("Email");
		lbCidade = new JLabel("Cidade");
		lbEstado = new JLabel("Estado");
		
		//jLabel();
		
		txCRM = new JTextField();
		txNomeDoMedico = new JTextField();
		txEspecialidade = new JTextField();
		txDDD = new JTextField();
		txTelefone = new JTextField();
		txEmail = new  JTextField();
		txCidade = new JTextField();
		txEstado = new JTextField();
		
		//jTextField();
		
		btCadastrarMedico = new JButton("Cadastrar Medico");
		btGerarCRM = new JButton("Gerar CRM");
		
		//jButton();
	}
	
	
	public void setCadProfissionarMedico() {
		cadProfissionarMedico.setSize(400, 400);
		cadProfissionarMedico.setLayout(null);
		jLabel();
		jButton();
		jTextField();
		cadProfissionarMedico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cadProfissionarMedico.setVisible(true);
	}
	
	private void jLabel() {
		cadProfissionarMedico.add(lbCRM);
		cadProfissionarMedico.add(lbNomeDoMedico);
		cadProfissionarMedico.add(lbEspecialidade);
		cadProfissionarMedico.add(lbDDD);
		cadProfissionarMedico.add(lbTelefone);
		cadProfissionarMedico.add(lbEmail);
		cadProfissionarMedico.add(lbCidade);
		cadProfissionarMedico.add(lbEstado);
		
		lbCRM.setBounds(10, 10, 100, 20);
		lbNomeDoMedico.setBounds(10, 40, 150, 20);
		lbEspecialidade.setBounds(10, 70, 130, 20);
		lbDDD.setBounds(10, 100, 100, 20);
		lbTelefone.setBounds(10, 130, 100, 20);
		lbEmail.setBounds(10, 160, 100, 20);
		lbCidade.setBounds(10, 190, 100, 20);
		lbEstado.setBounds(10, 220, 100, 20);
	}
	
	
	private void jTextField() {
		cadProfissionarMedico.add(txCRM);
		cadProfissionarMedico.add(txNomeDoMedico);
		cadProfissionarMedico.add(txEspecialidade);
		cadProfissionarMedico.add(txDDD);
		cadProfissionarMedico.add(txTelefone);
		cadProfissionarMedico.add(txEmail);
		cadProfissionarMedico.add(txCidade);
		cadProfissionarMedico.add(txEstado);
		
		txCRM.setBounds(110, 10, 100, 20);
		txNomeDoMedico.setBounds(110, 40, 100, 20);
		txEspecialidade.setBounds(110, 70, 100, 20);
		txDDD.setBounds(110, 100, 100, 20);
		txTelefone.setBounds(110, 130, 100, 20);
		txEmail.setBounds(110, 160, 100, 20);
		txCidade.setBounds(110, 190, 100, 20);
		txEstado.setBounds(110, 220, 100, 20);
	}
	
	private void jButton() {
		cadProfissionarMedico.add(btGerarCRM);
		cadProfissionarMedico.add(btCadastrarMedico);
		
		btGerarCRM.setBounds(230, 10, 100, 20);
		btCadastrarMedico.setBounds(70, 260, 170, 40);
		
		btGerarCRM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txCRM.setText(GerarCRM.gerarRegistroMedico());
			}
		});
		
		btCadastrarMedico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Medico medico = new Medico();
				MedicoDAO medicoDAO = new MedicoDAO();
				medico.setCrm(txCRM.getText());
				medico.setNomeMedico(txNomeDoMedico.getText());
				medico.setEspecialidade(txEspecialidade.getText());
				medico.setDdd(Integer.parseInt(txDDD.getText()));
				medico.setTelefone(txTelefone.getText());
				medico.setEmail(txEmail.getText());
				medico.setCidade(txCidade.getText());
				medico.setEstado(txEstado.getText());
		
				medicoDAO.cadastroMedico(medico);
				limparTxt();
			}
		});
	}

	private void limparTxt() {
		String limpa = "";
		txCRM.setText(limpa);
		txNomeDoMedico.setText(limpa);
		txEspecialidade.setText(limpa);
		txDDD.setText(limpa);
		txTelefone.setText(limpa);
		txEmail.setText(limpa);
		txCidade.setText(limpa);
		txEstado.setText(limpa);
	}
	public static void main(String[] args) {
		new CadastroProfissionalMedico().
			setCadProfissionarMedico();
	}
}
