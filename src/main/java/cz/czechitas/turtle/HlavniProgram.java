package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

import java.awt.*;

public class HlavniProgram {
    private Turtle zofka = new Turtle();
//    private final double strana = 50;

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {
        double strana = 100;

        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(5 * strana);
        zofka.turnRight(90);

        nakresliZmrzlinu(strana, 2 * strana, strana, Color.RED, Color.DARK_GRAY);

        zofka.turnRight(90);
        zofka.move(2 * strana);
        zofka.turnRight(90);
        zofka.move(2 * strana);
        zofka.turnLeft(180);

        nakresliSnehulaka(2 * strana, 1.5 * strana, strana);

        zofka.turnRight(90);
        zofka.move(2 * strana);
        zofka.turnRight(90);
        zofka.move(strana);
        zofka.turnLeft(180);

        nakresliMasinku(strana);
    }

    private void nakresliZmrzlinu(double prumer, double delsiStrana, double kratsiStrana, Color barvaKopecku, Color barvaKornoutku) {
        nakresliKruznici(prumer, barvaKopecku);
        zofka.turnRight(90);
        zofka.move(prumer);
        zofka.turnRight(90);
        nakresliRovnoramennyTrojuhelnik(delsiStrana, kratsiStrana, barvaKornoutku);
        zofka.turnLeft(180);
    }

    private void nakresliSnehulaka(double prumerNejvetsi, double prumerStredni, double prumerMale) {
        nakresliKruznici(prumerNejvetsi, Color.BLUE);

        zofka.move(prumerNejvetsi / 2);
        zofka.turnRight(90);
        zofka.move(prumerNejvetsi / 2);
        zofka.turnLeft(180);

        nakresliKruznici(prumerStredni, Color.BLUE);

        zofka.move(prumerStredni / 2);
        zofka.turnRight(90);
        zofka.move(prumerStredni / 2);
        zofka.turnRight(180);

        nakresliKruznici(50, Color.BLUE);

        zofka.turnLeft(90);
        zofka.move(prumerStredni);
        zofka.turnLeft(90);

        nakresliKruznici(50, Color.BLUE);

        zofka.move(prumerStredni / 2);
        zofka.turnLeft(90);
        zofka.move(prumerStredni / 2);

        nakresliKruznici(prumerMale, Color.BLUE);

        zofka.turnRight(90);
    }

    private void nakresliMasinku(double odvesna) {
        nakresliPravouhlyTrojuhelnik(odvesna, Color.RED);

        zofka.turnRight(90);
        zofka.move(odvesna);
        zofka.turnLeft(90);
        zofka.move(30);

        nakresliObdelnik(odvesna, 2 * odvesna, Color.BLACK);

        zofka.turnRight(90);
        zofka.move(50);
        zofka.turnRight(90);
        zofka.move(25);
        zofka.turnLeft(180);

        nakresliKruznici(30, Color.BLACK);
        zofka.turnRight(90);
        zofka.move(80);
        zofka.turnLeft(90);

        nakresliKruznici(30, Color.BLACK);

        zofka.move(30);
        zofka.turnRight(90);
        zofka.move(2 * odvesna - 50 - 80);
        zofka.turnLeft(90);

        nakresliObdelnik(2 * odvesna, 1.5 * odvesna, Color.BLUE);

        nakresliKruznici(1.5 * odvesna, Color.BLACK);
    }

    private void nakresliRovnostrannyTrojuhelnik(double strana, Color barva) {
        zofka.setPenColor(barva);
        zofka.turnRight(30);
        zofka.penDown();
        for (int i = 0; i < 3; i++) {
            zofka.move(strana);
            if (i != 2) {
                zofka.turnRight(120);
            }
        }
        zofka.penUp();
        zofka.turnRight(90);
    }

    private void nakresliRovnoramennyTrojuhelnik(double stranaA, double stranaB, Color barva) {
        zofka.setPenColor(barva);
        double uhel = Math.toDegrees(Math.acos((stranaB / 2) / stranaA));

        zofka.turnRight(90 - uhel);
        zofka.penDown();
        zofka.move(stranaA);
        zofka.turnRight(2 * uhel);
        zofka.move(stranaA);
        zofka.turnRight(180 - uhel);
        zofka.move(stranaB);

        zofka.penUp();
        zofka.turnRight(90);
    }

    private void nakresliPravouhlyTrojuhelnik(double odvesna, Color barva) {
        zofka.setPenColor(barva);
        double prepona = Math.sqrt(2 * Math.pow(odvesna, 2));
        double uhel = Math.toDegrees(Math.acos((odvesna) / prepona));

        zofka.turnRight(90);
        zofka.penDown();
        zofka.move(odvesna);
        zofka.turnLeft(90);
        zofka.move(odvesna);
        zofka.turnLeft(180 - uhel);
        zofka.move(prepona);
        zofka.turnRight(90 + uhel);
        zofka.penUp();
    }

    private void nakresliCtverec(double strana, Color barva) {
        zofka.setPenColor(barva);
        zofka.penDown();
        for (int i = 0; i < 4; i++) {
            zofka.move(strana);
            zofka.turnRight(90);
        }
        zofka.penUp();
    }

    private void nakresliObdelnik(double stranaA, double stranaB, Color barva) {
        zofka.setPenColor(barva);
        zofka.penDown();
        for (int i = 0; i < 2; i++) {
            zofka.move(stranaA);
            zofka.turnRight(90);
            zofka.move(stranaB);
            zofka.turnRight(90);
        }
        zofka.penUp();
    }

    private void nakresliKruznici(double prumer, Color barva) {
        zofka.setPenColor(barva);
        zofka.penDown();
        for (int i = 0; i <= 50; i++) {
            zofka.move(prumer / 16);
            zofka.turnRight(360 / 50);
        }
        zofka.penUp();
        zofka.turnRight(360 / 100);
    }
}
