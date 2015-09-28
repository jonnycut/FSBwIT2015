import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/*
 * Created by KNapret on 18.09.2015.
 */
public class Bild_einlesen_byte {


    public static void main(String[] args) {
        Collection<byte[]> al = new ArrayList<>();
        Collection<byte[]> ausgabeListe = new ArrayList<>();


        try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream("hexTest.bmp"))){

            byte[] puffer= new byte[16];
            int zLang;

            while((zLang = reader.read(puffer))!= -1){
                byte[] toStore = new byte[16];

                for(int i = 0; i<16;i++){
                    if(zLang<16){
                        //array auffüllen
                    }
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

                    fileWr.write(adresseHex + ": " + ausgabe + " " + new String(array).replaceAll("[^\\p{Print}]", "."));
                    fileWr.newLine();
                    adresse = adresse + 16;

            }


        }
        catch(IOException e){
            System.out.println("Fehler beim Schreiben");
        }


        try(BufferedReader fileR = new BufferedReader(new FileReader("hex_editor.txt"))){


            String change;
            String puffS;


            while((change = fileR.readLine())!= null){
                int start = change.indexOf(":");
                System.out.println(change);

                puffS = change.substring(start+2,start+47);


                ausgabeListe.add(new BigInteger(puffS.replaceAll(" ", ""), 16).toByteArray());

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }







        try(BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream("hex_bitmap.bmp"))){
            //ToDo: schreiben in Datei
            for (byte[] array: ausgabeListe){

                for (byte b : array){
                    writer.write(b);
                }




            }

        }

        catch(IOException e){
            System.out.println("Fehler beim Schreiben!");
        }




    }//end MainFunction
}//end MainClass
