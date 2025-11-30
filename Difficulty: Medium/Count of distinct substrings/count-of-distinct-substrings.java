// class Solution {
//     public static int countSubs(String s) {
//         // code here
//         int n = s.length();
        
//         Set<String> st = new HashSet<>();

        
//         for(int i=0; i<n; i++){
//             for(int j=i+1; j<=n; j++){
                
//               st.add(s.substring(i,j));
                
//             }
//         }
        
//         return st.size();
        
//     }
// }

class Solution {

    static class State {
        int length, link;
        Map<Character, Integer> next = new HashMap<>();
    }

    static State[] st = new State[200000];
    static int size, last;

    static void saInit() {
        st[0] = new State();
        st[0].length = 0;
        st[0].link = -1;
        size = 1;
        last = 0;
    }

    static void saExtend(char c) {
        int cur = size++;
        st[cur] = new State();
        st[cur].length = st[last].length + 1;

        int p = last;
        while (p != -1 && !st[p].next.containsKey(c)) {
            st[p].next.put(c, cur);
            p = st[p].link;
        }

        if (p == -1) {
            st[cur].link = 0;
        } else {
            int q = st[p].next.get(c);
            if (st[p].length + 1 == st[q].length) {
                st[cur].link = q;
            } else {
                int clone = size++;
                st[clone] = new State();
                st[clone].length = st[p].length + 1;
                st[clone].next.putAll(st[q].next);
                st[clone].link = st[q].link;

                while (p != -1 && st[p].next.get(c) == q) {
                    st[p].next.put(c, clone);
                    p = st[p].link;
                }

                st[q].link = st[cur].link = clone;
            }
        }
        last = cur;
    }

    public static int countSubs(String s) {
        saInit();
        for (char c : s.toCharArray()) {
            saExtend(c);
        }

        long total = 0;
        for (int i = 1; i < size; i++) {
            total += st[i].length - st[st[i].link].length;
        }

        return (int) total;
    }
}
