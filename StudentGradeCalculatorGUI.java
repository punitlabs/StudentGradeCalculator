import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentGradeCalculatorGUI extends JFrame implements ActionListener {
    private JTextField[] marksFields;
    private JTextArea resultArea;
    private JButton calcButton;
    private int subjects = 3; // You can change this if needed

    public StudentGradeCalculatorGUI() {
        setTitle("Student Grade Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Enter marks for " + subjects + " subjects:"));
        marksFields = new JTextField[subjects];
        for (int i = 0; i < subjects; i++) {
            marksFields[i] = new JTextField(10);
            add(new JLabel("Subject " + (i + 1) + ": "));
            add(marksFields[i]);
        }

        calcButton = new JButton("Calculate Grade");
        calcButton.addActionListener(this);
        add(calcButton);

        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int total = 0;
        try {
            for (JTextField field : marksFields) {
                total += Integer.parseInt(field.getText());
            }

            double average = (double) total / subjects;
            char grade;

            if (average >= 90) grade = 'A';
            else if (average >= 75) grade = 'B';
            else if (average >= 60) grade = 'C';
            else if (average >= 40) grade = 'D';
            else grade = 'F';

            resultArea.setText("Total: " + total + "\nAverage: " + average + "\nGrade: " + grade);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new StudentGradeCalculatorGUI();
    }
}
