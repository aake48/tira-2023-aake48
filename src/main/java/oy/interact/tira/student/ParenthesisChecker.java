package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

   public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {

      int column = 1;
      int line = 1;
      int parentheses = 0;
      Character poppedParenthesis;
      boolean quoteStatus = false;

      // for each character in the input string

      for (int index = 0; index < fromString.length(); index++) {
         Character currentCharacter = fromString.charAt(index);

         column++;

         // if in between of quotes
         // ignore this character (but count column numbers)
         if (currentCharacter == '"') {
            quoteStatus = !quoteStatus;
         }

         if (quoteStatus == true) {

            continue;
         }

         if (currentCharacter == '\n') {
            line++;
            column = 1;
         }
         // if character is an opening parenthesis -- one of "([{"
         // push it into the stack (check for failure and throw an exception if so)
         if (currentCharacter.equals('[') || currentCharacter.equals('{') || currentCharacter.equals('(')) {
            try {
               stack.push(currentCharacter);
               parentheses++;
            } catch (Exception e) {
               throw new ParenthesesException("Stack push failed", line, column - 1,
                     ParenthesesException.STACK_FAILURE);
            }

            // else if character is a closing parenthesis -- one of ")]}"
            // pop the latest opening parenthesis from the stack
         } else if (currentCharacter.equals(']') || currentCharacter.equals('}') || currentCharacter.equals(')')) {
            parentheses++;

            // if the popped item is null
            // throw an exception, there are too many closing parentheses
            try {
               poppedParenthesis = stack.pop();
            } catch (Exception e) {
               throw new ParenthesesException("Too many closing parentheses", line, column - 1,
                     ParenthesesException.TOO_MANY_CLOSING_PARENTHESES);
            }

            // check the popped opening parenthesis against the closing parenthesis read
            // from the string
            // if they do not match -- opening was { but closing was ], for example.
            // throw an exception, wrong kind of parenthesis were in the text (e.g. "asfa (
            // asdf } sadf")

            if (poppedParenthesis.equals('[') && !currentCharacter.equals(']')
                  || poppedParenthesis.equals('(') && !currentCharacter.equals(')')
                  || poppedParenthesis.equals('{') && !currentCharacter.equals('}')) {
               throw new ParenthesesException("Wrong kind of parenthesis were in the text", line, column - 1,
                     ParenthesesException.PARENTHESES_IN_WRONG_ORDER);
            }

         }

      }

      // if the stack is not empty after all the characters have been handled
      // throw an exception since the string has more opening than closing
      // parentheses.

      if (!stack.isEmpty()) {
         throw new ParenthesesException("Too many opening paranthesis in string", line, column - 1,
               ParenthesesException.TOO_MANY_OPENING_PARENTHESES);
      }
      
      //return the amount of parentheses
      return parentheses;
   }
}
