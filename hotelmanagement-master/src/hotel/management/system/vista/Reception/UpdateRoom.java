
package hotel.management.system.vista.Reception;


import hotel.management.system.controlador.conexion.Conn;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice ccliente;
    JTextField tfhab,tfdispo,tfestado;
    JButton check,act,back;
    
    
    
    UpdateRoom(){
        
     getContentPane().setBackground(Color.WHITE);
     setLayout(null);
     
     // Titulo inicial de la ventana a lo que se hace referencia en la pestaña creada
     JLabel text = new JLabel ("Actualizar Habitacion");
     text.setFont(new Font("Tahoma",Font.PLAIN,25));// aqui definimos y especificamos lo de la fuente desde la fuente que yo coloque tahoma pero podria ser arial, despues coloque el Font.PLAIN para que esta fuente sea asi normalita sin estilos adicionales ni negrita ni cursiva ni nada y por ultimo ya el tamaño
     text.setBounds(30,20,250,30);// posicionamos el elemento 
     text.setForeground(Color.BLUE);//color de la letra
     add(text);// añadimos el elemento
     
     JLabel lblid = new JLabel ("ID CLIENTE");// creamos un label para saber a que nos referimos
     lblid.setBounds(30,80,100,30);  // posicionamos el label en la ventana  
     add(lblid);// añadimos el label a la ventana
     
     ccliente = new Choice ();// creamos un choice(desplegable) este va a tener los datos de la base 
     ccliente.setBounds(200,80,150,25);// posicionamos el label en la ventana  
     add(ccliente);// añadimos el label a la ventana
     
     try{
         Conn c = new Conn();// conexion con la base de datos
         ResultSet rs = c.s.executeQuery("select * from customer ");//orden tipo sql "seleccionar todo de customer(cliente) 
         while(rs.next()){//ejecutamos la orden y nos vamos a la columna
               ccliente.add(rs.getString("numero"));// pedimos los datos que se encuentra en numero(columna) 
         
         }
     
     }catch(Exception e){
         e.printStackTrace();// ver errores en consola
     
     
     }
     
     
      // creamos un label para saber a que nos referimos  
     JLabel lblhab = new JLabel ("NUMERO HABITACION");
     lblhab.setBounds(30,130,200,30); // posicionamos el label en la ventana     
     add(lblhab);  // añadimos
     
     // creamos un campo de texto(TEXTFIELD)  lo dejamos vacio por que se completa con los datos que se piden de la base 
     tfhab = new JTextField();
     tfhab.setBounds(200,130,150,25);// posicionamos el elemento
     add(tfhab);
    
     
      // creamos un label para saber a que nos referimos  
     JLabel lblname = new JLabel ("DISPONIBILIDAD");
     lblname.setBounds(30,180,100,30); // posicionamos el elemento   
     add(lblname);  // añadimos el elemento
     
     // creamos un campo de texto(TEXTFIELD)  lo dejamos vacio por que se completa con los datos que se piden de la base 
     tfdispo = new JTextField();
     tfdispo.setBounds(200,180,150,25);// posicionamos el elemento
     add(tfdispo);//añadimos el elemento
     
     
      // creamos un label para saber a que nos referimos  
     JLabel lblcheckin = new JLabel ("ESTADO DE LIMPIEZA");
     lblcheckin.setBounds(30,230,200,30);  // posicionamos el elemento  
     add(lblcheckin);  // añadimos el elemento
     
     
     
     
     // creamos un campo de texto(TEXTFIELD)  lo dejamos vacio por que se completa con los datos que se piden de la base 
     tfestado = new JTextField();
     tfestado.setBounds(200,230,150,25);// posicionamos el elemento
     add(tfestado);// añadimos el elemento
     
     
     // creamos un boton para hacer las consultas con la base
     check = new JButton("CONSULTAR");
     check.setBackground(Color.BLACK);// asignamos el color del boton
     check.setForeground(Color.WHITE);//color de la letra del boton
     check.setBounds(30, 300, 120, 30);// posicionamos el elemento
     check.addActionListener(this);//le damos un listener al boton para tener funcionalidad 
     add(check);// añadimos el boton
     
     // creamos un boton para hacer las consultas con la base
     act = new JButton("ACTUALIZAR");
     act.setBackground(Color.BLACK);// asignamos el color del boton
     act.setForeground(Color.WHITE);//color de la letra del boton
     act.setBounds(160, 300, 120, 30);// posicionamos el elemento
     act.addActionListener(this);//le damos un listener al boton para tener funcionalidad 
     add(act);// añadimos el elemento
     
     
     // creamos un boton
     back = new JButton("VOLVER");
     back.setBackground(Color.BLACK);// asignamos el color del boton
     back.setForeground(Color.WHITE);//color de la letra del boton
     back.setBounds(290, 300, 120, 30);// posicionamos el elemento
     back.addActionListener(this);//le damos un listener al boton para tener funcionalidad 
     add(back);// añadimos el elemento
     
     
     // imagen que se encuentra en la pestaña 
     ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));//metodo para poder exportar la imagen con la ruta
     Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);// metemos la imagen exportada dentro de otro contenedor tipo "Image" para escalarla y usamos el metodo getScaledInstance que nos sirve para agrandar o achiquitar la imagen y el metodo tiene ancho,alto,y por ultimo es la calidad y velocidad de escalado pero se usa el  por defecto pa no complicarse
     ImageIcon i3 = new ImageIcon(i2);// metemos una vez mas la imagen ya escalada en otro y ultimo imageicon 
     JLabel image = new JLabel(i3);// agregamos un label y creamos una variable y añadimos un nuevo label que contenga la anterior image icon que es la que contiene todo los escalados
     image.setBounds(450, 50, 500, 300);// posicionamos el elemento
     add(image);// añadimos el elemento
     
     
    setBounds(200,200,1000,450);// esto hace parte de la posicion de la ventana que contiene todo lo que se esta añadiendo  anteriormente
    setVisible(true);// decidimos mostrar siempre la ventana claro cuando se requiera
    }
   
    public void actionPerformed(ActionEvent ae){// evento
        if (ae.getSource() == check){// evento si el boton check es clickado
            String id = ccliente.getSelectedItem();// aqui pedimos lo que el usuario selecciono del desplegable
            String query = "select * from customer where numero = '"+id+"'";// creamos una orden tipo sql " seleccionar todo de customer (cliente) de la fila  cuando la columna de numero  tenga la seleccion del desplegable----------- en cuestion si  el id que se selecciona del desplegable esta en la columna de numero se  piden todos los datos que corresponden a ese id ( esto es lo que hace el where)
            try{
                Conn c = new Conn();// conexion con  la base de datoos
                ResultSet rs = c.s.executeQuery(query);//ejecutamos la orden sql
                while (rs.next()){
                    tfhab.setText(rs.getString("hab"));//asignamos el valor con el setText que se pide a la base de datos en la columna hab
                    
            }
            
                
                ResultSet rs2 = c.s.executeQuery("select * from room where  numerohab = '"+tfhab.getText()+"'");// orden tipo sql " seleccionar todo de room(habitaciones)  de la fila que corresponde tfhab que es la variable le asignamos el valor en la anterior orden y ese  valor lo comparamos en la columna de  numerohab en la tabla de room
                while(rs2.next()){
                    tfdispo.setText(rs2.getString("dispo"));//asignamos el valor  que nos de la base de datos despues de ejecutar la anterior orden y tomamos el valor que este en la columna dispo
                    tfestado.setText(rs2.getString("estado"));//asignamos el valor  que nos de la base de datos despues de ejecutar la anterior orden y tomamos el valor que este en la columna estado
                }
            }catch (Exception e){
                e.printStackTrace();// ver errores en consola de bd
            
            }
            
            
            
        
        }else if(ae.getSource() == act){// metodo getSource para saber si se dio click en el boton
            
            String hab = tfhab.getText();
            String disponile = tfdispo.getText(); // datos que recolectamos de las anteriores ordenes sql
            String estado = tfestado.getText();
            
            
            
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update room set dispo = '"+disponile+"', estado = '"+estado+"' where numerohab = '"+hab+"' ");// ejecutamos una orden sql de tipo update para actualizar  los datos que ya pedimos en las anteriores ordenes sql 
                
                JOptionPane.showMessageDialog(null,"DATOS ACTUALIZADOS CORRECTAMENTE");// mostramos un mensaje que se actualizaron
                
                setVisible(false);//ocultamos la ventana
                new Reception();// mostramos la recepcion
            
            
            }catch(Exception e){
                e.printStackTrace();// mostrar errores consola
            }
        
        }else{//boton volver
            setVisible(false);// ocultamos ventana
            new Reception();// vamos a recepcion
            
        
        }
    
    
    }
    
    public static void main(String[]args){
        new UpdateRoom();    
    }
            
            
}
