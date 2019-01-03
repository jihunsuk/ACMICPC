import java.util.Scanner;

public class N_2985 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        int second = scan.nextInt();
        int third = scan.nextInt();
        boolean find = false;
        if(first == op(second, third, '+')){
            System.out.println(first +"="+second+"+"+third);
            find = true;
        }
        else if(!find && first == op(second, third, '-')){
            System.out.println(first +"="+second+"-"+third);
            find = true;
        }
        else if(!find && first == op(second, third, '*')){
            System.out.println(first +"="+second+"*"+third);
            find = true;
        }
        else if(!find && first == op(second, third, '/')){
            System.out.println(first +"="+second+"/"+third);
            find = true;
        }
        else if(!find && op(first, second, '+') == third){
            System.out.println(first+"+"+second+"="+third);
            find = true;
        }
        else if(!find && op(first, second, '-') == third){
            System.out.println(first+"-"+second+"="+third);
            find = true;
        }
        else if(!find && op(first, second, '*') == third){
            System.out.println(first+"*"+second+"="+third);
            find = true;
        }
        else if(!find && op(first, second, '/') == third){
            System.out.println(first+"/"+second+"="+third);
            find = true;
        }
    }
    static int op(int l, int r, char op){
        if (op == '+')
            return l+r;
        else if (op == '-')
            return l-r;
        else if (op == '*')
            return l*r;
        else
            return l/r;
    }
}
