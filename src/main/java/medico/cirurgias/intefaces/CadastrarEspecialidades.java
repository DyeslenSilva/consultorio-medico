package medico.cirurgias.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import medico.cirurgias.dao.EspecialidadeDAO;
import medico.cirurgias.model.Especialidades;
import medico.cirurgias.model.GerarIdEspecialidade;

public class CadastrarEspecialidades {
	
	private JFrame cadadstraEspecialidade;
	private JLabel lbIdEspecialidade, lbNomeEspecialidade;
	private JTextField txIdEspecialidade, txNomeEspecialidade;
	private JButton gerarIdEspecialidade, btCadastrarEspecialidade;
	
	public CadastrarEspecialidades() {
		cadadstraEspecialidade = new JFrame();
		
		lbIdEspecialidade = new JLabel("Id Especialidade");
		lbNomeEspecialidade = new JLabel("Nome Especialidade");
		
		txIdEspecialidade = new JTextField();
		txNomeEspecialidade = new JTextField();
		
		gerarIdEspecialidade  = new JButton("Gerar ID Especialidade");
		btCadastrarEspecialidade = new JButton("Cadastrar Especialidade");
		
		gerarIdEspecialidade.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int idEspecialidade = GerarIdEspecialidade.gerarIdEspecialidade();
				txIdEspecialidade.setText(String.valueOf(idEspecialidade));
			}
		});
		
		btCadastrarEspecialidade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer idEspecialidade = Integer.parseInt(txIdEspecialidade.getText());
				String especialidade = txNomeEspecialidade.getText();
				
				Especialidades espec = new Especialidades();
				EspecialidadeDAO especDAO = new EspecialidadeDAO();
				
				espec.setIdEspecialidade(idEspecialidade);
				espec.setNomeEspecialidade(especialidade);
				
				especDAO.cadastrarEspecialidade(espec);
				
			}
		});
		
		
	}

	
	public void setCadadstraEspecialidade() {
		cadadstraEspecialidade.setSize(500, 150);
		cadadstraEspecialidade.setLayout(null);
		comps();
		cadadstraEspecialidade.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cadadstraEspecialidade.setVisible(true);
	}


	private void comps() {
		cadadstraEspecialidade.add(lbIdEspecialidade);
		cadadstraEspecialidade.add(lbNomeEspecialidade);
		
		lbIdEspecialidade.setBounds(10, 10, 100, 20);
		lbNomeEspecialidade.setBounds(10, 40, 150, 20);
		
		cadadstraEspecialidade.add(txIdEspecialidade);
		cadadstraEspecialidade.add(txNomeEspecialidade);
		
		txIdEspecialidade.setBounds(150, 10, 100, 20);
		txNomeEspecialidade.setBounds(150, 40, 100, 20);
		
		cadadstraEspecialidade.add(btCadastrarEspecialidade);
		cadadstraEspecialidade.add(gerarIdEspecialidade);
		
		btCadastrarEspecialidade.setBounds(30 ,70, 190, 20);
		gerarIdEspecialidade.setBounds(270, 10, 190, 20);
	}
	
	
	public static void main(String[] args) {
		new CadastrarEspecialidades()
			.setCadadstraEspecialidade();
	}
}
