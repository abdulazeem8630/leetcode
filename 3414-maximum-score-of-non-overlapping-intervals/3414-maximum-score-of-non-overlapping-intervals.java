import java.util.*;

class Solution {
    private static class Interval {
        int l, r, w, id;
        Interval(int l, int r, int w, int id) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.id = id;
        }
    }

    private static class Element {
        long w;
        List<Integer> idx;
        Element(long w, List<Integer> idx) {
            this.w = w;
            this.idx = idx;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervalsList) {
        int n = intervalsList.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(intervalsList.get(i).get(0), intervalsList.get(i).get(1), intervalsList.get(i).get(2), i);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.l, b.l));

        int[] nextIdx = new int[n];
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n, ans = n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (mid < n && arr[mid].l > arr[i].r) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            nextIdx[i] = ans;
        }

        Element[][] dp = new Element[n + 1][5];
        for (int j = 0; j <= 4; j++) {
            dp[n][j] = new Element(0, new ArrayList<>());
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 4; j++) {
                dp[i][j] = dp[i + 1][j];

                if (j > 0) {
                    Element nextState = dp[nextIdx[i]][j - 1];
                    long newWeight = arr[i].w + nextState.w;
                    List<Integer> newIdx = new ArrayList<>();
                    newIdx.add(arr[i].id);
                    newIdx.addAll(nextState.idx);

                    if (newWeight > dp[i][j].w) {
                        dp[i][j] = new Element(newWeight, newIdx);
                    } else if (newWeight == dp[i][j].w) {
                        List<Integer> sortedNew = new ArrayList<>(newIdx);
                        Collections.sort(sortedNew);
                        List<Integer> sortedOld = new ArrayList<>(dp[i][j].idx);
                        Collections.sort(sortedOld);

                        if (compareLists(sortedNew, sortedOld) < 0) {
                            dp[i][j] = new Element(newWeight, newIdx);
                        }
                    }
                }
            }
        }

        List<Integer> ansList = new ArrayList<>(dp[0][4].idx);
        Collections.sort(ansList);
        int[] result = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            result[i] = ansList.get(i);
        }
        return result;
    }

    private int compareLists(List<Integer> a, List<Integer> b) {
        int len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }
        return Integer.compare(a.size(), b.size());
    }
}
