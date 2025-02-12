class Solution {

    int[][] rects;
    Random r=new Random();
    int total=0;
    List<Integer> sum=new ArrayList<>();
    public Solution(int[][] rects) {
        this.rects=rects;
        for(int[] rec:rects){
            total+=(rec[2]-rec[0]+1)*(rec[3]-rec[1]+1);
            sum.add(total);
        }
    }
    
    public int[] pick() {
        int target= r.nextInt(total);
        int lo=0,hi=rects.length-1;
        while(lo<hi){
            int mid = lo  + (hi - lo)/2;
            
            if(target>=sum.get(mid)) lo = mid+1;
            else hi=mid;
        }
        int[] rect=rects[lo];
        int x1=rect[0];
        int y1=rect[1];
        int x2=rect[2];
        int y2=rect[3];
        int x=r.nextInt(x2-x1+1);
        int y=r.nextInt(y2-y1+1);
        return new int[]{x1+x,y1+y};
    }
}
