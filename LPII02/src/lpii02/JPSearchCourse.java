/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lpii02;

import LPII02.Business.Services.CourseBusiness;
import LPII02.Business.Services.LessonBusiness;
import LPII02.Business.Services.MatterBusiness;
import LPII02.Business.Services.TeacherBusiness;
import LPII02.Domain.Entities.Course;
import LPII02.Domain.Entities.Lesson;
import LPII02.Domain.Entities.Matter;
import LPII02.Domain.Entities.Teacher;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo
 */
public class JPSearchCourse extends javax.swing.JPanel {

    private boolean _loadPassed = false;
    private CourseBusiness _coBusiness = new CourseBusiness();
    private Course _course;
    private int _page = 1;
    private int _qtdPerPage = 5;

    /**
     * Creates new form JPSearchCourse
     */
    public JPSearchCourse() {
        initComponents();

        this.grCourses.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                valueRowChanged(e);
            }
        });
    }

    private void valueRowChanged(ListSelectionEvent e) {
        if (this.grCourses.getSelectedRows() == null
                || this.grCourses.getSelectedRows().length == 0) {
            return;
        }

        int selectedRow = this.grCourses.getSelectedRows()[0];
        int courseId = Integer.parseInt(this.grCourses.getValueAt(selectedRow, 0).toString());

        try {
            this._course = this._coBusiness.get(courseId);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocorreu um erro ao carregar as informações do curso selecionado, tente novamente.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadTable() throws Exception {
        List<Course> courses = this._coBusiness.get(
                ((Matter) this.cbMatters.getModel().getSelectedItem()).getId(),
                ((Teacher) this.cbTeacher.getModel().getSelectedItem()).getId(),
                this.txtName.getText());

        if (courses.size() > this._qtdPerPage) {
            boolean addOneLength = false;

            if ((this._page - 1) * this._qtdPerPage == this._qtdPerPage) {
                addOneLength = true;
            }

            courses = courses.subList(
                    (this._page - 1) * this._qtdPerPage,
                    (addOneLength ? this._qtdPerPage + 1 : this._qtdPerPage));
        }

        if (courses != null) {
            DefaultTableModel dtm = (DefaultTableModel) this.grCourses.getModel();
            LessonBusiness lBusiness = new LessonBusiness();

            while (dtm.getRowCount() > 0) {
                dtm.removeRow(0);
            }

            for (Course c : courses) {
                dtm.addRow(new Object[]{
                    c.getId(),
                    c.getName(),
                    this._coBusiness.formatDuration(c.getDuration()),
                    (c.getLessons() == null ? 0 : c.getLessons().size())
                });
            }
        }
    }

    private void loadMatters() throws InstantiationException, IllegalAccessException {
        MatterBusiness mBusiness = new MatterBusiness();
        ArrayList<Matter> matters = new ArrayList<Matter>();

        Matter mDefault = mBusiness.getInstance();

        mDefault.setId(0);
        mDefault.setCode(0);
        mDefault.setName("Selecione");

        matters.add(mDefault);
        matters.addAll(mBusiness.get());

        //load combo...
        DefaultComboBoxModel<Matter> cbModel = new DefaultComboBoxModel<Matter>(matters.toArray(new Matter[]{}));
        this.cbMatters.setModel(cbModel);

        //select default (Selecione)...
        cbModel.setSelectedItem(mDefault);
    }

    private void loadTeachers() throws InstantiationException, IllegalAccessException {
        TeacherBusiness tBusiness = new TeacherBusiness();
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();

        Teacher tDefault = tBusiness.getInstance();

        tDefault.setId(0);
        tDefault.setName("Selecione");

        teachers.add(tDefault);
        teachers.addAll(tBusiness.get());

        DefaultComboBoxModel<Teacher> cbModel = new DefaultComboBoxModel<Teacher>(teachers.toArray(new Teacher[]{}));

        this.cbTeacher.setModel(cbModel);

        //select default (Selecione)...
        cbModel.setSelectedItem(tDefault);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbMatters = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grCourses = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        cbTeacher = new javax.swing.JComboBox<>();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();

        addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                formHierarchyChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Matéria:");

        cbMatters.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");

        txtName.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnSearch.setText("Pesquisar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnView.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnView.setText("Assistir");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        grCourses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Duração", "Qtd. Aulas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(grCourses);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel3.setText("Professor:");

        cbTeacher.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        btnLast.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnLast.setText(">>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnBack.setText("<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnFirst.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnFirst.setText("<<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addGap(26, 26, 26)
                                .addComponent(btnView))
                            .addComponent(cbMatters, 0, 247, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 8, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnLast)
                                    .addComponent(btnNext)
                                    .addComponent(btnBack)
                                    .addComponent(btnFirst)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbMatters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSearch)
                            .addComponent(btnView))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formHierarchyChanged
        if (this._loadPassed) {
            return;
        }

        try {
            this.loadMatters();
            this.loadTeachers();
            this.loadTable();

            this._loadPassed = true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocorreu um erro ao carregar o formulário, tente novamente.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);

            this.setVisible(false);
            try {
                this.finalize();
            } catch (Throwable ex1) {
                Logger.getLogger(JPSearchCourse.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }//GEN-LAST:event_formHierarchyChanged

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            this._page = 1;
            this.loadTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        try {
            List<Course> courses = this._coBusiness.get(
                    ((Matter) this.cbMatters.getModel().getSelectedItem()).getId(),
                    ((Teacher) this.cbTeacher.getModel().getSelectedItem()).getId(),
                    this.txtName.getText());

            this._page = (int) Math.round(courses.size() / Double.parseDouble(this._qtdPerPage + ""));

            this.loadTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        try {
            List<Course> courses = this._coBusiness.get(
                    ((Matter) this.cbMatters.getModel().getSelectedItem()).getId(),
                    ((Teacher) this.cbTeacher.getModel().getSelectedItem()).getId(),
                    this.txtName.getText());

            int maxPage = (int) Math.round(courses.size() / Double.parseDouble(this._qtdPerPage + ""));

            if (this._page >= maxPage) {
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }

        this._page++;

        try {
            this.loadTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        if (this._page == 1) {
            return;
        }

        this._page--;

        try {
            this.loadTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        if (this._page == 1) {
            return;
        }

        this._page = 1;

        try {
            this.loadTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        if (this._course == null) {
            JOptionPane.showMessageDialog(this,
                    "Curso não foi selecionado",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE);

            return;
        }

        try {

            LessonBusiness lBusiness = new LessonBusiness();
            List<Lesson> lessons = lBusiness.getByCourse(this._course);

            if (lessons == null
                    || lessons.size() == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "O curso selecionado não tem aulas cadastradas ainda.",
                        "Atenção",
                        JOptionPane.WARNING_MESSAGE);

                return;
            }

            JFrame frame = new JFrame();
            JPDoCourse pDoCourse = new JPDoCourse(lessons);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            frame.setLayout(new BorderLayout());
            frame.add(pDoCourse, BorderLayout.CENTER);
            frame.pack();

            frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
            frame.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnViewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox<Matter> cbMatters;
    private javax.swing.JComboBox<Teacher> cbTeacher;
    private javax.swing.JTable grCourses;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
