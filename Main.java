import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println(SieveOfEratosthenes(120));
        GoldbachConjecture(120);
        ArrayList<Integer> n1 = new ArrayList<Integer>();
        n1.add(1);
        n1.add(9);
        ArrayList<Integer> n2 = new ArrayList<Integer>();
        n2.add(8);
        n2.add(1);
        ArrayList<Integer> n3 = add(n1, n2);
        System.out.println(n3);
    }
    public static ArrayList<Integer> SieveOfEratosthenes(int n){
        ArrayList<Integer> lst = new ArrayList<Integer>();

        for(int i = 2; i<= n; i++){
            lst.add(i);
        }
        for(int j = 0; j< lst.size(); j++) {
            for (int q = j + 1; q < lst.size(); q++) {
                if (lst.get(q) % lst.get(j) == 0) {
                    lst.remove(q);
                    q--;
                }
            }
        }
        return lst;
    }
    public static void GoldbachConjecture (int n){
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst = SieveOfEratosthenes(n);
        for(int i = 0; i< lst.size(); i++){
            int j = n - lst.get(i);
            if(lst.contains(j)){
                System.out.println(lst.get(i) + " + " + j + " = " + n);
                return;

            }
        }
    }
    public static ArrayList<Integer> add(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int c = a.size() - 1;
        int d = b.size() - 1;
        int e = 0;
        while (c >= 0 || d >= 0) {
            int s = 0;
            if (c >= 0 && d >= 0) {
                s = a.get(c) + b.get(d) + e;
            } else if (c >= 0) {
                s = a.get(c) + e;
            } else if (d >= 0) {
                s = b.get(d) + e;
            } else {
                s = e;
            }
            if (s > 9) {
                e = 1;
                s -= 10;
            } else {
                e = 0;
            }
            result.add(0, s);
            c--;
            d--;

        }
        if(e>0){
            result.add(0,1);
        }
        return result;
    }
}