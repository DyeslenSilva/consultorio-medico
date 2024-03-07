package medico.consultorio.interfaces.exames;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import medico.consultorio.database.dao.AgendaExameDAO;
import medico.consultorio.database.dao.MedicoDAO;
import medico.consultorio.model.AgendaExames;
import medico.consultorio.model.Medico;

public class ListaExamePorMedicoSolicitante {

    private JFrame listExamePorMedico;
    private JLabel lbNomeDoMedico;
    private JComboBox<String> cbMedicos;
    private JButton btConsultarMedicos;
    private JTable tabelaMedicoExames;
    private DefaultTableModel dtm;

    public ListaExamePorMedicoSolicitante() {
        listExamePorMedico = new JFrame();

        lbNomeDoMedico = new JLabel("Nome do Médico");

        cbMedicos = new JComboBox<String>();

        btConsultarMedicos = new JButton("Consultar Médico");

        // Inicialize o modelo de tabela aqui
        dtm = new DefaultTableModel();

        tabelaMedicoExames = new JTable(dtm);
    }

    public void setListExamePorMedico() {
        listExamePorMedico.setSize(1000, 650);
        listExamePorMedico.setLayout(null);
        comps();
        listExamePorMedico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listExamePorMedico.setVisible(true);
    }

    private void comps() {
        listExamePorMedico.add(lbNomeDoMedico);
        listExamePorMedico.add(cbMedicos);
        listExamePorMedico.add(btConsultarMedicos);


        lbNomeDoMedico.setBounds(10, 10, 150, 20);
        cbMedicos.setBounds(150, 10, 160, 20);
        btConsultarMedicos.setBounds(370, 10, 150, 20);

        JScrollPane jScrollPane = new JScrollPane(tabelaMedicoExames);
        jScrollPane.setBounds(20, 50, 950, 400);
        listExamePorMedico.add(jScrollPane);

        carregarMedicos();

        btConsultarMedicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarExamesDoMedicoSelecionado();
            }
        });
    }

    private void carregarMedicos() {
        MedicoDAO medicoDAO = new MedicoDAO();
        List<Medico> medicos = medicoDAO.listarTodosOsMedicos();
        for (Medico medico : medicos) {
            String nomeMedico = medico.getNomeMedico();
            cbMedicos.addItem(nomeMedico);
        }
    }

    private void consultarExamesDoMedicoSelecionado() {
        String nomeDoMedico = cbMedicos.getSelectedItem().toString();
        AgendaExameDAO ageDAO = new AgendaExameDAO();
        List<AgendaExames> agendaExame = ageDAO.listaExamesPorMedicoSolicitante(nomeDoMedico);

        // Limpar os dados do modelo
        dtm.setRowCount(0);

        if (agendaExame.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Exame não encontrado");
        } else {
        	
        	dtm.addColumn("Token do Exame");
        	dtm.addColumn("CPF");
        	dtm.addColumn("Nome do Paciente");
        	dtm.addColumn("Nome do Exame");
        	dtm.addColumn("Medico Solicitante");
        	dtm.addColumn("Descricao do Exame");
        	dtm.addColumn("Data do Exame");
        	dtm.addColumn("Hora do Exame");
        	
        	
            for (AgendaExames ageExames : agendaExame) {
                Object[] rowData = {
                        ageExames.getTokenExame(),
                        ageExames.getCpf(),
                        ageExames.getNomePaciente(),
                        ageExames.getNomeDoExame(),
                        ageExames.getMedicoSolicitante(),
                        ageExames.getDescricaoExame(),
                        ageExames.getDataExame(),
                        ageExames.getHoraExame()
                };
                dtm.addRow(rowData);
            }
        }
    }

    public static void main(String[] args) {
        new ListaExamePorMedicoSolicitante().setListExamePorMedico();
    }
}

