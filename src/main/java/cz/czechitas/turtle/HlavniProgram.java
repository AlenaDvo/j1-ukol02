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

        nakresliRovnostrannyTrojuhelnik(strana, Color.BLUE);

        zofka.turnRight(90);
        zofka.move(2 * strana);
        zofka.turnLeft(90);

        nakresliRovnoramennyTrojuhelnik(2 * strana, strana, Color.CYAN);

        zofka.turnRight(90);
        zofka.move(2 * strana);
        zofka.turnLeft(90);

        nakresliCtverec(strana, Color.BLACK);

        zofka.turnRight(90);
        zofka.move(2 * strana);
        zofka.turnLeft(90);

        nakresliObdelnik(strana, 2 * strana, Color.GREEN);

        zofka.turnRight(90);
        zofka.move(3 * strana);
        zofka.turnLeft(90);

        nakresliKruznici(strana, Color.YELLOW);
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
            zofka.move(prumer / 15);
            zofka.turnRight(360 / 50);
        }
        zofka.penUp();
        zofka.turnRight(360 / 100);
    }
}
