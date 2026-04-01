package modele;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Graphe {
    private String file ;
    private Map<Integer, Set<Integer>> nodes ;

    /**
     * Constructeur de Graphe qui prend en paramètre un fichier, et un ensemble contenant les sommet et leurs voisins.
     * @param file Un objet de type String, qui est le nom du fichier à utiliser
     * @param nodes Un objet de type Map, contenant les sommets en clés et l'ensemble de leurs voisins en valeurs.
     */
    public Graphe (String file, Map <Integer, Set<Integer>> nodes){
        this.file = file;
        this.nodes = nodes;
    }

    /**
     * Affiche le conteny de la Map dans un string
     * @return String
     */
    public String toString() {
        return nodes.toString();
    }


}
