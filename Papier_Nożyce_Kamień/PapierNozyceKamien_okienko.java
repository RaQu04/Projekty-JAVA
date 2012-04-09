import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Random;
import java.io.*;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class PapierNozyceKamien_okienko extends JFrame
{ Button przy1,przy2,przy3,przy4;
static int x,komp,czlowiek,wynik_komp=0,wynik_czlowiek=0,licznik = 0,ponownie;
  JTextField textField1 = new JTextField(2);
  JTextField textField2 = new JTextField(2);
 
  public PapierNozyceKamien_okienko() {
    super("Gra Papier Nożyce Kamień");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	setSize(550, 250);
	final Container c=getContentPane();
	c.setLayout(new BorderLayout(1,1));
	
	final ImageIcon papier = new ImageIcon("obrazki/papier.png"); 
	final ImageIcon nozyce = new ImageIcon("obrazki/nozyce.png");
    final ImageIcon kamien = new ImageIcon("obrazki/kamien.png");
	final ImageIcon user = new ImageIcon("obrazki/User.png");
	final ImageIcon comp = new ImageIcon("obrazki/computer.png");
	
	String wielkosc = JOptionPane.showInputDialog(null,"Do ilu wygranych chcesz grać?");
	x = Integer.parseInt(wielkosc);
	final JLabel arg1 = new JLabel("                                                                                          Grasz do "+x+" wygranych");
	c.add(arg1, BorderLayout.NORTH);
	final JLabel arg2 = new JLabel(user);
	c.add(arg2,BorderLayout.WEST);
	final JLabel arg3 = new JLabel(comp);
	c.add(arg3, BorderLayout.EAST);
	final String napis = "<html>&nbsp;&nbsp;||=====================||<br>";
	final String napis1 = "&nbsp;&nbsp;||:Aktualny Status Wygranych:&nbsp;|| <br>&nbsp;&nbsp;||&nbsp;&nbsp;Gracz:";
	final String napis2 = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Komputer:";
	final String napis3 = "&nbsp;&nbsp;||<br>&nbsp;&nbsp;||=====================||";
	final JLabel arg4 = new JLabel(napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);
    c.add(arg4, BorderLayout.CENTER);
    setVisible(true);
    JButton przy1 = new JButton("| GRAJ |");
    c.add(przy1, BorderLayout.SOUTH);
	
		ActionListener losujActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent actionEvent) {
        AbstractButton przy1 = (AbstractButton) actionEvent.getSource();
		Object[] options = {" PAPIER "," NOŻYCE "," KAMIEŃ "};
		int komputer;
		int pytanie = JOptionPane.showOptionDialog(null,"Wybierz z dostępnych opcji:",
		"Wybór",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		Random losuj = new Random();
	    komputer = losuj.nextInt(3)+1;
		if(pytanie==0&&komputer==3){
			System.out.println("Komputer wybrał Kamień. Wygrałeś!!");
			wynik_czlowiek++;
			arg2.setIcon(papier);
			arg3.setIcon(kamien);
			arg4.setText(napis+napis1+wynik_czlowiek+napis2+wynik_komp+napis3);
			}
		}};
        przy1.addActionListener(losujActionListener);   
}
  public static void main(String argv[]) throws IOException{
    new PapierNozyceKamien_okienko();
  }
}
