package com.epam.preprod.hrabovska.web.servlet.image;

import com.epam.preprod.hrabovska.model.entity.User;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet(name = "AvatarServlet", urlPatterns = "/avatar")
public class AvatarServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(AvatarServlet.class);

    private String uploadPath;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        LOG.info("AvatarServlet starts");

        ServletContext context = servletConfig.getServletContext();
        uploadPath = (String) context.getAttribute("ImagePath");
        LOG.info("Avatar directory: " + uploadPath);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        LOG.trace("Get user from session " + user);
        String imageName = user.getImagePath();
        response.setContentType("image/jpeg");
        File file = new File(uploadPath + File.separator + imageName);
        FileImageInputStream fiis = new FileImageInputStream(file);
        try {
            ImageIO.write(ImageIO.read(fiis), "jpeg", response.getOutputStream());
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}
