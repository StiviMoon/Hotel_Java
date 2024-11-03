
package hotel.management.system.vista.Reception;

import hotel.management.system.controlador.conexion.Conn;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;


public class Checkout extends JFrame implements ActionListener{
    
    
    Choice ccliente;                                       //aqui estan instanciadas algunas de las variables
    JLabel lblnumerhab,lblcheckinttime,lblcheckoutttime; //faltan unas pero me ha dado pereza pasarlas pero se pueden agregar 
    JButton checkout,back;
    
    
    
    Checkout(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Titulo inicial de la ventana a lo que se hace referencia en la pestaña creada
        JLabel text = new JLabel("HORA DE SALIDA");
        text.setBounds(100,20,300,30);
        text.setForeground(Color.BLUE);// Definimos el color de la letra 
        text.setFont(new Font("Tahoma",Font.PLAIN,20));// aqui definimos y especificamos lo de la fuente desde la fuente que yo coloque tahoma pero podria ser arial, despues coloque el Font.PLAIN para que esta fuente sea asi normalita sin estilos adicionales ni negrita ni cursiva ni nada y por ultimo ya el tamaño
        add(text);// añadimos a la ventana
        
        // solo es label para saber que dato se hace referencia
        JLabel lblid = new JLabel("Cliente ID");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        
        
        //desplegable de los clientes que tenemos en  la base
        ccliente = new Choice ();
        ccliente.setBounds(150,80,150,25);
        add(ccliente);
     
        
        // imagen que se encuentra en la pestaña 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png")); //metodo para poder exportar la imagen con la ruta 
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT); // metemos la imagen exportada dentro de otro contenedor tipo "Image" para escalarla y usamos el metodo getScaledInstance que nos sirve para agrandar o achiquitar la imagen y el metodo tiene ancho,alto,y por ultimo es la calidad y velocidad de escalado pero se usa el  por defecto pa no complicarse
        ImageIcon i3 = new ImageIcon(i2);// metemos una vez mas la imagen ya escalada en otro y ultimo imageicon 
        JLabel tick = new JLabel(i3);// agregamos un label y creamos una variable y añadimos un nuevo label que contenga la anterior image icon que es la que contiene todo los escalados
        tick.setBounds(310,80,20,20);// por ultimo usamos el metodo setBounds para posicionar el elemento, este metodo cuenta con datos como (pos x,pos y, ancho, alto) con eso podemos manejar a gusto la posicion y tamaño de la imagen
        add(tick);// fianlemte agregamos la variable que asignamos el label a la pestaña sobre la que estamos trabajando

        
        //creamos un label para identificar el dato que hace referencia
        JLabel lblhabi = new JLabel("Numero Habitacion");
        lblhabi.setBounds(30,130,100,30);//posicionamos el label con el metodo setBounds
        add(lblhabi);// añadimos a la ventana
        
         //creamos un label para identificar el dato que hace referencia
        lblnumerhab = new JLabel(); // en este caso dejamos el label vacio para llenarlo con los datos cargados de la base de datos
        lblnumerhab.setBounds(150,130,100,30);//posicionamos el label con el metodo setBounds
        add(lblnumerhab);// añadimos a la ventana
        
        
        //creamos un label para identificar el dato que hace referencia
        JLabel lblcheckin = new JLabel("Hora de entrada");
        lblcheckin.setBounds(30,180,100,30);//posicionamos el label con el metodo setBounds
        add(lblcheckin);// añadimos a la ventana
        
         //creamos un label para identificar el dato que hace referencia
        lblcheckinttime = new JLabel();// en este caso dejamos el label vacio para llenarlo con los datos cargados de la base de datos
        lblcheckinttime.setBounds(150,180,100,30);//posicionamos el label con el metodo setBounds
        add(lblcheckinttime);// añadimos a la ventana
        
        //creamos un label para identificar el dato que hace referencia
        JLabel lblcheckout = new JLabel("Hora de Salida");
        lblcheckout.setBounds(30,230,100,30);//posicionamos el label con el metodo setBounds
        add(lblcheckout);// añadimos a la ventana
        
        
        Date date= new Date();// creamos una variable tipo Date de la libreria que se exporto para el uso de la fecha y hora que usamos para tener la hora de salida
        
        //creamos un label para identificar el dato que hace referencia
        lblcheckoutttime = new JLabel(""+ date);// colocamos la variable que se creo arriba  de la libreria Date para que esta aparezca en la pestaña
        lblcheckoutttime.setBounds(150,230,150,30);// posicionamos el label
        add(lblcheckoutttime);// añadimos el label a la ventana
        
        
        
       // creamos un boton , la variable solo contiene el nombre por que esta instanciada como JButton en la creacion de la clase  
       checkout = new JButton("CheckOut") ;
       checkout.setBackground(Color.BLACK);// definimos el color de fondo del boton
       checkout.setForeground(Color.WHITE);// definimos el color de la letra del boton
       checkout.setBounds(30,280,120,30);// posicionamos el boton
       checkout.addActionListener(this);// añadimos  el listener al boton para que reaccione cuando se lo pulse y realize la accion que se especifica mas adelante en la conexion con la base de datos
       add(checkout);// añadimos el boton a la ventana
        
       
        // creamos un boton , la variable solo contiene el nombre por que esta instanciada como JButton en la creacion de la clase  
        back = new JButton("Volver") ;
       back.setBackground(Color.BLACK);// definimos el color de fondo del boton
       back.setForeground(Color.WHITE);// definimos el color de la letra del boton
       back.setBounds(170,280,120,30);// posicionamos el boton
       back.addActionListener(this);// añadimos el listener al boton para volver al panel de recepcion
       add(back);// añadimos el boton  a la ventana 
       
       
       //CONEXION A LA BASE DE DATOS
       try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer "); // PEDIR TODOS LOS DATOS DE LA TABLA CLIENTE ( CUSTOMER)
            while(rs.next()){
                  ccliente.add(rs.getString("numero")); // CARGAMOS EL DATOS DE LA TABLA COSTUMER Y LA COLUMNA NUMERO QUE HACE REFERENCIA A LA CEDULA O  NUMERO  DEDOCUMENTO CON EL  QUE SE REGISTRA EL CLIENTE
                  lblnumerhab.setText(rs.getString("hab"));// CARGAMOS EL DATOS DE LA TABLA COSTUMER Y LA COLUMNA HAB QUE SE REFIERE A LA HABITACION  EN LA QUE SE QUEDA EL CLIENTE
                  lblcheckinttime.setText(rs.getString("time"));// CARGAMOS EL DATOS DE LA TABLA COSTUMER Y LA COLUMNA TIME HACE REFERENCIA A LA FECHA EN LA QUE EL CLIENTE HACE EL REGISTRO Y SE ASIGNA LA HABITACION

            }

        }catch(Exception e){
            e.printStackTrace();// este metodo nos muestra en consola si tenemos algun error en el try ya sea en la coneccion con la base de datos o por que se pide un dato y no existe o una tabla entre otras cosas pero principalmente coloca los errores en consola


        }
       
       
       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));//una parte similar a esta
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);//ya la explique arriba
        ImageIcon i6 = new ImageIcon(i5);// pero principalmente se usa para usar una imagen y achiquitarla o agrandarla
        JLabel image = new JLabel(i6);//y posicionamos 
        image.setBounds(350,50,400,250);//y agregamos
        add(image);
        
        setBounds(300,200,800,400);// esto hace parte de la posicion de la ventana que contiene todo lo que se esta añadiendo  anteriormente
        setVisible(true);// decidimos mostrar siempre la ventana claro cuando se requiera

    }
    
    
    
    public void actionPerformed(ActionEvent ae){//vamos a realizar los eventos  que va a tener la clase
        if (ae.getSource()== checkout){// creamos un condicional y usamos el  metodo getSource y lo igualamos a checkout para saber que el boton fue presionado
            String query1= "delete from customer where numero ='"+ccliente.getSelectedItem()+"'";// creamos una query que hacemos referencia a lo que queremos que se ejecute en la base de datos, en este caso entramos a la base de datos y explicitamente "Borramos de la tabla customer(cliente) de la fila numero y especificamos que es lo que queremos borrar en este caso es ccliente que es el dato que se esta extrayendo de la base de datos
            String query2= "update room set dispo = 'DISPONIBLE' where numerohab = '"+lblnumerhab.getText()+"'";// en esta query que ejecutamos  al darle click al boton es para actualizar la informacion de la habitacion de la siguiente manera " actualizamos en la tabla room(habitaciones) con el set cambiamos el valor de la columna dispo que esta hace referencia a disponible o ocupada, por ultimo  con el where decimos en que fila queremos hacer esta actualizacion y llamamos a la variable donde esta guardada la habitacion especifica a modificar
            
            // despues de crear las lineas que queremos ejecutar en la base en caso de que se presione el boton  vamos a conectar con la base para poder ejecutar
            try{
                
                Conn c =  new Conn();//hacemos un llamado a la clase Conn que es donde tenemos la conexion a la base de datos
                c.s.executeUpdate(query1);//  ejecutamos la linea que se creo al iniciar el if
                c.s.executeUpdate(query2);// info adicional la s que esta en la la accion de ejecutar la linea de la base es un statement que esto es para ejecutar las ordenes sql
                
                
                JOptionPane.showMessageDialog(null, "Salida Finalizada");// dentro del try mostramos un mensaje despues de que se realizo la actualizacion de los datos en la base
                setVisible(false);// como ya hemos realizado la actualizacion que es el motivo principal de la clase y la ventan se cambia el estado a false para que esta se oculte
                new Reception();// seguido de esto hacemos el llamado a la clase de reception que es la recepcion que es donde tenemos el menu para realizar mas acciones
                
            }catch(Exception e){
                e.printStackTrace();// esto ya lo explique anteriormente y es solo para que se muestren los errores en consola de una manera mas especifica
            
            }
        
        }else{
            setVisible(false);// esto seria por defecto con el boton de volver por si no queremos actualizar ningun dato y nos metimos por error a la clase de salida
            new Reception();// volvemos al menu de recepcion
        
        }
        
    
    }
    
    public static void main(String[] args){
        new Checkout();
    }
} 

