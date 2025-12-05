// class Solution {
//     int majorityElement(int arr[]) {
//         // code here
//         int count =0;
//         int candidate=0;
//         for(int i=0; i<arr.length; i++){
//             if(count  ==0){
//                 candidate = arr[i];
//                 count =1;
//             }else if(arr[i] == candidate){
//                 count++;
//             }else{
//                 count --;
//             }
//         }
//         int fre =0;
//         for(int a : arr){
//             if(a == candidate){
//                 fre++;
//             }
//         }
       
//       return (fre>arr.length/2)? candidate : -1;
        
//     }
// }
class Solution {
    int majorityElement(int arr[]) {
        // code here
        int count =0; 
        int candidate =0;
       for(int i=0; i<arr.length; i++){
           if(count ==0){
               candidate = arr[i];
               count =1;
           }else if(candidate == arr[i]){
               count++;
           }else{
               count--;
           }
       }
       int frq=0;
       for(int a: arr){
           if(a == candidate){
               frq++;
           }
       }
        
    return (frq> arr.length/2 ? candidate :-1 );
        
    }
}