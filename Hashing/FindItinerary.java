import java.util.HashMap;
import java.util.Map;

class FindItinerary {

    void FindOrder(Map<String, String>map) {
        Map<String, String>reverse = new HashMap<>();
        String start = "";
        for(Map.Entry<String, String>entry : map.entrySet()) {
            reverse.put(entry.getValue(), entry.getKey());
        }
        for(Map.Entry<String, String>entry: map.entrySet()) {
            if(reverse.get(entry.getKey()) == null) {
                start = entry.getKey();
                break;
            }
        }
        for(int i=0; i<reverse.size(); i++) {
            System.out.print(start + "-->" + map.get(start));
            System.out.println();
            start = map.get(start);
        }
    }

    public static void main(String[] args) {
        FindItinerary obj = new FindItinerary();
        Map<String, String>map = new HashMap<>();
        map.put("Chennai", "Banglore");
        map.put("Bombay", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");
        obj.FindOrder(map);
    }

}
