package medico.cirurgias.intefaces;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import medico.cirurgias.dao.AgendaCirurgiaDAO;
import medico.cirurgias.model.AgendaCirurgias;

public class ListaCirurgiasAgendadas {
    private JFrame listaCirurgiaAgendadas;
    private JButton btListaTodasCirAgendadas;
    private JTable tbCirurgiaAgendada;
    private DefaultTableModel dtm;
    private JScrollPane jScrollPane;

    public ListaCirurgiasAgendadas() {
        listaCirurgiaAgendadas = new JFrame();

        btListaTodasCirAgendadas = new JButton("Listar Todas as Cirurgias");

        tbCirurgiaAgendada = new JTable();
        dtm = new DefaultTableModel();
        jScrollPane = new JScrollPane(tbCirurgiaAgendada);
    }

    public void setListaCirurgiaAgendadas() {
        listaCirurgiaAgendadas.setSize(1900, 600);
        listaCirurgiaAgendadas.setLayout(null);

        comps();

        listaCirurgiaAgendadas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listaCirurgiaAgendadas.setVisible(true);
    }

    private void comps() {
        listaCirurgiaAgendadas.add(btListaTodasCirAgendadas);
        listaCirurgiaAgendadas.add(jScrollPane);

        btListaTodasCirAgendadas.setBounds(10, 10, 250, 40);
        jScrollPane.setBounds(10, 60, 1450, 450);

        btListaTodasCirAgendadas.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AgendaCirurgiaDAO cdao = new AgendaCirurgiaDAO();
                List<AgendaCirurgias> listaTodasCirurgias = cdao.listaTodasCirurgias();

                dtm.setColumnIdentifiers(new String[]{"Token",
                				"CPF", 
                				"Nome do Paciente", 
                				"Medico Requirente", 
                				"Medico Cirurgiao", 
                				"Nome da Cirurgia", 
                				"Tipo da Cirurgia", 
                				"Risco da Cirurgia", 
                				"Data da Cirurgia", 
                				"Hora da Cirurgia"});

                for (AgendaCirurgias age : listaTodasCirurgias) {
                    Object[] rows = {
                            age.getToken(),
                            age.getCpf(),
                            age.getNomePaciente(),
                            age.getMedicoRequerente(),
                            age.getMedicoCirurgiao(),
                            age.getNomeCirurgia(),
                            age.getTipoCirurgia(),
                            age.getRiscoCirurgia(),
                            age.getDataCirurgia(),
                            age.getHoraCirurgia()
                    };
                    dtm.addRow(rows);

                }
                tbCirurgiaAgendada.setModel(dtm);
                ajustarTamanho();
            }           
            
        });
        
    }


    private void ajustarTamanho() {
        TableColumnModel columnModel = tbCirurgiaAgendada.getColumnModel();
        for (int i = 0; i < columnModel.getColumnCount(); i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(100); // Defina o tamanho preferencial de cada coluna aqui
        }
    }



    
    public static void main(String[] args) {
        new ListaCirurgiasAgendadas()
                .setListaCirurgiaAgendadas();
    }
}
