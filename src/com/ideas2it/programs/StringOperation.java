import java.util.Stack;
import java.util.StringJoiner;

public class StringOperation {

    public static void main(String[] args) {
        String input = "10 * 3 - 8*( 3 + 2*(4-2) - 3*(1-3) - 10)".replaceAll("\\s+", "");
        System.out.println(evaluateExpression(input));
    }

    private static int evaluateExpression(String input) {
        Stack<Integer> resultStack = new Stack<>();
        int nextNumber;
        for (int i = 0; i < input.length(); i++) {
            if (i == 0) {
                resultStack.push(getNextNumbers(input, i));
                continue;
            }

            char currentCharacter = input.charAt(i);
            boolean isNumeric = charIsNumber(currentCharacter);
            if (isNumeric) {
                continue;
            }

            if (input.charAt(i + 1) == '(' || input.charAt(i + 1) == ')') {
                continue;
            }

            // To Evaluate the expression inside bracket
            if (currentCharacter == '(') {
                int bracketClosedIndex = getCloseBracketIndex(input, i);
                String bracketExpression = input.substring(i + 1, bracketClosedIndex);
                nextNumber = evaluateExpression(bracketExpression);
                currentCharacter = input.charAt(i - 1); // reset to last operation. So last operation & bracket result would be processed
                i = bracketClosedIndex;
            } else {
                nextNumber = getNextNumbers(input, i + 1);
            }

            switch (currentCharacter) {
                case '+':
                    resultStack.push(nextNumber);
                    break;
                case '-':
                    resultStack.push(-nextNumber);
                    break;
                case '*':
                    resultStack.push(resultStack.pop() * nextNumber);
                    break;
                case '/':
                    resultStack.push(resultStack.pop() / nextNumber);
                    break;
            }
        }

        int sum = 0;
        while (resultStack.iterator().hasNext()) {
            sum += resultStack.pop();
        }
        return sum;
    }

    private static boolean charIsNumber(char input) {
        return (int) input >= 48 && (int) input <= 57;
    }

    private static int getNextNumbers(String input, int index) {
        StringJoiner numberString = new StringJoiner("");
        for (int i = index; i < input.length(); i++) {
            if (charIsNumber(input.charAt(i))) {
                numberString.add(input.charAt(i) + "");
                continue;
            }
            break;
        }
        return Integer.parseInt(numberString.toString());
    }

    public static int getCloseBracketIndex(String input, int index) {
        int result = -1;
        for (int i = index + 1; i < input.length(); i++) {
            if ('(' == input.charAt(i)) {
                result++;
            } else if (')' == input.charAt(i)) {
                result--;
            }
            if (result == -2) {
                return i;
            }
        }
        return result;
    }

}
