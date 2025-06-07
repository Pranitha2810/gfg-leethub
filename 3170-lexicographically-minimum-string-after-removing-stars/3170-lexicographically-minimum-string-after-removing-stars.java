class Solution {
    public String clearStars(String s) {
        // Stack array for each character from 'a' to 'z'
        Stack<Integer>[] charStacks = new Stack[26];
        for (int i = 0; i < 26; i++) {
            charStacks[i] = new Stack<>();
        }

        // List to simulate result building
        List<Character> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                // Find smallest character with an index to remove
                for (int j = 0; j < 26; j++) {
                    if (!charStacks[j].isEmpty()) {
                        int pos = charStacks[j].pop();
                        result.set(pos, null); // Mark for deletion
                        break;
                    }
                }
            } else {
                // Track character position in result
                charStacks[ch - 'a'].push(result.size());
                result.add(ch);
            }
        }

        // Build final string, skipping nulls
        StringBuilder sb = new StringBuilder();
        for (Character c : result) {
            if (c != null) sb.append(c);
        }

        return sb.toString();
    }
}
