//Kevin Fitzgerald
//Exam 2
//5/5/2015
//Purpose: Help people determine BMI

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

public class bmiCalculator extends JFrame
{
  private double weight,height,age,bmi,maxHeart,kiloWeight,iWeight;
  private JButton calculate;
  private JPanel display;
  private JTextField w,h,a,b,m,t,i;
  private JLabel wt,ht,ae,bi,mt,tt,it,pound,inches;
  private JRadioButton male,female;
  private ButtonGroup gender;
  private JTable table;
  String[] colNames = {"BMI","Max Heart Rate","Target Heart Rate","Ideal Weight","Status"};
  String tarHeart,status;
  DecimalFormat df = new DecimalFormat("###.#");
  
  public bmiCalculator()
  {
    super("BMI Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    setPreferredSize(new Dimension(125, 220));
    display = new JPanel();
    wt = new JLabel("Weight:");//Weight section
    w = new JTextField(3);
    pound = new JLabel("Lb.");
    
    ht = new JLabel("Height:");//Height section
    h = new JTextField(3);
    inches = new JLabel("in.");
    
    ae = new JLabel("Age:");//Age 
    a = new JTextField(3);
    
    male = new JRadioButton("Male");//Gender
    female = new JRadioButton("Female");
    gender = new ButtonGroup();
    gender.add(male);
    gender.add(female);
    
    calculate = new JButton("Calculate");//Button
    calculate.addActionListener(new calculateListener());
    
    add(wt);
    add(w);
    add(pound);
    add(ht);
    add(h);
    add(inches);
    add(ae);
    add(a);
    add(male);
    add(female);
    add(calculate);
    
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  private class calculateListener implements ActionListener//Math is done here
  {
    public void actionPerformed(ActionEvent e)
    {
      weight = Double.parseDouble(w.getText());
      height = Double.parseDouble(h.getText());
      age = Double.parseDouble(a.getText());
      
      bmi = ((weight*703)/(height*height));//calculates bmi
      maxHeart = 220-age;//calculates max heart rate
      tarHeart = (maxHeart*0.5)+" - "+(maxHeart*0.8);//calculates target heart rate
      
      double cmHeight = height*2.54;//converts inches to centimenters
      if(male.isSelected())//male selected
        kiloWeight = (cmHeight-100)-((cmHeight-100)*0.1);
      if(female.isSelected())//female selected
        kiloWeight = (cmHeight-100)+((cmHeight-100)*0.15);
      
      iWeight = kiloWeight * 2.2046;//Ideal weight in pounds
      if(bmi>=19.0 && bmi<=24.0)//Determines where person is on status scale
        status = "Normal";
      else if(bmi>=24.1 && bmi<=29.0)
        status = "Overweight";
      else if(bmi>=29.1 && bmi<=39.0)
        status = "Obese";
      else if(bmi>=39.1)
        status = "Extreme Obesity";
      else
        status = "null";
      
      JFrame frame1 = new JFrame("Results");//The following code creates the table for display
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.setLayout(new BorderLayout());
      DefaultTableModel model = new DefaultTableModel();
      model.setColumnIdentifiers(colNames);

      table = new JTable();
      table.setModel(model);
      table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      table.setFillsViewportHeight(true);
      JScrollPane scroll = new JScrollPane(table);
      scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
      model.addRow(new Object[]{df.format(bmi),df.format(maxHeart),tarHeart,df.format(iWeight),status});//Inputs the data to display in the table
      
      frame1.add(scroll);
      frame1.setVisible(true);
      frame1.setLocationRelativeTo(null);
      frame1.pack();
    }
  }
  
  public static void main(String[] args)//main method
 {
  new bmiCalculator();
 }
  
}