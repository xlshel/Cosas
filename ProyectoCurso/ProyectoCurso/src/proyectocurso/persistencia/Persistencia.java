/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectocurso.persistencia;

/*
 * Clase : Persistencia
 *
 * Version 1.0
 *
 * Fecha : 20 - 04 - 2022
 *
 * Autor: Ing. Namuel Solórzano Peralta
 */
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

public class Persistencia {

    private static File file = null;
    private static ObjectOutputStream out = null;
    private static ObjectInputStream in = null;
    private static boolean ESTADO = true;

    public static void conectarArchivo(File f, String modo) {
        if (modo.equalsIgnoreCase("grabar")) {

            try {
                file = f;
                out = appendableObjectOutputStream(file);
            } catch (IOException e) {
                System.out.println("Error" + e);
            }
        } else {
            try {
                file = f;
                in = new ObjectInputStream(new FileInputStream(file));
            } catch (IOException e) {
                System.out.println("Error" + e);
            }
        }

    }

    public static void grabarObjeto(Object ob) {
        try {
            out.writeObject(ob);
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println("Error" + e);
        }

    }

    public static ArrayList leerObjeto() {
        Object objeto = null;
        ArrayList listaObjetos = new ArrayList();
        try {

            while ((objeto = in.readObject()) != null) {
                listaObjetos.add(objeto);

            }
        } catch (EOFException e) {
            //System.out.println("Fin de archivo" + e);
        } catch (IOException e) {
            System.out.println("Error :+++++ " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Error" + e);
        }
        return listaObjetos;
    }

    public static ObjectOutputStream appendableObjectOutputStream(File f) throws IOException {

        FileOutputStream fos = new FileOutputStream(f, true);

        boolean append = f.exists() && f.length() > 0;
        if (append) {
            return new ObjectOutputStream(fos) {
                protected void writeStreamHeader() throws IOException {
                }
            };
        } else {
            return new ObjectOutputStream(fos);
        }
    }

}
