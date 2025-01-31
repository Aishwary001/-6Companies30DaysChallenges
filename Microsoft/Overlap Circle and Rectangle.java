class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearest_X = Math.max(x1, Math.min(x2, xCenter));
        int nearest_Y = Math.max(y1, Math.min(y2, yCenter));

        int distX = nearest_X - xCenter;
        int distY = nearest_Y - yCenter;

        return distX * distX + distY * distY <= radius * radius;
    }
}
