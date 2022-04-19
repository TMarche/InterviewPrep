package chapter5;

public class Executor {
	public int insertion(int n, int m, int i, int j) {
		return insertBits(n, m, i, j);
	}
	
	
	public int insertBits(int n, int m, int i, int j) {
		m = m << i;
		n = clearBits(n, i, j);
		n = updateBits(n, m, i, j);
		return n;
	}

	public int clearBits(int num, int i, int j) {
		if (j < i) return num;
		if (j > 32 || i > 32) return num;
		int left = j >= 31 ? 0 : -1 << j + 1;
		int right = i == 0 ? 0 : -1 >>> 32 - i;
		int mask = left | right;
		return num & mask;
	}
	
	public int updateBits(int n, int m, int i, int j) {
		if (j < i) return n;
		if (j > 32 || i > 32) return n;
		int left = j >= 31 ? 0 : -1 << j + 1;
		int right = i == 0 ? 0 : -1 >>> 32 - i;
		int mask = ~(left | right);
		return (n | (m & mask));
	}
	
	public int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}
	
	public boolean getBit(int num, int i) {
		return (num & (1 << i)) != 0;
	}
	
	public int setBit(int num, int i, boolean v) {
		int value = v ? 1 : 0;
		int mask = ~(1 << i);
		return (num & mask) | (value << i);
	}
}
