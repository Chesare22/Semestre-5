/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myIO.input;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
// import java.lang.IndexOutOfBoundsException;
import java.util.ArrayList;

public class CSVReader implements TableReader{

  String[] lineas;

  @Override
  public String[][] read(String pathName, int campos) throws FileNotFoundException{
    guardarPorLineas(pathName);
    return convertirLineasATabla(campos);
  }

  private void guardarPorLineas(String nombreDelArchivo) throws FileNotFoundException{
    try{
      BufferedReader leer = new BufferedReader(new FileReader(nombreDelArchivo));
      Object[] lineas = leer.lines().toArray();
      leer.close();
      this.lineas = new String[lineas.length];
      for(int i = 0;i<lineas.length;i++){
        this.lineas[i] = String.valueOf(lineas[i]);
      }
    }
    catch (IOException io){
      System.out.println("Ocurrio un error al cerrar el reader");
    }
  }


  private String[][] convertirLineasATabla(int campos){
    int desface = 0;
    //Falta importar el Stack
    ArrayList<Integer> lineasInvalidas = new ArrayList<Integer>();
    //String[][] elementos = new String[lineas.length][campos];
    for(int i=0;i<lineas.length;i++){
      //Checo si tiene formato CSV con el número adecuado de líneas
      if(CSVReader.validarFormatoCSV(lineas[i], campos) == false){
        //En caso de que sí se pueda, lo guardo
        //elementos[i-desface] = CSVRead.lineToArray(lineas[i],campos)
        lineasInvalidas.add(0,i);
      }
    }
    String [][] elementos = new String[lineas.length - lineasInvalidas.size()][campos];
    for(int i = 0;i<lineas.length;i++){
      if(lineasInvalidas.isEmpty()){
        elementos[i-desface] = CSVReader.lineToArray(lineas[i],campos);
      }else{
        if(i == lineasInvalidas.get(0)){
          lineasInvalidas.remove(lineasInvalidas.get(0));
          desface++;
        }else{
          elementos[i-desface] = CSVReader.lineToArray(lineas[i],campos);
        }
      }
    }
    return elementos;
  }

  private static String[] lineToArray(String linea, int campos){
    String[] arreglo = new String[campos];
    try{
      for(int i=0;i<campos;i++){
        if(linea.charAt(0) == '"'){
          linea = linea.substring(1);
          arreglo[i] = linea.substring(0, linea.indexOf('"'));
          if(linea.length() == linea.indexOf('"')+1){
            linea = "";
          }else{
            linea = linea.substring(linea.indexOf('"')+2);
          }
        }else{
          if(i == campos-1){
            arreglo[i] = linea;
          }else{
            arreglo[i] = linea.substring(0, linea.indexOf(','));
            linea = linea.substring(linea.indexOf(',')+1);
          }
        }
      }
    }catch(StringIndexOutOfBoundsException str){}

    return arreglo;
  }


  //Método que valida si un String cumple el formato CSV con el número específico de campos
    //Nota: Si da tiempo, mejorar esto para que use expresiones regulares
    //Esta cosa no valida si antes de abrir comillas hay una coma
  private static boolean validarFormatoCSV(String linea, int camposDeseados){
    int numeroDeCampos = 1;
    int cerrarComillas;
    try{
      while(linea.isEmpty()==false){
        //Checo si el primer elemento es una coma o comillas
        if(linea.charAt(0) == ','){
          numeroDeCampos++;
        }else if(linea.charAt(0) == '"'){
          //Si se abren comillas, continúo hasta que se cierren comillas
          linea = linea.substring(1);
          //Checo si se cerraron las comillas
          cerrarComillas = linea.indexOf('"');
          if(cerrarComillas == -1){
            System.out.println("Hay unas comillas que no se cerraron.");
            System.exit(0);
          } else{
            linea = linea.substring(cerrarComillas);
          }
        }
        //Una vez checado, quito el primer elemento
        linea = linea.substring(1);
      }
      return numeroDeCampos == camposDeseados;
    }catch(StringIndexOutOfBoundsException str){
      return false;
    }

  }

}