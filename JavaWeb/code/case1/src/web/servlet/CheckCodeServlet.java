package web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private int width = 80;
	private int height = 30;
	private String codes = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	private Random random = new Random();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//tell the browser not to cache
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setHeader("expires", "0");


		//1. create an object, to store img in memory
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		//2.landscaping pictures
		//2.1 fill
		Graphics g = image.getGraphics();//paintbrush object
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);

		//2.2 input letter
		String checkCode = this.getCheckCode();
		request.getSession().setAttribute("CHECKCODE_SERVER", checkCode);
		g.setColor(Color.black);
		g.setFont(new Font("", Font.BOLD, 26));
		g.drawString(checkCode, 15, 25);

		//2.3 twist the image
		this.shearX(g,Color.white);
		this.shearY(g,Color.white);

		//2.4 draw lines
		for (int i = 0; i < 10; i++) {
			g.setColor(this.getColor());
			int x1 = random.nextInt(width);
			int x2 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int y2 = random.nextInt(height);
			g.drawLine(x1, x2, y1, y2);
		}

		//2.5 draw noise
		float yawpRate = 0.02f;
		int area = (int) (yawpRate * width * height);
		for (int i = 0; i < area; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int rgb = random.nextInt(255);
			image.setRGB(x, y, rgb);
		}



		//3. output image to page
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	private String getCheckCode() {
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= 4; i++) {
			int index = random.nextInt(str.length());
			char ch = str.charAt(index);
			sb.append(ch);
		}
		return sb.toString();
	}

	private Color getColor() {
		int red = random.nextInt(150);
		int green = random.nextInt(150);
		int blue = random.nextInt(150);
		return new Color(red, green, blue);
	}

	private void shearX(Graphics g, Color color) {

		int period = random.nextInt(2);

		boolean borderGap = true;
		int frames = 1;
		int phase = random.nextInt(2);

		for (int i = 0; i < height; i++) {
			double d = (double) (period >> 1)
					* Math.sin((double) i / (double) period
					+ (6.2831853071795862D * (double) phase)
					/ (double) frames);
			g.copyArea(0, i, width, 1, (int) d, 0);
			if (borderGap) {
				g.setColor(color);
				g.drawLine((int) d, i, 0, i);
				g.drawLine((int) d + width, i, width, i);
			}
		}
	}

	private void shearY(Graphics g, Color color) {

		int period = random.nextInt(40) + 10; // 50;

		boolean borderGap = true;
		int frames = 20;
		int phase = 7;
		for (int i = 0; i < width; i++) {
			double d = (double) (period >> 1)
					* Math.sin((double) i / (double) period
					+ (6.2831853071795862D * (double) phase)
					/ (double) frames);
			g.copyArea(i, 0, 1, height, 0, (int) d);
			if (borderGap) {
				g.setColor(color);
				g.drawLine(i, (int) d, i, 0);
				g.drawLine(i, (int) d + height, i, height);
			}

		}


	}
}