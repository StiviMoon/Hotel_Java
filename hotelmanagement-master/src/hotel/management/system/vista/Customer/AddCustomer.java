
package hotel.management.system.vista.Customer;

import hotel.management.system.vista.Reception.Reception;
import hotel.management.system.controlador.conexion.Conn;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;


public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tfnumero,tfname,tfpais,tfdeposito;
    JRadioButton rmale,rfemale;                         //algunos elementos instanciados con su tipo
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    
    
    
    public AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);//contenedor
        setLayout(null);
        
        
        //titulo que hace referencia a la pestaña
        JLabel text = new JLabel("FORMULARIO NUEVO CLIENTE");
        text.setBounds(100,20,300,30);// posicionamos el elemento
        text.setFont (new Font("Raleway",Font.PLAIN,20));//definimos los detalles de la fuente
        add(text);// añadimos el elemento a la ventana
        
        
        //añadimos un label  para saber a que hace referencia
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(35,80,100,20);//posicionamos el elemento
        lblid.setFont (new Font("Raleway",Font.PLAIN,20));// detalles de la fuente
        add(lblid);// añadimos el elemento a la ventana
        
        
        // creamos un arreglo para las opciones del tipo de documento
        String  options[] ={"Tarjeta identificacion","Pasaporte","Licencia de conduccion"};
        comboid = new JComboBox(options);//usamos un elemento tipo JComboBox  para tener un desplegable
        comboid.setBounds(200,80,150,25);// posicionamos el elemento  en la ventana
        comboid.setBackground(Color.WHITE);//definimos el fondo de los items del desplegable
        add(comboid);// añadimos el elemento a la ventana
        
        
        //añadimos un label  para saber a que hace referencia
        JLabel lblnumero = new JLabel("NUMERO");
        lblnumero.setBounds(35,120,100,20);//posicionamos el elemento
        lblnumero.setFont (new Font("Raleway",Font.PLAIN,20));// detalles de la fuente
        add(lblnumero);// añadimos el elemento a la ventana
        
        
        // creamos un elemento tipo campo de texto (TextField) lo dejamos vacio para llenar los datos con la base de datos
        tfnumero = new JTextField();
        tfnumero.setBounds(200,120,150,25);// posicionamos el elemento en la ventana
        add(tfnumero);//añadimos el elemtno a la ventana
        
        
        
        //añadimos un label  para saber a que hace referencia
        JLabel lblname = new JLabel("NOMBRE");
        lblname.setBounds(35,160,100,20);// posicionamos el elemto
        lblname.setFont (new Font("Raleway",Font.PLAIN,20));// detalles de la fuente 
        add(lblname); //añadimos  el elemento  a la ventana
        
        
        
         // creamos un elemento tipo campo de texto (TextField) lo dejamos vacio para llenar los datos con la base de datos
        tfname = new JTextField();
        tfname.setBounds(200,160,150,25);//posicionamos el elemento en la ventana
        add(tfname);// añadimos el elemento a la ventana
        
        //añadimos un label  para saber a que hace referencia
        JLabel lblgenero = new JLabel("GENERO");
        lblgenero.setBounds(35,200,100,20);// posicionamos el elemento 
        lblgenero.setFont (new Font("Raleway",Font.PLAIN,20));//configuramos la fuente
        add(lblgenero);//añadimos el elemento 
        
        // creamos un radio buton para la seleccion del genero
        rmale  = new JRadioButton("MASCULINO");
        rmale.setBackground(Color.WHITE);//colocamos el color del elemento pero actua soblre el bloque que esta el texto del radio button
        rmale.setBounds(200,200,100,25);//posicionamos el elemento
        add(rmale);//añadimos el elemento
        
        // creamos un radio buton para la seleccion del genero
        rfemale = new JRadioButton("FEMENINO");
        rfemale.setBackground(Color.WHITE);//colocamos el color del elemento pero actua soblre el bloque que esta el texto del radio button
        rfemale.setBounds(300,200,100,25);//posicionamos el elemento
        add(rfemale);// añadimos el elemento
        
        
        //creamos un elemento tipo ButtonGroup para que los radio buton tengan una sola seleccion 
        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);//añadimos los radio button que habiamos creado para que la restriccion sea efectiva
        bg.add(rfemale);
        
        // creamos un label para saber a que dato hace referencia
        JLabel lblpais = new JLabel("PAIS");
        lblpais.setBounds(35,240,100,20);// posicionamos el elemento
        lblpais.setFont (new Font("Raleway",Font.PLAIN,20));// configuramos la fuente del label
        add(lblpais); // añadimos el elemento
        
        
        
        //creamos un campo de texto vacio para que sea llenado con los datos de la base
        tfpais = new JTextField();
        tfpais.setBounds(200,240,150,25);// posicionamos el eleme
        add(tfpais);
        
        JLabel lblroom = new JLabel("NUMERO HAB");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont (new Font("Raleway",Font.PLAIN,20));
        add(lblroom); 
        
        
        croom = new Choice();// creamos un desplegable para que  sea llenado con los datos de la base
        
        try{
            Conn conn = new Conn();// conexion con la base
            String query = "select * from room where dispo = 'DISPONIBLE'";//orden tipo sql " seleccionar todo de room (habitaciones) donde la  la fila de la columna dispo sea 'DISPONIBLE' y se muestre en la interfaz
            ResultSet rs = conn.s.executeQuery(query);// ejecutamos la orden para mostrar solo las habitaciones disponibles
            while(rs.next()){
                croom.add(rs.getString("numerohab"));// añadimos los valores disponibles de la base ene le choice que vacio que habiamos creado
            }
            
            
        
        }catch(Exception e){
            e.printStackTrace();// muestra los errores en consola
        }
        
        
        
        croom.setBounds(200,280,150,25);//posicionamos el elemento 
        add(croom);//añadimos el elemento choice a la ventana  
        
        
        JLabel lbltime = new JLabel("CHECK IN");//creamos un label para saber a que informacion nos referimos
        lbltime.setBounds(35,320,150,20);// ubicamos el elemento
        lbltime.setFont (new Font("Raleway",Font.PLAIN,20));// detallamos la fuente
        add(lbltime);// añadimos el elemento a la ventanna
        
        Date date = new Date();// creamos un elemento tipo Date para usar la fecha 
        
        
        checkintime = new JLabel("" + date);// añadimos un label y colocamos el elemento tipo date que habiamos creado para poder usar la fecha 
        checkintime.setBounds(200,320,150,25);// posicionamos el elemento
        checkintime.setFont (new Font("Raleway",Font.PLAIN,16));// detalles de la fuente
        add(checkintime);// añadimos el elemento
        
        
        //creamos un label para saber a que dato nos referimos
        JLabel lbldeposito = new JLabel("DEPOSITO");
        lbldeposito.setBounds(35,360,100,20);// posicionamos el elemento
        lbldeposito.setFont (new Font("Raleway",Font.PLAIN,20));// configuramos l a fuente 
        add(lbldeposito); // añadimos el elemento a la ventana
        
        
        
        //creamos un campo de texto vacio 
        tfdeposito = new JTextField();
        tfdeposito.setBounds(200,360,150,25);//posicionamos el elemento 
        add(tfdeposito);// añadimos el elemtno a  la ventana
        
        
        //creamos un boton 
        add= new JButton("AÑADIR");
        add.setBackground(Color.BLACK);//damos el color al boton
        add.setForeground(Color.WHITE);// damos color a la letra del boton
        add.setBounds(50,410,120,30);//posicionamos el boton
        add.addActionListener(this);//añadimos un listener  para darle funcionalidad
        add(add);// añadimos a la ventana
        
        
        //creamos un boton 
        back= new JButton("VOLVER");
        back.setBackground(Color.BLACK);//damos el color al boton
        back.setForeground(Color.WHITE);// damos color a la letra del boton
        back.setBounds(200,410,120,30);//posicionamos el elemtno
        back.addActionListener(this);// añadimos el listener para que tenga funcionalidad
        add(back);// agregamos el boton
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));    //bloque para añadir la imagen
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);         //dimensionarla y añadirla
        ImageIcon i3 = new ImageIcon(i2);                                                 //
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
        
        setBounds(350,200,800,550);// posicion y tamaño de la ventana contenedor
        setVisible(true);// la ventana siempre visible
    
    
    }
    
    public void actionPerformed(ActionEvent ae){// evento
        if(ae.getSource()== add){
            String  id =(String) comboid.getSelectedItem();// guardar la seleccion del desplegable  con el getSelectedItem para pedir el elemento seleccionado 
            String numero = tfnumero.getText();// pedimos el numero que se escribe en el textfield y lo asignamos a una variable que vamos a usar para mandar el dato a la base de datos
            String nombre = tfname.getText();//pedimos el dato del textfield para asignarlo a una variable  y despues mandar el dato a la bd
            String genero = null;// este lo dejamos como null para que  la seleccion sea por medio del condicional  dependiendo de los radiobutton
            
            if(rmale.isSelected()){
                genero = "MASCULINO";
                
            }else{
                genero ="FEMENINO";
            }
            
            String pais = tfpais.getText();
            String hab = croom.getSelectedItem();           // pedimos los datos de los textfield y los asignamos a una variable que los identifique
            String time = checkintime.getText();            //para mandarlos a la base de datos
            String deposito = tfdeposito.getText();
            
            try{
                String query ="insert into customer values('"+id+"','"+numero+"','"+nombre+"','"+genero+"','"+pais+"','"+hab+"','"+time+"','"+deposito+"')";
                //creamos una orden tipo sql para meter los datos que pedimos anteriormente  en la tabla de customer(cliente)
                
                String query2 = "update room set dispo = 'OCUPADA'  where  numerohab = '"+hab+"'";
                //orden tipo sql para actualizar el estado de la habitacion  a ocupada en la columna de dispo pero solo en la fila que el valor de hab es el seleccionado en la columan de numerohab
                
                
                Conn conn = new Conn();// creamos la conexion a la bd
                conn.s.executeUpdate(query);// ejecutamos la primera orden tipo sql que creamos para añadir los valores que pedimos en el formulario
                conn.s.executeUpdate(query2);// ejecutamos la segunda orden para actualizar los datos de la habitacion para cambiar el estado a ocupado
                
                JOptionPane.showMessageDialog(null, "Nuevo cliente añadido exitosamente");// mostramos un mensaje que los datos han sido actualizados
                
                setVisible(false);// ocultamos la ventana
                new Reception();// redireccionamos a la recepcion
                
                
            }catch(Exception e){
                e.printStackTrace();//muestra los errores en la consola 
            }
            
            
            
        }else if (ae.getSource()== back ){// evento del boton volver 
            setVisible(false);// cierra la ventana
                new Reception();// direcciona a la recepcion


        }
    }
    
    
    
    
    public static void main(String[]args){
        new AddCustomer();
    }
    
    
}
