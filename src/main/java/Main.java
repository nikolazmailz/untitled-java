//import javax.swing.text.html.parser.Entity;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Stream;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        int[] arr = {9, 4, 3, 9, 6, 1, 4, 8, 3, 0};
//
//        System.out.println(
//                Main.firstUniqueElement(arr)
//        );
//
//    }
//
//    public static int firstUniqueElement(int[] arr){
//        HashMap<Integer, Integer> map = new HashMap();
//
////        Arrays.stream(arr).map(e ->   map.containsKey(e) )
//
////        Arrays.stream(arr).reduce()
//
//        for(int i = 0; i < arr.length; i++){
//            if(map.containsKey(arr[i])){
//                map.compute(arr[i], (k, count) -> count + 1);
//            }else {
//                map.put(arr[i], 0);
//            }
//        }
//
//        for(int i = 0; i < arr.length; i++){
//            if(map.get(arr[i]) == 0){
//                return arr[i];
//            }
//        }
//
//        return 0;
//    }
//
//    private void move(Account a1, Account a2, int summa) {
//        synchronized (a1) {
//            synchronized (a2) {
//                a1.money = a1.money - summa;
//                a2.money = a2.money + summa;
//            }
//        }
//    }
//
//
//    /**
//     * users 100
//     * product 100
//     * SELECT * FROM users u JOIN product p ON 1=1
//     *
//     * user 1 join product 1
//     * user 1 join product 2
//     * user 1 join product 3
//     * /api/users
//     *
//     *
//     * */
//}
