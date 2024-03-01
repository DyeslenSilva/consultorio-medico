package estado.sistema.interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import estado.sistema.dao.EstadoDAO;
import estado.sistema.model.Estado;

public class CadastroDeEstados {

	private JFrame cadastroDeEstado;
	private JLabel lbEstado, lbUF;
	private JTextField txUF, txEstado;
	private JButton btCadastrarEstado;
	
	public CadastroDeEstados() {
		cadastroDeEstado = new JFrame("Cadastro de Estados");
		
		lbUF = new JLabel("UF");
		lbEstado = new JLabel("Estado");
		
		txUF = new JTextField();
		txEstado = new JTextField();
		
		btCadastrarEstado = new JButton("Cadastrar Estado");
	}
	
	public void setCadastroDeEstado() {
		cadastroDeEstado.setSize(250, 200);
		cadastroDeEstado.setLayout(null);
		
		jlabel();
		jTextField();
		jButton();
		
		cadastroDeEstado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cadastroDeEstado.setVisible(true);
	}
	
	private void jlabel() {
		cadastroDeEstado.add(lbUF);
		cadastroDeEstado.add(lbEstado);
		
		lbUF.setBounds(10, 10, 100, 20);
		lbEstado.setBounds(10, 40, 100, 20);
	}
	
	private void jTextField() {
		cadastroDeEstado.add(txUF);
		cadastroDeEstado.add(txEstado);
		
		txUF.setBounds(70, 10, 100, 20);
		txEstado.setBounds(70, 40, 100, 20);
	}
	
	private void jButton() {
		cadastroDeEstado.add(btCadastrarEstado);
		
		btCadastrarEstado.setBounds(30, 80, 150, 40);
		
		btCadastrarEstado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String uf = txUF.getText();
				String estado = txEstado.getText();
				
				Estado estadoE = new Estado();
				EstadoDAO estadoDAO = new EstadoDAO();
				
				estadoE.setNomeEstado(estado);
				estadoE.setUf(uf);
				
				estadoDAO.cadastroEstado(estadoE);
				
				limpaCaixaDeTexto();
			}
		});
	}
	
	private void limpaCaixaDeTexto() {
		String  vazio = "";
		txUF.setText(vazio);
		txEstado.setText(vazio);
	}
	
	public static void main(String[] args) {
		new CadastroDeEstados()
			.setCadastroDeEstado();
	}
}

