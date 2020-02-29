package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

@WebFilter(filterName = "SensitiveWordsFilter", urlPatterns = "/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> list = new ArrayList<String>();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (method.getName().equals("getParameter")) {
                    String value = (String) method.invoke(req, objects);
                    if (value != null) {
                        for (String str : list) {

                            if (value.contains(str)) {
                                value = value.replace(str, "xxx");
                            }
                        }
                    }
                    return value;

                } else if (method.getName().equals("getParameterMap")) {
                    Map<String, String[]> map = (Map<String, String[]>) method.invoke(req, objects);
                    //map.values()
//                    for (String s : map.keySet()) {
//                        String[] values = map.get(s);
                    for (String[] values : map.values()) {
                        for (int i = 0; i < values.length; i++) {
                            for (String str : list) {
                                if (values[i].contains(str)) {
                                    values[i] = values[i].replace(str, "***");
                                }
                            }
                        }
                    }
//                    }
                    return map;

                } else if (method.getName().equals("getParameterValues")) {
                    String[] values = (String[]) method.invoke(req, objects);
                    for (int i = 0; i < values.length; i++) {
                        for (String str : list) {
                            if (values[i].contains(str)) {
                                values[i] = values[i].replace(str, "xxx");
                            }
                        }
                    }
                    return values;
                }
                return method.invoke(req, objects);
            }
        });
        chain.doFilter(proxy_req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        try {
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");

            BufferedReader br = new BufferedReader(new FileReader(realPath));

            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }

            br.close();

            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
