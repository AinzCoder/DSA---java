public class stockPro{
    public static int isStock(int[] prices){
        int min=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            profit=Math.max(profit,prices[i]-min);//sell=6-1 is the profit
        }
        return profit;
    }
    public static void main(String []args){
        int[] prices={7,1,5,6,4};
        int result = isStock(prices);
        System.out.println(result);
    }
}