//  https://www.w3resource.com/java-exercises/search/index.php

package kyh.övningar;

import java.util.Scanner;
import java.lang.Math;


public class Main {

  private static Scanner in;

  public static void main(String[] args) {
    in = new Scanner(System.in);

    övn1();
    övn2();
  }


  //  övning 1, binärsökning
  public static void övn1() {
    int längd = 1000;

    int[] arr = new int[längd];
    for (int v = 1, i = 0; i < längd; ++i) {
      v += (int)(Math.random()*3);
      arr[i] = v;
    }

    System.out.println("Fältet har värden från "+arr[0]+" till "+arr[längd-1]);

    while (true) {
      System.out.print("Sök efter värde, 0 för att avsluta:  ");
      int värde = in.nextInt();
      if (värde == 0)  break;

      int i = -1, i1 = 0, i2 = längd-1;
      while (i1 <= i2) {
        i = i1 + (i2-i1)/2;
        if (arr[i] == värde)      break;
        else if (värde < arr[i])  i2 = i-1;
        else if (värde > arr[i])  i1 = i+1;
      }

      if (i1 <= i2  &&  arr[i] == värde)
        System.out.println("Talet hittades på index "+i);
      else
        System.out.println("Talet finns ej");
    }
  }


  //  övning 2, linjär sökning
  public static void övn2() {
    int längd = 1000;
    int[] arr = new int[längd];
    for (int i = 0; i < längd; ++i)  arr[i] = 1+(int)(Math.random()*längd*10);

    System.out.println("Fältet innehåller tal från 1 till "+längd*10);

    while (true) {
      System.out.print("Sök efter ett tal, 0 för att avsluta:  ");
      int tal = in.nextInt();
      if (tal == 0)  break;

      boolean finns = false;
      for (int v:arr)
        if (tal == v) {
          finns = true;
          break;
        }

      System.out.println(finns ? "Talet finns" : "Talet finns ej");
    }
  }

}
