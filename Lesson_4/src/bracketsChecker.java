import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
Написать программу, определяющую правильность расстановки скобок в выражении
 */
public class bracketsChecker {

    public static void main(String[] args) {              //условие:    //результат:
        System.out.println(isValid("a+(d*3)"));       // истина       // true
        System.out.println(isValid("[a+(1*3)"));      // ложь         // false
        System.out.println(isValid("[6+(3*3)]"));     // истина       // true
        System.out.println(isValid("{a}[+]{(d*3)}")); // истина       // true
        System.out.println(isValid("<{a}+{(d*3)}>")); // истина       // true
        System.out.println(isValid("{a+]}{(d*3)}"));  // ложь         // false
    }

    private static boolean isValid(String input) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put('>', '<');

        Deque<Character> stack = new LinkedList<>();
        for (char c : input.toCharArray()) {
            if (brackets.containsValue(c)) {
                stack.push(c);
            } else if (brackets.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}