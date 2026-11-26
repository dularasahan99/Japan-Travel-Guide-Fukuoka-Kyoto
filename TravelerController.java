
package aiwa.Controller;

import java.util.Scanner;

public class TravelerController {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("***日本の美しい所***");

        while (true) {

            System.out.println("1:福岡 2:京都 0:終わり");

            int menu;

            try {

                menu = Integer.parseInt(scan.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("数字を入力してください");

                continue;
            }

            if (menu == 1) {

                FukuokaController fc = new FukuokaController();

                fc.showFukuoka();

            } else if (menu == 2) {

                KyotoController dc = new KyotoController();

                dc.showMenu();

            } else if (menu == 0) {

                System.out.println("🙌🙌🙌");

                break;

            } else {

                System.out.println("1、2、0のいずれかを入力してください");

            }
        }
    }
}
