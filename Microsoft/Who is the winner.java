class Solution {
    public int findTheWinner(int n, int k) {
        boolean remove[] = new boolean[n];
        int currentIndex = 0; // Start from the first person (index 0)

        while (n > 1) {
            int count = 0;
            while (count < k) {
                if (!remove[currentIndex]) {
                    count++;
                }
                if (count == k) {
                    break;
                }
                currentIndex = (currentIndex + 1) % remove.length;
            }
            remove[currentIndex] = true;
            n--;
            // Move to the next person who is still in the game
            while (remove[currentIndex]) {
                currentIndex = (currentIndex + 1) % remove.length;
            }
        }

        for (int j = 0; j < remove.length; j++) {
            if (!remove[j]) {
                return j + 1;
            }
        }

        return -1;
    }
}
