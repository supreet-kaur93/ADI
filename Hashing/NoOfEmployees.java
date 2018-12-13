import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

/*
   a c      c a
   b c      c b
   c f      f c
   d e      e d
   e f      f e
   f f      f f


*/

class NoOfEmployees {

    // c---a,b    f---c,e    e---d

    Map<String, Integer>res = new HashMap<>();

    @SuppressWarnings("unchecked")
    void FindEmployees(Map<String, String>map) {
        Map<String, LinkedList>reverseList = new HashMap<>();
        for(Map.Entry<String, String>entry : map.entrySet()){
            String emp = entry.getKey();
            String mngr = entry.getValue();
            if(!emp.equals(mngr)) {
                LinkedList<String> getList = reverseList.get(mngr);
                if(getList != null) {
                     getList.add(emp);
                }
                else {
                     getList = new LinkedList<String>();
                     getList.add(emp);
                }
                reverseList.put(emp, getList);
            }
        }

        // iterate for each employee
        for(String emp: map.keySet()) {
            CountRes(emp, reverseList);
        }
    }

    @SuppressWarnings("unchecked")
    int CountRes(String emp, Map<String, LinkedList>map) {
        int count = 0;
        if(!map.containsKey(emp)) {
            res.put(emp, 0);
            return 0;
        }
        else if(res.get(emp) != null) {
            return res.get(emp);
        }
        LinkedList<String>list = map.get(emp);
        count = list.size();
        for(String ListEmp: list) {
            count = count + CountRes(ListEmp, map);
        }
        res.put(emp, count);
        return count;
    }

    void Display() {
        for(Map.Entry<String, Integer>map: res.entrySet()) {
            System.out.println(map.getKey() + " " + map.getKey());
            System.out.println();
        }
    }

    public static void main(String[] args) {
         NoOfEmployees obj = new NoOfEmployees();
         Map<String, String> map = new HashMap<>();
         map.put("a", "c");
         map.put("b", "c");
         map.put("c", "f");
         map.put("d", "e");
         map.put("e", "f");
         map.put("f", "f");
         obj.FindEmployees(map);
         obj.Display();
    }

}
