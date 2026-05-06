package modele;

import java.util.Map;
import java.util.Set;

public class GrapheOriente {
    private String fichier;
    private Map<Integer, Set<Integer>> voisinsSortants;

    /**
     * Constructeur de Graphe qui prend en paramètre un fichier, et un ensemble contenant les sommet et leurs voisins.
     * @param file Un objet de type String, qui est le nom du fichier à utiliser
     * @param nodes Un objet de type Map, contenant les sommets en clés et l'ensemble de leurs voisins en valeurs.
     */
    public GrapheOriente(String file , Map <Integer, Set<Integer>> nodes) {
        fichier = file;
        voisinsSortants = nodes;
    }

    public String toString()
    {
        return voisinsSortants.toString();
    }
}
