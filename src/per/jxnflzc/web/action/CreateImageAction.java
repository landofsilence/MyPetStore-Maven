package per.jxnflzc.web.action;

import com.opensymphony.xwork2.Action;
import org.apache.struts2.ServletActionContext;
import java.awt.image.BufferedImage;
import javax.servlet.http.HttpServletResponse;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

/**
 * @author 河木
 * @version v1.0.0
 */
public class CreateImageAction implements Action {
	private ByteArrayInputStream inputStream;
	private static int WIDTH = 60;
	private static int HEIGHT = 20;

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	private  static String createRandom(){
		String str = "2345678abcdefhijkmnpqrstuvwxyz";
		char [] rands = new char[4];
		Random random = new Random();
		for (int i = 0; i < 4; i++){
			rands[i] = str.charAt(random.nextInt(30));
		}
		return new String(rands);
	}

	private  void drawBackground(Graphics graphics){
		graphics.setColor(new Color(0xDCDCDC));
		graphics.fillRect(0, 0, WIDTH, HEIGHT);

		for (int i = 0; i < 120; i++){
			int x = (int) (Math.random() * WIDTH);
			int y = (int) (Math.random() * HEIGHT);
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);

			graphics.setColor(new Color(red, green, blue));
			graphics.drawOval(x, y, 1, 0);
		}
	}

	private void drawRands(Graphics graphics, String rands){
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font(null, Font.ITALIC | Font.BOLD, 18));

		graphics.drawString("" + rands.charAt(0), 1, 17);
		graphics.drawString("" + rands.charAt(1), 16, 15);
		graphics.drawString("" + rands.charAt(2), 31, 18);
		graphics.drawString("" + rands.charAt(3), 46, 16);

		System.out.println(rands);
	}

	@Override
	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		// 设置浏览器不要缓存此图片
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String rands = createRandom();
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// 产生图像
		drawBackground(g);
		drawRands(g, rands);
		// 结束图像 的绘制 过程， 完成图像
		g.dispose();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ImageIO.write(image, "jpeg", outputStream);
		ByteArrayInputStream input = new ByteArrayInputStream(outputStream
				.toByteArray());
		this.setInputStream(input);
		HttpSession session =ServletActionContext.getRequest().getSession();
		session.setAttribute("checkCode", rands);
		input.close();
		outputStream.close();
		return SUCCESS;

	}
}
