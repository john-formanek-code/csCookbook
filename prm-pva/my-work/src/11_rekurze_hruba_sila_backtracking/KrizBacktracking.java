package ctvrtak;

public class KrizBT {

static int level;
static int[] kriz = new int[5];

static void bt (){
   level++;
for(int i=1; i<=8; i++){
   kriz[level] = i;
   if(test()){
      bt();
   }
}

   level--;
}

static boolean test() {
   switch(level){
      case 0: return true;
      case 1: return (kriz[0] + kriz[1] ==10);
      case 2: return (kriz[0] > kriz[2]);
      case 3: return (Math.abs(hriz[0]-kriz[3])<4);
      case 4: {
         if (kriz[0]*kriz[4] <40){
            System.out.println();
         }
         return false;
      }

   }
   return true;
}

   public static void main(String[] args){
    level = -1;
    bt();
   }  
}