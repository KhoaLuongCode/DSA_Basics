import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Assignment2Tester{

    @Test
    public void toPostFixTest(){
        // CASE 1: With parenthesis
        assertEquals("34+5*6-", StringManipulation.toPostfix("(3+4)*5-6"));
        // CASE 2: Higher precedence first
        assertEquals("43*2/11+", StringManipulation.toPostfix("4*3/2+11"));
        // CASE 3: Lower precedence first
        assertEquals("42+115*2/-", StringManipulation.toPostfix("4+2-11*5/2"));
        // CASE 4: No operator
        assertEquals("1111111", StringManipulation.toPostfix("1111111"));
    }

    @Test
    public void resultTest(){
        // CASE 1: Case with + and - operator
        assertEquals(-4, StringManipulation.result("3 20 + 6 -"));
        // CASE 2: Case with * operator
        assertEquals(-9, StringManipulation.result("23 - 45 + *"));
        // CASE 3:Case with / operator
        assertEquals(1, StringManipulation.result("21/2+1"));
        // CASE 4: No operator
        assertEquals(3, StringManipulation.result("3333"));

    }

    @Test
    public void smallestNumberTest(){
        // CASE 1: Remove all leading zeros
        assertEquals("4", StringManipulation.smallestNumber("70004", 1));
        // CASE 2: No leading zeros
        assertEquals("218281", StringManipulation.smallestNumber("92818281", 2));
        // CASE 3: Removal n is the same as number length => return 0
        assertEquals("0", StringManipulation.smallestNumber("123", 3));
        // CASE 4: Removal n is larger than the length of the number
        assertEquals("0", StringManipulation.smallestNumber("123", 9));
        // CASE 5: Removal n is 0, no number was removed
        assertEquals("123", StringManipulation.smallestNumber("123", 0));
    }

    @Test
    public void unbelievableStringTest(){
        // CASE 1: Double removal of upper case and lower case
        assertEquals("abdE", StringManipulation.unbelievableString("abDDdddE"));
        // CASE 2: Removal of all upper case and lower case together
        assertEquals("a", StringManipulation.unbelievableString("abBbBbBbBbB"));
        // CASE 3: There is no removal
        assertEquals("abcdefg", StringManipulation.unbelievableString("abcdefg"));

    }

    @Test
    public void isEmptyTest(){
        // CASE 1: The stack is empty
        LinkedListStack stack = new LinkedListStack();
        assertEquals(true, stack.isEmpty());

        // CASE 2: The stack is not empty
        LinkedListStack stack1 = new LinkedListStack();
        stack1.push(1);
        assertEquals(false, stack1.isEmpty());
    }

    @Test
    public void popAndPushTest(){
        // CASE 1: The stack is empty => pop() returns null
        LinkedListStack stack = new LinkedListStack();
        assertEquals(null, stack.pop());

        // CASE 2: The stack is not empty => pop() returns 1
        LinkedListStack stack1 = new LinkedListStack();
        stack1.push(1);
        assertEquals(1, stack1.pop());

        // CASE 3: Push two values and the top of the stack is updated. Also test the push method that pushes two values on top of the stack
        LinkedListStack stack2 = new LinkedListStack();
        stack2.push(1);
        stack2.push(24);
        assertEquals(24, stack2.pop());
    }

    @Test
    public void peekTest(){
        // CASE 1: There is an element to peek
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        assertEquals(1, stack.peek());

        // CASE 2: The stack is empty
        LinkedListStack stack1 = new LinkedListStack();
        assertEquals(null, stack1.peek());
    }








}