package com.yinzifan.data_structures._01_array;

public class Array<T> {

	private T[] data;
	private int size;

	/**
	 * 
	 * @param capacity
	 *            传入数组的容量capacity构造Array
	 */
	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		data = (T[]) new Object[capacity];
		size = 0;
	}

	public Array() {
		this(10);
	}

	/**
	 * 
	 * @return 获取数组中的元素个数
	 */
	public int getSize() {
		return size;
	}

	/**
	 * 
	 * @return 获取数组的容量
	 */
	public int getCapacity() {
		return data.length;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 均摊复杂度(amortized time complexity): O(1)
	 * 
	 * @param e
	 */
	public void addLast(T e) {
		// if(size == data.length) {
		// throw new ArrayIndexOutOfBoundsException();
		// }
		// data[size] = e;
		// size++;
		add(size, e);
	}

	public void addFirst(T e) {
		add(0, e);
	}

	/**
	 * O(n)
	 * 
	 * @param index
	 * @param e
	 */
	public void add(int index, T e) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (size == data.length) {
			// throw new ArrayIndexOutOfBoundsException();
			resize(data.length * 2);
		}
		for (int i = size - 1; i >= index; i--) {
			data[i + 1] = data[i];
		}
		data[index] = e;
		size++;
	}

	/**
	 * O(n)
	 * 
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	private void resize(int capacity) {
		T[] newData = (T[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/**
	 * 
	 * @param index
	 *            根据索引获取相应位置的元素(O(1))
	 * @return
	 */
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return data[index];
	}

	public T getFirst() {
		return get(0);
	}
	
	public T getLast() {
		return get(size - 1);
	}
	
	
	/**
	 * 为指定位置的元素更新值(O(1))
	 * 
	 * @param index
	 * @param e
	 */
	public void set(int index, T e) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		data[index] = e;

	}

	/**
	 * O(n)
	 * 
	 * @param e
	 * @return
	 */
	public boolean contains(T e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * O(n) 查找数组中的元素返回相应索引, 如果没有查找到返回-1
	 * 
	 * @param e
	 * @return
	 */
	public int find(T e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	public T removeFirst() {
		return remove(0);
	}

	public T removeLast() {
		return remove(size - 1);
	}

	/**
	 * O(n)
	 * 
	 * @param index
	 * @return
	 */
	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		T ret = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}
		size--;
		data[size] = null; // loitering objects 消除游离对象.
		if (size == data.length / 4 && data.length / 2 != 0) {
			resize(data.length / 2);
		}

		return ret;
	}

	public void removeElement(T e) {
		int index = find(e);
		if (index != -1) {
			remove(index);
		}
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size=%d, capacity = %d \n", size, data.length));
		res.append("[");
		for (int i = 0; i < size; i++) {
			res.append(data[i]);
			if (i != size - 1) {
				res.append(", ");
			}
		}
		res.append("]");
		return res.toString();
	}

}
