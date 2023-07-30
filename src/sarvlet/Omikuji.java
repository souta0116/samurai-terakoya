package uhablog;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * おみくじサーブレット
 */
@WebServlet("/omikuji")
public class Omikuji extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public Omikuji() {
        super();
    }

    /**
     * 乱数を生成して、おみくじ結果を返却する
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random r = new Random();
        // 0~99の乱数を取得する
        int omikuji = r.nextInt(100);
		
        // おみくじ結果
        String omikujiResult = "";
		
        if(omikuji < 10) {
            omikujiResult = "凶";
        } else if (10 <= omikuji && omikuji < 20) {
            omikujiResult = "末吉";
        } else if (20 <= omikuji && omikuji < 40 ) {
            omikujiResult = "吉";
        } else if (40 <= omikuji && omikuji < 50) {
            omikujiResult = "小吉";
        } else if (50 <= omikuji && omikuji < 60) {
            omikujiResult = "中吉";
        } else if (60 <= omikuji) {
            omikujiResult = "大吉";
        }
		
        request.setAttribute("omikujiResult", omikujiResult);
        request.getRequestDispatcher("/omikuji-result.jsp").forward(request, response);
    }
}