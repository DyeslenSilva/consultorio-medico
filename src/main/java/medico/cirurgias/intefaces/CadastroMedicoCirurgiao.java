package medico.cirurgias.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import estado.sistema.dao.EstadoDAO;
import estado.sistema.model.Estado;
import medico.cirurgias.dao.EspecialidadeDAO;
import medico.cirurgias.dao.MedicoCirurgiaoDAO;
import medico.cirurgias.model.Especialidades;
import medico.cirurgias.model.MedicoCirurgiao;
import medico.consultorio.model.GerarCRM;

public class CadastroMedicoCirurgiao {

	private JFrame cadastroMedicoCirurgiao;
	private JLabel lbCRM, lbNomeMedico, lbEspecialidade, lbDDD;
	private JLabel lbTelefone, lbEmail, lbCidade, lbEstado;
	private JTextField txCRM, txNomeMedico, txDDD;
	private JTextField txTelefone, txEmail, txCidade;
	private JButton btGerarCRM, btCadastrarCM;
	private JComboBox<String> estados;
	private JComboBox<String> especialidades;
	
	
	public CadastroMedicoCirurgiao() {
		cadastroMedicoCirurgiao = new JFrame();
		
		lbCRM = new JLabel("CRM");
		lbNomeMedico = new JLabel("Nome do Medico");
		lbEspecialidade =new JLabel("Especialidade");
		lbDDD = new JLabel("DDD");
		lbTelefone = new JLabel("Telefone");
		lbEmail = new JLabel("Email");
		lbCidade = new JLabel("Cidade");
		lbEstado = new JLabel("Estado");
		
		txCRM = new JTextField();
		txNomeMedico = new JTextField();
		txDDD = new JTextField();
		txTelefone = new JTextField();
		txEmail = new JTextField();
		txCidade = new JTextField();
		
		btGerarCRM = new JButton("Gerar CRM");
		btCadastrarCM = new JButton("Cadastrar Medico Cirurgiao");
		
		
		estados = new JComboBox<String>();
		especialidades = new JComboBox<String>();
	}
	
	public void setCadastroMedicoCirurgiao() {
		cadastroMedicoCirurgiao.setSize(600, 400);
		cadastroMedicoCirurgiao.setLayout(null);
		jLabel();
		jTextField();
		jComboBox();
		jButton();
		cadastroMedicoCirurgiao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cadastroMedicoCirurgiao.setVisible(true);
	}

	
	private void jButton() {
		cadastroMedicoCirurgiao.add(btGerarCRM);
		cadastroMedicoCirurgiao.add(btCadastrarCM);
		
		
		btGerarCRM.setBounds(350, 10, 150, 20);
		btCadastrarCM.setBounds(30, 250, 220, 20);
		
		
		btGerarCRM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String crm = GerarCRM.gerarRegistroMedico();
				txCRM.setText(crm);
			}
		});
		
		btCadastrarCM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String crm = txCRM.getText();
				String nomeDoMedico = txNomeMedico.getText();
				String especialidade = especialidades.getSelectedItem().toString();
				int ddd = Integer.parseInt(txDDD.getText());
				String telefone = txTelefone.getText();
				String email = txEmail.getText();
				String cidade = txCidade.getText();
				String estado = estados.getSelectedItem().toString();
				
				MedicoCirurgiao medCir = new MedicoCirurgiao();
				MedicoCirurgiaoDAO medCirDAO = new MedicoCirurgiaoDAO();
				
				medCir.setCrm(crm);
				medCir.setNomeMedico(nomeDoMedico);
				medCir.setEspecialidade(especialidade);
				medCir.setDdd(ddd);
				medCir.setTelefone(telefone);
				medCir.setEmail(email);
				medCir.setCidade(cidade);
				medCir.setEstado(estado);
				
				medCirDAO.cadastrarMedicoCirurgia(medCir);
			}
		});
		
	}

	private void jComboBox() {
		cadastroMedicoCirurgiao.add(estados);
		cadastroMedicoCirurgiao.add(especialidades);
		estados.setBounds(150, 220, 150, 20);
		especialidades.setBounds(150, 70, 150, 20);

		carregarEstados();
		carregaEspecialidades();
	}

	private void carregarEstados() {
		EstadoDAO estDAO = new EstadoDAO();
		List<Estado> listaEstados = estDAO.listaTodosEstados();
		
		for(Estado sigEst : listaEstados) {
			 estados.addItem(sigEst.getUf());
		}
	}
	
	
	private void carregaEspecialidades() {
		EspecialidadeDAO epecDAO = new EspecialidadeDAO();
		List<Especialidades> listaEspec = epecDAO.listaTodasEspecialidades();
		
		for(Especialidades espec : listaEspec) {
			especialidades.addItem(espec.getNomeEspecialidade());
		}
	}

	private void jLabel() {
		cadastroMedicoCirurgiao.add(lbCRM);
		cadastroMedicoCirurgiao.add(lbNomeMedico);
		cadastroMedicoCirurgiao.add(lbEspecialidade);
		cadastroMedicoCirurgiao.add(lbDDD);
		cadastroMedicoCirurgiao.add(lbTelefone);
		cadastroMedicoCirurgiao.add(lbEmail);
		cadastroMedicoCirurgiao.add(lbCidade);
		cadastroMedicoCirurgiao.add(lbEstado);
		
		lbCRM.setBounds(10, 10, 150, 20);
		lbNomeMedico.setBounds(10, 40, 150, 20);
		lbEspecialidade.setBounds(10, 70, 150, 20);
		lbDDD.setBounds(10, 100, 150, 20);
		lbTelefone.setBounds(10, 130, 150, 20);
		lbEmail.setBounds(10, 160, 150, 20);
		lbCidade.setBounds(10, 190, 150, 20);
		lbEstado.setBounds(10, 220, 150, 20);
	}
	
	private void jTextField() {
		cadastroMedicoCirurgiao.add(txCRM);
		cadastroMedicoCirurgiao.add(txNomeMedico);
		//cadastroMedicoCirurgiao.add(txEspecialidade);
		cadastroMedicoCirurgiao.add(txDDD);
		cadastroMedicoCirurgiao.add(txTelefone);
		cadastroMedicoCirurgiao.add(txEmail);
		cadastroMedicoCirurgiao.add(txCidade);
		
		txCRM.setBounds(150, 10, 150, 20);
		txNomeMedico.setBounds(150, 40, 150, 20);
		txDDD.setBounds(150, 100, 150, 20);
		txTelefone.setBounds(150, 130, 150, 20);
		txEmail.setBounds(150, 160, 150, 20);
		txCidade.setBounds(150, 190, 150, 20);
		
	}

	public static void main(String[] args) {
		new CadastroMedicoCirurgiao()
			.setCadastroMedicoCirurgiao();
	}

}
