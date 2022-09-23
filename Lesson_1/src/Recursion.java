public class Recursion {
    int a;
    int b;
    int c;
    int d;
    int[] arr;
    int index;

    public Recursion(int a, int b, int c, int d) {
        this.a = a; // Начальная точка
        this.b = b; // Конечная точка
        this.c = c; // Плюсовая цифра
        this.d = d; // Множитель цифра
        this.arr = new int[b + 1];
        arr[a] = 1;
        this.index = a + 1;
        solve();
    }

    void solve() {
        if (index % d == 0) {
            arr[index] = arr[index - c] + arr[index / d];
        } else {
            arr[index] = arr[index - c];
        }

        index++;

        if (index <= b) {
            solve();
        }
    }
}
