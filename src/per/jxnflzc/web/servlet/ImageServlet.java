package per.jxnflzc.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * @author 河木
 * @version v1.0.0
 */
@WebServlet(name = "ImageServlet", urlPatterns = "/imageServlet")
public class ImageServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		Color c = new Color(200, 150, 255);
		g.setColor(c);
		g.fillRect(0, 0, 68, 22);
		String ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random r = new Random();
		int len = ch.length();
		int index;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(len);
			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
			g.drawString(ch.substring(index, index + 1) + "", (i * 15) + 3, 18);
			sb.append(ch.substring(index, index + 1) + "");
		}
		
		request.getSession().setAttribute("captcha", sb.toString());
		ImageIO.write(bi, "JPG", response.getOutputStream());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
