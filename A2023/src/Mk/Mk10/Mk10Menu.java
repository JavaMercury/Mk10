package Mk.Mk10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mk10Menu extends Mk10Initializer implements MouseListener, KeyListener, FocusListener {

    JMenu aboutJMenu = new JMenu("关于");
    JButton changeNumberSystemJB = new JButton("进制转换工具");
    JButton checkPrimeNumberJB = new JButton("质数判断器");
    JButton getRandomNumberJB = new JButton("随机数生成器");
    JButton playPuzzleGameJB = new JButton("拼图小游戏");
    JMenuItem resetPasswordJMI = new JMenuItem("修改密码");
    JMenuItem resetPhoneNumberJMI = new JMenuItem("修改手机号码");
    JMenuItem logout = new JMenuItem("退出登录");
    int focusSelect;

    public Mk10Menu(String username) {
        this.username = username;
        initJFrame();
        initMenuBar();
        initContent();
        setResizable(false);
        setVisible(true);
    }

    @Override
    void collectData() {

    }

    ///窗口初始化
    @Override
    void initJFrame() {
        setLayout(null);
        setSize(356, 390);
        setIcon();
        setTitle(version);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    ///菜单初始化
    @Override
    void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu me = new JMenu("我的");
        me.add(logout);
        me.add(resetPasswordJMI);
        me.add(resetPhoneNumberJMI);
        menuBar.add(me);
        menuBar.add(aboutJMenu);
        setJMenuBar(menuBar);
    }

    ///内容初始化
    @Override
    void initContent() {
        getContentPane().setBackground(Color.WHITE);
        changeNumberSystemJB.setBounds(95, 20, 150, 50);
        checkPrimeNumberJB.setBounds(95, 100, 150, 50);
        getRandomNumberJB.setBounds(95, 180, 150, 50);
        playPuzzleGameJB.setBounds(95, 260, 150, 50);
        getContentPane().add(playPuzzleGameJB);
        getContentPane().add(getRandomNumberJB);
        getContentPane().add(changeNumberSystemJB);
        getContentPane().add(checkPrimeNumberJB);
        changeNumberSystemJB.addMouseListener(this);
        checkPrimeNumberJB.addMouseListener(this);
        getRandomNumberJB.addMouseListener(this);
        playPuzzleGameJB.addMouseListener(this);
        aboutJMenu.addMouseListener(this);
        logout.addMouseListener(this);
        resetPasswordJMI.addMouseListener(this);
        resetPhoneNumberJMI.addMouseListener(this);
        changeNumberSystemJB.addKeyListener(this);
        checkPrimeNumberJB.addKeyListener(this);
        getRandomNumberJB.addKeyListener(this);
        playPuzzleGameJB.addKeyListener(this);
        changeNumberSystemJB.addFocusListener(this);
        checkPrimeNumberJB.addFocusListener(this);
        getRandomNumberJB.addFocusListener(this);
        playPuzzleGameJB.addFocusListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object thing = e.getSource();
        if (thing == aboutJMenu) {
            showAbout();
        } else if (thing == playPuzzleGameJB) {
            setVisible(false);
            new Mk10PuzzleGame();
        } else if (thing == changeNumberSystemJB) {
            setVisible(false);
            new Mk10ChangeNumberSystem(username);
        } else if (thing == checkPrimeNumberJB) {
            setVisible(false);
            new Mk10CheckPrimeNumber();
        } else if (thing == logout) {
            setVisible(false);
            new Mk10Login();
        } else if (thing == getRandomNumberJB) {
            setVisible(false);
            new Mk10GetRandomNumber();
        } else if (thing == resetPasswordJMI) {
            setVisible(false);
            new Mk10ResetPassword(username);
        } else if (thing == resetPhoneNumberJMI) {
            setVisible(false);
            new Mk10ResetPhoneNumber(username);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object thing = e.getSource();
        if (thing == changeNumberSystemJB || thing == checkPrimeNumberJB || thing == getRandomNumberJB || thing == playPuzzleGameJB)
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object thing = e.getSource();
        if (thing == changeNumberSystemJB || thing == checkPrimeNumberJB || thing == getRandomNumberJB || thing == playPuzzleGameJB)
            setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 10) {
            switch (focusSelect) {
                case 1: {
                    setVisible(false);
                    new Mk10ChangeNumberSystem(username);
                    break;
                }
                case 2: {
                    setVisible(false);
                    new Mk10CheckPrimeNumber();
                    break;
                }
                case 3: {
                    setVisible(false);
                    new Mk10GetRandomNumber();
                    break;
                }
                case 4: {
                    setVisible(false);
                    new Mk10PuzzleGame();
                    break;
                }
            }
        } else if (code == 27) {
            setVisible(false);
            new Mk10Login();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        Object thing = e.getSource();
        if (thing == changeNumberSystemJB) {
            focusSelect = 1;
        } else if (thing == checkPrimeNumberJB) {
            focusSelect = 2;
        } else if (thing == getRandomNumberJB) {
            focusSelect = 3;
        } else if (thing == playPuzzleGameJB) {
            focusSelect = 4;
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
