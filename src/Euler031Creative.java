
public class Euler031Creative {

	public static void main(String[] args) {
		int maxx = 200;
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };
        long[] ways = new long[maxx+1];
        ways[0] = 1;

        for(int coin : coins)
            for (int i = coin; i <= maxx; i++)
                ways[i] += ways[i - coin];

        System.out.print(ways[maxx]);

	}

}
