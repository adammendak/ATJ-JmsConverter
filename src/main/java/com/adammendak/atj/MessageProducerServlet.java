package com.adammendak.atj;

import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Topic;
import com.sun.messaging.jms.JMSException;

import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        asyncSupported = true,
        description = "jms message producer",
        urlPatterns = {"/produce"})
public class MessageProducerServlet extends HttpServlet {

    private static final String RESPONSE_TEMPLATE = "Wiadomość : %s, wysłana";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = String.valueOf(request.getParameter("value"));

        try {
            JMSPublisher.publishMessage(message);
        } catch (javax.jms.JMSException e) {
            e.printStackTrace();
            respond(request, response, e.getMessage());
        }

        respond(request, response, String.format(RESPONSE_TEMPLATE, message));

    }

    private void respond(HttpServletRequest request, HttpServletResponse response, String responseValue)
            throws ServletException, IOException {
        request.setAttribute("result", responseValue);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private static class JMSPublisher {

        private static final String TOPIC_NAME = "ATJTopic";

        public static void publishMessage(String message) throws javax.jms.JMSException {
            ConnectionFactory connectionFactory = new
                    com.sun.messaging.ConnectionFactory();
            JMSContext jmsContext = connectionFactory.createContext();
            JMSProducer jmsProducer = jmsContext.createProducer();

            try {
                Topic topic = new com.sun.messaging.Topic(TOPIC_NAME);
                    jmsProducer.send(topic, message);
            } catch (JMSException e) {
                e.printStackTrace();
            }
            jmsContext.close();
        }
    }
}
