import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*public class Regi_Page implements ActionListener{
    JFrame rpframe;

    JButton sregi,tregi,aregi ;


    public void rpframe() {

        rpframe = new JFrame("Student Learning System" );
        rpframe.setSize(1600, 850);
        rpframe.setLayout(null);

        //bgpic = new JLabel();
        //bgpic.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/main.jfif"));
        // bgpic.setBounds(0,0,2000,1500);
        //rpframe.add(bgpic);

        sregi = new JButton("Student Registration");
        sregi.setBounds(520,50,390,150);
        sregi.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        sregi.addActionListener(this::actionPerformed);
        rpframe.add(sregi);

        tregi = new JButton("Teacher Registration");
        tregi.setBounds(520,250,390,150);
        tregi.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        tregi.addActionListener(this::actionPerformed);
        rpframe.add(tregi);

        aregi = new JButton("Admin Registration");
        aregi.setBounds(520,450,390,150);
        aregi.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        aregi.addActionListener(this::actionPerformed);
        rpframe.add(aregi);


        rpframe.setVisible(true);

    }

    public static void main(String args[])
    {
        Regi_Page m2 = new Regi_Page();
        m2.rpframe();
    }


    public void actionPerformed(ActionEvent e)
    {
        String button = e.getActionCommand();
        if(button.equals("Teacher Registration"))
        {
            T_Registration tr = new T_Registration();
            tr.Register2();
        }
        else if(button.equals("Student Registration"))
        {
            S_Registration sr = new S_Registration();
            sr.Register1();
        }
        else if(button.equals("Admin Registration"))
        {
            A_Registration ar = new A_Registration();
            ar.Register4();
        }
    }

}*/

public class Regi_Page extends JFrame implements ActionListener{
    JPanel panel;
    JButton studentSignUpButton, teacherSignUpButton;
    JLabel title;
    public Regi_Page(){
        super("Signup");
        setSize(360,220);
        setLocation(550,365);
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/systemIcon.png");
        setIconImage(icon.getImage());

        panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("SignUp Here", JLabel.CENTER);
        title.setBackground(Color.LIGHT_GRAY);
        title.setForeground(Color.BLACK);
        title.setOpaque(true);
        title.setFont(title.getFont ().deriveFont (22.0f));


        studentSignUpButton = new  JButton("Student SignUp");
        studentSignUpButton.addActionListener((ActionListener) this);
        studentSignUpButton.setHorizontalAlignment(JButton.CENTER);
        studentSignUpButton.setBounds(115, 15, 130, 40);

        teacherSignUpButton = new  JButton("Teacher SignUp");
        teacherSignUpButton.addActionListener((ActionListener) this);
        teacherSignUpButton.setHorizontalAlignment(JButton.CENTER);
        teacherSignUpButton.setBounds(115, 95, 130, 40);



        // add to panel
        panel.add(studentSignUpButton);
        panel.add(teacherSignUpButton);

        // Add to Frame
        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        // Settings for the frame
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == studentSignUpButton){
            setVisible(false);
            //new StudentSignup();
            S_Registration sr = new S_Registration();
            sr.Register1();
        }
        else if(ae.getSource() == teacherSignUpButton){
            setVisible(false);
            //new TeacherSignup();
            T_Registration tr = new T_Registration();
            tr.Register2();

        }
    }
    public static void main(String[] args) {
        new Regi_Page();
    }
}


