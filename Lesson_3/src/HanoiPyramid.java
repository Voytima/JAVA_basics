/*
Написать программу, показывающую последовательность действий для игры “Ханойская башня”
 */
import java.util.Scanner;

public class HanoiPyramid {
    public static void hanoiTower(int topDisc, char start, char aux, char dest) {
        if (topDisc == 1) {
            System.out.println("Disk 1 --> " + dest);
        } else {
            hanoiTower(topDisc - 1, start, dest, aux);
            System.out.println("Disk " + topDisc + " --> " + dest);
            hanoiTower(topDisc - 1, aux, start, dest);
        }
    }
        public static void main (String[]args){

            Scanner in = new Scanner(System.in);
            System.out.println("How many discs: ");
            int n = in.nextInt();
            hanoiTower(n, '1', '2', '3');
        }
    }