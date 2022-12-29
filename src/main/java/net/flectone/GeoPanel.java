/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package net.flectone;

import com.formdev.flatlaf.ui.FlatButtonBorder;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author TheFaser
 */
public class GeoPanel extends javax.swing.JPanel {

    /**
     * Creates new form GeoPanel
     */

    private boolean isCorrect = true;

    public GeoPanel() {
        initComponents();



        corner1.setVisible(false);
        corner2.setVisible(false);

        rast1.setVisible(false);
        rast2.setVisible(false);

        searchButton.addActionListener(e -> {


            ArrayList<Double> firstVector = new ArrayList<>();
            firstVector.add(getNumber(l1Label));
            firstVector.add(getNumber(m1Label1));
            firstVector.add(getNumber(n1Label));

            ArrayList<Double> secondVector = new ArrayList<>();
            secondVector.add(getNumber(l2Label));
            secondVector.add(getNumber(m2Label));
            secondVector.add(getNumber(n2Label));

            ArrayList<Double> M1 = new ArrayList<>();
            M1.add(getNumber(x1Label));
            M1.add(getNumber(y1Label1));
            M1.add(getNumber(z1Label2));

            ArrayList<Double> M2 = new ArrayList<>();
            M2.add(getNumber(x2Label));
            M2.add(getNumber(y2Label));
            M2.add(getNumber(z2Label));

            if(!isCorrect){
                JOptionPane.showMessageDialog(null, "Данные введены некорректно или неполностью. Убедитесь, что уравнения содержат только \"0123456789\", \"/ \", \"sqrt\"", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                isCorrect = true;
                return;
            }

            double absFirstSecond = firstVector.get(0)*secondVector.get(0) + firstVector.get(1)*secondVector.get(1) + firstVector.get(2)*secondVector.get(2);
            double absFirstAbsSecond = getABSVector(firstVector)*getABSVector(secondVector);
            String cornerAnswer = String.valueOf(Math.round(Math.toDegrees(Math.acos(absFirstSecond/absFirstAbsSecond)))) + "°";

            ArrayList<Double> threeVector = getVector(firstVector, secondVector);

            ArrayList<Double> m1m2 = new ArrayList<>();
            m1m2.add(M2.get(0) - M1.get(0));
            m1m2.add(M2.get(1) - M1.get(1));
            m1m2.add(M2.get(2) - M1.get(2));

            double absThreeM1M2 = threeVector.get(0)*m1m2.get(0) + threeVector.get(1)*m1m2.get(1) + threeVector.get(2)*m1m2.get(2);
            double absThree = getABSVector(threeVector);
            String answerRast = String.format("%.2f", Math.abs(absThreeM1M2/absThree));

            if(absThreeM1M2 == 0){
                ArrayList<Double> m1m2first = getVector(m1m2, firstVector);
                double absM1M2First = getABSVector(m1m2first);
                double absFirst = getABSVector(firstVector);
                answerRast = String.format("%.2f", Math.abs(absM1M2First/absFirst));
            }

            if(answerRast.equals("NaN")){
                JOptionPane.showMessageDialog(null, "Направляющий вектор должен быть ненулевым", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                return;
            }

            answerRast = replaceZeros(answerRast);


            rast1.setVisible(true);
            rast2.setText(answerRast);
            rast2.setVisible(true);

            corner1.setVisible(true);
            corner2.setText(cornerAnswer);
            corner2.setVisible(true);
        });

    }

    private String replaceZeros(String string){
        char[] chars = string.split(",")[1].toCharArray();

        String formatString = ",";

        if(String.valueOf(chars[0]).equals("0") && String.valueOf(chars[1]).equals("0")){
            return string.split(",")[0];
        }

        if(String.valueOf(chars[1]).equals("0")){
            return string.split(",")[0] + formatString + String.valueOf(chars[0]);
        }

        return string;


    }

    private Double getABSVector(ArrayList<Double> vector){
        return Math.sqrt(Math.pow(vector.get(0), 2) + Math.pow(vector.get(1), 2) + Math.pow(vector.get(2), 2));
    }

    private Double getNumber(JTextField label){

        try {
            String[] chastnoe = label.getText().replace(" ", "").split("/");

            if(chastnoe.length == 2){
                return Double.parseDouble(returnSqrt(chastnoe[0]))/Double.parseDouble(returnSqrt(chastnoe[1]));
            }

            return Double.parseDouble(returnSqrt(label.getText().replace(" ", "")));

        } catch (Exception exception){
            exception.printStackTrace();
            isCorrect = false;
            return null;
        }
    }

    private String returnSqrt(String string){
        String[] strings = string.split("sqrt");
        if(strings.length == 2) return strings[0] + Math.sqrt(Double.parseDouble(strings[1]));

        return string;
    }

    private ArrayList<Double> getVector(ArrayList<Double> firstArray, ArrayList<Double> secondArray){
        ArrayList<Double> firstVector = new ArrayList<>();

        firstVector.add(firstArray.get(1)*secondArray.get(2) - firstArray.get(2)*secondArray.get(1));
        firstVector.add(firstArray.get(2)*secondArray.get(0) - firstArray.get(0)*secondArray.get(2));
        firstVector.add(firstArray.get(0)*secondArray.get(1) - firstArray.get(1)*secondArray.get(0));

        return firstVector;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        x1Label = new javax.swing.JTextField();
        l1Label = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        y1Label1 = new javax.swing.JTextField();
        m1Label1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        z1Label2 = new javax.swing.JTextField();
        n1Label = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        x2Label = new javax.swing.JTextField();
        l2Label = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        y2Label = new javax.swing.JTextField();
        m2Label = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        z2Label = new javax.swing.JTextField();
        n2Label = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        corner2 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        rast2 = new javax.swing.JLabel();
        rast1 = new javax.swing.JLabel();
        corner1 = new javax.swing.JLabel();

        jPanel4.setBorder(new FlatButtonBorder());

        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Первая прямая");

        jPanel1.setOpaque(false);

        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("x -");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/free-icon-dash-9061433.png"))); // NOI18N

        x1Label.setForeground(new java.awt.Color(204, 255, 255));
        x1Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x1LabelActionPerformed(evt);
            }
        });
        x1Label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                x1LabelKeyPressed(evt);
            }
        });

        l1Label.setForeground(new java.awt.Color(204, 255, 255));
        l1Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                l1LabelMousePressed(evt);
            }
        });
        l1Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l1LabelActionPerformed(evt);
            }
        });
        l1Label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                l1LabelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(x1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(l1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(l1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        jPanel2.setOpaque(false);

        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("y -");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/free-icon-dash-9061433.png"))); // NOI18N

        y1Label1.setForeground(new java.awt.Color(204, 255, 255));
        y1Label1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                y1Label1ActionPerformed(evt);
            }
        });
        y1Label1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                y1Label1KeyPressed(evt);
            }
        });

        m1Label1.setForeground(new java.awt.Color(204, 255, 255));
        m1Label1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m1Label1ActionPerformed(evt);
            }
        });
        m1Label1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                m1Label1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(y1Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(m1Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(y1Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(m1Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("=");

        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setText("=");

        jPanel3.setOpaque(false);

        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setText("z -");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/free-icon-dash-9061433.png"))); // NOI18N

        z1Label2.setForeground(new java.awt.Color(204, 255, 255));
        z1Label2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                z1Label2ActionPerformed(evt);
            }
        });
        z1Label2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                z1Label2KeyPressed(evt);
            }
        });

        n1Label.setForeground(new java.awt.Color(204, 255, 255));
        n1Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n1LabelActionPerformed(evt);
            }
        });
        n1Label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                n1LabelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(z1Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(n1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(z1Label2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(n1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel5.setBorder(new FlatButtonBorder());

        jLabel11.setForeground(new java.awt.Color(255, 204, 204));
        jLabel11.setText("Вторая прямая");

        jPanel6.setOpaque(false);

        jLabel12.setForeground(new java.awt.Color(255, 204, 204));
        jLabel12.setText("x -");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/free-icon-dash-9061433.png"))); // NOI18N

        x2Label.setForeground(new java.awt.Color(255, 204, 204));
        x2Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                x2LabelActionPerformed(evt);
            }
        });
        x2Label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                x2LabelKeyPressed(evt);
            }
        });

        l2Label.setForeground(new java.awt.Color(255, 204, 204));
        l2Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l2LabelActionPerformed(evt);
            }
        });
        l2Label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                l2LabelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(x2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(l2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setOpaque(false);

        jLabel14.setForeground(new java.awt.Color(255, 204, 204));
        jLabel14.setText("y -");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/free-icon-dash-9061433.png"))); // NOI18N

        y2Label.setForeground(new java.awt.Color(255, 204, 204));
        y2Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                y2LabelActionPerformed(evt);
            }
        });
        y2Label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                y2LabelKeyPressed(evt);
            }
        });

        m2Label.setForeground(new java.awt.Color(255, 204, 204));
        m2Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m2LabelActionPerformed(evt);
            }
        });
        m2Label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                m2LabelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(y2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel15)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(m2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(y2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel16.setForeground(new java.awt.Color(255, 204, 204));
        jLabel16.setText("=");

        jLabel17.setForeground(new java.awt.Color(255, 204, 204));
        jLabel17.setText("=");

        jPanel8.setOpaque(false);

        jLabel18.setForeground(new java.awt.Color(255, 204, 204));
        jLabel18.setText("z -");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/free-icon-dash-9061433.png"))); // NOI18N

        z2Label.setForeground(new java.awt.Color(255, 204, 204));
        z2Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                z2LabelActionPerformed(evt);
            }
        });
        z2Label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                z2LabelKeyPressed(evt);
            }
        });

        n2Label.setForeground(new java.awt.Color(255, 204, 204));
        n2Label.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                n2LabelActionPerformed(evt);
            }
        });
        n2Label.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                n2LabelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(n2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(z2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(z2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(n2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(23, 23, 23))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        corner2.setForeground(new java.awt.Color(255, 255, 102));
        corner2.setText("dfdf");

        searchButton.setText("Найти угол и расстояние");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        rast2.setForeground(new java.awt.Color(255, 255, 102));
        rast2.setText("sdsds");

        rast1.setForeground(new java.awt.Color(255, 255, 102));
        rast1.setText("Расстояние ≈");

        corner1.setForeground(new java.awt.Color(255, 255, 51));
        corner1.setText("Угол ≈");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(rast1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rast2))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(corner1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(corner2)
                        .addGap(44, 44, 44)))
                .addContainerGap(73, Short.MAX_VALUE))
            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(corner1)
                    .addComponent(corner2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rast1)
                    .addComponent(rast2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(207, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(208, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(150, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void x2LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x2LabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x2LabelActionPerformed

    private void l2LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l2LabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_l2LabelActionPerformed

    private void y2LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_y2LabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_y2LabelActionPerformed

    private void m2LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m2LabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m2LabelActionPerformed

    private void z2LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_z2LabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_z2LabelActionPerformed

    private void n2LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n2LabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n2LabelActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    private void n1LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_n1LabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_n1LabelActionPerformed

    private void z1Label2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_z1Label2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_z1Label2ActionPerformed

    private void m1Label1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m1Label1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m1Label1ActionPerformed

    private void y1Label1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_y1Label1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_y1Label1ActionPerformed

    private void l1LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l1LabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_l1LabelActionPerformed

    private void x1LabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_x1LabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_x1LabelActionPerformed

    private void x1LabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x1LabelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            l1Label.requestFocusInWindow();
        }
    }//GEN-LAST:event_x1LabelKeyPressed

    private void l1LabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l1LabelMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_l1LabelMousePressed

    private void l1LabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_l1LabelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            y1Label1.requestFocusInWindow();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_l1LabelKeyPressed

    private void y1Label1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_y1Label1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            m1Label1.requestFocusInWindow();
        }
    }//GEN-LAST:event_y1Label1KeyPressed

    private void m1Label1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_m1Label1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            z1Label2.requestFocusInWindow();
        }
    }//GEN-LAST:event_m1Label1KeyPressed

    private void z1Label2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_z1Label2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            n1Label.requestFocusInWindow();
        }
    }//GEN-LAST:event_z1Label2KeyPressed

    private void n1LabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_n1LabelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            x2Label.requestFocusInWindow();
        }
    }//GEN-LAST:event_n1LabelKeyPressed

    private void x2LabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x2LabelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            l2Label.requestFocusInWindow();
        }
    }//GEN-LAST:event_x2LabelKeyPressed

    private void l2LabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_l2LabelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            y2Label.requestFocusInWindow();
        }
    }//GEN-LAST:event_l2LabelKeyPressed

    private void y2LabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_y2LabelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            m2Label.requestFocusInWindow();
        }
    }//GEN-LAST:event_y2LabelKeyPressed

    private void m2LabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_m2LabelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            z2Label.requestFocusInWindow();
        }
    }//GEN-LAST:event_m2LabelKeyPressed

    private void z2LabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_z2LabelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            n2Label.requestFocusInWindow();
        }
    }//GEN-LAST:event_z2LabelKeyPressed

    private void n2LabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_n2LabelKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            searchButton.requestFocusInWindow();
            searchButton.doClick();
        }
    }//GEN-LAST:event_n2LabelKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel corner1;
    private javax.swing.JLabel corner2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField l1Label;
    private javax.swing.JTextField l2Label;
    private javax.swing.JTextField m1Label1;
    private javax.swing.JTextField m2Label;
    private javax.swing.JTextField n1Label;
    private javax.swing.JTextField n2Label;
    private javax.swing.JLabel rast1;
    private javax.swing.JLabel rast2;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField x1Label;
    private javax.swing.JTextField x2Label;
    private javax.swing.JTextField y1Label1;
    private javax.swing.JTextField y2Label;
    private javax.swing.JTextField z1Label2;
    private javax.swing.JTextField z2Label;
    // End of variables declaration//GEN-END:variables
}
