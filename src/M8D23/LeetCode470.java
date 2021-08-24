package M8D23;

/**
 * 用Rand7()实现Rand10()
 */
public class LeetCode470 {
    public int rand10() {
        /*int a=rand7(), b=rand7();
        while(a==7)
            a=rand7();//a不能为7 必须为【1，6】这样才能保证奇偶都是1/2概率
        while(b>5)
            b=rand7();//b不能为5以上 因为一会可能要加5
        return ((a%2)==0?0:5)+b;//判断a奇偶性1/2 * b取值【0，5】之间1/5=1/10*/

        //或者构造出1-40的均匀分布
        int res;
        while (true){
            res=(rand7()-1)*7+rand7();
            if(res<=40)
                break;
        }
        //然后构造出1-10的均匀分布
        return res%10+1;


    }

    private int rand7(){
        return (int) (Math.random()*7);
    }
}
