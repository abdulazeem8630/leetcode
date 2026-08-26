class Solution {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        a %= MOD;
        return superPowHelper(a, b, b.length - 1);
    }

    private int superPowHelper(int a, int[] b, int index) {
        if (index < 0) return 1;

        int lastDigit = b[index];

        int part1 = power(a, lastDigit);
        
        int part2 = power(superPowHelper(a, b, index - 1), 10);

        return (part1 * part2) % MOD;
    }

    private int power(int base, int exp) {
        int result = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return result;
    }
}
