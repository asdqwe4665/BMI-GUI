import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class BMI {
    private JPanel mainPanel;
    private JTextField firstNameTextField;
    private JTextField ageTextField;
    private JTextField lastNameTextField;

    private JButton submitButton;
    private JButton clearButton;
    private JRadioButton largeRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton smallRadioButton;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JSlider heightSlider;
    private JTextField weightTextField;

    private int weight;
    private double age;
    private int height;

    private String weightText;

    private String ageText;
    private double slimness;

    ButtonGroup genderGroup;

    ButtonGroup bodyFrameGroup;

    public BMI() {
        submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            genderGroup = new ButtonGroup();
            genderGroup.add(maleRadioButton);
            genderGroup.add(femaleRadioButton);

            bodyFrameGroup =new ButtonGroup();
            bodyFrameGroup.add(largeRadioButton);
            bodyFrameGroup.add(mediumRadioButton);
            bodyFrameGroup.add(smallRadioButton);


            double heightInCm=height*0.01;
            double bmiStatus=weight/(Math.pow(heightInCm,2));
            double idealWeight= (height-100+(age/10))*0.9* slimness;
            JOptionPane.showMessageDialog(null,"Your BMI is : "+bmiStatus+"\nYour body status is: "+weightStatus(bmiStatus)+ "\nYour ideal weight is: "+ idealWeight+"\nAnd your Actual Weight is: "+weight);

        }
    });
        heightSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                height= heightSlider.getValue();
            }
        });

        largeRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                slimness=1.1;
            }
        });
        mediumRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                slimness=1;
            }
        });
        smallRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                slimness=0.9;
            }
        });


        ageTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ageText= ageTextField.getText();
                age =Integer.parseInt(ageText);
            }
        });
        weightTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                weightText = weightTextField.getText();
                weight = Integer.parseInt(weightText);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNameTextField.setText("");
                lastNameTextField.setText("");
                ageTextField.setText("");
                weightTextField.setText("");

                genderGroup.clearSelection();
                bodyFrameGroup.clearSelection();

                heightSlider.setValue(140);

            }
        });


    }
    public String weightStatus (double bmiStatus) {
        if (bmiStatus < 15) {
            return "Anorexic";
        }
        if (bmiStatus >= 15 && bmiStatus < 18.5) {
            return "Underweight";
        }
        if (bmiStatus >= 18.5 && bmiStatus < 25) {
            return "Normal";
        }
        if (bmiStatus >= 25 && bmiStatus < 30) {
            return "Overweight";
        }
        if (bmiStatus >= 30 && bmiStatus < 35) {
            return "Obese";
        }
        if (bmiStatus >= 35) {
            return "Extreme Obese";
        }
        return "";
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI");
        frame.setContentPane(new BMI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }


}
