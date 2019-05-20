class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null||image.length<1||image[0].length<1||sr<0||sr>=image.length||sc<0||sc>=image[0].length){
            return image;
        }
        int visited [][] = new int [image.length][image[0].length];
        int origin = image[sr][sc];
        reColor(image,sr,sc,origin,newColor,visited);
        return image;
    }
    public void reColor(int [][] image,int x,int y,int origin,int newColor,int [][] visited){
        if(x<0||x>=image.length||y<0||y>=image[0].length||visited[x][y]==1||image[x][y]!=origin){
            return;
        }else{
            image[x][y] = newColor;
            visited[x][y] = 1;
            reColor(image,x-1,y,origin,newColor,visited);
            reColor(image,x+1,y,origin,newColor,visited);
            reColor(image,x,y-1,origin,newColor,visited);
            reColor(image,x,y+1,origin,newColor,visited);
        }
    }
}