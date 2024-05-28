import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*public class Login_Page implements ActionListener{
    JFrame lpframe;

    JButton slogin,tlogin,alogin ;

    
    public void lpframe() {

        lpframe = new JFrame("Student Learning System" );
        lpframe.setSize(1600, 850);
        lpframe.setLayout(null);

        //bgpic = new JLabel();
        //bgpic.setIcon(new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/main.jfif"));
        // bgpic.setBounds(0,0,2000,1500);
        //lpframe.add(bgpic);

        slogin = new JButton("Student Login");
        slogin.setBounds(520,50,190,150);
        slogin.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        slogin.addActionListener(this::actionPerformed);
        lpframe.add(slogin);

        tlogin = new JButton("Teacher Login");
        tlogin.setBounds(520,250,190,150);
        tlogin.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        tlogin.addActionListener(this::actionPerformed);
        lpframe.add(tlogin);

        alogin = new JButton("Admin Login");
        alogin.setBounds(520,450,190,150);
        alogin.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        alogin.addActionListener(this::actionPerformed);
        lpframe.add(alogin);

        lpframe.setVisible(true);

    }

    public static void main(String args[])
    {
        Login_Page m1 = new Login_Page();
        m1.lpframe();
    }


    public void actionPerformed(ActionEvent e)
    {
        String button = e.getActionCommand();
        if(button.equals("Teacher Login"))
        {
            T_Login tl = new T_Login();
            tl.login2();
        }
        else if(button.equals("Student Login"))
        {
            S_Login obj6 = new S_Login();
            obj6.login1();
        }
        else if(button.equals("Admin Login"))
        {
            A_Login obj = new A_Login();
            obj.login3();
        }
    }

}*/


public class Login_Page extends JFrame implements ActionListener{
    JPanel panel;
    JButton studentLoginButton, teacherLoginButton, adminLoginButton;
    JLabel title;
    public Login_Page(){
        super("Login");
        setSize(360,260);
        setLocation(550,365);
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/systemIcon.png");
        setIconImage(icon.getImage());

        panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("Login Here", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont (22.0f));
        title.setBackground(Color.LIGHT_GRAY);
        title.setForeground(Color.BLACK);
        title.setOpaque(true);

        studentLoginButton = new  JButton("Student Login");
        studentLoginButton.addActionListener((ActionListener) this);
        studentLoginButton.setHorizontalAlignment(JButton.CENTER);
        studentLoginButton.setBounds(115, 15, 120, 40);

        teacherLoginButton = new  JButton("Teacher Login");
        teacherLoginButton.addActionListener((ActionListener) this);
        teacherLoginButton.setHorizontalAlignment(JButton.CENTER);
        teacherLoginButton.setBounds(115, 75, 120, 40);

        adminLoginButton = new  JButton("Admin Login");
        adminLoginButton.addActionListener((ActionListener) this);
        adminLoginButton.setHorizontalAlignment(JButton.CENTER);
        adminLoginButton.setBounds(115, 135, 120, 40);

        // add to panel
        panel.add(studentLoginButton);
        panel.add(teacherLoginButton);
        panel.add(adminLoginButton);

        // Add to Frame
        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == studentLoginButton){
            setVisible(false);
            //new StudentLogin();
            S_Login obj6 = new S_Login();
            obj6.login1();
        }
        else if(ae.getSource() == teacherLoginButton){
            setVisible(false);
            //new TeacherLogin();
            T_Login tl = new T_Login();
            tl.login2();
        }
        else if(ae.getSource() == adminLoginButton){
            setVisible(false);
            //new AdminLogin();
            A_Login obj = new A_Login();
            obj.login3();
        }
    }
    public static void main(String[] args) {
        new Login_Page();
    }
}
