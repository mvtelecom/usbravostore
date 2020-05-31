/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.usbravo.telas;

import java.sql.*;
import br.com.usbravo.connections.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import sun.awt.X11.XConstants;

/**
 *
 * @author mv
 */
public class TelaCliente extends javax.swing.JInternalFrame {

    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        c = ModuloConexao.conector();
        pesquisar_cliente();
    }

    private void adicionar() {
        String sql = "INSERT INTO `clientes` VALUES (NULL, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, txtNome.getText());
            ps.setString(2, txtCpf.getText());
            ps.setString(3, txtIdentidade.getText());
            ps.setString(4, txtRua.getText());
            ps.setString(5, txtBairro.getText());
            ps.setString(6, txtCep.getText());
            ps.setString(7, txtCidade.getText());
            ps.setString(8, txtTelefone.getText());

            if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtIdentidade.getText().isEmpty() || txtRua.getText().isEmpty() || txtBairro.getText().isEmpty() || txtCep.getText().isEmpty() | txtCidade.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtTelefone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                //atualiza a tabela usuarios com os dados dos campos
                int adicionado = ps.executeUpdate();
                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
                    txtNome.setText(null);
                    txtCpf.setText(null);
                    txtIdentidade.setText(null);
                    txtRua.setText(null);
                    txtBairro.setText(null);
                    txtCep.setText(null);
                    txtCidade.setText(null);
                    txtTelefone.setText(null);

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CPF em uso");
        }

    }

    private void pesquisar_cliente() {
        String sql = "SELECT `idcliente`, `nome`, `cpf`, `identidade`, `telefone` FROM `clientes` WHERE `nome` like ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, txtPesquisar.getText() + "%");
            rs = ps.executeQuery();
            //usando a biblioteca rs2.xml para preencher a tabela
            tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
            tblClientes.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void setar_campos() {
        int setar = tblClientes.getSelectedRow();
        txtIdcliente.setText(tblClientes.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tblClientes.getModel().getValueAt(setar, 1).toString());
        txtCpf.setText(tblClientes.getModel().getValueAt(setar, 2).toString());
        txtIdentidade.setText(tblClientes.getModel().getValueAt(setar, 3).toString());
        txtTelefone.setText(tblClientes.getModel().getValueAt(setar, 4).toString());
        btnAdicionar.setEnabled(false);
        btnAtualizar.setEnabled(true);
        btnRemover.setEnabled(true);

    }

    private void alterar() {
        String sql = "UPDATE `clientes` SET `nome` = ?, `cpf` = ?, `identidade` = ?, `rua` = ?, `bairro` = ?, `cep` = ?, `cidade` = ?, `telefone` = ? WHERE `clientes`.`idcliente` = ?;";
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1, txtNome.getText());
            ps.setString(2, txtCpf.getText());
            ps.setString(3, txtIdentidade.getText());
            ps.setString(4, txtRua.getText());
            ps.setString(5, txtBairro.getText());
            ps.setString(6, txtCep.getText());
            ps.setString(7, txtCidade.getText());
            ps.setString(8, txtTelefone.getText());
            ps.setString(9, txtIdcliente.getText());

            if (txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtIdentidade.getText().isEmpty() || txtRua.getText().isEmpty() || txtBairro.getText().isEmpty() || txtCep.getText().isEmpty() | txtCidade.getText().isEmpty() || txtTelefone.getText().isEmpty() || txtTelefone.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                //atualiza a tabela usuarios com os dados dos campos
                int alterado = ps.executeUpdate();
                if (alterado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
                    txtNome.setText(null);
                    txtCpf.setText(null);
                    txtIdentidade.setText(null);
                    txtRua.setText(null);
                    txtBairro.setText(null);
                    txtCep.setText(null);
                    txtCidade.setText(null);
                    txtTelefone.setText(null);
                    txtIdcliente.setText(null);
                    btnAdicionar.setEnabled(true);
                    btnAtualizar.setEnabled(false);
                    btnRemover.setEnabled(false);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CPF em uso");

        }
    }

    private void remover() {
        int confirmar = JOptionPane.showConfirmDialog(null, "Deseja realmente remover Usuario?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confirmar == JOptionPane.YES_NO_OPTION) {
            String sql = "DELETE FROM `clientes` WHERE `clientes`.`idcliente` = ?";
            try {
                ps = c.prepareStatement(sql);
                ps.setString(1, txtIdcliente.getText());
                //remove o usuario digitado

                if (txtIdcliente.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente para remover");
                } else {

                    int remover = ps.executeUpdate();
                    if (remover > 0) {
                        JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado");
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            txtNome.setText(null);
            txtCpf.setText(null);
            txtIdentidade.setText(null);
            txtRua.setText(null);
            txtBairro.setText(null);
            txtCep.setText(null);
            txtCidade.setText(null);
            txtTelefone.setText(null);
            txtIdcliente.setText(null);
            btnAdicionar.setEnabled(true);
            btnAtualizar.setEnabled(false);
            btnRemover.setEnabled(false);
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

        btnAdicionar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtIdentidade = new javax.swing.JTextField();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtPesquisar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        txtIdcliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Tela de Cliente");
        setPreferredSize(new java.awt.Dimension(1023, 630));

        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/usbravo/icones/adduser64.png"))); // NOI18N
        btnAdicionar.setToolTipText("Adicionar");
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/usbravo/icones/atualizaruser64.png"))); // NOI18N
        btnAtualizar.setToolTipText("Atualizar");
        btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAtualizar.setEnabled(false);
        btnAtualizar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/usbravo/icones/removeuser.png"))); // NOI18N
        btnRemover.setToolTipText("Excluir");
        btnRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemover.setEnabled(false);
        btnRemover.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Nome");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("CPF");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Identidade");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Rua");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Bairro");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("CEP");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Telefone ");

        txtNome.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtCpf.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtIdentidade.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtRua.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtBairro.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtCep.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtTelefone.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        txtPesquisar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/usbravo/icones/searchuser48.png"))); // NOI18N

        tblClientes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idCliente", "Nome", "CPF", "Telefone"
            }
        ));
        tblClientes.setEnabled(false);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        tblClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblClientesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(1).setPreferredWidth(5);
        }

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Cidade");

        txtCidade.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        txtIdcliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtIdcliente.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Id do Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtIdentidade, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtCidade, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRua, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionar, btnAtualizar, btnRemover});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIdcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdentidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdicionar, btnAtualizar, btnRemover});

        setBounds(0, 0, 1023, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // adicionar cliente
        adicionar();
        pesquisar_cliente();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void tblClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblClientesKeyReleased

    }//GEN-LAST:event_tblClientesKeyReleased

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        // pesquisa avancada de clientes

        pesquisar_cliente();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        // setar os campos do cliente
        setar_campos();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // altera os dados do cliente
        alterar();
        pesquisar_cliente();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // remover cliente selecionado
        remover();
        pesquisar_cliente();
    }//GEN-LAST:event_btnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtIdcliente;
    private javax.swing.JTextField txtIdentidade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
