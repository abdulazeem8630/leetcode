class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[]{-1, -1};
        if (head == null || head.next == null || head.next.next == null) {
            return result;
        }

        int firstCriticalIndex = -1;
        int prevCriticalIndex = -1;
        int minDistance = Integer.MAX_VALUE;
        
        ListNode prev = head;
        ListNode curr = head.next;
        int currentIndex = 1;

        while (curr.next != null) {
            ListNode next = curr.next;
            
            boolean isMaxima = curr.val > prev.val && curr.val > next.val;
            boolean isMinima = curr.val < prev.val && curr.val < next.val;

            if (isMaxima || isMinima) {
                if (firstCriticalIndex == -1) {
                    firstCriticalIndex = currentIndex;
                } else {
                    minDistance = Math.min(minDistance, currentIndex - prevCriticalIndex);
                }
                prevCriticalIndex = currentIndex;
            }

            prev = curr;
            curr = next;
            currentIndex++;
        }

        if (firstCriticalIndex != -1 && prevCriticalIndex != firstCriticalIndex) {
            result[0] = minDistance;
            result[1] = prevCriticalIndex - firstCriticalIndex;
        }

        return result;
    }
}
