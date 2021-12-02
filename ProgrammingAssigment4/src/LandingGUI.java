/**
 * @author Cody Liske
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LandingGUI extends JFrame implements ActionListener {
    
    FlashCardGUI flashCards;
    private JButton englishSpanish;
    private JButton englishItalian;
    private JButton englishGerman;
    private JButton spanishItalian;
    private JButton spanishGerman;
    private JButton italianGerman;
    
    public LandingGUI()
    {
        GridBagConstraints layoutConst = new GridBagConstraints();
        
        super.setTitle("Language Learning Game");
        super.setLayout(new GridBagLayout());
        super.setSize(600, 450);
        
        englishSpanish = new JButton("English and Spanish");
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        englishSpanish.setActionCommand("ENG_SPA");
        englishSpanish.addActionListener(this);
        super.add(englishSpanish, layoutConst);
        
        englishItalian = new JButton("English and Italian");
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        englishItalian.setActionCommand("ENG_ITA");
        englishItalian.addActionListener(this);
        super.add(englishItalian, layoutConst);
        
        englishGerman = new JButton("English and German");
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        englishGerman.setActionCommand("ENG_GER");
        englishGerman.addActionListener(this);
        super.add(englishGerman, layoutConst);
        
        spanishItalian = new JButton("Spanish and Italian");
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        spanishItalian.setActionCommand("SPA_ITA");
        spanishItalian.addActionListener(this);
        super.add(spanishItalian, layoutConst);
        
        spanishGerman = new JButton("Spanish and German");
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        spanishGerman.setActionCommand("SPA_GER");
        spanishGerman.addActionListener(this);
        super.add(spanishGerman, layoutConst);
        
        italianGerman = new JButton("Italian and German");
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        italianGerman.setActionCommand("ITA_GER");
        italianGerman.addActionListener(this);
        super.add(italianGerman, layoutConst);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command)
        {
            case "ENG_SPA":
                LandingGUI.this.setVisible(false);
                flashCards = new FlashCardGUI(Languages.ENGLISH, Languages.SPANISH);
                break;
            case "ENG_ITA":
                LandingGUI.this.setVisible(false);
                flashCards = new FlashCardGUI(Languages.ENGLISH, Languages.ITALIAN);
                break;
            case "ENG_GER":
                LandingGUI.this.setVisible(false);
                flashCards = new FlashCardGUI(Languages.ENGLISH, Languages.GERMAN);
                break;
            case "SPA_ITA":
                LandingGUI.this.setVisible(false);
                flashCards = new FlashCardGUI(Languages.ITALIAN, Languages.SPANISH);
                break;
            case "SPA_GER":
                LandingGUI.this.setVisible(false);
                flashCards = new FlashCardGUI(Languages.GERMAN, Languages.SPANISH);
                break;
            case "ITA_GER":
                LandingGUI.this.setVisible(false);
                flashCards = new FlashCardGUI(Languages.ITALIAN, Languages.GERMAN);
                break;
            default:
                
                break;
        }
    }
    
    public static void main(String[] args)
    {
        LandingGUI gui = new LandingGUI();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        
        gui.setDefaultCloseOperation(LandingGUI.EXIT_ON_CLOSE);
    }
}
