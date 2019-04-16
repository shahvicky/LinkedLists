import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Main {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String input = br.readLine();
      ParentList parent = new ParentList();
      List<JSONObject> parentList = new ArrayList<JSONObject>();
      JSONParser parser = new JSONParser();
      JSONArray json = (JSONArray) parser.parse(input);
      Iterator it = json.iterator();
      
      Queue<Integer> q = new LinkedList<>();
      
      
      
      
      while(it.hasNext()){
        JSONObject obj = (JSONObject) it.next();
        if(obj.get("parent_id") == null){
          parentList.add(obj);
        }
      }
      System.out.println(json.get(0));
      System.out.print(json.size());
      

      Iterator itr = parentList.iterator();
      while(itr.hasNext()){
        System.out.print(itr.next()+" ");
      }
    }
}

class ParentList{
  String[] parents;
}

class Parent{
  int id;
  String name;
  String[] children;
  int parent_id;
  public Parent(String parent){
    name = parent;
  }
}

