import java.awt.*;
import javax.swing.*;
import java.awt.event.*;




public class Main2 extends JFrame implements ActionListener{
    JPanel headerPanel, mainPanel, footerPanel;
    JButton LoginButton, SignupButton;
    JLabel title, footerLbl, mainScreenLbl;
    JMenuBar menuBar;
    JMenu file, about;
    JMenuItem aboutProject,aboutDevelopers, exit;
    public static Main2 main;
    public Main2(){
        super("E-Learning System");
        setSize(1280,720);
        setLocation(35,30);
        setLayout(new BorderLayout());
        this.main = this;

        ImageIcon icon = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/systemIcon.png");
        setIconImage(icon.getImage());

        headerPanel = new JPanel(new BorderLayout());
        add(headerPanel, BorderLayout.NORTH);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        add(mainPanel, BorderLayout.CENTER);

        footerPanel = new JPanel(new BorderLayout());
        add(footerPanel, BorderLayout.SOUTH);


        //Header Code
        aboutProject = new JMenuItem("About Project");
       // aboutDevelopers = new JMenuItem("About Developers");
        menuBar = new JMenuBar();
        about = new JMenu("About");
        exit = new JMenuItem("Exit");
        // Adding Shortcut key to close the window
        KeyStroke ctrlE = KeyStroke.getKeyStroke(KeyEvent.VK_E, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
        exit.setAccelerator(ctrlE);
        file = new JMenu("File");
        file.add(exit);
        about.add(aboutProject);
       // about.add(aboutDevelopers);
        exit.addActionListener(this);
       // aboutDevelopers.addActionListener(this);
        aboutProject.addActionListener(this);
        menuBar.add(file);
        menuBar.add(about);


        headerPanel.add(menuBar,BorderLayout.NORTH);
        ImageIcon i1 = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/MainTitle.png");
        Image i2 = i1.getImage().getScaledInstance(1280 ,96 ,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        title = new JLabel(i3);
        headerPanel.add(title, BorderLayout.CENTER);



        //Main Center Code
        ImageIcon loginImg1 = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/login.png");
        Image loginImg2 = loginImg1.getImage().getScaledInstance(96  ,96 ,Image.SCALE_DEFAULT);
        ImageIcon loginImg3 =  new ImageIcon(loginImg2);
        LoginButton = new  JButton("Login", loginImg3);
        LoginButton.setHorizontalAlignment(JButton.CENTER);
        LoginButton.setBounds(420,15,190,150);
        LoginButton.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        LoginButton.setBackground(new Color(21,76,121));
        LoginButton.setForeground(Color.WHITE);
        LoginButton.setHorizontalTextPosition(JButton.CENTER);
        LoginButton.setVerticalTextPosition(JButton.BOTTOM);
        LoginButton.addActionListener((ActionListener) this);


        ImageIcon signUpImg1 = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/signup.png");
        Image signUpImg2 = signUpImg1.getImage().getScaledInstance(96  ,96 ,Image.SCALE_DEFAULT);
        ImageIcon signUpImg3 =  new ImageIcon(signUpImg2);
        SignupButton = new  JButton("SignUp", signUpImg3);
        SignupButton.setHorizontalAlignment(JButton.CENTER);
        SignupButton.setBounds(715,15,210,150);
        SignupButton.setFont(new Font(Font.SERIF, Font.BOLD, 25));
        SignupButton.setBackground(new Color(21,76,121));
        SignupButton.setForeground(Color.WHITE);
        SignupButton.setHorizontalTextPosition(JButton.CENTER);
        SignupButton.setVerticalTextPosition(JButton.BOTTOM);
        SignupButton.addActionListener((ActionListener) this);

        ImageIcon mainPic1 = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/ElearningMain.png");
        Image mainPic2 = mainPic1.getImage().getScaledInstance(500 ,500 ,Image.SCALE_DEFAULT);
        ImageIcon mainPic3 =  new ImageIcon(mainPic2);
        mainScreenLbl = new JLabel(mainPic3);
        mainScreenLbl.setBounds(422,50,500,500);


        // add to mainPanel
        mainPanel.add(LoginButton);
        mainPanel.add(SignupButton);
        mainPanel.add(mainScreenLbl);

        // Footer Panel Code
        ImageIcon i4 = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/footer.png");
        Image i5 = i4.getImage().getScaledInstance(1280 ,60 ,Image.SCALE_DEFAULT);
        ImageIcon i6 =  new ImageIcon(i5);
        footerLbl = new JLabel(i6);
        footerPanel.add(footerLbl, BorderLayout.SOUTH);


        // Settings for the frame
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == LoginButton){

            Login_Page l = new Login_Page();

        }
        else if(ae.getSource() == SignupButton){

            Regi_Page r = new Regi_Page();

        }

        else if(ae.getSource() == exit){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Main2();
    }
}
