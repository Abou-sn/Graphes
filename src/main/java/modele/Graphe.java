package modele;

import java.util.Map;
import java.util.Set;
import org.javatuples.Pair;

public class Graphe {
    private String fichier;
    private Map<Integer, Set<Integer>> sommets;

    /**
     * Constructeur de Graphe qui prend en paramètre un fichier, et un ensemble contenant les sommet et leurs voisins.
     * @param file Un objet de type String, qui est le nom du fichier à utiliser
     * @param nodes Un objet de type Map, contenant les sommets en clés et l'ensemble de leurs voisins en valeurs.
     */
    public Graphe (String file, Map <Integer, Set<Integer>> nodes){
        this.fichier = file;
        this.sommets = nodes;
    }

    public Map<Integer, Set<Integer>> getSommets() {
        return sommets;
    }

    /**
     * Retourne le nombre de sommet du graphes, l'odre
     * @return int
     */
    public int ordre(){
        return sommets.size();
    }

    /**
     * Retourne le nombre de voisin du sommet entré en paramètre, son degré
     * @param sommet
     * @return int
     */
    public int degre( int sommet){
        return sommets.get(sommet).size();
    }

    /**
     * Retourne la taille du graphe this
     * @return int
     */
    public int taille(){
        int somme_degre = 0;
        for (int s : sommets.keySet()){
            somme_degre+= sommets.get(s).size();
        }

        return somme_degre/2;
    }

    /**
     * Methode retournanr un tuple contenant le degré minimum et maximum du graphe
     * @return un objet de type Pair
     */
    public Pair degreMinDegreMax(){
        int min = sommets.get(0).size(); // On initialise la taille min
        for(int s : sommets.keySet()){
            if (sommets.get(s).size()<min) min = sommets.get(s).size();
        }

        int max = sommets.get(0).size();
        for(int s : sommets.keySet()){
            if (sommets.get(s).size()>max) max = sommets.get(s).size();
        }

        return new Pair<Integer, Integer>(min,max);
    }

    /**
     * Affiche le conteny de la Map dans un string
     * @return String
     */
    public String toString() {
        String affichage ="";
        String graphe = sommets.toString();
        String ordre = "Ordre "+ordre();
        String degres = "Degré min : "+degreMinDegreMax().getValue(0) +" -- Degré max : "+degreMinDegreMax().getValue(1);
        String taille = "Taille "+taille();

        affichage += "Fichier : "+fichier+"\n"+ordre+" - "+taille+"\n"+degres+"\n";

        for (int s : sommets.keySet()){
            String ligne = "Sommet "+s+" — degré "+degre(s)+", voisins : "+sommets.get(s)+"\n";
            affichage += ligne;
        }

        return affichage;

    }


}
