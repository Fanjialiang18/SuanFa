package HomeWork;

public class Demo {
    public static void main(String[] args) {
        char [][] a1=new char[2][2];
        System.out.println((int)a1[0][0]);
        System.out.println(a1.length);
        int [] b={1,2,3,4,5,6,7,8,9,10};
        System.out.println(b);
        String[][] a = {
                {"Beijing","Wuhan"},
                {"Shanghai","Guangzhou","Xian"},
                {"Chongqing","Chengdu"}
        };
        System.out.println(a[a.length - 1].length);
        System.out.println(a[a.length - 1][a[a.length - 1].length - 1].length());
        System.out.println(new int[10].length);
        System.out.println("--------------");
        show();



    }

    public static void  show(){
        int[] a = {1};
        String[] s = {"Hello"};
        int i = a[0];
        m(s,a,i);
        for(String v:s){
            System.out.println(v);
        }
        for(int v:a){
            System.out.println(v);
        }
        System.out.println(i);

    }
    public static void m(String[] a1, int[] a2, int i){
        for(int j =0; j < a1.length;j++){
            a1[j] = "Java";
        }
        for(int j =0; j < a2.length;j++){
            a2[j]++;
        }
        i++;
    }


}
