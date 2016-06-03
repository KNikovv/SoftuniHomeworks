import java.util.*;

public class BalancedParanthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean areBalanced = true;
        for(int i = 0; i < input.length(); i++){
            char current = input.charAt(i);
            if(current == '('|| current=='{' || current=='['){
                stack.push(current);
            }else{
                if(!stack.isEmpty()){
                    if(current==')'&&stack.peek()=='('){
                        stack.pop();
                    }else if(current==']'&&stack.peek()=='['){
                        stack.pop();
                    }else if(current=='}'&&stack.peek()=='{'){
                        stack.pop();
                    }else{
                        areBalanced= false;
                        break;
                    }
                }else{
                    areBalanced = false;
                    break;
                }
            }
        }


        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}