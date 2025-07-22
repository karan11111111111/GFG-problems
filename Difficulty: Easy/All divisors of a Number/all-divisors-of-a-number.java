
// class Solution {
//     public static void print_divisors(int n) {
//         // code here
//         if(n<1){
//             return;
//         }
//         for(int i=1; i<=n; i++){
//             if(n%i==0){
//                 System.out.print(i + " ");
//             }
//         }
//     }
// }

class Solution {
    public static void print_divisors(int n) {
        // code here
        if(n<1){
            return;
        }
        List<Integer> divisor = new ArrayList<>();
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                System.out.print(i + " ");
                
                if(i != n/i){
                    divisor.add(n/i);
                }
            }
            
        }
        
        Collections.reverse(divisor);
        
        for(int d: divisor){
            System.out.print(d+ " ");
        }
    }
}


// class Solution {
//     public static void print_divisors(int n) {
//         // code here
//         if(n<1){
//             return;
//         }
//       int i=1;
       
//       while(i<=n){
//           if(n%i == 0){
//               System.out.print(i + " ");
//           }
//           i++;
//       }
//     }
// }
