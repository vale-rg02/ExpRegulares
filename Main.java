import java.util.regex.Pattern;
 
public class Main {
 
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Recuerda poner una cadena entre comillas en argumentos");
            return;
        }
 
        String input = args[0];
        boolean coincide = false;
 
        if (validarHolamundo(input)) {
            System.out.println("Contiene el Hola mundo.");
            coincide = true;
        }
        if (validarHolamundoMym(input)) {
            System.out.println("Contiene el Hola mundo en cualquier combinacion de mayusculas y minusculas.");
            coincide = true;
        }
        if (validarLenguaje(input)) {
            System.out.println("Contiene uno de los lenguajes de programacion.");
            coincide = true;
        }
        if (validarCorreo(input)) {
            System.out.println("Contiene un correo de la unison");
            coincide = true;
        }
        if (validarArchivo(input)) {
            System.out.println("Contiene un formato de nombre de archivo especificado.");
            coincide = true;
        }
 
        if (!coincide) {
            System.out.println("La cadena no contiene ninguna expresio");
        }
    }
 
    private static boolean validarHolamundo(String input) {
        String regex = "Hola mundo";
        return Pattern.compile(regex).matcher(input).find();
    }
 
    private static boolean validarHolamundoMym(String input) {
        String regex = "(?i)hola mundo";
        return Pattern.compile(regex).matcher(input).find();
    }
 
    private static boolean validarLenguaje(String input) {
        String regex = "\\b(Java|Python|Go|Pascal|Perl)\\b";
        return Pattern.compile(regex).matcher(input).find();
    }
 
    private static boolean validarCorreo(String input) {
        String regex = "[a-zA-Z0-9._%+-]+@(?:unison\\.mx|uson\\.mx)";
        return Pattern.compile(regex).matcher(input).find();
    }
 
    private static boolean validarArchivo(String input) {
        String regex = "ISI\\d{4}-[12]\\.(txt|csv)";
        return Pattern.compile(regex).matcher(input).find();
    }
}