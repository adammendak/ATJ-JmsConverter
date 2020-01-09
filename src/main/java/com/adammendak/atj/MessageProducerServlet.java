package com.adammendak.atj;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        asyncSupported = true,
        description = "jms message producer",
        urlPatterns = { "/produce" })
public class MessageProducerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //todo zrobic to gowno jutro z rana jak smietana

    }
}
