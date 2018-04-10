/*
 El siguiente código se crea para solucionar el autómata del taller
Es un Lenguaje 0,1 con 4 estados
 */
package automatas;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 *
 * @author Jonathan Cruz - 88404
 */
public class PrimerPunto {
    public boolean validate(String input){
        boolean accepted = true;//Como la cadena vacía es aceptada, se inicia en true
        int length = input.length();
        int index = 0;
        
        while(index<length){//Las validaciones se repiten a lo largo de la cadena
            //Estado inicial: q0
            if(index<length && input.charAt(index)=='0'){//Validación para cambio de estado
                System.out.println(input.charAt(index)+" q1");//Se imprime el símbolo leído y el estado a donde pasa
                index+=1;//cambio de posición de la cadena pasa al estado q1
                while(input.charAt(index)=='0'){//Validación 0 a la estrella de klean
                    System.out.println(input.charAt(index)+" q1");//Se imprime el símbolo leído y el estado a donde continúa
                    index+=1;//cambio de posición de la cadena continía en el estado q1
                }
                accepted = false;//cambio de estado de aceptación ya que en este punto la cadena no es válida
                if(index<length && input.charAt(index)=='1'){//Validación para cambio de estado
                    System.out.println(input.charAt(index)+" q2");//Se imprime el símbolo leído y el estado a donde pasa
                    index+=1;//cambio de posición de la cadena pasa al estado q2
                    while(input.charAt(index)=='0'){//Validación 0 a la estrella de klean
                        System.out.println(input.charAt(index)+" q2");//Se imprime el símbolo leído y el estado a donde continúa
                        index+=1;//cambio de posición de la cadena continía en el estado q2
                    }
                    if(index<length && input.charAt(index)=='1'){//Validación para cambio de estado
                        System.out.println(input.charAt(index)+" q3");//Se imprime el símbolo leído y el estado a donde pasa
                        index+=1;//cambio de posición de la cadena pasa al estado q3
                        accepted = true;//cambio de estado de aceptación ya que en este punto la cadena es válida
                        while(index<length && input.charAt(index)=='1'){//Validación 0 a la estrella de klean
                            System.out.println(input.charAt(index)+" q3");//Se imprime el símbolo leído y el estado a donde continúa
                            index+=1;//cambio de posición de la cadena continía en el estado q3
                        }
                        if(index<length && input.charAt(index)=='0'){//Validación para cambio de estado
                            System.out.println(input.charAt(index)+" q0");//Se imprime el símbolo leído y el estado a donde pasa
                            index+=1;//cambio de posición de la cadena pasa al estado q0
                            accepted = true;//cambio de estado de aceptación ya que en este punto la cadena es válida
                            if(index<length && input.charAt(index)=='0'){//Validación para cambio de estado
                                accepted = false;//cambio de estado de aceptación ya que en este punto la cadena no es válida
                            }
                        }
                    }
                }
            }
            else
            accepted = false;//cambio de estado de aceptación ya que en este punto la cadena no es válida
            break;
        }
        return accepted;//Retorna estado de la cadena después de las validaciones para indicar si es válida o no
    }
    
    public static void main(String[] args) {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PrimerPunto afd = new PrimerPunto();
        try{
            if(afd.validate("000001000000111111101"))//Validación de la cadena
                System.out.println("Cadena aceptada");//Se imprime resultado afirmativo
            else
                System.out.println("Cadena rechazada");//Se imprime resultado negativo
            bw.flush();
        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}