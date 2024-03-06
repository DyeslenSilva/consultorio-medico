package medico.consultorio.interfaces.exames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import medico.consultorio.database.dao.ExameDAO;
import medico.consultorio.model.Exame;
import medico.consultorio.model.GerarCodigoExame;

public class CadastroExames {

	private JFrame cadastroExames;
	private JLabel lbCodigoExame, lbNomeExame, lbDescricao;
	private JTextField txCodigoExame, txNomeExame;
	private JTextArea taDescricao;
	private JButton btCadastrarExame, btGerarCodigoExame;
	
	public CadastroExames() {
		cadastroExames = new JFrame("Cadastro de Exames");
		
		lbCodigoExame = new JLabel("Codigo do Exame");
		lbNomeExame = new JLabel("Nome do Exame");
		lbDescricao = new JLabel("Descricao");
		
		txCodigoExame = new JTextField();
		txNomeExame = new JTextField();
		
		taDescricao = new JTextArea(6, 4);
		
		btCadastrarExame = new JButton("Cadastrar Exame");
		btGerarCodigoExame = new JButton("Gerar Codigo do Exame");
	}
	
	
	public void setCadastroExames() {
		cadastroExames.setSize(650, 250);
		cadastroExames.setLayout(null);
		
		jLabel();
		jTextField();
		jTextArea();
		jButton();
		
		cadastroExames.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cadastroExames.setVisible(true);
	}
	
	private void jLabel() {
		cadastroExames.add(lbCodigoExame);
		cadastroExames.add(lbNomeExame);
		cadastroExames.add(lbDescricao);
		
		lbCodigoExame.setBounds(10, 10, 100, 20);
		lbNomeExame.setBounds(10, 40, 100, 20);
		lbDescricao.setBounds(10, 70, 100, 20);
	}
	
	private void jTextField() {
		cadastroExames.add(txCodigoExame);
		cadastroExames.add(txNomeExame);
		
		txCodigoExame.setBounds(250, 10, 100, 20);
		txNomeExame.setBounds(250, 40, 150, 20);
	}
	
	private void jTextArea() {
		cadastroExames.add(taDescricao);
		
		JScrollPane pane = new JScrollPane();
		cadastroExames.add(pane);
		
		taDescricao.setLineWrap(true);
		taDescricao.setWrapStyleWord(true);
		
		taDescricao.setBounds(250, 70, 150, 100);
	}
	
	
	private void jButton() {
		cadastroExames.add(btCadastrarExame);
		cadastroExames.add(btGerarCodigoExame);
		
		btCadastrarExame.setBounds(30, 180, 190, 20);
		btGerarCodigoExame.setBounds(370, 10, 190, 20);
		
		
		btGerarCodigoExame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int codExame = GerarCodigoExame.gerarCodigoExame();
				String codExamee = String.valueOf(codExame);
				txCodigoExame.setText(codExamee);
			}
		});
		
		
		btCadastrarExame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer codigoDoExame = Integer.parseInt(txCodigoExame.getText());
				String nomeDoExame = txNomeExame.getText();
				String descricaoExame  = taDescricao.getText();
				
				Exame exame = new Exame();
					
				exame.setCodigoDoExame(codigoDoExame);
				exame.setNomeDoExame(nomeDoExame);
				exame.setDescricao(descricaoExame);
				
				ExameDAO exameDAO = new ExameDAO();
				
				exameDAO.cadastrarExame(exame);
				txCodigoExame.setText("");
				txNomeExame.setText("");
				taDescricao.setText("");
			}
		});
		
	}
	
	
	public static void main(String[] args) {
		new CadastroExames()
				.setCadastroExames();
	}
	
	
}
