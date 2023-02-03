
/*
Vampires are numbers consisting of an even number of digits and obtained by multiplying a pair of numbers,
 each of which contains half the digits of the result.
 Digits are taken from the original number in random order, trailing zeros are not allowed.
 */
/*
Author FullFe
 */
public class Den {
    public static void main(String[] args) {
        for(int i = 1000; i<10000; i++){
            if(i %100 == 0)
                continue;
            check(i, allPos(i));
        }
    }
    public static int[] allPos(int num){ // get all possible digits from a 4-digit number
        int[] allDoub = new int[12];
        String numsStr = Integer.toString(num);
        int k = 0;
        for(int i=0, j = i+1;i<3;i++, j = i+1){
            while(j<4){
                allDoub[k] = Integer.parseInt(String.valueOf(numsStr.charAt(i))+ numsStr.charAt(j));
                allDoub[k+1] = Integer.parseInt(String.valueOf(numsStr.charAt(j))+ numsStr.charAt(i));
                k +=2;
                j++;
            }
        }
        return allDoub;
    }
    public static boolean check(int num, int[] mass){ // is the number a vampire
        for(int i =0; i<12;i++){
            if(mass[i] == 0 || num % mass[i] != 0)
                continue;
            int res = num / mass[i];
            for(int k =0;k<12;k++){
                if(k==i)
                    continue;
                if(res == mass[k]){
                    System.out.println(mass[i] + "*" + mass[k] + " = " + num);
                    return true;
                }
            }
        }
        return false;
    }
}
