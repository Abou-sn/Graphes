package client;

import modele.GrapheOriente;
import modele.LectureGraphe;

import java.io.File;

public class ClientGrapheOriente {
    public static void main(String[] args) {
        int nb = 4;
        GrapheOriente[] tabDiGraphes = new GrapheOriente[nb];

        for (int i = 0; i < nb; i++) { // Creer les petits graphes
            tabDiGraphes[i] = LectureGraphe.lectureOriente(new File("data" + File.separator + "graphes" + File.separator + "graphes_orientes" + File.separator + "graphe_oriente" + (i + 1) + ".txt"));
        }

        for(GrapheOriente g : tabDiGraphes){
            System.out.println(g);
        }

        GrapheOriente g1 = tabDiGraphes[0];

        System.out.println(g1.ordreTopologique());

    }
}
