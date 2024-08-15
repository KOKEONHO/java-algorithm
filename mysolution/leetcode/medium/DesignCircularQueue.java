package leetcode.medium;

public class DesignCircularQueue {
	private int[] queue;
	private int headIndex;
	private int count;
	private int capacity;

	public DesignCircularQueue(int k) {
		this.capacity = k;
		this.queue = new int[k];
		this.headIndex = 0;
		this.count = 0;
	}

	public boolean enQueue(int value) {
		if (this.count == this.capacity) {
			return false;
		}
		this.queue[(this.headIndex + this.count) % this.capacity] = value;
		this.count++;
		return true;
	}

	public boolean deQueue() {
		if (this.count == 0) {
			return false;
		}
		this.headIndex = (this.headIndex + 1) % this.capacity;
		this.count--;
		return true;
	}

	public int Front() {
		if (this.count == 0) {
			return -1;
		}
		return this.queue[this.headIndex];
	}

	public int Rear() {
		if (this.count == 0) {
			return -1;
		}
		return this.queue[(this.headIndex + this.count - 1) % this.capacity];
	}

	public boolean isEmpty() {
		if (this.count == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (this.count == capacity) {
			return true;
		}
		return false;
	}
}
