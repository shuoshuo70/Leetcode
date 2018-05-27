package LC41;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AutocompleteSystem {
    List<Element> dict;
    String prefix;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        dict = new ArrayList<>();
        prefix = "";
        
        for(int i=0; i<sentences.length; i++) {
            dict.add(new Element(sentences[i], times[i]));
        }
        
        Collections.sort(dict, new Comparator<Element>() {
            public int compare(Element e1, Element e2) {
                if(e1.time == e2.time) return e1.word.compareTo(e2.word);
                return e2.time - e1.time;
            }
        });
    }
    
    public List<String> input(char c) {
        List<String> list = new ArrayList<>();
        
        if(c == '#') {
            boolean found = false;
            
            for(Element e : dict) {
                if(e.word.equals(prefix)) {
                    e.time++;
                    found = true;
                    break;
                }
            }
            
            if(!found) dict.add(new Element(prefix, 1));
            
            Collections.sort(dict,  new Comparator<Element>() {
                public int compare(Element e1, Element e2) {
                    if(e1.time == e2.time) return e1.word.compareTo(e2.word);
                    return e2.time - e1.time;
                }
            });
            
            prefix = "";
            
        } else {
            prefix += c;
            
            for(Element e : dict) {
                if(e.word.startsWith(prefix)) {
                    list.add(e.word);
                    if(list.size() == 3) break;
                }
            }
        }
        
        return list;
    }
    
    class Element {
        String word;
        int time;
        
        Element(String word, int time) {
            this.word = word;
            this.time = time;
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */