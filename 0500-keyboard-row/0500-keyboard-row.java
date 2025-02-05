class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        Map<Character, Integer> charToRow = new HashMap<>();
        
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                charToRow.put(c, i);
                charToRow.put(Character.toUpperCase(c), i);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            int row = charToRow.get(word.charAt(0)); 
            boolean isValid = true;
            
            for (char c : word.toCharArray()) {
                if (charToRow.get(c) != row) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) result.add(word);
        }
        
        return result.toArray(new String[0]);
    }
}