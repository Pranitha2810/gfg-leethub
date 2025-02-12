class Solution {
    public int findMinDifference(List<String> timePoints) {
        ArrayList<Integer> minutes = new ArrayList<>();
        for(String s:timePoints)
        {
           String[] parts = s.split(":");
           int hour = Integer.parseInt(parts[0]);
           int minute = Integer.parseInt(parts[1]);
           int totalmin = hour*60 + minute;
           minutes.add(totalmin);
        }
        Collections.sort(minutes);
        int minValue =Integer.MAX_VALUE;
        for(int i=1;i<minutes.size();i++)
        {
            minValue=Math.min(minValue,minutes.get(i)-minutes.get(i-1));
        }
        minValue=Math.min(minValue,1440+minutes.get(0)-minutes.get(minutes.size()-1));
        return minValue;
    }
}