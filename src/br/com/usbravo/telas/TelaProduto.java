/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usbravo.telas;

import javax.swing.JOptionPane;
import java.sql.*;
import br.com.usbravo.connections.ModuloConexao;

/**
 *
 * @author mv
 */
public class TelaProduto extends javax.swing.JInternalFrame {

    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private String tamanho;
    private String status;

    /**
     * Creates new form TelaProduto
     */
    public TelaProduto() {
        initComponents();
        c = ModuloConexao.conector();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidproduto = new javax.swing.JTextField();
        txtdescricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        rbtp = new javax.swing.JRadioButton();
        rbtm = new javax.swing.JRadioButton();
        rbtg = new javax.swing.JRadioButton();
        rbtgg = new javax.swing.JRadioButton();
        txtpreco_venda = new javax.swing.JTextField();
        txtdata_compra = new javax.swing.JFormattedTextField();
        txtpreco_compra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        rbts = new javax.swing.JRadioButton();
        rbtn = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Tela Produto");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("id Produto");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Descrição");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Tamanho");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Data");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Preço Compra");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Preço Venda");

        txtidproduto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtdescricao.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Estoque");

        buttonGroup1.add(rbtp);
        rbtp.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rbtp.setText("P");
        rbtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtpActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtm);
        rbtm.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rbtm.setText("M");
        rbtm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtmActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtg);
        rbtg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rbtg.setText("G");
        rbtg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtgActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtgg);
        rbtgg.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rbtgg.setText("GG");
        rbtgg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtggActionPerformed(evt);
            }
        });

        txtpreco_venda.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtpreco_venda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpreco_vendaActionPerformed(evt);
            }
        });

        try {
            txtdata_compra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtdata_compra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtdata_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdata_compraActionPerformed(evt);
            }
        });

        txtpreco_compra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtpreco_compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpreco_compraActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/usbravo/icones/create.png"))); // NOI18N
        jButton1.setToolTipText("Adicionar Produto");
        jButton1.setPreferredSize(new java.awt.Dimension(80, 80));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/usbravo/icones/read.png"))); // NOI18N
        jButton2.setToolTipText("Pesquisar Produto");
        jButton2.setPreferredSize(new java.awt.Dimension(80, 80));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/usbravo/icones/update.png"))); // NOI18N
        jButton3.setToolTipText("Editar Produto");
        jButton3.setPreferredSize(new java.awt.Dimension(80, 80));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/usbravo/icones/clean64.png"))); // NOI18N
        jButton4.setToolTipText("Limpar Campos");
        jButton4.setPreferredSize(new java.awt.Dimension(80, 80));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/usbravo/icones/delete.png"))); // NOI18N
        jButton5.setToolTipText("Remover Produto");
        jButton5.setPreferredSize(new java.awt.Dimension(80, 80));

        buttonGroup2.add(rbts);
        rbts.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rbts.setText("Sim");
        rbts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtsActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbtn);
        rbtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rbtn.setText("Não");
        rbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtidproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtgg))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtpreco_compra, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtdata_compra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                        .addContainerGap(254, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpreco_venda, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbts)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtn)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtp)
                    .addComponent(rbtm)
                    .addComponent(rbtg)
                    .addComponent(rbtgg)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdata_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpreco_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpreco_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rbts)
                    .addComponent(rbtn))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpreco_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpreco_vendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpreco_vendaActionPerformed

    private void txtpreco_compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpreco_compraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpreco_compraActionPerformed

    private void rbtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtpActionPerformed
        // atribui o texto a variavel tamanho:
        tamanho = "P";
    }//GEN-LAST:event_rbtpActionPerformed

    private void rbtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtmActionPerformed
        // atribui o texto a variavel tamanho:
        tamanho = "M";
    }//GEN-LAST:event_rbtmActionPerformed

    private void rbtgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtgActionPerformed
        // atribui o texto a variavel tamanho:
        tamanho = "G";
    }//GEN-LAST:event_rbtgActionPerformed

    private void rbtggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtggActionPerformed
        // atribui o texto a variavel tamanho:
        tamanho = "GG";
    }//GEN-LAST:event_rbtggActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // ao iniciar a tela marcar o radiobuton:
        rbtp.setSelected(true);
        tamanho = "P";
        rbts.setSelected(true);
        status = "sim";
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Adiconar Produto:
        adicionar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnActionPerformed
        // atribui o texto a variavel status:
        status = "nao";
    }//GEN-LAST:event_rbtnActionPerformed

    private void rbtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtsActionPerformed
        // atribui o texto a variavel status:
        status = "sim";
    }//GEN-LAST:event_rbtsActionPerformed

    private void txtdata_compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdata_compraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdata_compraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton rbtg;
    private javax.swing.JRadioButton rbtgg;
    private javax.swing.JRadioButton rbtm;
    private javax.swing.JRadioButton rbtn;
    private javax.swing.JRadioButton rbtp;
    private javax.swing.JRadioButton rbts;
    private javax.swing.JFormattedTextField txtdata_compra;
    private javax.swing.JTextField txtdescricao;
    private javax.swing.JTextField txtidproduto;
    private javax.swing.JTextField txtpreco_compra;
    private javax.swing.JTextField txtpreco_venda;
    // End of variables declaration//GEN-END:variables

    private void adicionar() {
        String sql = "INSERT INTO `produtos` VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, txtidproduto.getText());
            ps.setString(2, txtdescricao.getText());
            ps.setString(3, tamanho);
            ps.setString(4, txtdata_compra.getText());
            ps.setString(5, txtpreco_compra.getText());
            ps.setString(6, txtpreco_venda.getText());
            ps.setString(7, status);
            
            if (txtidproduto.getText().isEmpty() || txtdescricao.getText().isEmpty() || txtdata_compra.getText().isEmpty() || txtpreco_compra.getText().isEmpty() || txtpreco_venda.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {

                //atualiza a tabela usuarios com os dados dos campos
                int adicionado = ps.executeUpdate();System.out.println(ps);
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
                    limpar_dados();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void limpar_dados() {
        txtidproduto.setText(null);
        txtdescricao.setText(null);        
        txtdata_compra.setText(null);
        txtpreco_compra.setText(null);
        txtpreco_venda.setText(null);
    }
}
