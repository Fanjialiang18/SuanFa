package dp.Pack0_1;

/**
 * @author clearlove3
 */
public class Package0_1 {
    public int cal(int[] value,int[] weight,int pack){
        int[] res=new int[pack+1];
        res[0]=0;
        //遍历物品
        for (int i = 0; i < weight.length; i++) {
            //遍历背包容量
            for (int j = pack; j >=weight[i] ; j--) {
                res[j]=Math.max(res[j],res[j-weight[i]]+value[i]);
            }
        }
        return res[pack];
    }
}
