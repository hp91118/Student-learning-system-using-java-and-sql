import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class T_Assignment extends JFrame implements ActionListener {
    JPanel panel;
    JButton C_Assignment, Cpp_Assignment, Java_Assignment,P_Assignment;
    JLabel title;
    public T_Assignment(){
        super("Teacher Assignment");
        setSize(450,350);
        setLocation(550,365);
        setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("C:/Users/Kulkarni/IdeaProjects/JavaProject3/src/systemIcon.png");
        setIconImage(icon.getImage());

        panel = new JPanel();
        panel.setLayout(null);

        title = new JLabel("Add Assignment", JLabel.CENTER);
        title.setFont(title.getFont().deriveFont (22.0f));
        title.setBackground(Color.LIGHT_GRAY);
        title.setForeground(Color.BLACK);
        title.setOpaque(true);

        C_Assignment = new  JButton("C Assignment");
        C_Assignment.addActionListener((ActionListener) this);
        C_Assignment.setHorizontalAlignment(JButton.CENTER);
        C_Assignment.setBounds(125, 15, 150, 40);

        Cpp_Assignment = new  JButton("Cpp Assignment");
        Cpp_Assignment.addActionListener((ActionListener) this);
        Cpp_Assignment.setHorizontalAlignment(JButton.CENTER);
        Cpp_Assignment.setBounds(125, 75, 150, 40);

        P_Assignment = new  JButton("Python Assignment");
        P_Assignment.addActionListener((ActionListener) this);
        P_Assignment.setHorizontalAlignment(JButton.CENTER);
        P_Assignment.setBounds(125, 135, 150, 40);


        Java_Assignment = new  JButton("Java Assignment");
        Java_Assignment.addActionListener((ActionListener) this);
        Java_Assignment.setHorizontalAlignment(JButton.CENTER);
        Java_Assignment.setBounds(125, 195, 150, 40);


        // add to panel
        panel.add(C_Assignment);
        panel.add(Cpp_Assignment);
        panel.add(Java_Assignment);
        panel.add(P_Assignment);

        // Add to Frame
        add(title, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == C_Assignment){
            setVisible(false);
            C_Assignment c=new C_Assignment();
            c.framec();
        }
        else if(ae.getSource() == Cpp_Assignment){
            setVisible(false);
            Cpp_Assignment cpp=new Cpp_Assignment();
            cpp.framecpp();
        }
        else if(ae.getSource() == P_Assignment){
            setVisible(false);
            Python_Assignment obj = new Python_Assignment();
            obj.framep();
        }
        else if(ae.getSource() == Java_Assignment){
            setVisible(false);
           Assignment obj = new Assignment();
           obj.frame3();
                   }
    }
    public static void main(String[] args) {
        new T_Assignment();
    }
}

