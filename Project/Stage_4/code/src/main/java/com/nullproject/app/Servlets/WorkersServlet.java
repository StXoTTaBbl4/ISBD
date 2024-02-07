package com.nullproject.app.Servlets;

import com.google.gson.JsonObject;
import com.nullproject.app.Entries.Facility;
import com.nullproject.app.Entries.FuneralServicesAccData;
import com.nullproject.app.Entries.Worker;
import com.nullproject.app.hibernate.HibernateUtil;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "workerServlet", value = "/workers-servlet")
public class WorkersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.connection();
        Session session = hibernateUtil.session();
        Transaction transaction = hibernateUtil.transaction();

        try {
            transaction.begin();
            Query query = session.createNativeQuery("SELECT * FROM worker", Worker.class);
            List<Worker> entries = query.getResultList();
            transaction.commit();

            transaction.begin();
            query = session.createNativeQuery("SELECT * FROM facility", Facility.class);
            List<Facility> f = query.getResultList();
            transaction.commit();

            JsonObject object = getJsonObject(f, entries);
            resp.getWriter().println(object);

        } catch (RuntimeException exception) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            resp.sendError(500);
            throw exception;
        }catch (Exception e){
            //Потому что иначе вместо ошибок ДБ выдает $%!@*$%!^(#&%Q
            PrintStream printStream;
            printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
            printStream.println(e);
            resp.sendError(500);
            throw e;
        }
    }

    private static JsonObject getJsonObject(List<Facility> f, List<Worker> entries) {
        Map<Integer,Integer> m = new HashMap<>();
        for (Facility fs: f) {
            m.put(fs.getId(), fs.getRegistrationId());
        }

        JsonObject object = new JsonObject();
        for (Worker e: entries) {
            object.addProperty("ID-"+e.getId(),
                    e.getName() + " " +
                    e.getSecondName() +
                    (e.getIntern() ? ", intern." : ".") +
                    " Working in facility ID-" + m.get(e.getIdOfFacility()));
        }
        return object;
    }
}
