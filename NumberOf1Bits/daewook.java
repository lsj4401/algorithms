public int hammingWeight(int n) {
    int res = 0;

    while (n > 0) {
        if (masking(n,1) % 2 == 1) {
            res++;
        }
        n = n>>1;
    }

    return res;
}

private int masking (int input, int mask) {
    return input&mask;
}