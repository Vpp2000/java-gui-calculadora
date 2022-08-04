import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    double op1=0,op2=0,M=0;
    String operacion="";
    boolean nueva=true;  // "true" si la pantalla esta vacia, "false" si la pantalla tiene algun valor
    boolean on_off=true;
    boolean operation=true;
    boolean decimal=true;

    public int cont=0;
    String botonns[][] ={ {"OFF","MRC","M-","M+","/"},{"%","7","8","9","X"},{"sqrt","4","5","6","-"},{"C","1","2","3","+"}};
    String botonns2[]={"AC","0",".","="};
    JTextField texto= new JTextField(9);

    public JButton bot_or= new JButton("inv/sqrt");

    public 	JButton botones[][]= new JButton[4][5];
    public JButton bots[]=new JButton[4];
    public	JLabel lab1= new JLabel("     CASIO");
    public	JLabel lab2= new JLabel("ELECTRONIC CALCULATOR");


    public Ventana(){
        super("Calculadora");
        Container cpp = getContentPane();
        cpp.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();

        cons.gridx=2;
        cons.gridy=0;
        cons.gridwidth=1;
        cons.gridheight=1;
        cpp.add(lab1,cons);

        cons.gridx=1;
        cons.gridy=1;
        cons.gridwidth=5;
        cons.gridheight=1;
        cpp.add(lab2,cons);

        cons.gridx=0;
        cons.gridy=1;
        cons.gridwidth=1;
        cons.gridheight=1;
        bot_or.setBackground(Color.orange);
        cpp.add(bot_or,cons);

        cons.gridx=0;
        cons.gridy=2;
        cons.fill=GridBagConstraints.BOTH;
        cons.gridwidth=5;
        cons.gridheight=1;
        cpp.add(texto,cons);


        int c=3;
        for(int i=0 ; i<4 ; i++){

            for(int j=0 ; j<5 ; j++ ){
                cons.gridy=c;
                cons.gridx=j;
                if(i==3 && j==4){
                    cons.gridwidth=1;
                    cons.gridheight=2;
                }
                else{
                    cons.gridwidth=1;
                    cons.gridheight=1;
                }
                cpp.add(botones[i][j]=new JButton(botonns[i][j]),cons);
            }
            c++;
        }
        for(int i=0 ; i<4 ; i++)
        {	cons.gridy=7;
            cons.gridx=i;
            cons.gridwidth=1;
            cons.gridheight=1;
            cpp.add(bots[i]= new JButton(botonns2[i]),cons);
        }



        for(int i=0; i<4 ; i++ ){
            for(int j=0; j<5 ; j++){
                botones[i][j].addActionListener(this);
            }
        }

        for(int i=0 ; i<4 ; i++)
            bots[i].addActionListener(this);
        bot_or.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(bots[0])){   //el boton de encendido
            on_off=false;
            op1=0;
            op2=0;
            operation=true;
            decimal=true;
            texto.setText("0");
            nueva=true;
        }
        if(e.getSource().equals(botones[0][0])){  // el boton de apagado

            on_off=true;
            op1=0;
            op2=0;
            cont=0;
            decimal=true;
            botones[2][0].setText("sqrt");
            texto.setText("");
        }
        if(on_off==false){   // aqui se prende la calculadora y se empieza a digitar


            if(e.getSource().equals(bots[2])){
                if(decimal==true){
                    if(nueva){texto.setText("");nueva=false;}{
                        texto.setText(texto.getText()+".");
                        decimal=false;
                    }

                }
            }




            if(e.getSource().equals(botones[1][0])){  // el operador porcentaje
                try{op2=Double.parseDouble(texto.getText());
                    double rest=op1*op2*0.01;
                    operation=true;
                    op2=op1=0;
                    nueva=true;
                    texto.setText(String.valueOf(rest));
                    decimal=true;
                }
                catch(Exception err){}
            }

            if(e.getSource().equals(bot_or)){  // el bendito boton naranja
                ++cont;
                if(cont%2==0)
                    botones[2][0].setText("sqrt");
                else
                    botones[2][0].setText("1/x");

                decimal=true;
            }

            if(cont%2==0){
                if(e.getSource().equals(botones[2][0])){ // la raiz cuadrada

                    try{
                        if(op1!=0)
                            op2=op1*Double.parseDouble(texto.getText());
                        else
                            op2=Double.parseDouble(texto.getText());
                        op2=Math.sqrt(op2);
                        texto.setText(String.valueOf(op2));
                        operation=true;
                        nueva=true;
                    }catch(Exception err){}

                    decimal=true;}}
            else{
                if(e.getSource().equals(botones[2][0])){ // la inversa de un numero

                    try{

                        double res=(1/Double.parseDouble(texto.getText()));
                        texto.setText(String.valueOf(res));
                        nueva=true;

                    }catch(Exception err){}

                    decimal=true;}

            }


            if(e.getSource().equals(bots[1])){  //el numero 0
                if(nueva){
                    texto.setText("");
                    nueva=false;}
                texto.setText(texto.getText()+"0");
            }
            if(e.getSource().equals(botones[3][1])){  //el numero 1
                if(nueva){
                    texto.setText("");
                    nueva=false;}
                texto.setText(texto.getText()+"1");
            }
            if(e.getSource().equals(botones[3][2])){  // el numero 2
                if(nueva){
                    texto.setText("");
                    nueva=false;}
                texto.setText(texto.getText()+"2");
            }

            if(e.getSource().equals(botones[3][3])){   // el numero 3
                if(nueva){
                    texto.setText("");
                    nueva=false;}
                texto.setText(texto.getText()+"3");
            }
            if(e.getSource().equals(botones[1][1])){       // el numero 7
                if(nueva){
                    texto.setText("");
                    nueva=false;}
                texto.setText(texto.getText()+"7");
            }
            if(e.getSource().equals(botones[1][2])){     // el numero 8
                if(nueva){
                    texto.setText("");
                    nueva=false;}
                texto.setText(texto.getText()+"8");
            }
            if(e.getSource().equals(botones[1][3])){   // el numero 9
                if(nueva){
                    texto.setText("");
                    nueva=false;}
                texto.setText(texto.getText()+"9");
            }
            if(e.getSource().equals(botones[2][1])){   // el numero 4
                if(nueva){
                    texto.setText("");
                    nueva=false;}
                texto.setText(texto.getText()+"4");
            }
            if(e.getSource().equals(botones[2][2])){   // el numero 5
                if(nueva){
                    texto.setText("");
                    nueva=false;}
                texto.setText(texto.getText()+"5");
            }
            if(e.getSource().equals(botones[2][3])){   // el numero 6
                if(nueva){
                    texto.setText("");
                    nueva=false;}
                texto.setText(texto.getText()+"6");
            }
            if(e.getSource().equals(botones[3][0])){  // boton que borra el ultimo numero
                texto.setText("");
                decimal=true;

            }
            if(e.getSource().equals(botones[1][4])){  //la multiplicacion
                try{
                    if(op1!=0){
                        if(operacion.equals("suma")){
                            op1=op1+Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("resta")){
                            op1=op1-Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("multiplicacion")){
                            op1=op1*Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("division")){

                            op1=op1/Double.parseDouble(texto.getText());

                        }
                    }
                    else
                        op1=Double.parseDouble(texto.getText());
                    operacion="multiplicacion";
                    operation=false;
                    texto.setText("");
                    decimal=true;

                }catch(Exception err){}
            }
            if(e.getSource().equals(botones[3][4])){  // la operacion suma
                try{
                    if(op1!=0){
                        if(operacion.equals("suma")){
                            op1=op1+Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("resta")){
                            op1=op1-Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("multiplicacion")){
                            op1=op1*Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("division")){

                            op1=op1/Double.parseDouble(texto.getText());


                        }
                    }
                    else
                        op1=Double.parseDouble(texto.getText());
                    operacion="suma";
                    operation=false;
                    texto.setText("");
                    decimal=true;

                }catch(Exception err){}
            }

            if(e.getSource().equals(botones[2][4])){   //  la operacion resta
                try{
                    if(op1!=0){
                        if(operacion.equals("suma")){
                            op1=op1+Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("resta")){
                            op1=op1-Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("multiplicacion")){
                            op1=op1*Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("division"))
                        {
                            op1=op1/Double.parseDouble(texto.getText());



                        }
                    }
                    else
                        op1=Double.parseDouble(texto.getText());
                    operacion="resta";
                    operation=false;
                    texto.setText("");
                    decimal=true;

                }catch(Exception err){}

            }

            if(e.getSource().equals(botones[0][4])){  // la operacion division
                try{
                    if(op1!=0){
                        if(operacion.equals("suma")){
                            op1=op1+Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("resta")){
                            op1=op1-Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("multiplicacion")){
                            op1=op1*Double.parseDouble(texto.getText());

                        }
                        else
                        if(operacion.equals("division")){

                            op1=op1/Double.parseDouble(texto.getText());

                        }
                    }
                    else
                        op1=Double.parseDouble(texto.getText());
                    operacion="division";
                    operation=false;
                    texto.setText("");
                    decimal=true;
                }catch(Exception err){

                }

            }

            if(e.getSource().equals(bots[3])){  // el boton de igual


                try{
                    op2=Double.parseDouble(texto.getText());
                }catch(Exception err){}
                if(operacion.equals("suma")){
                    double res=op1+op2;
                    texto.setText(String.valueOf(res));
                    op1=op2=0;
                    operacion="";
                }else if(operacion.equals("resta")){
                    double res=op1-op2;
                    texto.setText(String.valueOf(res));
                    op1=op2=0;
                    operacion="";
                }else if(operacion.equals("multiplicacion")){
                    double res=op1*op2;
                    texto.setText(String.valueOf(res));
                    op1=op2=0;
                    operacion="";
                }else if(operacion.equals("division")){
                    double res=op1/op2;

                    texto.setText(String.valueOf(res));
                    op1=op2=0;
                    operacion="";
                }
                nueva=true;
                operation=true;
                decimal=true;

            }
            if(e.getSource().equals(botones[0][2])){

                M=M-Double.parseDouble(texto.getText());
            }
            if(e.getSource().equals(botones[0][3])){

                M=M+Double.parseDouble(texto.getText());
            }


        }

    }
}
