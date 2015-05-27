import javax.swing.*;

public class groceryStore
{
  public static void main(String[]args)
  {
    String name;
    String item;
    String strInput;
    double price;
    double total = 0.00;
    double paid;
    double change;
    int value;
    
    name = JOptionPane.showInputDialog("Enter your name");
    
    do{
      item = JOptionPane.showInputDialog("Enter item name");
      strInput = JOptionPane.showInputDialog("Enter price");
      price = Double.parseDouble(strInput);
      total = total + price;
      value = JOptionPane.showConfirmDialog(null,"Is that all?","Please Confirm",JOptionPane.YES_NO_OPTION);
    }while(value ==JOptionPane.NO_OPTION);
    
    strInput = JOptionPane.showInputDialog("Total is "+total+". Enter money given");
    paid = Double.parseDouble(strInput);
    change = paid-total;
    JOptionPane.showMessageDialog(null,"Give "+change+" in change");
  }
}