import java.util.*;

class Solution {
    public String clearStars(String s) {
        // Create 26 stacks for each character from 'a' to 'z'
        Stack<Integer>[] charStacks = new Stack[26];
        for (int i = 0; i < 26; i++) {
            charStacks[i] = new Stack<>();
        }

        // List to store the resulting characters (null for deleted ones)
        List<Character> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                // Find the smallest lexicographical character with a valid position
                for (int j = 0; j < 26; j++) {
                    if (!charStacks[j].isEmpty()) {
                        int pos = charStacks[j].pop();
                        result.set(pos, null); // Mark for deletion
                        break;
                    }
                }
            } else {
                // Track the index of the character in result
                charStacks[ch - 'a'].push(result.size());
                result.add(ch);
            }
        }

        // Build the final output string, skipping null entries
        StringBuilder sb = new StringBuilder();
        for (Character c : result) {
            if (c != null) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

