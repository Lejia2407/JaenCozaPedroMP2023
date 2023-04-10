package sesion03;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> extends AbstractList<E> {
	private static final int CAPACIDAD_INICIAL = 16;
	@SuppressWarnings("unchecked")
	private E[] data = (E[]) new Object[CAPACIDAD_INICIAL];

	public ArrayList() {
	}

	public ArrayList(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			add(objects[i]);
	}

	@Override
	public void add(int index, E e) {
		if (index > data.length || index < 0)
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
		ensureCapacity();
		for (int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];
		data[index] = e;
		size++;
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if (data.length == size) {
			E[] newData = (E[]) (new Object[size * 2 + 1]);
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		}
	}

	private int getLength() {
		return data.length;
	}

	@SuppressWarnings("unused")
	@Override
	public void clear() {
		@SuppressWarnings("unchecked")
		E[] newData = (E[]) (new Object[CAPACIDAD_INICIAL]);
		size = 0;
	}

	@Override
	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e))
				return true;
		}
		return false;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Indice: " + index + ", Tamaño: " + size);
	}

	@Override
	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i] == e)
				return i;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(E e) {
		for (int i = size; i > 0; i--) {
			if (data[i] == e)
				return i;
		}
		return -1;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);
		E e = data[index];
		for (int i = index + 1; i < size; i++) {
			data[i - 1] = data[i];
		}
		size--;
		return e;
	}

	@Override
	public E set(int index, E e) {
		checkIndex(index);
		E antiguo = data[index];
		data[index] = e;
		return antiguo;
	}

	@Override
	public String toString() {
		StringBuilder resultado = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			resultado.append(data[i]);
			if (i < size - 1)
				resultado.append(", ");
		}
		return resultado.toString() + "]";
	}

	@SuppressWarnings("unchecked")
	public void trimToSize() {
		if (size != getLength()) {
			E[] newData = (E[]) (new Object[size]);
			System.arraycopy(data, 0, newData, 0, size);
			data = newData;
		} else
			throw new RuntimeException("Guapit@ no necesitas hacer un trim, el tamaño coincide con la capacidad");
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<E> {
		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < size;
		}

		@Override
		public E next() {
			if (current == size)
				throw new NoSuchElementException("No hay más elementos en la lista");
			return data[current++];
		}

		@Override
		public void remove() {
			ArrayList.this.remove(current);
		}
	}
}