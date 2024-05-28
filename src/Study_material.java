import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;





public class Study_material extends JFrame implements ActionListener{
    JLabel title, subjectCbLbl, quizCbLbl, courseDescriptionLbl;
   // JTextArea courseDescription;
    JComboBox subjectsCb, quizCb;
    JButton quizBtn;
    JPanel middlePanel;
    JScrollPane scroll;
    public Study_material(){
        super("Study Material");
        setLayout(new BorderLayout());

        title = new JLabel("Study Material", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont (22.0f));
        title.setBackground(Color.LIGHT_GRAY);
        title.setForeground(Color.BLACK);
        title.setOpaque(true);
        add(title, BorderLayout.NORTH);

        middlePanel = new JPanel();
        middlePanel.setLayout(null);
        add(middlePanel, BorderLayout.CENTER);

        subjectCbLbl = new JLabel("Select Subject");
        subjectCbLbl.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        subjectCbLbl.setBounds(80, 30, 120, 28);
        subjectCbLbl.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(subjectCbLbl);

        subjectsCb = new JComboBox(this.getSubjects());
        subjectsCb.setSelectedIndex(-1);
        subjectsCb.setBounds(200, 30, 140, 28);
        subjectsCb.addActionListener(this);
        middlePanel.add(subjectsCb);

        quizCbLbl = new JLabel("Select Course");
        quizCbLbl.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        quizCbLbl.setBounds(80, 80, 120, 28);
        quizCbLbl.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(quizCbLbl);


        quizCb = new JComboBox(this.getquiz());
        quizCb.setSelectedIndex(-1);
        quizCb.setBounds(200, 80, 140, 28);
        quizCb.addActionListener(this);
        middlePanel.add(quizCb);


/*        courseDescriptionLbl = new JLabel("Course Description");
        courseDescriptionLbl.setFont(new Font(Font.SERIF,Font.BOLD, 16));
        courseDescriptionLbl.setBounds(80, 130, 140, 28);
        courseDescriptionLbl.setHorizontalAlignment(JLabel.CENTER);
        middlePanel.add(courseDescriptionLbl);

        courseDescription = new JTextArea();
        courseDescription.setLineWrap(true);
        courseDescription.setWrapStyleWord(true);
        scroll = new JScrollPane(courseDescription);
        scroll.setBounds(150, 160, 230, 100);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        courseDescription.setEditable(false);
        middlePanel.add(scroll);*/


        quizBtn = new JButton("View Course Material");
        quizBtn.setFont(new Font(Font.SERIF,Font.BOLD, 15));
        quizBtn.setHorizontalAlignment(JButton.CENTER);
        quizBtn.addActionListener(this);
        add(quizBtn, BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(500,400);
        setLocation(420,320);
        setVisible(true);
    }
    private String[] getSubjects(){
        String[] subjectsData = null;
        try{
            //DBConnection c1 = new DBConnection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
            Statement sta = connection.createStatement();


            String q = "select * from Subjects";

            ResultSet rs = sta.executeQuery(q);
            int rowCount = 0;
            while(rs.next())
                rowCount++;
            subjectsData = new String[rowCount];
            rs.beforeFirst();
            int i=0;
            while(rs.next()){
                subjectsData[i] = rs.getString("Name");
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return subjectsData;
    }

    private String[] getquiz(){
        String[] quizData = null;
        try{
            //DBConnection c1 = new DBConnection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
            Statement sta = connection.createStatement();


            String q = "select * from Quiz";

            ResultSet rs = sta.executeQuery(q);
            int rowCount = 0;
            while(rs.next())
                rowCount++;
            quizData = new String[rowCount];
            rs.beforeFirst();
            int i=0;
            while(rs.next()){
                quizData[i] = rs.getString("Name");
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return quizData;
    }

    private void getSetCourses(int subjectID){
        String[] coursesData;
        try{
            //DBConnection c1 = new DBConnection();
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
            Statement sta = connection.createStatement();

            String q = "select * from Courses Where Subject_ID = '"+ subjectID +"'";

            ResultSet rs = sta.executeQuery(q);
            int rowCount = 0;
            while(rs.next())
                rowCount++;
            coursesData = new String[rowCount];
            rs.beforeFirst();
            int i=0;
            while(rs.next()){
                coursesData[i] = rs.getString("Name");
                i++;
            }
            for(int j=0; j< coursesData.length ; j++)
                quizCb.addItem(coursesData[j]);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == subjectsCb){
            //  quizCb.removeAllItems();
            //courseDescription.setText(null);
            Object selected = subjectsCb.getSelectedItem();
            String subjectName = selected.toString();
            try{
                // DBConnection c1 = new DBConnection();
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                Statement sta = connection.createStatement();

                String q1  = "Select Subject_ID From Subjects Where Name = '"+ subjectName +"'";
                ResultSet rs = sta.executeQuery(q1);
                int subjectID;
                rs.next();
                subjectID = rs.getInt("Subject_ID");
                //this.getSetCourses(subjectID);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == quizCb){
            Object selectedMain = quizCb.getSelectedItem();
            if(selectedMain == null){
                System.out.println("Null Value");
            }
            else{
                Object selected = quizCb.getSelectedItem();
                String quizName = selected.toString();
                try{
                    //DBConnection c1 = new DBConnection();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                    Statement sta = connection.createStatement();

                    String q1  = "Select quiz_ID From Quiz Where Name = '"+ quizName +"'";
                    ResultSet rs = sta.executeQuery(q1);

                    //   String quiz;
                    //  rs.next();
                    //    quiz = rs.getString("Name");
                    //                courseDescriptionLbl.setVisible(true);
                    //                scroll.setVisible(true);
                    // courseDescription.setText(course_Description);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        else if(ae.getSource() == quizBtn){

            String quiz = quizCb.getSelectedItem().toString();
            if(quiz.equals("C Programming"))
            {
                C_Course c1 = new C_Course();
                c1.cframe();


            }
            else if(quiz.equals("Cpp Programming"))
            {
                Cpp_Course c2 = new Cpp_Course();
                c2.cpframe();

            }
            else if(quiz.equals("Python Programming"))
            {
                Python_Course p = new Python_Course();
                p.pframe();

            }
            else if(quiz.equals("Java Programming"))
            {
                Java_Course j = new Java_Course();
                j.jframe();

            }
            // Main2 obj = new Main2();
            // obj.mframe();
            //    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
           /* try{
                //DBConnection c1 = new DBConnection();
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?characterEncoding=latin1", "root", "shravani");
                Statement sta = connection.createStatement();

                String q1  = "Select course_ID From Courses Where Name = '"+ courseNameStr +"'";
                ResultSet rs = sta.executeQuery(q1);
                int course_ID;
                rs.next();
                course_ID = rs.getInt("course_ID");

                String q = "INSERT INTO Enrollments ( course_ID, stdID) "
                        + "Values ('" + course_ID +"', '" + S_Login.currentStudentID +"')";

                int x = sta.executeUpdate(q);
                if(x == 0){
                    JOptionPane.showMessageDialog(null, "Some Error Occured");
                }else{
                    JOptionPane.showMessageDialog(null, "Course Enrollement Successfull!");
                    dispose();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "You are Already Enrolled in this Course!");
                e.printStackTrace();
            }*/
        }
    }
    public static void main(String[] args) {
        new Study_material();
    }

}

