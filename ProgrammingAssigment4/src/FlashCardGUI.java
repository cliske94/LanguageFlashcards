/**
 * @author Cody Liske
 */

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class FlashCardGUI extends JFrame {

    private JLabel outputArea;
    private JLabel currentWord;
    private JTextField userInput;
    private JButton okButton;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenu subMenu;
    private JMenuItem about, settings, close;
    private Languages beginLanguage, targetLanguage;
    private int correctAns = 0, incorrectAns = 0;
    private JLabel tallies;
    private Timer timer = new Timer(5000, new UpdateGUI());
    private RandomGen generator = new RandomGen();
    private int randomizer;
    boolean reverseFlag = false;
    private String userGuess;
    
    public FlashCardGUI(Languages targetLanguage, Languages beginLanguage)
    {
        timer.setActionCommand("CHECKTIME");
        timer.addActionListener(new UpdateGUI());
        generator.setHighBound(2);
        generator.setLowBound(0);
        randomizer = generator.getRandomI();
        this.beginLanguage = beginLanguage;
        this.targetLanguage = targetLanguage;
        
        GridBagConstraints layoutConst = new GridBagConstraints();
        
        super.setTitle("Language Flash Cards");
        super.setLayout(new GridBagLayout());
        super.setSize(450, 150);
        
        outputArea = new JLabel();
        outputArea.setText("Language Learning Flash Card Game");
        outputArea.setHorizontalAlignment(JLabel.CENTER);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.gridwidth = 3;
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        super.add(outputArea, layoutConst);
        
        currentWord = new JLabel();
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        super.add(currentWord, layoutConst);
        
        tallies = new JLabel();
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 2;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        super.add(tallies, layoutConst);
        tallies.setText("Wins: " + correctAns + " Losses: " + incorrectAns);
        
        userInput = new JTextField();
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10, 5, 10, 5);
        userInput.setEditable(false);
        super.add(userInput, layoutConst);
        userInput.setColumns(15);
        userInput.addKeyListener(new UpdateGUI());
        userInput.setActionCommand("CHECK");
        
        okButton = new JButton("Start");
        okButton.setActionCommand("START");
        okButton.addActionListener(new UpdateGUI());
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 2;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        super.add(okButton, layoutConst);
        
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        subMenu = new JMenu("Other");
        about = new JMenuItem("About");
        about.setActionCommand("ABOUT");
        about.addActionListener(new UpdateGUI());
        settings = new JMenuItem("Settings");
        settings.setActionCommand("SETTINGS");
        settings.addActionListener(new UpdateGUI());
        
        subMenu.add(settings);
        menu.add(about);
        menu.add(subMenu);
        menuBar.add(menu);
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        super.add(menuBar, layoutConst);
        
        super.setSize(450, 160);
        super.setMinimumSize(new Dimension(450, 160));
        super.setVisible(true);
        super.setDefaultCloseOperation(FlashCardGUI.EXIT_ON_CLOSE);
        
    }
    
    private class UpdateGUI implements ActionListener, KeyListener
    {
        Translator translator = new Translator();
        public void actionPerformed(ActionEvent e)
        {
            switch (e.getActionCommand())
            {
                case "ABOUT":
                    
                    break;
                case "SETTINGS":
                    
                    break;
                case "CHECK":
                    timer.stop();
                    userInput.setEditable(false);
                    String correct = translator.translate(targetLanguage, beginLanguage, currentWord.getText(), reverseFlag);
                    reverseFlag = !reverseFlag;
                    if (userInput.getText().toUpperCase().equals(correct.toUpperCase()))
                    {
                        correctAns++;
                        tallies.setText("Correct: " + correctAns + " Incorrect: " + incorrectAns);
                        outputArea.setText("Correct!");
                    } else
                    {
                        incorrectAns++;
                        tallies.setText("Correct: " + correctAns + " Incorrect: " + incorrectAns);
                        outputArea.setText("Incorrect! Answer: " + correct);
                    }
                    
                    timer.restart();
                    break;
                case "START":
                    okButton.setText("Check");
                    okButton.setActionCommand("CHECK");
                    outputArea.setText("Type the translation into the field below.");
                    userInput.setEditable(true);
                    switch (beginLanguage)
                    {
                        case ENGLISH:
                            currentWord.setText(DatabaseFacade.getEnglishWord());
                            break;
                        case SPANISH:
                            currentWord.setText(DatabaseFacade.getSpanishWord());
                            break;
                        case GERMAN:
                            currentWord.setText(DatabaseFacade.getGermanWord());
                            break;
                        case ITALIAN:
                            currentWord.setText(DatabaseFacade.getItalianWord());
                            break;
                    }
                    break;
                case "CHECKTIME":
                        timer.stop();
                        userInput.setEditable(true);
                        outputArea.setText("");
                        userInput.setText("");
                        switch (beginLanguage)
                        {
                        case ENGLISH:
                            switch (targetLanguage)
                            {
                                case SPANISH:
                                    randomizer = generator.getRandomI();
                                    if (randomizer == 1) 
                                    {
                                        currentWord.setText(DatabaseFacade.getSpanishWord());
                                        reverseFlag = true;
                                    }
                                    else currentWord.setText(DatabaseFacade.getEnglishWord());
                                    timer.restart();
                                    break;
                                case GERMAN:
                                    randomizer = generator.getRandomI();
                                    if (randomizer == 1) currentWord.setText(DatabaseFacade.getGermanWord());
                                    else currentWord.setText(DatabaseFacade.getEnglishWord());
                                    timer.restart();
                                    break;
                                case ITALIAN:
                                    randomizer = generator.getRandomI();
                                    if (randomizer == 1) currentWord.setText(DatabaseFacade.getItalianWord());
                                    else currentWord.setText(DatabaseFacade.getEnglishWord());
                                    timer.restart();
                                    break;
                            }
//                            timer.restart();
                            break;
                        case SPANISH:
                            switch (targetLanguage)
                            {
                                case ENGLISH:
                                    randomizer = generator.getRandomI();
                                    //System.out.println(randomizer + " is random");
                                    if (randomizer == 1) currentWord.setText(DatabaseFacade.getSpanishWord());
                                    else currentWord.setText(DatabaseFacade.getEnglishWord());
                                    timer.restart();
                                    break;
                                case GERMAN:
                                    randomizer = generator.getRandomI();
                                    if (randomizer == 1) currentWord.setText(DatabaseFacade.getGermanWord());
                                    else currentWord.setText(DatabaseFacade.getSpanishWord());
                                    timer.restart();
                                    break;
                                case ITALIAN:
                                    randomizer = generator.getRandomI();
                                    if (randomizer == 1) currentWord.setText(DatabaseFacade.getItalianWord());
                                    else currentWord.setText(DatabaseFacade.getSpanishWord());
                                    timer.restart();
                                    break;
                            }
                            break;
                        case GERMAN:
                            switch (targetLanguage)
                            {
                                case SPANISH:
                                    randomizer = generator.getRandomI();
                                    if (randomizer == 1) currentWord.setText(DatabaseFacade.getSpanishWord());
                                    else currentWord.setText(DatabaseFacade.getGermanWord());
                                    timer.restart();
                                    break;
                                case ENGLISH:
                                    randomizer = generator.getRandomI();
                                    if (randomizer == 1) currentWord.setText(DatabaseFacade.getGermanWord());
                                    else currentWord.setText(DatabaseFacade.getEnglishWord());
                                    timer.restart();
                                    break;
                                case ITALIAN:
                                    randomizer = generator.getRandomI();
                                    if (randomizer == 1) currentWord.setText(DatabaseFacade.getItalianWord());
                                    else currentWord.setText(DatabaseFacade.getGermanWord());
                                    timer.restart();
                                    break;
                            }
                            break;
                        case ITALIAN:
                            switch (targetLanguage)
                            {
                                case SPANISH:
                                    randomizer = generator.getRandomI();
                                    if (randomizer == 1) currentWord.setText(DatabaseFacade.getSpanishWord());
                                    else currentWord.setText(DatabaseFacade.getItalianWord());
                                    timer.restart();
                                    break;
                                case GERMAN:
                                    randomizer = generator.getRandomI();
                                    if (randomizer == 1) currentWord.setText(DatabaseFacade.getGermanWord());
                                    else currentWord.setText(DatabaseFacade.getItalianWord());
                                    timer.restart();
                                    break;
                                case ENGLISH:
                                    randomizer = generator.getRandomI();
                                    if (randomizer == 1) currentWord.setText(DatabaseFacade.getItalianWord());
                                    else currentWord.setText(DatabaseFacade.getEnglishWord());
                                    timer.restart();
                                    break;
                            }
                            break;
                        }
                    break;
                default:
                    
                    break;
            }
            //timer.stop();
        }

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                userGuess = userInput.getText();
                ActionEvent event = new ActionEvent(FlashCardGUI.this, 0, "Enter Pressed");
                this.actionPerformed(event);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                userGuess = userInput.getText();
                ActionEvent event = new ActionEvent(FlashCardGUI.this.userInput, 0, "CHECK");
                this.actionPerformed(event);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("Key was released");
        }
    }
    
    public int getRandom()
    {
        return randomizer;
    }
}
