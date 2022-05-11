import java.util.Arrays;
import java.util.List;

public class QuickSort<E extends Comparable<E>> implements Sorter<E> {

    private List<E> elements;
    private Order   order;

    public QuickSort(List<E> elements, Order order) {
        this.elements = elements;
        this.order    = order;
    }

    @Override
    public List<E> getList() {
        return elements;
    }

    @Override
    public void sort()
    {
        sortRecursive(0, elements.size() - 1);
    }

    private void sortRecursive(int lowIndex, int highIndex)
    {
        int pivotIndex;

        if (lowIndex >= highIndex)
        {
           return;
        }
        pivotIndex = partition(lowIndex, highIndex);
        sortRecursive(lowIndex, pivotIndex);
        sortRecursive(pivotIndex + 1, highIndex);
    }

    private int partition(int firstIndex, int lastIndex)
    {
        int left, right;

        left = firstIndex;
        right = lastIndex;
        E pivotElement = elements.get(firstIndex);
        System.out.print(pivotElement + " :: ");
        for (int l = 0; l < elements.size(); l++)
        {
            System.out.print(elements.get(l) + ", ");
        }
        System.out.println();
        while (left <= right)
        {
            while (elements.get(left).compareTo(pivotElement) <= 0)
            {
                left++;
            }
            while (elements.get(right).compareTo(pivotElement) > 0)
            {
                right--;
            }
            if (left <= right)
            {
                swap(left,right);
                left++;
                right--;

                System.out.print(pivotElement + " :: ");
                for (int l = 0; l < elements.size(); l++)
                {
                    System.out.print(elements.get(l) + ", ");
                }
                System.out.println();
            }
        }
        swap(firstIndex, right);
        System.out.print( "  :: " );
        for (int l = 0; l < elements.size(); l++)
        {
            System.out.print(elements.get(l) + ", ");
        }
        System.out.println();
        return right;

    }

    private void swap(int firstIndex, int secondIndex)
    {
        E temp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, temp);
    }

    /**
     * The method displays the original input (unsorted) list, and then, each step is shown in a new line. For example,
     * if the original list to be sorted in increasing order is [6, 4, 9, 5, 1, 8, 2, 7, 3], calling this method should
     * string as follows, exactly in the format shown:
     * <p>
     * 6 :: [6, 4, 9, 5, 1, 8, 2, 7, 3]
     * 6 :: [6, 4, 3, 5, 1, 8, 2, 7, 9]
     * 6 :: [6, 4, 3, 5, 1, 2, 8, 7, 9]
     *   :: [2, 4, 3, 5, 1, 6, 8, 7, 9]
     * <p>
     * Only the steps with the first pivot are shown above, and NOT the entire output. The last step with a specific
     * pivot does not show the pivot separately in front of the :: separator, to indicate that a different pivot will
     * be used in the next step. At each stage, you must use the first element as the pivot.
     *
     * @return the string representation of the step-wise transformation of the input list, as done with quick sort
     */
    @Override
    public String show() {
        return null; // todo
    }

    public static void main(String... args)
    {
        Sorter<Integer> quicksorter = new QuickSort<>(Arrays.asList(6, 4, 9, 5, 1, 8, 2, 7, 3), Order.INCREASING);
        quicksorter.sort();
        System.out.println(quicksorter.show());
    }
}
