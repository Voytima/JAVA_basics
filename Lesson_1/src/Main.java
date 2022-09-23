public class Main {
    public static void main(String[] args) {
        int a = 3; // Начальная точка
        int b = 10; // Конечная точка
        int c = 1; // Плюсовая цифра
        int d = 2; // Множитель цифра
        Recursion reqursia = new Recursion(a,b,c,d);

        for (int i = 0; i < reqursia.arr.length; i++) {
            System.out.printf("%d -> %d\n", i, reqursia.arr[i]);
        }
    }
}
