package especialidade.sistema.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import especialidade.sistema.dao.EspecialidadeDAO;
import especialidade.sistema.model.Especialidades;

public class CadastroEspecialidades {

	private JFrame cadastroEspecialidade;
	private JLabel lbSiglaEspecialidade,lbEspecialidade;
	private JTextField txSiglaEspecialidade, txEspecialidade;
	private JButton btCadastrarEspecialidade;
	
	public CadastroEspecialidades() {
		cadastroEspecialidade = new JFrame();
		
		lbSiglaEspecialidade = new JLabel("Sigla Especialidade");
		lbEspecialidade = new JLabel("Especialidade");
		
		txSiglaEspecialidade = new JTextField();
		txEspecialidade = new JTextField();
		
		btCadastrarEspecialidade = new JButton("Cadastrar Especialidade");
	}
	
	
	public void setCadastroEspecialidade() {
		cadastroEspecialidade.setSize(300, 150);
		cadastroEspecialidade.setLayout(null);
		comps();
		
		cadastroEspecialidade.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cadastroEspecialidade.setVisible(true);
	}


	private void comps() {
		cadastroEspecialidade.add(lbSiglaEspecialidade);
		cadastroEspecialidade.add(lbEspecialidade);
		cadastroEspecialidade.add(txSiglaEspecialidade);
		cadastroEspecialidade.add(txEspecialidade);
		cadastroEspecialidade.add(btCadastrarEspecialidade);
		
		
		 lbSiglaEspecialidade.setBounds(10, 10, 130, 20);
		 lbEspecialidade.setBounds(10, 40, 130, 20);
		 txSiglaEspecialidade.setBounds(130, 10, 100, 20);
		 txEspecialidade.setBounds(130, 40, 100, 20);
		 btCadastrarEspecialidade.setBounds(40, 70, 190, 20);
		 
		 btCadastrarEspecialidade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Especialidades espec = new Especialidades();
				EspecialidadeDAO especDAO = new EspecialidadeDAO();
				
				String siglaEsp = txSiglaEspecialidade.getText();
				String nomeEsp = txEspecialidade.getText();
				
				espec.setSiglaEspecialidade(siglaEsp);
				espec.setNomeEspecialidade(nomeEsp);
				
				especDAO.cadastrarEspecialidade(espec);
				
				txSiglaEspecialidade.setText("");
				txEspecialidade.setText("");
			}
		});
		 
		 
	}
	
	public static void main(String[] args) {
		new CadastroEspecialidades()
			.setCadastroEspecialidade();
	}
	
}
