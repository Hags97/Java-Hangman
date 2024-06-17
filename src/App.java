import java.util.Scanner;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
      Scanner scanner = new Scanner(System.in);

      String palabraSecreta = "inteligencia";
      int intentosMaximos = 10;
      int intentos = 0;
      boolean isAdivinada = false;

      char[] letrasAdivinadas = new char[palabraSecreta.length()];

      for (int i = 0; i < letrasAdivinadas.length; i++)
      {
        letrasAdivinadas[i] = '_';
      }

      while(!isAdivinada && intentos < intentosMaximos)
      {
        System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras" + ")");

        System.out.println("Introduce una letra, por favor: ");
        char letra = Character.toLowerCase(scanner.next().charAt(0));

        boolean letraCorrecta = false;

        for(int i= 0; i < palabraSecreta.length(); i++)
        {
            if(palabraSecreta.charAt(i) == letra)
            {
                letrasAdivinadas[i] = letra;
                letraCorrecta = true;
            }
        }

        if(!letraCorrecta)
        {
            intentos++;
            System.out.println("Letra incorrecta. Intentos restantes: " + (intentosMaximos - intentos));
        }

        if(String.valueOf(letrasAdivinadas).equals(palabraSecreta))
        {
            isAdivinada = true;
            System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
        }

      }

      if(!isAdivinada)
      {
        System.out.println("¡Lo siento! Has agotado todos tus intentos. La palabra secreta era: " + palabraSecreta);
      }

      scanner.close();

    }
}
