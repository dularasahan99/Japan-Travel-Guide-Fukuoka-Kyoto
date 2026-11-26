
package aiwa.View;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import aiwa.Entity.Kyoto;

public class KyotoView {

    public void showlist(ArrayList<Kyoto> kyotos) {

        try {

            FileWriter fw = new FileWriter("menu.html");

            fw.write("<html>");
            fw.write("<head>");
            fw.write("<meta charset='UTF-8'>");
            fw.write("<link rel='stylesheet' href='style.css'>");
            fw.write("<title>京都旅行</title>");
            fw.write("</head>");
            fw.write("<body>");

            fw.write("<h1>京都旅行</h1>");
            fw.write("<table border='1'>");

            fw.write("<tr>");
            fw.write("<th>画像</th>");
            fw.write("<th>場所名</th>");
            fw.write("<th>住所</th>");
            fw.write("</tr>");

            for (Kyoto d : kyotos) {

                fw.write("<tr>");

                fw.write("<td>");
                fw.write("<a href='details/" + d.getPlaceId() + ".html'>");
                fw.write("<img height='100px' src='" + d.getImage() + "'>");
                fw.write("</a>");
                fw.write("</td>");

                fw.write("<td>" + d.getPlaceName() + "</td>");
                fw.write("<td>" + d.getFamousFood() + "円</td>");

                fw.write("</tr>");

                showDetail(d);

            }

            fw.write("</table>");

            fw.write("</body>");
            fw.write("</html>");

            fw.close();

            File file = new File("menu.html");
            Desktop.getDesktop().browse(file.toURI());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showDetail(Kyoto kyoto) {

        try {

            // details フォルダを自動作成
            File dir = new File("details");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            // 詳細ページを作成
            FileWriter fw = new FileWriter(
                "details/" + kyoto.getPlaceId() + ".html"
            );

            fw.write("<html>");
            fw.write("<head>");
            fw.write("<meta charset='UTF-8'>");
            fw.write("<link rel='stylesheet' href='../style.css'>");
            fw.write("<title>京都旅行 詳細</title>");
            fw.write("</head>");
            fw.write("<body>");

            fw.write("<h1>京都旅行</h1>");
            fw.write("<table border='1'>");

            fw.write("<tr>");
            fw.write("<th>Place ID</th>");
            fw.write("<td>" + kyoto.getPlaceId() + "</td>");
            fw.write("</tr>");

            fw.write("<tr>");
            fw.write("<th>場所名</th>");
            fw.write("<td>" + kyoto.getPlaceName() + "</td>");
            fw.write("</tr>");

            fw.write("<tr>");
            fw.write("<th>Famous Food</th>");
            fw.write("<td>" + kyoto.getFamousFood() + "</td>");
            fw.write("</tr>");

            fw.write("<tr>");
            fw.write("<th>詳細</th>");
            fw.write("<td>" + kyoto.getDetails() + "</td>");
            fw.write("</tr>");

            fw.write("<tr>");
            fw.write("<th>画像</th>");
            fw.write("<td><img height='300px' src='" + kyoto.getImage() + "'></td>");
            fw.write("</tr>");

            fw.write("</table>");

            fw.write("<a href='#' onclick='history.back()'>戻る</a>");

            fw.write("</body>");
            fw.write("</html>");

            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}