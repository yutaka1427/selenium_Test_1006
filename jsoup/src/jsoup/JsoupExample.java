package jsoup;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupExample {
    public static void main(String[] args) {
        String url = "https://item.fril.jp/31989e2f97dd2f3bf3de6cdc83c59ff7?_gl=1*1wwzzic*_gcl_au*MTMzODkwNTE4NC4xNjkzODA3MzMz*_ga*MTkwMzczMTYxNi4xNjkzODA3MzMz*_ga_7KV9PBS698*MTY5NDA0Nzc3Mi4zLjEuMTY5NDA0ODUyOC4yMC4wLjA."; // 対象のウェブページのURL
        try {
            // URLにHTTPリクエストを送信してHTMLドキュメントを取得
            Document document = Jsoup.connect(url).get();

            // タイトルを取得して表示
            Element titleElement = document.selectFirst("H1.item__name");
            if (titleElement != null) {
                String pageTitle = titleElement.text();
                System.out.println("Page Title: " + pageTitle);
            } else {
                System.out.println("Title not found.");
            }
            
         // span.item__value の要素(価格)を取得
            Element itemValueElement = document.selectFirst("span.item__value");
            if (itemValueElement != null) {
                String itemValueText = itemValueElement.text();
                System.out.println("Item Value: " + itemValueText);
            } else {
                System.out.println("Item Value not found.");
            }

            
            
            
            // 画像のURLを取得
            Element imageElement = document.selectFirst("img.sp-image");
            if (imageElement != null) {
                String imageUrl = imageElement.attr("src");
                
                // 画像をダウンロードして保存
                try (InputStream in = new URL(imageUrl).openStream()) {
                    Path outputPath = Path.of("output.jpg"); // 保存先のファイルパス
                    Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Image downloaded and saved as 'output.jpg'");
                }
            } else {
                System.out.println("Image not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}












/*
package jsoup;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupExample {
    public static void main(String[] args) {
        String url = "https://item.fril.jp/56416d4dfe228ff611e9b687a13a39af?_gl=1*amfpxq*_gcl_au*MTMzODkwNTE4NC4xNjkzODA3MzMz*_ga*MTkwMzczMTYxNi4xNjkzODA3MzMz*_ga_7KV9PBS698*MTY5MzgwNzMzMy4xLjEuMTY5MzgwNzM0Ni40Ny4wLjA."; // 対象のウェブページのURL
        try {
            // URLにHTTPリクエストを送信してHTMLドキュメントを取得
            Document document = Jsoup.connect(url).get();

            // タイトルを取得して表示
            Element titleElement = document.selectFirst("H1.item__name");
            if (titleElement != null) {
                String pageTitle = titleElement.text();
                System.out.println("Page Title: " + pageTitle);
            } else {
                System.out.println("Title not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

*/





