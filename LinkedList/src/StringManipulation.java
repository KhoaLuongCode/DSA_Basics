public class StringManipulation {

    public static String toPostfix(String infix) {
        // a postfix string variable to update
        StringBuilder postfix = new StringBuilder();

        // create a new stack
        LinkedListStack<Character> stack = new LinkedListStack<>();

        infix = infix.replaceAll("\\s+", "");

        // loop through the input string
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            // if token is an operand, write it to the output stream
            if (Character.isDigit(ch)) {
                postfix.append(ch);
            }
            // if token is the + * - / operator
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // pop all operators of higher or equal precedence outputting
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                // push token onto the stack
                stack.push(ch);
            }
            // if token is '(' push it onto the stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // if token is ')' pop all operators from the stack stopping AFTER the '(' is read and output each operator in the order popped from
            // the stack except for the '('.  NEVER output '(' or ')' as these
            //are not part of a postfix expression.
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
        }
        // loop through the stack
        while (!stack.isEmpty()) {
            // append every element on top of the stack
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    private static int precedence(char ch) {
        // Helper method that determines the precedence of the input char
        // + and - lower precedence than * and /, return 0
        if (ch == '+' || ch == '-') {
            return 0;
        }
        // * and / higher precedence so return 1
        else if (ch == '*' || ch == '/') {
            return 1;
        }
        // if neither then return -1
        else {
            return -1;
        }
    }

    public static int result(String postfix) {

        // create a stack of integers
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        // variable result to update the result of two operand
        int result = 0;

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            // if digit then push to the stack
            if (Character.isDigit(ch)) {
                stack.push(Integer.parseInt(String.valueOf(ch)));
                // if operator then pop two operands
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                // four cases of four operators: + - * /
                if (ch == '+') {
                    result = operand1 + operand2;
                } else if (ch == '-') {
                    result = operand1 - operand2;
                } else if (ch == '*') {
                    result = operand1 * operand2;
                } else if (ch == '/') {
                    result = operand1 / operand2;
                }
                // push the result to the stack
                stack.push(result);
            }
        }
        return stack.pop();
    }


    public static String smallestNumber(String number, int n){

        // create a result string variable using a string builder
        StringBuilder resultString = new StringBuilder();

        // create a stack of characters
        LinkedListStack<Character> stack = new LinkedListStack<>();

        // if n = 0 so there is no number to remove, just return the number
        if (n == 0){
            return number;
        }

        // check if the n is longer than the length of the string
        if (n > number.length()){
            return "0";
        }

        for (int i = 0; i < number.length(); i++){
            char num = number.charAt(i);
            while (!stack.isEmpty() && n > 0 && stack.peek() > num){
                // pop if the number is greater than the one deleted
                stack.pop();
                // keep track of how many digits we have deleted so far
                n = n - 1;
            }
            if (!stack.isEmpty() || num != '0'){
                stack.push(num);
            }
        }

        while (!stack.isEmpty() && n > 0) {
            n = n - 1;
            stack.pop();
        }

        // if after removal there is nothing in the stack then return 0
        if (stack.isEmpty()){
            return "0";
        }

        // loop through the stack
        while (!stack.isEmpty()){
            // append the elements at the top of the stack
            resultString.append(stack.pop());
        }
        // because it is in reverse so call the reverse method
        return resultString.reverse().toString();
    }

    public static String unbelievableString(String s) {

        // create a string builder field
        StringBuilder result = new StringBuilder();
        // create a new stack
        LinkedListStack<Character> stack = new LinkedListStack<>();
        // for loop to loop through the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // checks whether the stack is empty. the character
            if (!stack.isEmpty() && Character.toLowerCase(stack.peek()) == Character.toLowerCase(c) && stack.peek() != c) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }

        // loop through the stack
        while (!stack.isEmpty()) {
            // insert at first position the first element of the stack
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}
