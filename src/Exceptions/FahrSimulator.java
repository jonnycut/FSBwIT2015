package Exceptions;

/**
 * Created by KNapret on 11.12.2015.
 */
public class FahrSimulator {

    public static void main(String[] args) {

        Auto_exception auto = new Auto_exception();

        auto.tanken();

        for(int i=0; i<1000000;i++) {

            try{
                auto.fahren();
                System.out.println("brrr....brrrr");
            } catch (TankLeerException e) {
                auto.tanken();
                System.out.println("tank leer - ICH TANKE");
            }
            catch (ReifenKaputtException e){
                auto.reifenWechseln();
                System.out.println("ReifenPUTT - ICH REIFE");
            }

        }

    }
}
