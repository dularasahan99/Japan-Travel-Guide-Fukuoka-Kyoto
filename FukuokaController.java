
package aiwa.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import aiwa.Entity.Fukuoka;
import aiwa.Model.FukuokaModel;
import aiwa.View.FukuokaView;

public class FukuokaController {

    public void showFukuoka() {

        Scanner scan = new Scanner(System.in);

        FukuokaModel fm = new FukuokaModel();
        FukuokaView fv = new FukuokaView();

        System.out.println("***福岡旅行***");

        while (true) {

            System.err.println("----menu----");

            System.out.println("1:全部表示 2:キーワード検索 0:終了");

            int menu;

            try {

                menu = Integer.parseInt(scan.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("数字を入力してください");

                continue;
            }

            if (menu == 1) {

                ArrayList<Fukuoka> fukuokas = fm.findAll();

                fv.showlist(fukuokas);

            } else if (menu == 2) {

                System.out.println("キーワードを入力してください");

                String word = scan.nextLine();

                ArrayList<Fukuoka> fukuokas = fm.findBykeyword(word);

                fv.showlist(fukuokas);

            } else if (menu == 0) {

                System.out.println("🙌");

                break;

            } else {

                System.out.println("1、2、0のいずれかを入力してください");

            }
        }
    }
}