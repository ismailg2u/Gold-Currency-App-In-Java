import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class altin extends JFrame{
    private JPanel mainpanel;
    private JTextField gram;
    private JLabel satiss1;
    private JButton convertbutton;
    private JLabel satiss2;
    private JButton button1;
    private JLabel alis2;
    private JLabel asilalis ;
    private JLabel asilsatis;





    //data acquisition from the internet
    Document doc = Jsoup.connect("https://uzmanpara.milliyet.com.tr/gram-altin-fiyati/").timeout(6000).get();
    Elements alis_fiyati = doc.getElementsByClass("realTimeBoxL");
    //data acquisition from the internet
    //---------------------//
    //convert data to double
    //convert buying_data to double
    String alis_fiyativ1= alis_fiyati.text();
    String alis_fiyativ2 = alis_fiyativ1.substring(9);
    String alis_fiyativ3 = alis_fiyativ2;
    String alis_fiyativ4  = alis_fiyativ3.substring(0,3)+'.'+alis_fiyativ3 .substring(4);
    double alisfiyati=Double.parseDouble(String.valueOf(alis_fiyativ4));
    //convert selling_data to double
    Elements satis_fiyati = doc.getElementsByClass("realTimeBoxR");
    String satis_fiyativ1= satis_fiyati.text();
    String satis_fiyativ2 = satis_fiyativ1.substring(10);
    String satis_fiyativ3 = satis_fiyativ2;
    String satis_fiyativ4  = satis_fiyativ3 .substring(0,3)+'.'+satis_fiyativ3 .substring(4);
    double satisfiyati=Double.parseDouble(String.valueOf(satis_fiyativ4));
    //convert data to double
    //---------------------//

    public altin(String title) throws IOException {
        super(title);
        //write data to JLabel
        asilalis.setText(String.valueOf(alisfiyati));
        asilsatis.setText(String.valueOf((satisfiyati)));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainpanel);
        this.pack();
        convertbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double satis3= ((Double.parseDouble(gram.getText()))
                        * satisfiyati);
                satiss2.setText( " Satis fiyatı:" + satis3 + "tl");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double alis3= ((Double.parseDouble(gram.getText()))
                        * alisfiyati);
                alis2.setText( " Alış Fiyaatı:" + alis3 + "tl");

            }
        });
        setSize(600,600);


    }
    public static void main(String[] args) throws IOException {

        JFrame frame = new altin("altin");
        frame.setVisible(true );




    }
}
