package myapplet;

import javafx.util.Pair;

import java.awt.*;
import java.applet.*;
import java.io.*;
import java.util.ArrayList;

public class Triangle extends Applet {
    ArrayList<Pair<int[], int[]>> mass;

    public void paint(Graphics g) {
        int mySquare = 0;
        System.out.print("Input square: ");
        try {
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            mySquare = Integer.parseInt(stdin.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Pair<int[], int[]> coord : mass) {
            int squareTriangle = Math.abs(((coord.getKey()[1] - coord.getKey()[0]) * (coord.getValue()[2] - coord.getValue()[0])
                    - (coord.getValue()[1] - coord.getValue()[0]) * (coord.getKey()[2] - coord.getKey()[0])) / 2);
            System.out.println("Square: " + squareTriangle);

            if (squareTriangle <= mySquare)
                g.setColor(Color.blue);
            else
                g.setColor(Color.red);

            g.fillPolygon(coord.getKey(), coord.getValue(), 3);
        }
    }

    @Override
    public void init() {
        mass = new ArrayList<>();
        mass.add(new Pair<>(new int[]{140, 140, 210}, new int[]{210, 400, 360}));
        mass.add(new Pair<>(new int[]{360, 400, 200}, new int[]{310, 330, 370}));
        mass.add(new Pair<>(new int[]{80, 20, 22}, new int[]{110, 140, 160}));
        mass.add(new Pair<>(new int[]{200, 280, 340}, new int[]{110, 20, 260}));
        mass.add(new Pair<>(new int[]{220, 240, 260}, new int[]{500, 400, 560}));
    }
}
