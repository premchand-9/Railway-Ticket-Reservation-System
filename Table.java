import javax.swing.*;  
public class Table {    
    JFrame f;    
    Table(){    
    f=new JFrame();    
    String data[][]={ {"101","Amit","670000"},    
                          {"102","Jai","780000"},    
                          {"101","Sachin","700000"}};    
    String column[]={"ID","NAME","SALARY"};
    String dat[]= {"1","2","3"};
    data[2]=dat;
    JTable jt=new JTable(data,column);    
    jt.setBounds(30,40,1000,1000);          
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp); 
    f.setSize(300,400);    
    f.setVisible(true);    
}     
public static void main(String[] args) {    
    new Table();    
}    
}  