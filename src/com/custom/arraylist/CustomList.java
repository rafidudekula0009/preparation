package com.custom.arraylist;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Objects;

public class CustomList<E> extends AbstractList<E> {

	private static final int DEFAULT_CAPACITY = 0;

	private static final Object[] EMPTY_ELEMENTDATA = {};

	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

	transient Object[] elementData; // non-private to simplify nested class access

	private int size;

	public CustomList(int initialCapacity) {
		if (initialCapacity > 0) {
			this.elementData = new Object[initialCapacity];
		} else if (initialCapacity == 0) {
			this.elementData = EMPTY_ELEMENTDATA;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
		}
	}

	/**
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public CustomList() {
		this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
	}

	/**
	 * Constructs a list containing the elements of the specified collection, in the
	 * order they are returned by the collection's iterator.
	 *
	 * @param c the collection whose elements are to be placed into this list
	 * @throws NullPointerException if the specified collection is null
	 */
	public CustomList(Collection<? extends E> c) {
		Object[] a = c.toArray();
		if ((size = a.length) != 0) {
			if (c.getClass() == CustomList.class) {
				elementData = a;
			} else {
				elementData = Arrays.copyOf(a, size, Object[].class);
			}
		} else {
			// replace with empty array.
			elementData = EMPTY_ELEMENTDATA;
		}
	}

	/**
	 * Trims the capacity of this {@code CustomList} instance to be the list's
	 * current size. An application can use this operation to minimize the storage
	 * of an {@code CustomList} instance.
	 */
	public void trimToSize() {
		modCount++;
		if (size < elementData.length) {
			elementData = (size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyOf(elementData, size);
		}
	}

	/**
	 * Increases the capacity of this {@code CustomList} instance, if necessary, to
	 * ensure that it can hold at least the number of elements specified by the
	 * minimum capacity argument.
	 *
	 * @param minCapacity the desired minimum capacity
	 */
	public void ensureCapacity(int minCapacity) {
		System.out.println("ensureCapacity invoked!!");
		if (minCapacity > elementData.length
				&& !(elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA && minCapacity <= DEFAULT_CAPACITY)) {
			modCount++;
			grow(minCapacity);
		}
	}

	/**
	 * Increases the capacity to ensure that it can hold at least the number of
	 * elements specified by the minimum capacity argument.
	 *
	 * @param minCapacity the desired minimum capacity
	 * @throws OutOfMemoryError if minCapacity is less than zero
	 */
	private Object[] grow(int minCapacity) {
		int oldCapacity = elementData.length;
		if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
			int newCapacity = this.newLength(oldCapacity, minCapacity - oldCapacity, /* minimum growth */
					oldCapacity >> 1 /* preferred growth */);
			return elementData = Arrays.copyOf(elementData, newCapacity);
		} else {
			return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
		}
	}

	public static final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;

	public int newLength(int oldLength, int minGrowth, int prefGrowth) {
		// preconditions not checked because of inlining
		// assert oldLength >= 0
		// assert minGrowth > 0

		int prefLength = oldLength + Math.max(minGrowth, prefGrowth); // might overflow
		if (0 < prefLength && prefLength <= SOFT_MAX_ARRAY_LENGTH) {
			return prefLength;
		} else {
			// put code cold in a separate method
			return hugeLength(oldLength, minGrowth);
		}
	}

	private int hugeLength(int oldLength, int minGrowth) {
		int minLength = oldLength + minGrowth;
		if (minLength < 0) { // overflow
			throw new OutOfMemoryError("Required array length " + oldLength + " + " + minGrowth + " is too large");
		} else if (minLength <= SOFT_MAX_ARRAY_LENGTH) {
			return SOFT_MAX_ARRAY_LENGTH;
		} else {
			return minLength;
		}
	}

	private Object[] grow() {
		return grow(size + 1);
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the number of elements in this list
	 */
	public int size() {
		return size;
	}

	/**
	 * Returns {@code true} if this list contains no elements.
	 *
	 * @return {@code true} if this list contains no elements
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns {@code true} if this list contains the specified element. More
	 * formally, returns {@code true} if and only if this list contains at least one
	 * element {@code e} such that {@code Objects.equals(o, e)}.
	 *
	 * @param o element whose presence in this list is to be tested
	 * @return {@code true} if this list contains the specified element
	 */
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally, returns
	 * the lowest index {@code i} such that {@code Objects.equals(o, get(i))}, or -1
	 * if there is no such index.
	 */
	public int indexOf(Object o) {
		return indexOfRange(o, 0, size);
	}

	int indexOfRange(Object o, int start, int end) {
		Object[] es = elementData;
		if (o == null) {
			for (int i = start; i < end; i++) {
				if (es[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = start; i < end; i++) {
				if (o.equals(es[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Returns the index of the last occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element. More formally, returns
	 * the highest index {@code i} such that {@code Objects.equals(o, get(i))}, or
	 * -1 if there is no such index.
	 */
	public int lastIndexOf(Object o) {
		return lastIndexOfRange(o, 0, size);
	}

	int lastIndexOfRange(Object o, int start, int end) {
		Object[] es = elementData;
		if (o == null) {
			for (int i = end - 1; i >= start; i--) {
				if (es[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = end - 1; i >= start; i--) {
				if (o.equals(es[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element).
	 *
	 * <p>
	 * The returned array will be "safe" in that no references to it are maintained
	 * by this list. (In other words, this method must allocate a new array). The
	 * caller is thus free to modify the returned array.
	 *
	 * <p>
	 * This method acts as bridge between array-based and collection-based APIs.
	 *
	 * @return an array containing all of the elements in this list in proper
	 *         sequence
	 */
	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element); the runtime type of the returned array
	 * is that of the specified array. If the list fits in the specified array, it
	 * is returned therein. Otherwise, a new array is allocated with the runtime
	 * type of the specified array and the size of this list.
	 *
	 * <p>
	 * If the list fits in the specified array with room to spare (i.e., the array
	 * has more elements than the list), the element in the array immediately
	 * following the end of the collection is set to {@code null}. (This is useful
	 * in determining the length of the list <i>only</i> if the caller knows that
	 * the list does not contain any null elements.)
	 *
	 * @param a the array into which the elements of the list are to be stored, if
	 *          it is big enough; otherwise, a new array of the same runtime type is
	 *          allocated for this purpose.
	 * @return an array containing the elements of the list
	 * @throws ArrayStoreException  if the runtime type of the specified array is
	 *                              not a supertype of the runtime type of every
	 *                              element in this list
	 * @throws NullPointerException if the specified array is null
	 */
	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			// Make a new array of a's runtime type, but my contents:
			return (T[]) Arrays.copyOf(elementData, size, a.getClass());
		System.arraycopy(elementData, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
		return a;
	}

	// Positional Access Operations

	@SuppressWarnings("unchecked")
	E elementData(int index) {
		return (E) elementData[index];
	}

	@SuppressWarnings("unchecked")
	static <E> E elementAt(Object[] es, int index) {
		return (E) es[index];
	}

	/**
	 * Returns the element at the specified position in this list.
	 *
	 * @param index index of the element to return
	 * @return the element at the specified position in this list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public E get(int index) {
		Objects.checkIndex(index, size);
		return elementData(index);
	}

	/**
	 * Replaces the element at the specified position in this list with the
	 * specified element.
	 *
	 * @param index   index of the element to replace
	 * @param element element to be stored at the specified position
	 * @return the element previously at the specified position
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public E set(int index, E element) {
		Objects.checkIndex(index, size);
		E oldValue = elementData(index);
		elementData[index] = element;
		return oldValue;
	}

	private void add(E e, Object[] elementData, int s) {
		if (s == elementData.length)
			elementData = grow();
//			throw new RuntimeException("Limit exceeded");
		elementData[s] = e;
		size = s + 1;
	}

	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param e element to be appended to this list
	 * @return {@code true} (as specified by {@link Collection#add})
	 */
	public boolean add(E e) {
		modCount++;
//		System.out.println("modcount=> "+modCount+", elementData.length => "+elementData.length);
		if(modCount>elementData.length) {
//			System.out.println("element data length reached"+elementData.length);
			throw new RuntimeException("Max capacity is => "+elementData.length);
		}else {
			add(e, elementData, size);
			return true;
		}
//		return false;
	}

	/**
	 * Inserts the specified element at the specified position in this list. Shifts
	 * the element currently at that position (if any) and any subsequent elements
	 * to the right (adds one to their indices).
	 *
	 * @param index   index at which the specified element is to be inserted
	 * @param element element to be inserted
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public void add(int index, E element) {
		rangeCheckForAdd(index);
		modCount++;
		final int s;
		Object[] elementData;
		if ((s = size) == (elementData = this.elementData).length)
			elementData = grow();
		System.arraycopy(elementData, index, elementData, index + 1, s - index);
		elementData[index] = element;
		size = s + 1;
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left (subtracts one from their indices).
	 *
	 * @param index the index of the element to be removed
	 * @return the element that was removed from the list
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 */
	public E remove(int index) {
		Objects.checkIndex(index, size);
		final Object[] es = elementData;

		@SuppressWarnings("unchecked")
		E oldValue = (E) es[index];
		fastRemove(es, index);

		return oldValue;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof List)) {
			return false;
		}

		final int expectedModCount = modCount;
		// CustomList can be subclassed and given arbitrary behavior, but we can
		// still deal with the common case where o is CustomList precisely
		boolean equal = (o.getClass() == CustomList.class) ? equalsCustomList((CustomList<?>) o)
				: equalsRange((List<?>) o, 0, size);

		checkForComodification(expectedModCount);
		return equal;
	}

	boolean equalsRange(List<?> other, int from, int to) {
		final Object[] es = elementData;
		if (to > es.length) {
			throw new ConcurrentModificationException();
		}
		var oit = other.iterator();
		for (; from < to; from++) {
			if (!oit.hasNext() || !Objects.equals(es[from], oit.next())) {
				return false;
			}
		}
		return !oit.hasNext();
	}

	protected transient int modCount = 0;

	private boolean equalsCustomList(CustomList<?> other) {
		final int otherModCount = other.modCount;
		final int s = size;
		boolean equal;
		if (equal = (s == other.size)) {
			final Object[] otherEs = other.elementData;
			final Object[] es = elementData;
			if (s > es.length || s > otherEs.length) {
				throw new ConcurrentModificationException();
			}
			for (int i = 0; i < s; i++) {
				if (!Objects.equals(es[i], otherEs[i])) {
					equal = false;
					break;
				}
			}
		}
		other.checkForComodification(otherModCount);
		return equal;
	}

	private void checkForComodification(final int expectedModCount) {
		if (modCount != expectedModCount) {
			throw new ConcurrentModificationException();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public int hashCode() {
		int expectedModCount = modCount;
		int hash = hashCodeRange(0, size);
		checkForComodification(expectedModCount);
		return hash;
	}

	int hashCodeRange(int from, int to) {
		final Object[] es = elementData;
		if (to > es.length) {
			throw new ConcurrentModificationException();
		}
		int hashCode = 1;
		for (int i = from; i < to; i++) {
			Object e = es[i];
			hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
		}
		return hashCode;
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if it
	 * is present. If the list does not contain the element, it is unchanged. More
	 * formally, removes the element with the lowest index {@code i} such that
	 * {@code Objects.equals(o, get(i))} (if such an element exists). Returns
	 * {@code true} if this list contained the specified element (or equivalently,
	 * if this list changed as a result of the call).
	 *
	 * @param o element to be removed from this list, if present
	 * @return {@code true} if this list contained the specified element
	 */
	public boolean remove(Object o) {
		final Object[] es = elementData;
		final int size = this.size;
		int i = 0;
		found: {
			if (o == null) {
				for (; i < size; i++)
					if (es[i] == null)
						break found;
			} else {
				for (; i < size; i++)
					if (o.equals(es[i]))
						break found;
			}
			return false;
		}
		fastRemove(es, i);
		return true;
	}

	/**
	 * Private remove method that skips bounds checking and does not return the
	 * value removed.
	 */
	private void fastRemove(Object[] es, int i) {
		modCount++;
		final int newSize;
		if ((newSize = size - 1) > i)
			System.arraycopy(es, i + 1, es, i, newSize - i);
		es[size = newSize] = null;
	}

	/**
	 * Removes all of the elements from this list. The list will be empty after this
	 * call returns.
	 */
	public void clear() {
		modCount++;
		final Object[] es = elementData;
		for (int to = size, i = size = 0; i < to; i++)
			es[i] = null;
	}

	/**
	 * Appends all of the elements in the specified collection to the end of this
	 * list, in the order that they are returned by the specified collection's
	 * Iterator. The behavior of this operation is undefined if the specified
	 * collection is modified while the operation is in progress. (This implies that
	 * the behavior of this call is undefined if the specified collection is this
	 * list, and this list is nonempty.)
	 *
	 * @param c collection containing elements to be added to this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws NullPointerException if the specified collection is null
	 */
	public boolean addAll(Collection<? extends E> c) {
		Object[] a = c.toArray();
		modCount++;
		int numNew = a.length;
		if (numNew == 0)
			return false;
		Object[] elementData;
		final int s;
		if (numNew > (elementData = this.elementData).length - (s = size))
			elementData = grow(s + numNew);
		System.arraycopy(a, 0, elementData, s, numNew);
		size = s + numNew;
		return true;
	}

	/**
	 * Inserts all of the elements in the specified collection into this list,
	 * starting at the specified position. Shifts the element currently at that
	 * position (if any) and any subsequent elements to the right (increases their
	 * indices). The new elements will appear in the list in the order that they are
	 * returned by the specified collection's iterator.
	 *
	 * @param index index at which to insert the first element from the specified
	 *              collection
	 * @param c     collection containing elements to be added to this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws IndexOutOfBoundsException {@inheritDoc}
	 * @throws NullPointerException      if the specified collection is null
	 */
	public boolean addAll(int index, Collection<? extends E> c) {
		rangeCheckForAdd(index);

		Object[] a = c.toArray();
		modCount++;
		int numNew = a.length;
		if (numNew == 0)
			return false;
		Object[] elementData;
		final int s;
		if (numNew > (elementData = this.elementData).length - (s = size))
			elementData = grow(s + numNew);

		int numMoved = s - index;
		if (numMoved > 0)
			System.arraycopy(elementData, index, elementData, index + numNew, numMoved);
		System.arraycopy(a, 0, elementData, index, numNew);
		size = s + numNew;
		return true;
	}

	/**
	 * Removes from this list all of the elements whose index is between
	 * {@code fromIndex}, inclusive, and {@code toIndex}, exclusive. Shifts any
	 * succeeding elements to the left (reduces their index). This call shortens the
	 * list by {@code (toIndex - fromIndex)} elements. (If
	 * {@code toIndex==fromIndex}, this operation has no effect.)
	 *
	 * @throws IndexOutOfBoundsException if {@code fromIndex} or {@code toIndex} is
	 *                                   out of range ({@code fromIndex < 0 ||
	 *          toIndex > size() ||
	 *          toIndex < fromIndex}  )
	 */
	protected void removeRange(int fromIndex, int toIndex) {
		if (fromIndex > toIndex) {
			throw new IndexOutOfBoundsException(outOfBoundsMsg(fromIndex, toIndex));
		}
		modCount++;
		shiftTailOverGap(elementData, fromIndex, toIndex);
	}

	/** Erases the gap from lo to hi, by sliding down following elements. */
	private void shiftTailOverGap(Object[] es, int lo, int hi) {
		System.arraycopy(es, hi, es, lo, size - hi);
		for (int to = size, i = (size -= hi - lo); i < to; i++)
			es[i] = null;
	}

	/**
	 * A version of rangeCheck used by add and addAll.
	 */
	private void rangeCheckForAdd(int index) {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
	}

	/**
	 * Constructs an IndexOutOfBoundsException detail message. Of the many possible
	 * refactorings of the error handling code, this "outlining" performs best with
	 * both server and client VMs.
	 */
	private String outOfBoundsMsg(int index) {
		return "Index: " + index + ", Size: " + size;
	}

	/**
	 * A version used in checking (fromIndex > toIndex) condition
	 */
	private static String outOfBoundsMsg(int fromIndex, int toIndex) {
		return "From Index: " + fromIndex + " > To Index: " + toIndex;
	}

	/**
	 * Removes from this list all of its elements that are contained in the
	 * specified collection.
	 *
	 * @param c collection containing elements to be removed from this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws ClassCastException   if the class of an element of this list is
	 *                              incompatible with the specified collection
	 *                              (<a href=
	 *                              "Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if this list contains a null element and the
	 *                              specified collection does not permit null
	 *                              elements (<a href=
	 *                              "Collection.html#optional-restrictions">optional</a>),
	 *                              or if the specified collection is null
	 * @see Collection#contains(Object)
	 */
	public boolean removeAll(Collection<?> c) {
		return batchRemove(c, false, 0, size);
	}

	/**
	 * Retains only the elements in this list that are contained in the specified
	 * collection. In other words, removes from this list all of its elements that
	 * are not contained in the specified collection.
	 *
	 * @param c collection containing elements to be retained in this list
	 * @return {@code true} if this list changed as a result of the call
	 * @throws ClassCastException   if the class of an element of this list is
	 *                              incompatible with the specified collection
	 *                              (<a href=
	 *                              "Collection.html#optional-restrictions">optional</a>)
	 * @throws NullPointerException if this list contains a null element and the
	 *                              specified collection does not permit null
	 *                              elements (<a href=
	 *                              "Collection.html#optional-restrictions">optional</a>),
	 *                              or if the specified collection is null
	 * @see Collection#contains(Object)
	 */
	public boolean retainAll(Collection<?> c) {
		return batchRemove(c, true, 0, size);
	}

	boolean batchRemove(Collection<?> c, boolean complement, final int from, final int end) {
		Objects.requireNonNull(c);
		final Object[] es = elementData;
		int r;
		// Optimize for initial run of survivors
		for (r = from;; r++) {
			if (r == end)
				return false;
			if (c.contains(es[r]) != complement)
				break;
		}
		int w = r++;
		try {
			for (Object e; r < end; r++)
				if (c.contains(e = es[r]) == complement)
					es[w++] = e;
		} catch (Throwable ex) {
			// Preserve behavioral compatibility with AbstractCollection,
			// even if c.contains() throws.
			System.arraycopy(es, r, es, w, end - r);
			w += end - r;
			throw ex;
		} finally {
			modCount += end - w;
			shiftTailOverGap(es, w, end);
		}
		return true;
	}

	/**
	 * Saves the state of the {@code CustomList} instance to a stream (that is,
	 * serializes it).
	 *
	 * @param s the stream
	 * @throws java.io.IOException if an I/O error occurs
	 * @serialData The length of the array backing the {@code CustomList} instance
	 *             is emitted (int), followed by all of its elements (each an
	 *             {@code Object}) in the proper order.
	 */
	@java.io.Serial
	private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
		// Write out element count, and any hidden stuff
		int expectedModCount = modCount;
		s.defaultWriteObject();

		// Write out size as capacity for behavioral compatibility with clone()
		s.writeInt(size);

		// Write out all elements in the proper order.
		for (int i = 0; i < size; i++) {
			s.writeObject(elementData[i]);
		}

		if (modCount != expectedModCount) {
			throw new ConcurrentModificationException();
		}
	}
}