class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalcolor=image[sr][sc];
        if(originalcolor != color)
            Helper(image,originalcolor,color,sr,sc);
        return image;
    }
    static void Helper(int[][] image,int originalcolor,int color,int sr,int sc)
    {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != originalcolor) {
            return;
        }

        image[sr][sc]=color;
        Helper(image,originalcolor,color,sr,sc-1);
        Helper(image,originalcolor,color,sr,sc+1);
        Helper(image,originalcolor,color,sr+1,sc);
        Helper(image,originalcolor,color,sr-1,sc);

        
    }
}