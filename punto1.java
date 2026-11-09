package parcial3;

import primerSemestre.logica.Entrada;

public class punto1 {
    public static void main(String[] args) {
        int palabras = Entrada.leerEntero("Ingrese cuantas palabras va a analizar: ");
        String[] textos = new String[palabras];

        for (int i = 0; i < palabras; i++) {
            textos[i] = Entrada.leerTexto("Ingrese la palabra " + (i + 1) + ":");
        }
        int totalPalindromo = 0;
        for (int i = 0; i < palabras; i++) {

            boolean palindromo = CalcularPalindromo(textos[i]);
            int vocales = contarVocales(textos[i]);

            if (palindromo) {
                totalPalindromo++;
            }

            System.out.println("Palabra " + (i + 1) + ":" + textos[i]);
            System.out.println("Cantidad de vocales: " + vocales);
            System.out.println("Es palindromo: " + palindromo);

        }
        String ganadora = palabraMasVocales(textos);
        System.out.println("\n Palabra con mas vocales: " + palabraMasVocales(textos));
        System.out.println("Total de palindromos: " + totalPalindromo);

        String buscado = Entrada.leerTexto(" ¿Qué palabra quieres buscar: ");
        int posicion = buscar(textos, buscado);

        if (posicion == -1){
            System.out.println("La palabra " + buscado + " no está en el arreglo. ");
        } else {
            System.out.println("La palabra " + buscado + " está en la posición " +(posicion + 1)+ ".");
        }
    }

    public static boolean CalcularPalindromo(String texto) {
        boolean palindromo = true;
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length() / 2; i++) {
            if (texto.charAt(i) != texto.charAt(texto.length() - 1 - i)) {
                palindromo = false;
            }
        }
        return palindromo;
    }

    public static int contarVocales(String texto) {
        int vocales = 0;
        texto = texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {

            char letra = texto.charAt(i);

            if (letra == 'a' || letra == 'e' || letra == 'i' ||
                    letra == 'o' || letra == 'u') {

                vocales++;
            }
        }
        return vocales;
    }

    private static String palabraMasVocales(String[] textos) {
        String palabraConMasVocales = textos[0];

        for (int i = 1; i < textos.length; i++) {
            if (contarVocales(palabraConMasVocales) < contarVocales(textos[i])) {
                palabraConMasVocales = textos[i];
            }
        }

        return palabraConMasVocales;
    }

    public static int buscar(String[] textos, String buscando) {
        for (int i = 0; i < textos.length; i++) {
            if (textos[i].equalsIgnoreCase(buscando)) {
                return i;
            }
        }
        return -1;
    }
}











