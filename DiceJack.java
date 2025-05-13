import java.util.Scanner;

public class DiceJack {
    public static void main(String[] args) {

        /* 
        Reglas del juego:
        - El usuario debe escoger 3 números entre 1 y 6 (incluidos).
        - El usuario debe lanzar los dados una vez, el resultado serán 3 números aleatorios.

        ¿Cuándo gana el usuario?:
        - Cuando la suma de los números escogidos es mayor a la suma de los dados lanzados
        - Y cuando la diferencia entre los dos números anteriores es menor de 5

        ej. 
        - Usuario escoge los números: 1 3 5 (la suma es 9)
        - Usuario lanza dados y salen los números: 3 1 3 (la suma es 7)
        - 9 es mayor a 7 y la diferencia entre los dos números es menor a 5. El usuario gana.

        Requisitos no funcionales (atributos de calidad):
        - Definir las 4 funciones descritas abajo.
        - En el método main escribir el programa (usar condicionales, reusar las funciones creadas, pedir al usuario que ingrese datos y recogerlos).
      
        Pasos:
        - Pedir al usuario que escoja 3 números.
        - Si el usuario escoge un número fuera del rango, salir del programa (mira en los recursos system exit).
        - Si los números son correctos, pedir al usuario si desea lanzar dados.
        - Si el usuario dice que no, salir del programa.
        - Si el usuario dice que si, lanzar dados, hacer los cálculos que indiquen si el usuario ganó o perdió.
        - Imprimir la suma de los números escogidos por el usuario y la suma de los números que salieron en los dados.
        - Imprimir si el usuario ganó o perdió.
        */


        /**
         *
         * Function name: isLessThanOne
         *
         * @param num1 (int)
         * @param num2 (int)
         * @param num3 (int)
         * @return (boolean)
         *
         * Inside the function:
         * 1. check if numbers are less than 1
         */

        // Escribe tu código aquí


        /**
         *
         * Function name: isHigherThanSix
         *
         * @param num1 (int)
         * @param num2 (int)
         * @param num3 (int)
         * @return (boolean)
         *
         * Inside the function:
         * 1. Check if numbers are greater than 6
         */

        // Escribe tu código aquí


        /**
         *
         * Function name: userWon
         *
         * @param sumNumbers (int)
         * @param sumDiceRolls (int)
         * @return (boolean)
         *
         * Inside the function:
         * 1. check if user numbers are greater than computer numbers and the difference between user numbers and computer numbers are less than 5.
         */

        // Escribe tu código aquí


        /**
         * Function name: rollDice
         *
         * @return (int)
         *
         * Inside the function:
         * 1. get random number between 1 and 6
         */

        // Escribe tu código aquí
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige 3 números entre 1 y 6: ");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        if (isLessThanOne(number1, number2, number3) || isHigherThanSix(number1, number2, number3)) {
            System.out.println("Uno o más números están fuera del rango. Fin del juego");
            System.exit(0);
        }
        System.out.println("¿Quieres lanzar los dados? Sí o no");
        scanner.nextLine();
        String answer=scanner.nextLine().toLowerCase();
        if(!answer.equals("sí") && !answer.equals("si")){
            System.out.println("Si no quieres jugar, nos veremos a la próxima. Fin del juego.");
            System.exit(0);
        }
        int dice1=rollDice();
        int dice2=rollDice();
        int dice3=rollDice();
        int userSum=getSum(number1,number2,number3);
        int diceSum=getSum(dice1,dice2,dice3);
        System.out.println("Tús números son: " +number1+", " +number2+" y " +number3);
        System.out.println("La suma en total es: " + userSum);
        System.out.println("Los dados son: " +dice1+", " +dice2+" y " +dice3);
        System.out.println("La suma en total es: " + diceSum);
        if (userWon(userSum,diceSum)){
            System.out.println("¡Felicidades! Has ganado, devoraste reina.");
        } else {
            System.out.println("Has perdido. Qué más quieres que te diga.");
        }
        scanner.close();
    }
        public static boolean isLessThanOne ( int number1, int number2, int number3){
            return number1 < 1 || number2 < 1 || number3 < 1;
        }
        public static boolean isHigherThanSix ( int number1, int number2, int number3){
            return number1 > 6 || number2 > 6 || number3 > 6;
        }
        public static boolean userWon (int sumNumbers, int sumDice){
            return sumNumbers>sumDice && (sumNumbers-sumDice)<5;
        }
        public static int rollDice(){
            return (int)(Math.random()*6)+1;
        }
        public static int getSum(int number1,int number2,int number3){
            return number1+number2+number3;
        }
    }