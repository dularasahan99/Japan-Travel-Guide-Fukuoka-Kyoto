
package aiwa.View;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import aiwa.Entity.Fukuoka;

public class FukuokaView {

    public void showlist(ArrayList<Fukuoka> fukuokas) {

        try {

            FileWriter fw = new FileWriter("menu.html");

            fw.write("<html>");
            fw.write("<head>");
            fw.write("<meta charset='UTF-8'>");
            fw.write("<link rel='stylesheet' href='style.css'>");
            fw.write("<title>福岡旅行</title>");
            fw.write("</head>");
            fw.write("<body>");

            fw.write("<h1>福岡旅行</h1>");

            fw.write("<table border='1'>");
            fw.write("<tr>");
            fw.write("<th>画像</th>");
            fw.write("<th>場所名</th>");
            fw.write("<th>住所</th>");
            fw.write("</tr>");

            for (Fukuoka f : fukuokas) {

                fw.write("<tr>");

                fw.write("<td>");
                fw.write("<a href='details/" + f.getPlaceId() + ".html'>");
                fw.write("<img height='100px' src='" + f.getImage() + "'>");
                fw.write("</a>");
                fw.write("</td>");

                fw.write("<td>" + f.getPlaceName() + "</td>");
                fw.write("<td>" + f.getFamousFood() + "円</td>");

                fw.write("</tr>");

                showDetail(f);
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

    public void showDetail(Fukuoka fukuoka) {

        try {

         
            File dir = new File("details");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            
            FileWriter fw = new FileWriter(
                "details/" + fukuoka.getPlaceId() + ".html"
            );

            fw.write("<html>");
            fw.write("<head>");
            fw.write("<meta charset='UTF-8'>");
            fw.write("<link rel='stylesheet' href='../style.css'>");
            fw.write("<title>福岡旅行 詳細</title>");
            fw.write("</head>");
            fw.write("<body>");

            fw.write("<h1>福岡旅行</h1>");

            fw.write("<table border='1'>");

            fw.write("<tr>");
            fw.write("<th>Place ID</th>");
            fw.write("<td>" + fukuoka.getPlaceId() + "</td>");
            fw.write("</tr>");

            fw.write("<tr>");
            fw.write("<th>場所名</th>");
            fw.write("<td>" + fukuoka.getPlaceName() + "</td>");
            fw.write("</tr>");

            fw.write("<tr>");
            fw.write("<th>Famous Food</th>");
            fw.write("<td>" + fukuoka.getFamousFood() + "</td>");
            fw.write("</tr>");

            fw.write("<tr>");
            fw.write("<th>説明</th>");
            fw.write("<td>" + fukuoka.getDetails() + "</td>");
            fw.write("</tr>");

            fw.write("<tr>");
            fw.write("<th>画像</th>");
            fw.write("<td><img height='300px' src='" + fukuoka.getImage() + "'></td>");
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
