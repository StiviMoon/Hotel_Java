
package hotel.management.system.vista.Reception;


import hotel.management.system.controlador.conexion.Conn;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    Choice ccliente;
    JTextField tfhab,tfname,tfcheckin,tfpago,tfpend;
    JButton check,act,back;
    
    
    
    UpdateCheck(){
        
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
      // Titulo inicial de la ventana a lo que se hace referencia en la pestaña creada
     JLabel text = new JLabel ("Actualizar Estado");
     text.setFont(new Font("Tahoma",Font.PLAIN,20));// aqui definimos y especificamos lo de la fuente desde la fuente que yo coloque tahoma pero podria ser arial, despues coloque el Font.PLAIN para que esta fuente sea asi normalita sin estilos adicionales ni negrita ni cursiva ni nada y por ultimo ya el tamaño
     text.setBounds(90,20,200,30);// posicionamos el elemento 
     text.setForeground(Color.BLUE);//Color de la letra
     add(text);// añadimos el elemento
     
     
     // creamos un label para saber a que nos referimos
     JLabel lblid = new JLabel ("ID CLIENTE");
     lblid.setBounds(30,80,100,30);  // posicionamos el label en la ventana    
     add(lblid);// añadimos el label a la ventana
     
     
     //creamos un desplegable vacio, por que se usa con la bd
     ccliente = new Choice ();
     ccliente.setBounds(200,80,150,25); // posicionamos el elemento
     add(ccliente);//añadimos el elemento
     
     try{
         Conn c = new Conn();//conexion con la bd
         ResultSet rs = c.s.executeQuery("select * from customer ");// orden tipo sql "selecciona todo de customer( pide todos los datos de la tabla
         while(rs.next()){//
               ccliente.add(rs.getString("numero"));//pide el dato de la base de datos de la tabal customer y la columna numero y lo agrega al choice vacio que creamos anteriormente
         
         }
     
     }catch(Exception e){
         e.printStackTrace();//errores consola
     
     
     }
     
     
     // creamos un label para saber a que nos referimos  
     JLabel lblhab = new JLabel ("NUMERO HABITACION");
     lblhab.setBounds(30,120,200,30);    // posicionamos el label en la ventana 
     add(lblhab);  // añadimos el label a la ventana
     
      //creamos un espacio de texto vacio para llenarlo con info de la base de datos
     tfhab = new JTextField();
     tfhab.setBounds(200,120,150,25);//posicionamos el elemento
     add(tfhab);// añadimos el elemento
    
     
      // creamos un label para saber a que nos referimos 
     JLabel lblname = new JLabel ("NOMBRE");
     lblname.setBounds(30,160,100,30);   // posicionamos el label en la ventana   
     add(lblname);  // añadimos el label a la ventana
     
      //creamos un espacio de texto vacio para llenarlo con info de la base de datos
     tfname = new JTextField();
     tfname.setBounds(200,160,150,25);//posicionamos el elemento
     add(tfname);
     
     
      // creamos un label para saber a que nos referimos 
     JLabel lblcheckin = new JLabel ("CHECK IN");
     lblcheckin.setBounds(30,200,100,30);   // posicionamos el label en la ventana   
     add(lblcheckin);  // añadimos el label a la ventana
     
     //creamos un espacio de texto vacio para llenarlo con info de la base de datos
     tfcheckin = new JTextField();
     tfcheckin.setBounds(200,200,150,25);//posicionamos el elemento
     add(tfcheckin);
     
      // creamos un label para saber a que nos referimos 
     JLabel lblpago = new JLabel ("MONTO DE PAGO");
     lblpago.setBounds(30,240,200,30);    // posicionamos el label en la ventana  
     add(lblpago);  // añadimos el label a la ventana
     
     //creamos un espacio de texto vacio para llenarlo con info de la base de datos
     tfpago = new JTextField();
     tfpago.setBounds(200,240,150,25);//posicionamos el elemento
     add(tfpago);
     
      // creamos un label para saber a que nos referimos 
     JLabel lblpend = new JLabel ("MONTO PENDIENTE");
     lblpend.setBounds(30,280,200,30);    // posicionamos el label en la ventana    
     add(lblpend);  // añadimos el label a la ventana
     
     //creamos un espacio de texto vacio para llenarlo con info de la base de datos
     tfpend = new JTextField();
     tfpend.setBounds(200,280,150,25);//posicionamos el elemento
     add(tfpend);
     
     
     //creamos un boton
     check = new JButton("CONSULTAR");
     check.setBackground(Color.BLACK);//color del boton
     check.setForeground(Color.WHITE);// color de la letra
     check.setBounds(30, 340, 120, 30);//posicionamos el elemento
     check.addActionListener(this);//damos un listener para tener funcionalidad
     add(check);
     
      //creamos un boton
     act = new JButton("ACTUALIZAR");
     act.setBackground(Color.BLACK);//color del boton
     act.setForeground(Color.WHITE);// color de la letra
     act.setBounds(160, 340, 120, 30);//posicionamos el elemento
     act.addActionListener(this);//damos un listener para tener funcionalidad
     add(act);
     
     
     
      //creamos un boton
     back = new JButton("VOLVER");
     back.setBackground(Color.BLACK);//color del boton
     back.setForeground(Color.WHITE);// color de la letra
     back.setBounds(290, 340, 120, 30);//posicionamos el elemento
     back.addActionListener(this);//damos un listener para tener funcionalidad
     add(back);
     
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));//añadimos la imagen con la ruta
     JLabel image = new JLabel(i1);// convertimos la imagene en un label
     image.setBounds(400, 50, 500, 300);//posicionamos el elemento
     add(image);//añadimos
     
     
    setBounds(100,200,1080,500);//dimension y posicion de la ventan
    setVisible(true);//ventana visible
    }
   
    public void actionPerformed(ActionEvent ae){//evento
        if (ae.getSource() == check){//evento por el click en el boton check
            String id = ccliente.getSelectedItem();// asignamos el valor seleccionado en el desplegable como valor de id
            String query = "select * from customer where numero = '"+id+"'";// orden tipo sql " seleccionar todo de customer(cliente) cuando la fila sea el valor de id en la columna de numero 
            try{
                Conn c = new Conn();//conexion a la bd
                ResultSet rs = c.s.executeQuery(query);// ejecutar la orden de sql que definimos anteriormente
                while (rs.next()){
                    tfhab.setText(rs.getString("hab"));         // asignamos los valores de las tablas  y los seteamos en las variables que se anteponen
                    tfname.setText(rs.getString("nombre"));     //con el metodo getString (" es de la columna de donde se saca cada dato")
                    tfcheckin.setText(rs.getString("time"));
                    tfpago.setText(rs.getString("deposito"));
            }
            
                
                ResultSet rs2 = c.s.executeQuery("select * from room where  numerohab = '"+tfhab.getText()+"'");// orden tipo sql " seleccionar todo de room(habitaciones) cuando el valor de la columna numerohab sea el que se pide en la variable de tfhab 
                while(rs2.next()){
                    String precio = rs2.getString("precio");// ahora con la orden anterior vamos a la columna  de precio pero por la misma fila que se especifica en la orden anterior para saber el precio de la habitacion que solicitamos antes
                    int montopago = Integer.parseInt(precio)- Integer.parseInt(tfpago.getText());// definimos como entero  la variable  de precio y tf pago y la restamos
                    tfpend.setText(""+ montopago);// con esa resta obtenemos el valor pendiente que tiene el cliente de la habitacion
                }
            }catch (Exception e){
                e.printStackTrace();// mostrar errores en consola 
            
            }
            
            
            
        
        }else if(ae.getSource() == act){// accion con el boton
            String numero = ccliente.getSelectedItem();
            String hab = tfhab.getText();
            String nombre = tfname.getText();                   //datos solicitados
            String checkin = tfcheckin.getText();
            String deposito = tfpago.getText();
            
            
            
            try{
                Conn c = new Conn();//conexion a la bd
                
                //orden tipo sql y de tipo update para actualizar los datos que pedimos en las anteriores consultas  y especificamos  en que columna va y que variable que contiene el dato se remplaza
                c.s.executeUpdate("update customer set hab = '"+hab+"', nombre = '"+nombre+"', time= '"+checkin+"',deposito= '"+deposito+"' where numero = '"+numero+"' ");
                
                
                
                JOptionPane.showMessageDialog(null,"DATOS ACTUALIZADOS CORRECTAMENTE");//mostramos un mensaje para notificar que los datos se actualizaron
                
                setVisible(false);// ocultamos la ventana
                new Reception();//nos redirige a la recepcion
            
            
            }catch(Exception e){
                e.printStackTrace();//muestra errores
            }
        
        }else{//boton de back
            setVisible(false);//ocultamos la ventana
            new Reception();//nos redirige a la recepcion
            
        
        }
    
    
    }
    
    public static void main(String[]args){
        new UpdateCheck();    
    }
            
            
}
