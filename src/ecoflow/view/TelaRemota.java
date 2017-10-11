/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoflow.view;

import ecoflow.controle.ControleCentral;
import ecoflow.controle.ControleConexao;
import ecoflow.modelo.Central;
import ecoflow.modelo.Remota;
import ecoflow.modelo.RemotasTableModel;
import ecoflow.modelo.UnidadesTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import net.wimpi.modbus.net.TCPMasterConnection;

/**
 *
 * @author vinicius
 */
public class TelaRemota extends javax.swing.JInternalFrame {
    
    
    private Central central = new Central();
    private Remota  remota  = new Remota();
    
    private RemotasTableModel   remotasTableModel   = new RemotasTableModel();
    private UnidadesTableModel  unidadesTableModel  = new UnidadesTableModel();
    
    private ControleCentral     controleCentral     = new ControleCentral();
    private ControleConexao     controleConexao     = new ControleConexao();

    /**
     * Creates new form TelaRemota
     */
    public TelaRemota(Central c) {
        initComponents();
        
        TCPMasterConnection tcp;
        
        //Configurando a conexao
        tcp = controleConexao.getTcpMasterConnection();
        controleCentral.setTcpMasterConnection(tcp);
        
        //Cria o arquivo xml senão existir
        controleCentral.criarCentral(c);
        
        //Configurar central
        central = c;
        controleCentral.getRemotasLeituras(central.getRemotas() );
               
        //Configurar tbRemota
        tbRemota.setModel(remotasTableModel);
        tbRemota.setRowSorter(new TableRowSorter(remotasTableModel) ); //Ordena tbRemota
        remotasTableModel.setRemotas(c.getRemotas() );
        
        //Configurar tbUnidade
        tbUnidade.setModel(unidadesTableModel);
        tbUnidade.setRowSorter(new TableRowSorter(unidadesTableModel) ); //Ordena tbUnidade
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRemota = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUnidade = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbHabilitadoUnidade = new javax.swing.JCheckBox();
        ccServicoUnidade = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btAterarUnidade = new javax.swing.JButton();
        tfLeituraUnidade = new javax.swing.JFormattedTextField();
        tfNomeUnidade = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        tfMatriculaUnidade = new javax.swing.JFormattedTextField();
        tfNumeroUnidade = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbHabilitadoRemota = new javax.swing.JCheckBox();
        ccServicoRemota = new javax.swing.JComboBox<>();
        tfNomeRemota = new javax.swing.JFormattedTextField();
        tfLeituraRemota = new javax.swing.JFormattedTextField();
        btAdicionarRemota = new javax.swing.JButton();
        tfMatriculaRemota = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNumeroRemota = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        tbRemota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbRemota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRemotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbRemota);

        tbUnidade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbUnidade);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidade"));

        jLabel7.setText("Leitura:");
        jLabel7.setEnabled(false);

        jLabel5.setText("Serviço:");

        cbHabilitadoUnidade.setText("Habilitado");

        ccServicoUnidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        ccServicoUnidade.setPreferredSize(new java.awt.Dimension(37, 20));

        jLabel8.setText("Nome:");

        btAterarUnidade.setText("Alterar");
        btAterarUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAterarUnidadeActionPerformed(evt);
            }
        });

        tfLeituraUnidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tfLeituraUnidade.setEnabled(false);

        try {
            tfNomeUnidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUU")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("N. Hidrometro:");

        tfMatriculaUnidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        try {
            tfNumeroUnidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AAAAAAAAAAAA")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setText("Mat. Hidrometro:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(tfNomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(ccServicoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(tfMatriculaUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNumeroUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfLeituraUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbHabilitadoUnidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAterarUnidade)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addComponent(jLabel7)
                        .addComponent(jLabel5)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ccServicoUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbHabilitadoUnidade)
                            .addComponent(btAterarUnidade)
                            .addComponent(tfLeituraUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNomeUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfMatriculaUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNumeroUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Remota"));

        jLabel1.setText("Nome:");

        jLabel3.setText("Serviço:");

        jLabel4.setText("Leitura:");
        jLabel4.setEnabled(false);

        cbHabilitadoRemota.setText("Habilitado");
        cbHabilitadoRemota.setEnabled(false);

        ccServicoRemota.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        ccServicoRemota.setPreferredSize(new java.awt.Dimension(37, 20));

        try {
            tfNomeRemota.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUUUUU")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tfLeituraRemota.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tfLeituraRemota.setEnabled(false);

        btAdicionarRemota.setText("Adicionar");
        btAdicionarRemota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarRemotaActionPerformed(evt);
            }
        });

        tfMatriculaRemota.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        tfMatriculaRemota.setEnabled(false);

        jLabel2.setText("Mat. Hidrometro:");
        jLabel2.setEnabled(false);

        tfNumeroRemota.setEnabled(false);

        jLabel9.setText("N. Hidrometro:");
        jLabel9.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tfNomeRemota, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ccServicoRemota, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMatriculaRemota, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNumeroRemota, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfLeituraRemota, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbHabilitadoRemota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btAdicionarRemota)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ccServicoRemota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHabilitadoRemota)
                    .addComponent(tfNomeRemota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLeituraRemota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdicionarRemota)
                    .addComponent(tfMatriculaRemota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNumeroRemota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbRemotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRemotaMouseClicked
        // TODO add your handling code here:
        
        //Verifica se uma linha foi selecionada
        if(tbRemota.getSelectedRow() != -1){
            remota = central.getRemota(tbRemota.getSelectedRow() );
            unidadesTableModel.setUnidades(remota.getUnidades() );
        }
    }//GEN-LAST:event_tbRemotaMouseClicked

    private void btAdicionarRemotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarRemotaActionPerformed
        // TODO add your handling code here:
        
        if(tfNomeRemota.getText().isEmpty() ){
            
            //Adicionar remota nova
            controleCentral.addRemota(
                    central.getRemotas(), 
                    tfNomeRemota.getText().trim(),
                    Integer.parseInt(ccServicoRemota.getSelectedItem().toString() )
            );            
            //Recupera a lista de remota
            remota = central.getRemota(central.getRemotas().size() - 1);
            //Atualiza tbRemota
            remotasTableModel.setRemotas(central.getRemotas() );
            //Atualiza tbUnidade
            unidadesTableModel.setUnidades(remota.getUnidades() );
            //Salva xml da Central
            controleCentral.saveCentral(central);
            
        }else{
            JOptionPane.showMessageDialog(null, "Nome inválido!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btAdicionarRemotaActionPerformed

    private void btAterarUnidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAterarUnidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAterarUnidadeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionarRemota;
    private javax.swing.JButton btAterarUnidade;
    private javax.swing.JCheckBox cbHabilitadoRemota;
    private javax.swing.JCheckBox cbHabilitadoUnidade;
    private javax.swing.JComboBox<String> ccServicoRemota;
    private javax.swing.JComboBox<String> ccServicoUnidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbRemota;
    private javax.swing.JTable tbUnidade;
    private javax.swing.JFormattedTextField tfLeituraRemota;
    private javax.swing.JFormattedTextField tfLeituraUnidade;
    private javax.swing.JFormattedTextField tfMatriculaRemota;
    private javax.swing.JFormattedTextField tfMatriculaUnidade;
    private javax.swing.JFormattedTextField tfNomeRemota;
    private javax.swing.JFormattedTextField tfNomeUnidade;
    private javax.swing.JFormattedTextField tfNumeroRemota;
    private javax.swing.JFormattedTextField tfNumeroUnidade;
    // End of variables declaration//GEN-END:variables
}
