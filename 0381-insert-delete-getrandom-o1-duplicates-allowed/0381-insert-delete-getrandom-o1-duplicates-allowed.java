import java.util.*;

class RandomizedCollection {
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> locs;
    private Random rand;

    public RandomizedCollection() {
        nums = new ArrayList<>();
        locs = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean notPresent = !locs.containsKey(val) || locs.get(val).isEmpty();
        
        if (notPresent) {
            locs.put(val, new LinkedHashSet<>());
        }
        
        locs.get(val).add(nums.size());
        nums.add(val);
        
        return notPresent;
    }
    
    public boolean remove(int val) {
        if (!locs.containsKey(val) || locs.get(val).isEmpty()) {
            return false;
        }
        
        int removeIdx = locs.get(val).iterator().next();
        locs.get(val).remove(removeIdx);
        
        int lastIdx = nums.size() - 1;
        int lastVal = nums.get(lastIdx);
        
        if (removeIdx < lastIdx) {
            nums.set(removeIdx, lastVal);
            
            locs.get(lastVal).remove(lastIdx);
            locs.get(lastVal).add(removeIdx);
        }
        
        nums.remove(lastIdx);
        
        if (locs.get(val).isEmpty()) {
            locs.remove(val);
        }
        
        return true;
    }
    
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
