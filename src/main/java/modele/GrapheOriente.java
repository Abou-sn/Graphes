package modele;

import java.util.*;


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

    public TreeMap<Integer,Integer> degresEntrants() {
        TreeMap<Integer,Integer> degreeEntrants = new TreeMap<>();

        for (int s : voisinsSortants.keySet()) {
            degreeEntrants.put(s, 0);
        }
        for (int s : degreeEntrants.keySet()){

            for(int sommet : voisinsSortants.keySet()){
                if (voisinsSortants.get(sommet).contains(s)) degreeEntrants.put(s,degreeEntrants.get(s)+1);
            }
        }
        return degreeEntrants;

    }

    public List<Integer> ordreTopologique(){
        LinkedList<Integer> resultat = new LinkedList<>();
        LinkedList<Integer> file = new LinkedList<>();
        TreeMap<Integer,Integer> degres = degresEntrants();
        for(int s : voisinsSortants.keySet()){
            if (degres.get(s) == 0){
                file.add(s);
            }
        }

        while (!file.isEmpty()){
            int s = file.removeFirst();
            resultat.add(s);

            for (int v : voisinsSortants.get(s)){
                degres.put(v,degres.get(v)-1);
                if (degres.get(v) == 0) {
                    file.add(v);
            }


        }

            }

        return resultat;
    }

    /**
     * Retourne la taille du graphe this
     * @return int
     */
    public int taille(){
        int somme_degre = 0;
        for (int s : voisinsSortants.keySet()){
            somme_degre+= degreSortants(s);
        }

        return somme_degre;
    }

    public String toString() {
        String affichage ="";
        String ordre = "Ordre "+ordre();
        String taille = "Taille "+taille();

        affichage += "Fichier : "+fichier+"\n"+ordre+" - "+taille+"\n";

        for (int s : voisinsSortants.keySet()){
            String ligne = "Sommet "+s+" — d sortants, "+degreSortants(s)+" | d entrants : "+degresEntrants().get(s)+", voisins sortants : "+voisinsSortants.get(s)+"\n";
            affichage += ligne;
        }

        return affichage;
    }
}
