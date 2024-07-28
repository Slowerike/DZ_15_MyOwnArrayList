/**
 * Класс, реализующий простую версию списка с динамическим изменением размера.
 * @param <T> Тип элементов в списке.
 */
public class MyArrayList<T> {
    private T[] array; // Массив для хранения элементов списка
    private int countOfObject = 0; // Количество элементов в списке

    /**
     * Конструктор, создающий список с заданной начальной емкостью.
     * @param lengthOfArray Начальная емкость списка.
     */
    public MyArrayList(int lengthOfArray) {
        // Создаем массив с указанной емкостью
        array = (T[]) new Object[lengthOfArray];
    }

    /**
     * Конструктор, создающий список с начальной емкостью 10.
     */
    public MyArrayList() {
        array = (T[]) new Object[10];
    }

    /**
     * Возвращает элемент по указанному индексу.
     * @param index Индекс элемента.
     * @return Элемент списка.
     * @throws IndexOutOfBoundsException Если индекс находится вне допустимого диапазона.
     */
    public T get(int index) {
        if (index >= 0 && index < countOfObject) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Добавляет элемент в список по указанному индексу и расширяет массив, если это необходимо.
     * @param index Индекс, по которому нужно добавить элемент.
     * @param t Элемент, который нужно добавить.
     * @return Обновленный массив.
     * @throws IndexOutOfBoundsException Если индекс находится вне допустимого диапазона.
     */
    public T[] add(int index, T t) {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // Проверка, нужно ли расширять массив
        if (countOfObject == array.length) {
            T[] previousArray = array;
            array = (T[]) new Object[array.length + array.length/2+1];
            System.arraycopy(previousArray, 0, array, 0, previousArray.length);
        }
        array[index] = t;
        if (index == countOfObject) {
            countOfObject++;
        }
        // Создаем массив точного размера
        T[] exactSizeArray = (T[]) new Object[countOfObject];
        System.arraycopy(array, 0, exactSizeArray, 0, countOfObject);
        array = exactSizeArray;
        return array;
    }

    /**
     * Добавляет элемент в конец списка и расширяет массив, если это необходимо.
     * @param t Элемент, который нужно добавить.
     * @return Обновленный массив.
     */
    public T[] add(T t) {
        // Проверка, нужно ли расширять массив
        if (countOfObject == array.length) {
            T[] previousArray = array;
            array = (T[]) new Object[array.length + 10];
            System.arraycopy(previousArray, 0, array, 0, previousArray.length);
        }
        array[countOfObject] = t;
        countOfObject++;
        // Создаем массив точного размера
        T[] exactSizeArray = (T[]) new Object[countOfObject];
        System.arraycopy(array, 0, exactSizeArray, 0, countOfObject);
        array = exactSizeArray;
        return array;
    }

    /**
     * Удаляет элемент по указанному индексу.
     * @param index Индекс элемента, который нужно удалить.
     * @return Удаленный элемент.
     * @throws IndexOutOfBoundsException Если индекс находится вне допустимого диапазона.
     */
    public T remove(int index) {
        if (index < 0 || index >= countOfObject) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // Создаем новый массив на один элемент меньше
        T[] newArray = (T[]) new Object[array.length - 1];
        T result = array[index];
        // Копируем элементы до и после удаленного элемента
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        countOfObject--;
        array = (T[]) new Object[newArray.length];
        System.arraycopy(newArray, 0, array, 0, array.length);
        return result;
    }

    /**
     * Удаляет первое вхождение указанного элемента.
     * @param t Элемент, который нужно удалить.
     */
    public void remove(T t) {
        for (int i = 0; i < array.length; i++) {
            if (t == array[i]) {
                remove(i);
                return;
            }
        }
    }

    /**
     * Проверяет наличие элемента в списке.
     * @param t Элемент для проверки.
     * @return true, если элемент найден, иначе false.
     */
    public boolean isExist(T t) {
        if (array.length != 0) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == t) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Очищает список, устанавливая его размер в 0.
     * @return Пустой массив.
     */
    public T[] clear() {
        countOfObject = 0;
        return array = (T[]) new Object[0];
    }

    /**
     * Возвращает строковое представление списка.
     * @return Строковое представление списка.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < countOfObject; i++) {
            sb.append(array[i]);
            if (i < countOfObject - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Возвращает текущий размер массива (емкость).
     * @return Размер массива.
     */
    public int size() {
        return array.length;
    }
}
