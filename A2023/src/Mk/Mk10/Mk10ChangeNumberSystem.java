package Mk.Mk10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mk10ChangeNumberSystem extends Mk10Initializer implements MouseListener, FocusListener, KeyListener {

    JMenu about = new JMenu("关于");
    JMenu properties = new JMenu("选项");
    JMenuItem exit = new JMenuItem("退出进制转换器");
    JMenuItem logout = new JMenuItem("退出登录");
    JButton binaryToOctalJB = new JButton("将二进制转换为八进制");
    JButton binaryToDecimalJB = new JButton("将二进制转换为十进制");
    JButton binaryToHexJB = new JButton("将二进制转换为十六进制");
    JButton octalToBinaryJB = new JButton("将八进制转换为二进制");
    JButton octalToDecimalJB = new JButton("将八进制转换为十进制");
    JButton octalToHexJB = new JButton("将八进制转换为十六进制");
    JButton decimalToBinaryJB = new JButton("将十进制转换为二进制");
    JButton decimalToOctalJB = new JButton("将十进制转换为八进制");
    JButton decimalToHexJB = new JButton("将十进制转换为十六进制");
    JButton hexToBinaryJB = new JButton("将十六进制转换为二进制");
    JButton hexToOctalJB = new JButton("将十六进制转换为八进制");
    JButton hexToDecimalJB = new JButton("将十六进制转换为十进制");
    JButton submit = new JButton("确定");
    JLabel wrongInputWarning = new JLabel("输入有误，请重新输入");
    String resultIs;
    String result;
    JLabel resultJL = new JLabel();
    String hint = "请输入一个数字";
    String inputBinary = "请在此输入一个二进制数字";
    String inputOctal = "请在此输入一个八进制数字";
    String inputDecimal = "请在此输入一个十进制数字";
    String inputHex = "请在此输入一个十六进制数字";
    String resultBinary = "转换成二进制为";
    String resultOctal = "转换成八进制为";
    String resultDecimal = "转换成十进制为";
    String resultHex = "转换成十六进制为";
    String input;
    JTextField inputJTF = new JTextField();
    Double indicator = 0.0;

    public Mk10ChangeNumberSystem(String username) {
        super.username = username;
        setResizable(false);
        initJFrame();
        initMenuBar();
        initContent();
        setVisible(true);
    }

    ///判断输入的字符串是否只包含二进制数字
    public static boolean isOnlyBinary(String binaryString) {
        if (binaryString.equals("")) return false;
        for (int i = 0; i < binaryString.length(); i++) {
            if (!(binaryString.charAt(i) >= '0' && binaryString.charAt(i) <= '1')) {
                return false;
            }
        }
        return true;
    }

    //方法：判断输入的字符串是否只包含八进制数字
    public static boolean isOnlyOctal(String octalString) {
        if (octalString.equals("")) return false;
        for (int i = 0; i < octalString.length(); i++) {
            if (!(octalString.charAt(i) >= '0' && octalString.charAt(i) <= '7')) {
                return false;
            }
        }
        return true;
    }

    //方法：判断输入的字符串是否只包含十进制数字
    public static boolean isOnlyDecimal(String decimalString) {
        if (decimalString.equals("")) return false;
        for (int i = 0; i < decimalString.length(); i++) {
            if (!(decimalString.charAt(i) >= '0' && decimalString.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    ///判断输入的字符串是否只包含十六进制数字
    public static boolean isOnlyHexNumber(String hexString) {
        if (hexString.equals("")) return false;
        for (int i = 0; i < hexString.length(); i++) {
            if (!((hexString.charAt(i) >= '0' && hexString.charAt(i) <= '9') || (hexString.charAt(i) >= 'A' && hexString.charAt(i) <= 'F'))) {
                return false;
            }
        }
        return true;
    }

    @Override
    void collectData() {

    }

    ///窗口初始化
    @Override
    void initJFrame() {
        setLayout(null);
        setSize(636, 722);
        setTitle("水银第十代 进制转换器");
        setIcon();
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    ///菜单初始化
    @Override
    void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        properties.add(exit);
        properties.add(logout);
        menuBar.add(properties);
        menuBar.add(about);
        about.addMouseListener(this);
        properties.addMouseListener(this);
        exit.addMouseListener(this);
        logout.addMouseListener(this);
        setJMenuBar(menuBar);
    }

    ///内容初始化
    @Override
    void initContent() {
        getContentPane().setBackground(Color.WHITE);
        binaryToOctalJB.setBounds(60, 60, 200, 40);
        binaryToDecimalJB.setBounds(360, 60, 200, 40);
        binaryToHexJB.setBounds(60, 160, 200, 40);
        octalToBinaryJB.setBounds(360, 160, 200, 40);
        octalToDecimalJB.setBounds(60, 260, 200, 40);
        octalToHexJB.setBounds(360, 260, 200, 40);
        decimalToBinaryJB.setBounds(60, 360, 200, 40);
        decimalToOctalJB.setBounds(360, 360, 200, 40);
        decimalToHexJB.setBounds(60, 460, 200, 40);
        hexToBinaryJB.setBounds(360, 460, 200, 40);
        hexToOctalJB.setBounds(60, 560, 200, 40);
        hexToDecimalJB.setBounds(360, 560, 200, 40);
        inputJTF.setBounds(640, 210, 200, 30);
        submit.setBounds(705, 270, 70, 30);
        wrongInputWarning.setBounds(640, 160, 200, 30);
        resultJL.setBounds(640, 360, 500, 50);
        wrongInputWarning.setVisible(false);
        resultJL.setVisible(false);
        binaryToOctalJB.addMouseListener(this);
        binaryToDecimalJB.addMouseListener(this);
        binaryToHexJB.addMouseListener(this);
        octalToBinaryJB.addMouseListener(this);
        octalToDecimalJB.addMouseListener(this);
        octalToHexJB.addMouseListener(this);
        decimalToBinaryJB.addMouseListener(this);
        decimalToOctalJB.addMouseListener(this);
        decimalToHexJB.addMouseListener(this);
        hexToBinaryJB.addMouseListener(this);
        hexToOctalJB.addMouseListener(this);
        hexToDecimalJB.addMouseListener(this);
        inputJTF.addFocusListener(this);
        submit.addMouseListener(this);
        getContentPane().add(binaryToOctalJB);
        getContentPane().add(binaryToDecimalJB);
        getContentPane().add(binaryToHexJB);
        getContentPane().add(octalToBinaryJB);
        getContentPane().add(octalToDecimalJB);
        getContentPane().add(octalToHexJB);
        getContentPane().add(decimalToBinaryJB);
        getContentPane().add(decimalToOctalJB);
        getContentPane().add(decimalToHexJB);
        getContentPane().add(hexToBinaryJB);
        getContentPane().add(hexToOctalJB);
        getContentPane().add(hexToDecimalJB);
        getContentPane().add(inputJTF);
        getContentPane().add(submit);
        getContentPane().add(resultJL);
        getContentPane().add(wrongInputWarning);

        backJB.setBounds(0, 0, 60, 30);
        backJB.addMouseListener(this);
        getContentPane().add(backJB);
        inputJTF.addKeyListener(this);
        submit.setVisible(true);
        submit.addKeyListener(this);
        backJB.addKeyListener(this);
        wrongInputWarning.setForeground(Color.RED);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object thing = e.getSource();
        if (thing == binaryToDecimalJB) {
            input = null;
            indicator = 2.10;
            hint = inputBinary;
            inputJTF.setText(hint);
            binaryToDecimalUser();
        } else if (thing == submit) {
            input = inputJTF.getText().toUpperCase();
            select();
        } else if (thing == about) showAbout();
        else if (thing == exit || thing == backJB) {
            setVisible(false);
            new Mk10Menu(username);
        } else if (thing == logout) {
            setVisible(false);
            new Mk10Login();
        } else if (thing == octalToDecimalJB) {
            input = null;
            indicator = 8.10;
            hint = inputOctal;
            inputJTF.setText(hint);
            octalToDecimalUser();
        } else if (thing == hexToDecimalJB) {
            input = null;
            indicator = 16.10;
            hint = inputHex;
            inputJTF.setText(hint);
            hexToDecimalUser();
        } else if (thing == decimalToBinaryJB) {
            input = null;
            indicator = 10.2;
            hint = inputDecimal;
            inputJTF.setText(hint);
            decimalToBinaryUser();
        } else if (thing == decimalToOctalJB) {
            input = null;
            indicator = 10.8;
            hint = inputDecimal;
            inputJTF.setText(hint);
            decimalToOctalUser();
        } else if (thing == decimalToHexJB) {
            input = null;
            indicator = 10.16;
            hint = inputDecimal;
            inputJTF.setText(hint);
            decimalToHexUser();
        } else if (thing == binaryToOctalJB) {
            input = null;
            indicator = 2.8;
            hint = inputBinary;
            inputJTF.setText(hint);
            binaryToOctal();
        } else if (thing == binaryToHexJB) {
            input = null;
            indicator = 2.16;
            hint = inputBinary;
            inputJTF.setText(hint);
            binaryToHex();
        } else if (thing == octalToBinaryJB) {
            input = null;
            indicator = 8.2;
            hint = inputOctal;
            inputJTF.setText(hint);
            octalToBinary();
        } else if (thing == octalToHexJB) {
            input = null;
            indicator = 8.16;
            hint = inputOctal;
            inputJTF.setText(hint);
            octalToHex();
        } else if (thing == hexToBinaryJB) {
            input = null;
            indicator = 16.2;
            hint = inputHex;
            inputJTF.setText(hint);
            hexToBinary();
        } else if (thing == hexToOctalJB) {
            input = null;
            indicator = 16.8;
            hint = inputHex;
            inputJTF.setText(hint);
            hexToOctal();
        }
    }

    ///用户按下确定后，判断应该执行的功能
    void select() {
        if (indicator == 2.10) {
            binaryToDecimalUser();
        } else if (indicator == 8.10) {
            octalToDecimalUser();
        } else if (indicator == 16.10) {
            hexToDecimalUser();
        } else if (indicator == 10.2) {
            decimalToBinaryUser();
        } else if (indicator == 10.8) {
            decimalToOctalUser();
        } else if (indicator == 10.16) {
            decimalToHexUser();
        } else if (indicator == 2.8) {
            binaryToOctal();
        } else if (indicator == 2.16) {
            binaryToHex();
        } else if (indicator == 8.2) {
            octalToBinary();
        } else if (indicator == 8.16) {
            octalToHex();
        } else if (indicator == 16.2) {
            hexToBinary();
        } else if (indicator == 16.8) {
            hexToOctal();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object thing = e.getSource();
        if (thing == binaryToOctalJB || thing == binaryToDecimalJB || thing == binaryToHexJB || thing == octalToBinaryJB ||
                thing == octalToDecimalJB || thing == octalToHexJB || thing == decimalToBinaryJB || thing == decimalToOctalJB ||
                thing == decimalToHexJB || thing == hexToBinaryJB || thing == hexToOctalJB || thing == hexToDecimalJB || thing == submit || thing == backJB)
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object thing = e.getSource();
        if (thing == binaryToOctalJB || thing == binaryToDecimalJB || thing == binaryToHexJB || thing == octalToBinaryJB ||
                thing == octalToDecimalJB || thing == octalToHexJB || thing == decimalToBinaryJB || thing == decimalToOctalJB ||
                thing == decimalToHexJB || thing == hexToBinaryJB || thing == hexToOctalJB || thing == hexToDecimalJB || thing == submit || thing == backJB)
            setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void focusGained(FocusEvent e) {
        String temp = inputJTF.getText();
        if (temp.equals(hint)) {
            inputJTF.setText("");
            inputJTF.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        String temp = inputJTF.getText();
        if (temp.equals("")) {
            inputJTF.setForeground(Color.GRAY);
            inputJTF.setText(hint);
        }
    }

    ///二进制转十进制 - 用户
    void binaryToDecimalUser() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyBinary(input)) {
            wrongInputWarning.setVisible(false);
            this.result = binaryToDecimal(input);
            resultIs = resultDecimal;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
    }

    ///二进制转十进制 - 底层
    String binaryToDecimal(String binaryString) {
        wrongInputWarning.setVisible(false);
        StringBuilder temp = new StringBuilder();
        String binaryReverse = temp.append(binaryString).reverse().toString();
        long multiplier = 1;
        long result = 0;
        for (int i = 0; i < binaryReverse.length(); i++) {
            result += multiplier * Integer.parseInt("" + binaryReverse.charAt(i));
            multiplier *= 2;
        }
        return result + "";
    }

    //方法：八进制转十进制 - 用户
    void octalToDecimalUser() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyOctal(input)) {
            wrongInputWarning.setVisible(false);
            this.result = octalToDecimal(input);
            resultIs = resultDecimal;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
    }

    ///八进制转十进制 - 底层
    String octalToDecimal(String octalString) {
        StringBuilder temp = new StringBuilder();
        String octalReverse = temp.append(octalString).reverse().toString();
        long multiplier = 1;
        long result = 0;
        for (int i = 0; i < octalReverse.length(); i++) {
            result += multiplier * Integer.parseInt("" + octalReverse.charAt(i));
            multiplier *= 8;
        }
        return result + "";
    }

    ///十六进制转十进制 - 用户
    void hexToDecimalUser() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyHexNumber(input)) {
            wrongInputWarning.setVisible(false);
            this.result = hexToDecimal(input);
            resultIs = resultDecimal;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
    }

    ///十六进制转十进制 - 底层
    String hexToDecimal(String hexString) {
        StringBuilder temp = new StringBuilder();
        String hexReverse = temp.append(hexString).reverse().toString();
        long multiplier = 1;
        long result = 0;
        for (int i = 0; i < hexReverse.length(); i++) {
            int[] multiplierArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            if ((int) hexReverse.charAt(i) <= 57)
                result += multiplier * multiplierArray[(int) hexReverse.charAt(i) - 48];
            else result += multiplier * multiplierArray[(int) hexReverse.charAt(i) - 55];
            multiplier *= 16;
        }
        return result + "";
    }

    ///十进制转二进制 - 用户
    void decimalToBinaryUser() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyDecimal(input)) {
            wrongInputWarning.setVisible(false);
            this.result = decimalToBinary(input);
            resultIs = resultBinary;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
    }

    ///十进制转二进制 - 底层
    String decimalToBinary(String decimalString) {
       return Integer.toBinaryString(Integer.parseInt(decimalString));
    }

    ///十进制转八进制 - 用户
    void decimalToOctalUser() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyDecimal(input)) {
            wrongInputWarning.setVisible(false);
            this.result = decimalToOctal(input);
            resultIs = resultOctal;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
    }

    ///十进制转八进制 - 底层
    String decimalToOctal(String decimalString) {
        return Integer.toOctalString(Integer.parseInt(decimalString));
    }

    ///十进制转十六进制 - 用户
    void decimalToHexUser() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyDecimal(input)) {
            wrongInputWarning.setVisible(false);
            this.result = decimalToHex(input);
            resultIs = resultHex;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
    }

    ///十进制转十六进制 - 底层
    String decimalToHex(String decimalString) {
        return Integer.toHexString(Integer.parseInt(decimalString));
    }


    ///二进制转八进制
    void binaryToOctal() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyBinary(input)) {
            wrongInputWarning.setVisible(false);
            this.result = decimalToOctal(binaryToDecimal(input)) + "";
            resultIs = resultOctal;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
    }

    ///二进制转十六进制
    void binaryToHex() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyBinary(input)) {
            wrongInputWarning.setVisible(false);
            this.result = decimalToHex(binaryToDecimal(input));
            resultIs = resultHex;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
    }

    ///八进制转二进制
    void octalToBinary() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyOctal(input)) {
            wrongInputWarning.setVisible(false);
            this.result = decimalToBinary(octalToDecimal(input));
            resultIs = resultBinary;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
    }

    ///八进制转十六进制
    void octalToHex() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyOctal(input)) {
            wrongInputWarning.setVisible(false);
            this.result = decimalToHex(octalToDecimal(input));
            resultIs = resultHex;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
    }

    ///十六进制转二进制
    void hexToBinary() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyHexNumber(input)) {
            wrongInputWarning.setVisible(false);
            this.result = decimalToBinary(hexToDecimal(input));
            resultIs = resultBinary;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
    }

    ///十六进制转八进制
    void hexToOctal() {
        setSize(940, 702);
        if (input == null) wrongInputWarning.setVisible(false);
        else if (!input.equals("") && isOnlyHexNumber(input)) {
            wrongInputWarning.setVisible(false);
            this.result = decimalToOctal(hexToDecimal(input)) + "";
            resultIs = resultOctal;
            resultJL.setText(resultIs + " " + this.result);
            resultJL.setVisible(true);
        } else wrongInputWarning.setVisible(true);
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
            input = inputJTF.getText().toUpperCase();
            select();
        } else if (code == 27) {
            setVisible(false);
            new Mk10Menu(username);
        }
    }
}
