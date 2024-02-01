package cz.czechitas.turtle;

import dev.czechitas.java1.turtle.engine.Turtle;

public class HlavniProgram {
    private Turtle zofka = new Turtle();
    private final double strana = 50;

    public static void main(String[] args) {
        new HlavniProgram().start();
    }

    public void start() {
        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(5 * strana);
        zofka.turnRight(90);

        nakresliRovnostrannyTrojuhelnik();

        zofka.turnRight(90);
        zofka.move(2 * strana);
        zofka.turnLeft(90);

        nakresliRovnoramennyTrojuhelnik();

        zofka.turnRight(90);
        zofka.move(3 * strana);
        zofka.turnLeft(90);

        nakresliCtverec();

        zofka.turnRight(90);
        zofka.move(2 * strana);
        zofka.turnLeft(90);

        nakresliObdelnik();

        zofka.turnRight(90);
        zofka.move(3 * strana);
        zofka.turnLeft(90);

        nakresliKruznici();
    }

    private void nakresliRovnostrannyTrojuhelnik() {
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

    private void nakresliRovnoramennyTrojuhelnik() {
        double stranaA = Math.sqrt(10 * Math.pow(strana, 2));
        double uhel = Math.toDegrees(Math.asin(strana / stranaA));

        zofka.turnRight(uhel);
        zofka.penDown();
        zofka.move(stranaA);
        zofka.turnRight(180 - 2 * uhel);
        zofka.move(stranaA);
        zofka.turnRight(90 + uhel);
        zofka.move(2 * strana);

        zofka.penUp();
        zofka.turnRight(90);
    }

    private void nakresliCtverec() {
        zofka.penDown();
        for (int i = 0; i < 4; i++) {
            zofka.move(strana);
            zofka.turnRight(90);
        }
        zofka.penUp();
    }

    private void nakresliObdelnik() {
        zofka.penDown();
        for (int i = 0; i < 2; i++) {
            zofka.move(strana);
            zofka.turnRight(90);
            zofka.move(2 * strana);
            zofka.turnRight(90);
        }
        zofka.penUp();
    }

    private void nakresliKruznici() {
        zofka.penDown();
        for (int i = 0; i <= 50; i++) {
            zofka.move(strana / 10);
            zofka.turnRight(360 / 50);
        }
        zofka.penUp();
        zofka.turnRight(360 / 100);
    }
}
