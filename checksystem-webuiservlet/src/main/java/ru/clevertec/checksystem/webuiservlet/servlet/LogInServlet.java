package ru.clevertec.checksystem.webuiservlet.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.clevertec.checksystem.webuiservlet.Questionnaire;
import ru.clevertec.checksystem.webuiservlet.constant.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebServlet(
        name = Servlets.LOGIN_SERVLET,
        urlPatterns = UrlPatterns.LOGIN_PATTERN
)
public class LogInServlet extends ApplicationServlet {

    private Questionnaire questionnaire;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
        addQuestions(questionnaire);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(Attributes.ANSWER_INCORRECT_ATTRIBUTE, false);
        req.setAttribute(Attributes.QUESTION_ATTRIBUTE, questionnaire.nextQuestion());
        req.getRequestDispatcher(Pages.AUTHENTICATION_PAGE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var answer = req.getParameter(Parameters.ANSWER_PARAMETER);

        if (questionnaire.verify(questionnaire.lastQuestion(), answer)) {
            logIn(req, questionnaire.lastQuestion(), answer);
            resp.sendRedirect(req.getContextPath() + UrlPatterns.ROOT_PATTERN);
        } else {
            req.setAttribute(Attributes.QUESTION_ATTRIBUTE, questionnaire.lastQuestion());
            req.setAttribute(Attributes.ANSWER_INCORRECT_ATTRIBUTE, true);
            req.getRequestDispatcher(Pages.AUTHENTICATION_PAGE).forward(req, resp);
        }
    }

    private static void addQuestions(Questionnaire questionnaire) {
        questionnaire.addQuestion("Ноль в нулевой степени", new String[]{"1", "один"});
        questionnaire.addQuestion("Время (секунды), за которое свет, пущенный с Земли, достигает Луны?", new String[]{"0.255", "0,255"});
        questionnaire.addQuestion("Количество лапок у муравья?", new String[]{"6", "шесть"});
        questionnaire.addQuestion("Количество лапок у паука?", new String[]{"8", "восемь"});
        questionnaire.addQuestion("Чего хочет дима?", new String[]{"servlet", "колбасы"});
    }

    @Autowired
    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }
}
