import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MySimpleServletImpl implements Servlet {

    @Override
    public void init(final ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(final ServletRequest request,
                        final ServletResponse response) throws ServletException, IOException {
        String contentType = request.getContentType();
        Enumeration<String> parameterNames = request.getParameterNames();
        response.getWriter()
                .write("Content type is: " + contentType);

        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            response.getWriter().write("\nParameter name: " + s);
        }
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

}
