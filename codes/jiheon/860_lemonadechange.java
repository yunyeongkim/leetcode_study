class Solution {
      public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;

        for (int bill:bills){
            switch (bill){
                case 10 -> {
                    if (count5 == 0){
                        return false;
                    }
                    count5--;
                    count10++;
                }

                case 20 -> {
                    if (count10 > 0 && count5 > 0){
                        count10--;
                        count5 --;
                    }else if (count5 >= 3){
                        count5-=3;
                    }else{
                        return false;
                    }
                }

                default -> count5 ++;
            }
        }

        return true;
    }

}