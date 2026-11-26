
package aiwa.Controller;

import java.util.ArrayList;
import java.util.Scanner;

import aiwa.Entity.Kyoto;
import aiwa.Model.KyotoModel;
import aiwa.View.KyotoView;

public class KyotoController {

    public void showMenu() {

        Scanner scan = new Scanner(System.in);

        KyotoModel dm = new KyotoModel();
        KyotoView dv = new KyotoView();

        System.out.println("****京都旅行***:");

        while (true) {

            System.out.println("1:全部表示 2:キーワード検索 0:終了");

            int menu;

            try {
                menu = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("数字を入力してください");
                continue;
            }

            if (menu == 1) {

                ArrayList<Kyoto> kyotos = dm.findAll();
                dv.showlist(kyotos);

            } else if (menu == 2) {

                System.out.println("キーワードを入力してください");

                String word = scan.nextLine();

                ArrayList<Kyoto> kyotos = dm.findBykeyword(word);
                dv.showlist(kyotos);

            } else if (menu == 0) {

                System.out.println("🙌");
                break;

            } else {

                System.out.println("1、2、0のいずれかを入力してください");

            }
        }
    }
}
