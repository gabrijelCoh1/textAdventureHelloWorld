package firstAdventure;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    boolean milk;
    boolean meat;
    Container container;
    JPanel titlePanel, startPanel, mainTextPanel, choicePanel;
    JLabel titleLabel;
    JButton startButton, choice1,choice2,choice3,choice4;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 98);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    String pos;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler chHandler = new ChoiceHandler();


    public static void main(String[] args) {
        new Game();
    }

    public Game(){
        JFrame window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        container = window.getContentPane();

        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titlePanel.setBackground(Color.black);
        titleLabel = new JLabel("Hello World");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(titleFont);

        startPanel = new JPanel();
        startPanel.setBounds(300, 400, 200, 100);
        startPanel.setBackground(Color.black);

        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(tsHandler);

        titlePanel.add(titleLabel);
        startPanel.add(startButton);

        container.add(titlePanel);
        container.add(startPanel);

        window.setVisible(true);
    }
    public void createScreen(){

        titlePanel.setVisible(false);
        startPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        container.add(mainTextPanel);

        mainTextArea = new JTextArea("HELLO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choicePanel = new JPanel();
        choicePanel.setBounds(250,350,300,150);
        choicePanel.setBackground(Color.black);
        choicePanel.setLayout(new GridLayout(4, 1));
        container.add(choicePanel);

        //choicePanel.add(choice#);
        choice1 = ChoiceButton("Choice 1");
        choice1.addActionListener(chHandler);
        choice1.setActionCommand("ch1");
        choice2 = ChoiceButton("Choice 2");
        choice2.addActionListener(chHandler);
        choice2.setActionCommand("ch2");
        choice3 = ChoiceButton("Choice 3");
        choice3.addActionListener(chHandler);
        choice3.setActionCommand("ch3");
        choice4 = ChoiceButton("Choice 4");
        choice4.addActionListener(chHandler);
        choice4.setActionCommand("ch4");

        home();

    }

    public JButton ChoiceButton(String text){
        JButton  button;
        button = new JButton();
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(normalFont);
        button.setText(text);
        button.setFocusPainted(false);
        choicePanel.add(button);
        return button;
    }

    public void restartBtn(){
        choice1.setText("Restart");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void next(){
        choice1.setText(">");
        choice2.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void showChoices(){
        choice1.setVisible(true);
        choice2.setVisible(true);
        choice3.setVisible(true);
        choice4.setVisible(true);
    }

    public void home(){
        pos = "home";
        showChoices();
        mainTextArea.setText("You are at home.\n\nWhat will you do?");
        choice1.setText("Program");
        choice2.setText("Get groceries");
        choice3.setText("Sleep");
        choice4.setVisible(false);
    }
    //PROGRAMMING CHOICE RELATED
    public void program(){
        pos = "programming";
        showChoices();
        mainTextArea.setText("You are programming a game, and encounter an error.\n\nWhat now?");
        choice1.setText("Try to fix the error");
        choice2.setText("Go on Stack Overflow");
        choice3.setText("Give up");
        choice4.setText("Ask your IT teacher");
    }
    public void fixerror(){
        pos = "ending";
        mainTextArea.setText("You tried to fix the error by yourself.\nYou didn't succeed, and you were so angry.\nYou broke your laptop, and now are sad.\n\n<SAD ENDING>");
        restartBtn();
    }
    public void stack(){
        pos = "ending";
        int ranNum = new java.util.Random().nextInt(100);
        if((ranNum % 2) == 0) {
            mainTextArea.setText("You went on Stack Overflow.\nYou posted your problem, and eventually solved it, even\nfinding new friends too!\n\n <STACK OVERFLOW FRIENDS ENDING (1/3)>");
        }else if((ranNum % 2) == 1 && ranNum != 69){
            mainTextArea.setText("You went on Stack Overflow.\nYou posted your problem, but got a lot of downvotes.\n\n <STACK OVERFLOW DOWNVOTE ENDING> (2/3)");
        }else if((ranNum % 2) == 1 && ranNum == 69){
            mainTextArea.setText("You went on Stack Overflow.\nYou posted your problem, but never got a response.\n\n <STACK OVERFLOW NO RESPONSE ENDING (3/3)>");
        }
        restartBtn();
    }
    public void giveUp(){
        pos = "ending";
        mainTextArea.setText("You gave up, closed your laptop, and went to sleep,\ndisappointed.\n\n <DISAPPOINTING SLEEP ENDING>");
        restartBtn();
    }
    public void askTeacher(){
        pos = "ending";
        mainTextArea.setText("You emailed your IT teacher, and got a response.\nYou have a zoom meeting, fix the problem, and learn many new things too!\n\n <LEARNING ENDING>");
        restartBtn();
    }
    //SLEEP CHOICE
    public void sleep(){
        pos = "sleep";
        mainTextArea.setText("You took a nap, and you woke up feeling well rested.");
        next();
    }
    //GROCERIES RELATED
    public void groceries(){
        pos = "groceriesCF";
        mainTextArea.setText("How will you go?");
        choice1.setText("By car");
        choice2.setText("On foot");
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void car(){
        pos = "car";
        mainTextArea.setText("You went by car.\nYou felt kind of lazy...\n But you can atleast carry more things, right?");
        next();
    }
    public void foot(){
        pos = "foot";
        mainTextArea.setText("You went on foot.\nIt took you a while.\n You do feel somewhat proud, though.");
        next();
    }
    public void store(){
        pos = "store";
        showChoices();
        mainTextArea.setText("You are at the store.\nYou remember that you need cheese...\n\nWhere first?");
        choice1.setText("Dairy aisle #1");
        choice2.setText("Dairy aisle #2");
        choice3.setText("Meat aisle");
        choice4.setVisible(false);
    }
    public void dairy1(){
        pos = "dairy1";
        choice1.setVisible(true);
        choice2.setVisible(true);
        mainTextArea.setText("You are the first dairy aisle, but don't see any cheese, just\nmilk.\n\nDo you get some milk anyway?");
        choice1.setText("Yes");
        choice2.setText("No");
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void yesmilk(){
        pos = "yesmilk";
        mainTextArea.setText("You decided to get some milk.\n\nWhy not?\n\nLet's go to the second dairy aisle.");
        milk = true;
        next();
    }
    public void nomilk(){
        pos = "nomilk";
        mainTextArea.setText("You decided to not buy milk.\n\nAfter all, you are here for cheese.\n\nLet's go to the second dairy aisle.");
        milk = false;
        next();
    }
    public void dairy2(){
        pos = "dairy2";
        mainTextArea.setText("You are at the second dairy aisle.\nLo and behold, you see some cheese!");
        next();
    }
    public void cheeseEnd(){
        pos = "ending";
        if(milk == false && meat == false){
            mainTextArea.setText("You bought the cheese, went home, and ate some.\nYou saved some for when you will need it.\n\n<CHEESE ENDING>");
        }else if(milk == true && meat == false){
            mainTextArea.setText("You bought both cheese and milk, went home, drank some milk and ate some cheese.\nYou saved both for when you will need them.\n\n<CHEESE AND MILK ENDING>");
        }else if(milk == false && meat == true){
            mainTextArea.setText("You bought both cheese and meat, went home, put meat in the fridge, and ate some cheese.\nYou saved some for later when you will need them.\n\n<CHEESE AND MEAT ENDING>");
        }else if(milk == true && meat == true){
            mainTextArea.setText("You bought cheese, milk and meat, went home, put meat in the fridge, drank some milk, ate some cheese and saved some for later when you will need them.\n\n<CHEESE, MILK, AND MEAT ENDING>");
        }

        restartBtn();
    }
    public void meat(){
        pos = "meat";
        choice1.setVisible(true);
        choice2.setVisible(true);
        mainTextArea.setText("You decided to go to the meat aisle to see if there's\nanything.\n\nDo you buy some?");
        choice1.setText("Yes");
        choice2.setText("No");
        choice3.setVisible(false);
        choice4.setVisible(false);
    }
    public void yesmeat(){
        pos = "yesmeat";
        meat = true;
        mainTextArea.setText("You decide to get some meat.\nIt might be useful!\n\nLet's go to the dairy aisle.");
        next();
    }
    public void nomeat(){
        pos = "nomeat";
        meat = false;
        mainTextArea.setText("You decide to not get some meat.\nYou are here for cheese, right.\n\nLet's go to the dairy aisle.");
        next();
    }


    public class TitleScreenHandler implements ActionListener {
            public void actionPerformed(ActionEvent event){
                createScreen();
        }
    }
    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String choice = event.getActionCommand();

            switch(pos){
                case "home":
                    switch(choice){
                        case "ch1": program(); break;
                        case "ch3": sleep(); break;
                        case "ch2": groceries(); break;
                    }
                    break;
                case "programming":
                    switch(choice){
                        case "ch1": fixerror(); break;
                        case "ch2": stack(); break;
                        case "ch3": giveUp(); break;
                        case "ch4": askTeacher(); break;
                    }
                    break;
                case "groceriesCF":
                    switch(choice){
                        case "ch1": car(); break;
                        case "ch2": foot(); break;
                    }
                    break;

                case "ending", "sleep": if(choice.equals("ch1")){home();} break;
                case "car", "foot": if(choice.equals("ch1")){store();} break;
                case "store": if(choice.equals("ch1")){dairy1();}else if(choice.equals("ch2")){dairy2();}else if(choice.equals("ch3")){meat();} break;
                case "dairy1": if(choice.equals("ch1")){yesmilk();}else{nomilk();} break;
                case "nomilk", "yesmilk": if(choice.equals("ch1")){dairy2();} break;
                case "dairy2": if(choice.equals("ch1")){cheeseEnd();} break;
                case "meat": if(choice.equals("ch1")){yesmeat();}else{nomeat();} break;
                case "yesmeat", "nomeat":
                    if(choice.equals("ch1")){
                        int randNum = new java.util.Random().nextInt(2);
                        if(randNum == 0){
                            dairy1();
                        }else{
                            dairy2();
                        }
                    }
                    break;
            }

        }
    }

}
