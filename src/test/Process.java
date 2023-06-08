package test;

import java.util.Stack;
public class Process {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>(),stack2 = new Stack<Character>();
        StringBuffer stringBuffer = new StringBuffer();
        for(char c = 'A';c <= 'D';c++) {
            // stack.push(new Character(c));
        }
        while (!(stack.empty())) {
            Character temp = stack.pop();
            stack2.push(temp);
        }
        while(!(stack2.empty())) {
            Character temp = stack2.pop();
            stringBuffer.append(temp.charValue());
        }
        System.out.println(stringBuffer);
    }
}
