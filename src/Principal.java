import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaPeli consulta= new ConsultaPeli();
        Scanner lectura =new Scanner(System.in);
        System.out.println("Escriba el nombre de la película de Star Wars que quiere consultar: ");
        try {
            var numeroDePelicula = Integer.valueOf(lectura.nextLine());
            System.out.println("numero: "+numeroDePelicula);
            Pelicula pelicula = consulta.buscarPelicula(numeroDePelicula);
            System.out.println(pelicula);
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(pelicula);
        }catch(NumberFormatException e){
            System.out.println("Numero no encontrado: "+e.getMessage());
        }
        catch(RuntimeException | IOException e ){
            System.out.println(e.getMessage());
            System.out.println("Finalizando la app");
        }

    }
}
