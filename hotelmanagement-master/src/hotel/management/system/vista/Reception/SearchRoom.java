
package hotel.management.system.vista.Reception;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;// base de datos

import hotel.management.system.controlador.conexion.Conn;
import net.proteanit.sql.*;// algunas funcionalidades extras para facilitar el manejo de bd y tablas




public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,enviar;// instancias de algunos elementos, se puede colocar los que faltan de igual forma o dejarlos asi
    JComboBox tipocama;
    JCheckBox disponible;
    
    
    SearchRoom(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        // Titulo inicial de la ventana a lo que se hace referencia en la pestaña creada
        JLabel text = new JLabel ("Buscar Habitacion");
        text.setFont(new Font("Tahoma", Font.PLAIN,20));// aqui definimos y especificamos lo de la fuente desde la fuente que yo coloque tahoma pero podria ser arial, despues coloque el Font.PLAIN para que esta fuente sea asi normalita sin estilos adicionales ni negrita ni cursiva ni nada y por ultimo ya el tamaño
        text.setBounds(400,30,200,30);// posicionamos el elemento 
        add(text);// añadimos el elemento 
        
        JLabel lblcama = new JLabel ("Tipo de Cama");// creamos un label para saber a que nos referimos
        lblcama.setBounds(50,100,100,20);// posicionamos el label en la ventana
        add(lblcama);// añadimos el label a la ventana
        
        
        tipocama = new JComboBox (new String[]{"CAMA SENCILLA","CAMA DOBLE"});// usamos un combobox para crear un desplegable con las opciones que tenemos
        tipocama.setBounds(150,100,150,25);// posicionamos el elemento
        tipocama.setBackground(Color.WHITE);// colocamos el fondo del desplegable
        add(tipocama);//añadimos el elemento a la ventana
        
        
        disponible =  new JCheckBox("SOLO MOSTRAR DISPONIBLES");//añadimos un check box para poder visualizar solo las habitaciones disponibles
        disponible.setBounds(650,100,350,25);// usamos setBounds para posicionar el elemento
        disponible.setBackground(Color.WHITE);// damos  fondo al elemento( no al cuadro de seleccion sino al cuadro o espacio donde esta el texto)
        add(disponible);//añadimos el elemento
        
        
        
        // solo es label para saber que dato se hace referencia
        JLabel l1 = new JLabel ("Numero de Hab");
        l1.setBounds(50,160,100,20);//posicionamos el elemento
        add(l1);// añadimos el elemento a la ventana
        
        // solo es label para saber que dato se hace referencia
        JLabel l2 = new JLabel ("Disponible ");
        l2.setBounds(270,160,100,20);//posicionamos el elemento
        add(l2);// añadimos el elemento a la ventana
        
        
        // solo es label para saber que dato se hace referencia
        JLabel l3 = new JLabel ("Estado ");
        l3.setBounds(450,160,100,20);//posicionamos el elemento
        add(l3);// añadimos el elemento a la ventana
        
        
        // solo es label para saber que dato se hace referencia
        JLabel l4 = new JLabel ("Precio ");
        l4.setBounds(670,160,100,20);//posicionamos el elemento
        add(l4);// añadimos el elemento a la ventana
        
        
        
        // solo es label para saber que dato se hace referencia
        JLabel l5 = new JLabel ("Tipo ");
        l5.setBounds(870,160,100,20);//posicionamos el elemento
        add(l5);// añadimos el elemento a la ventana
        
        
        
        table = new JTable();// creamos un elemento tipo tabla(vacia) para meter los datos que tenemos en la base de datos
        table.setBounds(0,200,1000,300);//posicionamos el elemento
        add(table);// añadimos a la ventana
        
        
        try{
            Conn c = new Conn();//conexion con la base de datos
            ResultSet rs  = c.s.executeQuery("select * from room");// damos una orden tipo sql " seleccionar todo de room(habitaciones)
            table.setModel(DbUtils.resultSetToTableModel(rs));// ponemos los datos de la base de datos a la tabla que habiamos creado
        
        }catch (Exception e){
            e.printStackTrace();// para ver los errores mas comodo en consola
        }
        
        
        
        //creamos un boton
        enviar = new JButton("Consultar");
        enviar.setBackground(Color.BLACK);//le cambiamos el color(fondo) al boton
        enviar.setForeground(Color.WHITE);// colocamos el color de la letra del boton
        enviar.addActionListener(this);// añadimos un listener al boton para darle funcionalidad
        enviar.setBounds(300,520,120,30);//posicionamos el boton
        add(enviar);//añadimos a la ventana
        
        
         //creamos un boton
        back = new JButton("Volver");
        back.setBackground(Color.BLACK);//le cambiamos el color(fondo) al boton
        back.setForeground(Color.WHITE);// colocamos el color de la letra del boton
        back.addActionListener(this);// añadimos un listener al boton para darle funcionalidad
        back.setBounds(500,520,120,30);//posicionamos el boton
        add(back);//añadimos a la ventana
        
        
        setBounds(100,100,1050,600);// posicionamos la ventana
        setVisible(true);//mostramos la ventana
    
    }
    
    public void actionPerformed(ActionEvent ae){// evento que se hacen cuando se pulsa el boton
        if(ae.getSource()== enviar){
            try{
                String query1 = "select * from room where tipo = '"+tipocama.getSelectedItem()+"'";//orden tipo sql " seleccionar todo de room(habitaciones)  teniendo en cuenta la fila de la columna tipo donde el dato sea tipocama------- mejor dicho cuando el dato de tipocama sea el seleccionado y este en la columna tipo se ejecuta toda la fila
                String query2 = "select * from room where dispo ='DISPONIBLE' AND tipo = '"+tipocama.getSelectedItem()+"'";// orden tipo sql " es similar a la anterior orden solo lo que tiene de diferente es que  en esta orden se tiene en cuenta la columna tipo y que ese campo este en "DISPONIBLE" y se tiene en cuenta el dato que se pidio en la anterior orden y si estos 2 coinciden se pueden mostrar
                
                Conn conn = new Conn();// conexion con la base de datos
                ResultSet rs;
                if(disponible.isSelected()){// si el check box esta seleccionado se ejecuta la segunda orden que es para que muestre solo las disponibles y del tipo que se haya seleccionado en el desplegable
                    rs = conn.s.executeQuery(query2);
                }else{
                    rs = conn.s.executeQuery(query1);// si no esta marcado el check box simplemente tiene en cuenta el tipo y las muestra asi esten ocupadas
                
                }
                
                table.setModel(DbUtils.resultSetToTableModel(rs));// metemos los datos de la base en la tabla
                
                
                
            }catch(Exception e){
                e.printStackTrace();// ver errores en consola
            }
            
        }else{// con esto se dirige el boton de volver
        
            setVisible(false);//ocultamos la ventana
            new Reception();// abrimos la ventana de recepcion
        }
    }
    
    
    
    public static void main(String[]args){
        new SearchRoom();
    }
}
