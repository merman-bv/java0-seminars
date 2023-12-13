import java.util.Arrays;
import java.util.SortedMap;

public class HeapSort {

    private static int DepthSort;
    public static void buildTree(int[] tree, int sortLength) {
        System.out.println("Start buildTree(" + Arrays.toString(tree) + ", "+sortLength +")");
        /* sortLength - позиция крайнего, левого корневого элемента.
        * Левее которого, считаем, что массив отсортирован
        * Всегда идем от листьев к корню
        * (i-1)/2 - формула элемента - корня последнего дерева с листьями.
        *
        *  */
        int SizeTree = tree.length-sortLength;
        int LastRoot = (SizeTree-1-1)/2;
        if (sortLength > LastRoot || sortLength < 0 ) return;
        int RootEl = LastRoot;
        // Проверим крайний корень с левым листом

        if (RootEl == LastRoot && (2 * RootEl + 1) < SizeTree) {
            int LeftEl= 2 * RootEl + 1;
            //System.out.println("== LastRoot "+ RootEl + " " + LeftEl + " : "
            //        + tree[LastRoot] + " " + tree[LeftEl]);
            if (tree[LastRoot] > tree[LeftEl]) {
                int buff = tree[LastRoot];
                tree[LastRoot] = tree[LeftEl];
                tree[LeftEl] = buff;
            }
            RootEl --;
        } // --- End === LastRoot

        while (RootEl >= sortLength) {
            //System.out.println("Start while(" + Arrays.toString(tree) + ", "+RootEl +")");
            //int SizeArr = tree.length;
            int RootElIndex = RootEl;
            int LeftElIndex = 2 * RootEl + 1;
            int RightElIndex = 2 * RootEl + 2;
            //System.out.print(RootElIndex + " " + LeftElIndex + " " + RightElIndex + " : ");
            //System.out.println(tree[RootElIndex] + ", " + tree[LeftElIndex] + ", " + tree[RightElIndex]);

            if (LeftElIndex < SizeTree && tree[LeftElIndex] < tree[RootElIndex]) {
                RootElIndex = LeftElIndex;
            }
            if (RightElIndex < SizeTree && tree[RightElIndex] < tree[RootElIndex]) {
                RootElIndex = RightElIndex;
            }
            if (RootElIndex != RootEl) {
                int swap = tree[RootEl];
                tree[RootEl] = tree[RootElIndex];
                tree[RootElIndex] = swap;
            }
            if (LeftElIndex < SizeTree && RightElIndex < SizeTree && tree[LeftElIndex]>tree[RightElIndex]) {
                int buff = tree[LeftElIndex];
                tree[LeftElIndex] = tree[RightElIndex];
                tree[RightElIndex] = buff;
            }
            RootEl = RootEl - 1;
            //System.out.println("End while "+Arrays.toString(tree));
        }
        System.out.println("End buildTree "+ sortLength+" : "+Arrays.toString(tree));
    } // --- Finish buildTree

    public static void heapSort(int[] sortArray, int sortLength) {
        /*
        * sortArray - Исходный массив для сортировки
        * sortLength - размер массива (длина сортировки)
        * */
        System.out.println("Start heapSort(" + Arrays.toString(sortArray) +
                ", " + sortLength + ")");
        int n = sortArray.length;
        // Первый индекс неконечного узла n/2-1 (в случае полного дерева)
        // Все остальные узлы после этого являются листовыми узлами и, следовательно, не нуждаются в куче
        //for (int i = (n-1)/2; i >=0; i-- ) {
        //    buildTree(sortArray,i);
        //}
        //buildTree(sortArray,0);

        int LastRoot = (sortArray.length-1)/2;
        heapify(sortArray,0);
        for (int i = 1; i < 1 ; i++) { //<= LastRoot

        }

    } // --- Finish heapSort

    public static int[] heapify(int[] tree, int sortLength) {
        /*
        * sortLength - количество элементов с начала массива
        * т.е принимает значения от 0 и двигается к  tree.length
        * */
        System.out.println("Start heapify("+Arrays.toString(tree)+", "+sortLength+")");
        if (sortLength < 0 ) return tree;
        int LastElIndex = tree.length-1; // Не забываем, что индекс на единицы меньше количества
        int LastRootIndex = (LastElIndex-1)/2; // 0 элементов -> -1; 1 элемент -> 0; 2 элемента -> 0
        //System.out.println("sortLength="+sortLength+", LastRootIndex="+LastRootIndex);
        if (sortLength > LastElIndex) return tree;
        int RootElIndex = sortLength;
        int LeftElIndex = 2 * RootElIndex + 1;
        int RightElIndex = 2 * RootElIndex + 2;
        //System.out.println("Root: "+RootElIndex+", Left: "+LeftElIndex+", Right: "+RightElIndex+", LastEl: "+LastElIndex);
        /*
        if (RootElIndex == 0 ) { // Либо пусто корень, либо корень и левый лист
            if (LeftElIndex <= LastRootIndex) {
                if (tree[RootElIndex] > tree[LeftElIndex]) {
                    System.out.println("LastRoot: "+RootElIndex+"Left: "+LeftElIndex);
                    int buffer = tree[RootElIndex];
                    tree[RootElIndex] = tree[LastElIndex];
                    tree[LeftElIndex] = buffer;
                }
            } // End LastRoot is not empty
            RootElIndex --;
            return tree;
        } // --- End LastRootIndex
        */
        System.out.println("Root Full "+RootElIndex+", Left "+LastElIndex+", Right "+RightElIndex+", LastEl "+LastElIndex);

        int RootFlagIndex = RootElIndex;
        if (LeftElIndex < LastElIndex && tree[LeftElIndex] < tree[RootElIndex]) {
            RootElIndex = LeftElIndex;
        }
        if (RightElIndex < LastElIndex && tree[RightElIndex] < tree[RootElIndex]) {
            RootElIndex = RightElIndex;
        }
        if (RootElIndex != RootFlagIndex) {
            int swap = tree[RootFlagIndex];
            tree[RootFlagIndex] = tree[RootElIndex];
            tree[RootElIndex] = swap;
        }
        RootElIndex --;

        heapify(tree,sortLength++);
        return tree;
    }

}// --- End Class
