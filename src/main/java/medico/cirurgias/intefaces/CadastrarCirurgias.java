package medico.cirurgias.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import medico.cirurgias.dao.CirurugiaDAO;
import medico.cirurgias.model.Cirurgias;
import medico.cirurgias.model.GerarCodigoCirurgia;

public class CadastrarCirurgias {

	private JFrame cadastrarCirurgia;
	private JLabel lbCodigoCirurgia, lbNomeCirurgia,lbTipoCirurgia, lbRiscoCirurgia;
	private JTextField txCodigoDaCirurgia, txNomeDaCirurgia, txTipoCirurgia, txRiscoCirurgia;
	private JSlider slTipoCirurgia, slRiscoCirurgia;
	private JButton btGerarCodigoCirurgia , btCadastrarCirurgia;
	
	private String[] riscoCirurgia = {"Risco Baixo", "Risco Medio", "Alto Risco"};
	private String[] tipoDeCirurgia = {"Baixa Complexidade", "Media Complexidade", "Alta Complexidade"};
	
	
	public CadastrarCirurgias() {
		cadastrarCirurgia = new JFrame();
		
		lbCodigoCirurgia = new JLabel("Codigo da Cirurgia");
		lbNomeCirurgia = new JLabel("Nome da Cirurgia");
		lbTipoCirurgia = new JLabel("Tipo de Cirurgia");
		lbRiscoCirurgia = new JLabel("Risco da Cirurgia");
		
		txCodigoDaCirurgia = new JTextField();
		txNomeDaCirurgia = new JTextField();
		txTipoCirurgia = new JTextField();
		txRiscoCirurgia = new JTextField();
		
		slRiscoCirurgia = new JSlider(JSlider.HORIZONTAL,0,riscoCirurgia.length -1,0);
		slTipoCirurgia = new JSlider(JSlider.HORIZONTAL,0,tipoDeCirurgia.length-1,0);
		
		btGerarCodigoCirurgia = new JButton("Gerar Codigo da Cirurgia");
		btCadastrarCirurgia = new JButton("Cadastrar Cirurgia");
	}
	
	public void setCadastrarCirurgia() {
		cadastrarCirurgia.setSize(600, 240);
		cadastrarCirurgia.setLayout(null);
		jLabel();
		jTextField();
		jSlider();
		jButton();
		cadastrarCirurgia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cadastrarCirurgia.setVisible(true);
	}

	private void jButton() {
		cadastrarCirurgia.add(btGerarCodigoCirurgia);
		cadastrarCirurgia.add(btCadastrarCirurgia);
		
		btGerarCodigoCirurgia.setBounds(300, 10, 200, 20);
		btCadastrarCirurgia.setBounds(30, 150, 180, 20);
		btGerarCodigoCirurgia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer codigoDaCirurgia = GerarCodigoCirurgia.gerarCodigoCirurgia();
				String stCodigoCirurgia = Integer.toString(codigoDaCirurgia);
				txCodigoDaCirurgia.setText(stCodigoCirurgia);
				}
		});
		
		btCadastrarCirurgia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer codigoDaCirurgia = Integer.parseInt(txCodigoDaCirurgia.getText());
				String nomeDaCirurgia = txNomeDaCirurgia.getText();
				String tipoCirurgia = txTipoCirurgia.getText();
				String riscoCirurgia = txRiscoCirurgia.getText();
				
				Cirurgias cirurgias = new Cirurgias();
				CirurugiaDAO ciDAO = new CirurugiaDAO();
				
				cirurgias.setCodCirurgia(codigoDaCirurgia);
				cirurgias.setNomeCirurgia(nomeDaCirurgia);
				cirurgias.setTipoCirurgia(tipoCirurgia);
				cirurgias.setRiscoCirurgia(riscoCirurgia);
				
				ciDAO.cadastrarCirurgia(cirurgias);
				
			}
		});
	}

	private void jSlider() {
		cadastrarCirurgia.add(slRiscoCirurgia);
		cadastrarCirurgia.add(slTipoCirurgia);
		
		slRiscoCirurgia.setBounds(300, 100, 100, 20);
		slTipoCirurgia.setBounds(300, 70, 100, 20);
		
		
		slRiscoCirurgia.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int valorSlide = slRiscoCirurgia.getValue();
				txRiscoCirurgia.setText(riscoCirurgia[valorSlide]);
			}
		});
		
		slTipoCirurgia.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int valorSlide = slTipoCirurgia.getValue();
				txTipoCirurgia.setText(tipoDeCirurgia[valorSlide]);
			}
		});
	}

	private void jLabel() {
		cadastrarCirurgia.add(lbCodigoCirurgia);
		cadastrarCirurgia.add(lbNomeCirurgia);
		cadastrarCirurgia.add(lbTipoCirurgia);
		cadastrarCirurgia.add(lbRiscoCirurgia);
		
		lbCodigoCirurgia.setBounds(10, 10, 130, 20);
		lbNomeCirurgia.setBounds(10, 40, 100, 20);
		lbTipoCirurgia.setBounds(10, 70, 100, 20);
		lbRiscoCirurgia.setBounds(10, 100, 100, 20);
	}
	
	
	private void jTextField() {
		cadastrarCirurgia.add(txCodigoDaCirurgia);
		cadastrarCirurgia.add(txNomeDaCirurgia);
		cadastrarCirurgia.add(txTipoCirurgia);
		cadastrarCirurgia.add(txRiscoCirurgia);
		
		
		txCodigoDaCirurgia.setBounds(140,10, 150,20);
		txNomeDaCirurgia.setBounds(140, 40, 150, 20);
		txTipoCirurgia.setBounds(140, 70, 150, 20);
		txRiscoCirurgia.setBounds(140, 100, 150, 20);
	}
	
	
	

	
	public static void main(String[] args) {
		new CadastrarCirurgias()
			.setCadastrarCirurgia();
	}
}
