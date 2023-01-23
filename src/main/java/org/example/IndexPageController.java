package org.example;


import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;


@Controller
public class IndexPageController {

    @RequestMapping({ "/", "/home", "/public/" })
    public void home(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader(HttpHeaders.LOCATION, "/public/index.html");
        httpServletResponse.setStatus(HttpServletResponse.SC_FOUND);
    }

    @RequestMapping({ "/private/" })
    public void privateHome(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader(HttpHeaders.LOCATION, "/private/index.html");
        httpServletResponse.setStatus(HttpServletResponse.SC_FOUND);
    }
}
