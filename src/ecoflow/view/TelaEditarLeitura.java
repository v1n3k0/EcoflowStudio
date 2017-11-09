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
import ecoflow.modelo.Unidade;
import ecoflow.modelo.UnidadesTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import net.wimpi.modbus.net.TCPMasterConnection;
import util.outros.CampoInt;

/**
 *
 * @author vinicius
 */
public class TelaEditarLeitura extends javax.swing.JInternalFrame {
    
    private Central             centralSelcionada = new Central();
    private Remota              remotaSelecionada  = new Remota();
    
    private RemotasTableModel   remotasTableModel   = new RemotasTableModel();
    private UnidadesTableModel  unidadesTableModel  = new UnidadesTableModel();
    
    private ControleCentral     controleCentral     = new ControleCentral();
    private ControleConexao     controleConexao     = new ControleConexao();
    
    private static TCPMasterConnection tcp;
    
    private Boolean flag = true;
    
    /**
     * Creates new form TelaEditarLeitura
     */
    public TelaEditarLeitura() {
        
        initComponents();
        
        int idCentral;
        int qtdRemota;
        
        //Reseta conexao
        controleConexao.setTcpMasterConnection(null);
                
        //Configurando a conexao
        tcp = controleConexao.getTcpMasterConnection();
        controleCentral.setTcpMasterConnection(tcp);  
                
        //Le na central
        idCentral = controleCentral.getIdCentral();
        qtdRemota = controleCentral.getQtdRemota();
        
        //Configura Central
        centralSelcionada.setId(idCentral);
        
        //Le arquivo xml
        centralSelcionada = controleCentral.getCentralXML(idCentral);
        
                        
        //Configurar tbRemota
        tbRemota.setModel(remotasTableModel);
        tbRemota.setRowSorter(new TableRowSorter(remotasTableModel) ); //Ordena tbRemota
        
        //Configurando tbUnidades
        tbUnidade.setModel(unidadesTableModel);
        tbUnidade.setRowSorter(new TableRowSorter(unidadesTableModel) ); //Ordenar tbUnidades
        tbUnidade.getColumnModel().removeColumn(tbUnidade.getColumnModel().getColumn(0) ); //Remove coluna Porta
        
        if(centralSelcionada != null){
            if(centralSelcionada.getQtdRemotas() == qtdRemota){
                
                //Le a central toda
                controleCentral.getRemotasLeituras(centralSelcionada.getRemotas() );
                //Salva o xml da central
                controleCentral.saveCentralXML(centralSelcionada);
                //Atualiza tabela remota
                remotasTableModel.setRemotas(centralSelcionada.getRemotas() );
                                
            }else{
                JOptionPane.showMessageDialog(null, "Central desatualizada no sistema.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Central não Cadastrado no sistema.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfLeitura = new javax.swing.JTextField();
        btAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUnidade = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbRemota = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(700, 450));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unidade"));

        jLabel1.setText("Leitura");

        tfLeitura.setDocument(new CampoInt(10));

        btAlterar.setText("Alterar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAlterar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLeitura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

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
        tbUnidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUnidadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUnidade);

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
        jScrollPane2.setViewportView(tbRemota);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbRemotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRemotaMouseClicked
        // TODO add your handling code here:
        
        //Verifica se uma linha foi selecionada
        if(tbRemota.getSelectedRow() != -1){
            
            if(flag){
                flag = false;
                
                //Inicia tela carregando
                final TelaCarregando telaCarregando = new TelaCarregando();
                telaCarregando.setVisible(true);
                
                Thread t = new Thread(){
                    public void run(){
                        //Seleciona remota
                        remotaSelecionada = centralSelcionada.getRemota(tbRemota.getSelectedRow() );
                        
                        //Configurando a conexao
                        tcp = controleConexao.getTcpMasterConnection();
                        controleCentral.setTcpMasterConnection(tcp); 

                        //Leitura da central
                        controleCentral.getUnidadesLeituras(remotaSelecionada);

                        //Atualiza tabela
                        unidadesTableModel.setUnidades(remotaSelecionada.getUnidades() );
                        
                        //fecha tela de carregando
                        telaCarregando.dispose();
                        
                    }
                };
                
                t.start();
                                
                flag = true;
            }
        }
    }//GEN-LAST:event_tbRemotaMouseClicked

    private void tbUnidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUnidadeMouseClicked
        // TODO add your handling code here:
        
        Unidade un = remotaSelecionada.getUnidade(tbUnidade.getSelectedRow() );
        
        tfLeitura.setText( Integer.toString(un.getLeitura() ) );
    }//GEN-LAST:event_tbUnidadeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbRemota;
    private javax.swing.JTable tbUnidade;
    private javax.swing.JTextField tfLeitura;
    // End of variables declaration//GEN-END:variables
}
