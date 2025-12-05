class Solution {
    public int[] twoSum(int[] arr, int target) {
        // ill do it once again just for fun
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i< arr.length; i++){
            int diff = target - arr[i]; 
            if(map.containsKey(diff)){
                return new int[]{map.get(diff) , i};
            }
            map.put(arr[i], i);
        }

        // to avoid return statement errors
        return new int[]{};
    }
}
