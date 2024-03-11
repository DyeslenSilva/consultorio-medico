package medico.cirurgias.intefaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import medico.cirurgias.dao.CirurugiaDAO;
import medico.cirurgias.dao.MedicoCirurgiaoDAO;
import medico.cirurgias.model.Cirurgias;
import medico.cirurgias.model.MedicoCirurgiao;
import medico.consultorio.database.dao.MedicoDAO;
import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.GeradorToken;
import medico.consultorio.model.Medico;
import medico.consultorio.model.Paciente;

public class AgendarCirurgia {

	private JFrame agendarCirurgia;
	private JLabel lbToken, lbCPF, lbNomeDoPaciente, lbNomeCirurgia,lbTipoCirurgia, lbRiscoCirurgia;
	private JLabel lbDataCirurgia, lbHoraCirurgia;
	private JLabel lbMedicoRequirente, lbMedicoCirurgiao;
	private JTextField txToken, txCPF, txNomeDoPaciente, txTipoCirurgia, txRiscoCirurgia;
	private JTextField txDataCirurgia, txHoraCirurgia;
	private JComboBox<String> medicoRequirente;
	private JComboBox<String> medicoCirurgiao;
	private JComboBox<String> cirurgias;
	private JButton btAgendaCirurgia,btBuscaCPF, dataCirurgia, horaCirurgia , btGerarToken;
	
	
	public AgendarCirurgia() {
		agendarCirurgia = new JFrame("Agedar Cirurgia");
		
		lbToken = new JLabel("Token");
		lbCPF = new JLabel("CPF");
		lbNomeDoPaciente = new JLabel("Nome do Paciente");
		lbNomeCirurgia = new JLabel("Nome da Cirurgia");
		lbMedicoRequirente = new JLabel("Medico Requirente");
		lbMedicoCirurgiao = new JLabel("Medico Cirurgiao");
		lbTipoCirurgia = new JLabel("Tipo de Cirurgia");
		lbRiscoCirurgia = new JLabel("Risco de Cirurgia");
		lbDataCirurgia = new JLabel ("Data da Cirurgia");
		lbHoraCirurgia = new JLabel("Hora da Cirurgia");
		
		txToken = new JTextField();
		txCPF = new JTextField();
		txNomeDoPaciente = new  JTextField();
		txTipoCirurgia = new JTextField();
		txRiscoCirurgia = new JTextField();
		txDataCirurgia = new JTextField();
		txHoraCirurgia = new JTextField();
		
		cirurgias  =new JComboBox<String>();		
		medicoCirurgiao = new JComboBox<String>();
		medicoRequirente = new JComboBox<String>();
		
		btAgendaCirurgia  = new JButton("Agendar Cirurgia");
		btBuscaCPF = new JButton("Buscar CPF");
		btGerarToken = new JButton("Gerar Token");
		dataCirurgia = new JButton("Data da Cirurgia");
		horaCirurgia = new  JButton("Hora da Cirurgia");
	}
	
	
	public void setAgendarCirurgia() {
		agendarCirurgia.setSize(1000, 600);
		agendarCirurgia.setLayout(null);
		
		jLabel();
		jTextField();
		combobox();
		jButton();
		agendarCirurgia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		agendarCirurgia.setVisible(true);
	}

	private void jLabel() {
		agendarCirurgia.add(lbToken);
		agendarCirurgia.add(lbCPF);
		agendarCirurgia.add(lbNomeDoPaciente);
		agendarCirurgia.add(lbMedicoRequirente);
		agendarCirurgia.add(lbMedicoCirurgiao);
		agendarCirurgia.add(lbNomeCirurgia);
		agendarCirurgia.add(lbTipoCirurgia);
		agendarCirurgia.add(lbRiscoCirurgia);
		agendarCirurgia.add(lbDataCirurgia);
		agendarCirurgia.add(lbHoraCirurgia);
		
		lbToken.setBounds(10, 10, 100, 20);
		lbCPF.setBounds(10, 40, 100, 20);
		lbNomeDoPaciente.setBounds(10, 70, 150, 20);
		lbMedicoRequirente.setBounds(10, 100, 150, 20);
		lbMedicoCirurgiao.setBounds(10, 130, 150, 20);
		lbNomeCirurgia.setBounds(10, 160, 100, 20);
		lbTipoCirurgia.setBounds(10, 190, 100, 20);
		lbRiscoCirurgia.setBounds(10, 220, 100, 20);
		lbDataCirurgia.setBounds(10, 250, 100, 20);
		lbHoraCirurgia.setBounds(10, 280, 100, 20);
	}
	

	private void jTextField() {
		agendarCirurgia.add(txToken);
		agendarCirurgia.add(txCPF);
		agendarCirurgia.add(txNomeDoPaciente);
		agendarCirurgia.add(txTipoCirurgia);
		agendarCirurgia.add(txRiscoCirurgia);
		agendarCirurgia.add(txDataCirurgia);
		agendarCirurgia.add(txHoraCirurgia);
		
		txToken.setBounds(190, 10, 150, 20);
		txCPF.setBounds(190, 40, 150, 20);
		txNomeDoPaciente.setBounds(190, 70, 150, 20);
		txTipoCirurgia.setBounds(190, 190, 150, 20);
		txRiscoCirurgia.setBounds(190, 220, 150, 20);
		txDataCirurgia.setBounds(190, 250, 150, 20);
		txHoraCirurgia.setBounds(190, 280, 150, 20);
	}



	private void combobox() {
		agendarCirurgia.add(cirurgias);
		agendarCirurgia.add(medicoRequirente);
		agendarCirurgia.add(medicoCirurgiao);
		
		cirurgias.setBounds(190, 160, 150, 20);
		medicoRequirente.setBounds(190, 100, 150, 20);
		medicoCirurgiao.setBounds(190, 130, 150, 20);
		
		carregarCirurgias();
		carregarCirurgiao();
		carregarMedReq();
	}
	
	private void jButton() {
		agendarCirurgia.add(btBuscaCPF);
		agendarCirurgia.add(btGerarToken);
		agendarCirurgia.add(dataCirurgia);
		agendarCirurgia.add(horaCirurgia);
		agendarCirurgia.add(btAgendaCirurgia);
		
		btAgendaCirurgia.setBounds(30, 320, 130, 20);
		btBuscaCPF.setBounds(380,40,150,20);
		btGerarToken.setBounds(380, 10, 150,20);
		dataCirurgia.setBounds(380, 250, 150, 20);
		horaCirurgia.setBounds(380, 280, 150, 20);
		
		btGerarToken.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String token  = GeradorToken.gerarToken(5);
				txToken.setText(token);
			}
		});
		
		
		btBuscaCPF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PacienteDAO pacienteDAO = new PacienteDAO();
				String cpf = txCPF.getText();
				Paciente pac = pacienteDAO.consultaClientePorCPF(cpf);
				txNomeDoPaciente.setText(pac.getNomePaciente());
			}
		});
		
	}

	
	private void carregarCirurgiao() {
		MedicoCirurgiaoDAO medCirDAO = new MedicoCirurgiaoDAO();
		List<MedicoCirurgiao> listaMedCir = medCirDAO. listaMedicosCirurgia();
		for(MedicoCirurgiao medCir : listaMedCir) {
			medicoCirurgiao.addItem(medCir.getNomeMedico());
		}
	}
	
	
	private void carregarCirurgias() {
		CirurugiaDAO cirDAO = new CirurugiaDAO();
		List<Cirurgias> listaCir = cirDAO.listaTodasAsCirurgias();
		for(Cirurgias cirurgias : listaCir) {
			this.cirurgias.addItem(cirurgias.getNomeCirurgia());
		}
	}
	
	private void carregarMedReq() {
		MedicoDAO medDAO = new MedicoDAO();
		List<Medico> listaMedico = medDAO.listarTodosOsMedicos();
		for(Medico med : listaMedico) {
			medicoRequirente.addItem(med.getNomeMedico());
		}
	}
	public static void main(String[] args) {
		new AgendarCirurgia()
			.setAgendarCirurgia();
	}
	
}
