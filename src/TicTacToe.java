import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/* The Java ActionListener is notified whenever you click on the button or menu item.
* The Java ActionListener is an Interface.*/
public class TicTacToe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel=new JPanel();
    /*The JPanel is a simplest container class.
    It provides space in which an application can attach any other component.*/
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons=new JButton[9];
    boolean player1_turn;// If player1_turn is false then is player2 turn
    //The constructor
    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        ImageIcon image = new ImageIcon("src/Untitled design (11).png");
        frame.setIconImage(image.getImage());


        textfield.setBackground(new Color(0,255,255));
        textfield.setForeground(new Color(255,0,0));
        textfield.setFont(new Font("Tahoma",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TIC-TAC-TOE");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);// Tracar os limites . Bounds = limites

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(224,255,255));

        //This loop is to take care of the array of buttons
        for (int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Tahoma",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override // we write the action that we want in the actioPerformed method.
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<9;i++){
            if (e.getSource()==buttons[i]){
                if (player1_turn){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O Turn");
                        textfield.setForeground(new Color(0,0,255));
                        check();

                    }
                }
                else {
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X Turn");
                        textfield.setForeground(new Color(255,0,0));
                        check();
                    }
                }
            }
        }
    }
    //WHo will start first
    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Pick a random number between 0 and 1
        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X Turn");
        }
        else {
            player1_turn=false;
            textfield.setText("O Turn");
        }
    }
    //To see is there is any winning conditions
    public void check(){

        //check the rows
        if ((buttons[0].getText()=="X")&&
                (buttons[1].getText()=="X")&&
                (buttons[2].getText()=="X")){
            xWins(0,1,2);
        }
        if ((buttons[3].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[5].getText()=="X")){
            xWins(3,4,5);
        }
        if ((buttons[6].getText()=="X")&&
                (buttons[7].getText()=="X")&&
                (buttons[8].getText()=="X")){
            xWins(6,7,8);
        }
        //checks the columns
        if ((buttons[0].getText()=="X")&&
                (buttons[3].getText()=="X")&&
                (buttons[6].getText()=="X")){
            xWins(0,3,6);
        }
        if ((buttons[1].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[7].getText()=="X")){
            xWins(1,4,7);
        }
        if ((buttons[2].getText()=="X")&&
                (buttons[5].getText()=="X")&&
                (buttons[8].getText()=="X")){
            xWins(2,5,8);
        }
        //checks the diagonals
        if ((buttons[0].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[8].getText()=="X")){
            xWins(0,4,8);
        }if ((buttons[2].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[6].getText()=="X")){
            xWins(2,4,6);
        }
        // checks the rows
        if ((buttons[0].getText()=="O")&&
                (buttons[1].getText()=="O")&&
                (buttons[2].getText()=="O")){
            oWins(0,1,2);
        }//conditions for player O win:
        if ((buttons[3].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[5].getText()=="O")){
            oWins(3,4,5);
        }
        if ((buttons[6].getText()=="O")&&
                (buttons[7].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(6,7,8);
        }//checks the columns
        if ((buttons[0].getText()=="O")&&
                (buttons[3].getText()=="O")&&
                (buttons[6].getText()=="O")){
            oWins(0,3,6);
        }
        if ((buttons[1].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[7].getText()=="O")){
            oWins(1,4,7);
        }
        if ((buttons[2].getText()=="O")&&
                (buttons[5].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(2,5,8);
        }// checks the diagonals
        if ((buttons[0].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[8].getText()=="O")){
            oWins(0,4,8);
        }if ((buttons[2].getText()=="O")&&
                (buttons[4].getText()=="O")&&
                (buttons[6].getText()=="O")){
            oWins(2,4,6);
        }
    }
    public void xWins(int a , int b, int c) {
        buttons[a].setBackground(new Color(0, 255, 0));
        buttons[b].setBackground(new Color(0, 255, 0));
        buttons[c].setBackground(new Color(0, 255, 0));
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        JOptionPane.showMessageDialog(frame, "PLAYER X WINS", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
        textfield.setText("Player X win!!!");
    }
    public void oWins(int a , int b, int c){
        buttons[a].setBackground(new Color(0,255,0));
        buttons[b].setBackground(new Color(0,255,0));
        buttons[c].setBackground(new Color(0,255,0));
        for (int i =0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        JOptionPane.showMessageDialog(frame, "PLAYER O WINS","Tic Tac Toe",JOptionPane.INFORMATION_MESSAGE);
        textfield.setText("Player O win!!!");
    }


}
