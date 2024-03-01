package medico.consultorio.interfaces.pesquisas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import medico.consultorio.database.dao.PacienteDAO;
import medico.consultorio.model.Paciente;

public class ListaTodosOsPacientes {

    private JFrame listaTodosOsPacientes;
    private JButton listaTodosPacientes;
    private JTable listaDeTodosOsPacientes;
    private JScrollPane scrollPane;

    public ListaTodosOsPacientes() {
        listaTodosOsPacientes = new JFrame("Lista de Pacientes");

        listaTodosPacientes = new JButton("Listar todos os pacientes ");

        listaDeTodosOsPacientes = new JTable();
        scrollPane = new JScrollPane(listaDeTodosOsPacientes);
    }

    public void setListaTodosOsPacientes() {
        listaTodosOsPacientes.setSize(1600, 400);
        listaTodosOsPacientes.setLayout(null);

        jbutton();
        //jTable();
        jScrollPane();
        tamanhoDaTabela();
        
       // ajusteTamanhoColuna();
        
        scrollPane.setBounds(10, 60, 600, 300);
        listaTodosOsPacientes.add(scrollPane);

        listaTodosOsPacientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        listaTodosOsPacientes.setVisible(true);
    }

    private void jbutton() {
        listaTodosOsPacientes.add(listaTodosPacientes);
        listaTodosPacientes.setBounds(10, 10, 200, 40);

        listaTodosPacientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PacienteDAO pacDAO = new PacienteDAO();
                List<Paciente> listaDePacientes = pacDAO.listarTodosOsPacientes();
                DefaultTableModel dtm = new DefaultTableModel();

                dtm.addColumn("CPF");
                dtm.addColumn("Nome Completo");
                dtm.addColumn("DDD");
                dtm.addColumn("Telefone");
                dtm.addColumn("Endereco");
                dtm.addColumn("N");
                dtm.addColumn("Cidade");
                dtm.addColumn("UF");

                for (Paciente paciente : listaDePacientes) {
                    Object[] row = {
                            paciente.getCpf(),
                            paciente.getNomePaciente(),
                            paciente.getDdd(),
                            paciente.getTelefone(),
                            paciente.getEndereco(),
                            paciente.getNCasa(),
                            paciente.getCidade(),
                            paciente.getEstado()
                    };
                    dtm.addRow(row);
                }

                listaDeTodosOsPacientes.setModel(dtm);
                ajusteTamanhoColuna();
            }
        });
    }

    private void ajusteTamanhoColuna() {
    	listaDeTodosOsPacientes.getColumnModel().getColumn(0).setPreferredWidth(330); // CPF
        listaDeTodosOsPacientes.getColumnModel().getColumn(1).setPreferredWidth(440);// Nome Completo
        listaDeTodosOsPacientes.getColumnModel().getColumn(2).setPreferredWidth(100);//DDD
        listaDeTodosOsPacientes.getColumnModel().getColumn(3).setPreferredWidth(350); // Telefone
        listaDeTodosOsPacientes.getColumnModel().getColumn(4).setPreferredWidth(550); // Endereco
        listaDeTodosOsPacientes.getColumnModel().getColumn(5).setPreferredWidth(50);  // N
        listaDeTodosOsPacientes.getColumnModel().getColumn(6).setPreferredWidth(350); // Cidade
        listaDeTodosOsPacientes.getColumnModel().getColumn(7).setPreferredWidth(50); // Estado
    }
    
    private void jScrollPane() {
    	scrollPane.setBounds(10, 60,1500, 400);
    	listaTodosOsPacientes.add(scrollPane);
    }
    
    private void tamanhoDaTabela() {
    	listaDeTodosOsPacientes.setSize(600, 400);
    }
    
    public static void main(String[] args) {
        new ListaTodosOsPacientes().setListaTodosOsPacientes();
    }
}
