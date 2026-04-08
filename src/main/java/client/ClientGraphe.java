package client;

import modele.Graphe;
import modele.LectureGraphe;

import java.io.File;

public class ClientGraphe {
    public static void main(String[] args) {
        int nb = 3;
        Graphe[] tabGraphes = new Graphe[nb];

        for (int i = 0; i < nb; i++) { // Creer les petits graphes
            tabGraphes[i] = LectureGraphe.lecture(new File("data" + File.separator + "graphes" + File.separator + "petits_graphes" + File.separator + "petitgraphe" + (i + 1) + ".txt"));
        }

        for (int i = 0; i < nb; i++){
            System.out.println(tabGraphes[i]);
        }

        Graphe g1 = tabGraphes[0]; Graphe g2 = tabGraphes[1]; Graphe g3 = tabGraphes[2];



    }
}
