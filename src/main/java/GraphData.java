import java.util.ArrayList;
import java.util.HashMap;

public class GraphData {

    public ArrayList<Node> createGraph() {

        /**
         * Noderna instansieras med namn och koordinater i en
         * HashMap med en kortare sträng som nyckel (ID)
         */
        HashMap<String,Node> nodes = new HashMap<>();
        nodes.put("bole", new Node("Böle bibliotek",           60.2008, 24.9359));
        nodes.put("vall", new Node("Vallgårds bibliotek",      60.1923, 24.9626));
        nodes.put("berg", new Node("Berghälls bibliotek",      60.1837, 24.9536));
        nodes.put("tolo", new Node("Tölö bibliotek",           60.1833, 24.9175));
        nodes.put("oodi", new Node("Centrumbiblioteket Ode",   60.174,  24.9382));
        nodes.put("rich", new Node("Richardsgatans bibliotek", 60.1663, 24.9468));
        nodes.put("bush", new Node("Busholmens bibliotek",     60.16,   24.9209));

        /**
         * Data för nodernas grannar enligt linjerna på kartan. HashMap med ID
         * och en enkel String[]-array för grannarnas ID.
         */
        HashMap<String,String[]> neighbours = new HashMap<>();
        neighbours.put("bole", new String[]{"tolo", "berg"});
        neighbours.put("vall", new String[]{"berg"});
        neighbours.put("berg", new String[]{"bole", "vall", "tolo", "oodi", "rich"});
        neighbours.put("tolo", new String[]{"bole", "berg", "oodi", "bush"});
        neighbours.put("oodi", new String[]{"tolo", "berg", "bush"});
        neighbours.put("rich", new String[]{"berg", "bush"});
        neighbours.put("bush", new String[]{"rich", "oodi", "tolo"});

        /**
         *  Själva grafstrukturen kommer att sparas i följande ArrayList
         */
        ArrayList<Node> graph = new ArrayList<>();

        /**
         * Iterera noderna enligt ID och lägg till grannarna
         */
        for (String id : nodes.keySet()) {

            /* Ange nyckeln (t.ex. "bole") som ID åt noden, kan vara bra att ha för UI  */
            nodes.get(id).setId(id);

            /* Iterera nodens grannar och lägg till dem till noden */
            for (String neighbour : neighbours.get(id)) {
                nodes.get(id).addNeighbour(nodes.get(neighbour));
            }

            /* Lägg in noden i själva grafstrukturen */
            graph.add(nodes.get(id));
        }

        return graph;
    }

}
