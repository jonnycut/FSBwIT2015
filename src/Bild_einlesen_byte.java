import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/*
 * Created by JonnyCut on 18.09.2015.
 */
public class Bild_einlesen_byte {


    public static void main(String[] args) {
        Collection<byte[]> al = new ArrayList<>();
//        Collection<String[]> ausgabeListe = new ArrayList<>();


        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream("hexTest.bmp"))){

            byte[] puffer= new byte[16];
            int zLang;

            while((zLang = reader.read(puffer))!= -1){
                byte[] toStore = new byte[zLang];

                for(int i = 0; i<zLang;i++){

                    toStore[i] = puffer[i];
                }

                al.add(toStore);

            }
        }


            catch(IOException e){
                System.out.println("Fehler beim Lesen");
            }





        try (BufferedWriter fileWr = new BufferedWriter(new FileWriter("hex_editor.txt"))){
            int adresse=0;

            int maxAdresse = al.size()*16;

            for(byte[] array : al){

                String adresseHex = Integer.toHexString(adresse);
                while(adresseHex.length()< Integer.toHexString(maxAdresse).length()){
                    adresseHex = 0+adresseHex;
                }

                StringBuilder ausgabe = new StringBuilder();

                for(byte b: array){
                    String puffer = Integer.toHexString(b&255);
                    if(puffer.length()<2) puffer = 0+puffer;
                    ausgabe.append(puffer+" ");

                }
                    while (ausgabe.length()<48){
                        ausgabe.append(" ");
                    }
                    fileWr.write(adresseHex + ": " + ausgabe + " " + new String(array).replaceAll("[^\\p{Print}]", "."));
                    fileWr.newLine();
                    adresse = adresse + 16;

            }


        }
        catch(IOException e){
            System.out.println("Fehler beim Schreiben");
        }

        //Reader und writer werden gleichzeitig aufgerufen
        try(BufferedReader fileR = new BufferedReader(new FileReader("hex_editor.txt"));BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream("hex_bitmap.bmp"))){


            String change;
            String puffS;


            while((change = fileR.readLine())!= null){

                int start = change.indexOf(":");
                puffS = change.substring(start+2,start+49).trim();
//                ausgabeListe.add(puffS.split(" ")); //möglichkeit 2, den outPut vor Ausgabe zu speichern
                String[] outArray =puffS.split(" ");
                for (String s:outArray)
                    writer.write((byte)Integer.parseInt(s,16));


                }

            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Nicht mehr notwendig, da oben in einem Zug
//        try(BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream("hex_bitmap.bmp"))){
//
//            for (String[] value: ausgabeListe){
//
//                for(String s: value)
//                    writer.write((byte)Integer.parseInt(s,16));
//
//            }
//
//        }
//
//        catch(IOException e){
//            System.out.println("Fehler beim Schreiben!");
//        }




    }//end MainFunction
}//end MainClass
