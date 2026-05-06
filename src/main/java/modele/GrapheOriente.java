package modele;

import java.util.HashMap;
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

    /**
     * Retourne le nombre de sommet du graphe, l'odre
     * @return int
     */
    public int ordre(){
        return voisinsSortants.size();
    }

    /**
     * Retourne le nombre de voisin sortants du sommet entré en paramètre, son degré sortant
     * @param sommet
     * @return int
     */
    public int degreSortants( int sommet){
        return voisinsSortants.get(sommet).size();
    }



    /**
     * Retourne la taille du graphe this
     * @return int
     */
    public int taille(){
        int somme_degre = 0;
        for (int s : voisinsSortants.keySet()){
            somme_degre+= degre(s);
        }

        return somme_degre;
    }

    public String toString() {
        String affichage ="";
        String ordre = "Ordre "+ordre();
        String taille = "Taille "+taille();

        affichage += "Fichier : "+fichier+"\n"+ordre+" - "+taille+"\n";

        for (int s : voisinsSortants.keySet()){
            String ligne = "Sommet "+s+" — degré Sortants "+degreSortants(s)+", voisins : "+voisinsSortants.get(s)+"\n";
            affichage += ligne;
        }

        return affichage;
    }
}
