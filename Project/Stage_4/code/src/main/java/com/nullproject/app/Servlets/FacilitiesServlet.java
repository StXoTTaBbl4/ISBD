package com.nullproject.app.Servlets;

import com.google.gson.JsonObject;
import com.nullproject.app.Entries.Facility;
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
import java.util.List;

@WebServlet(name = "facilitiesServlet", value = "/facilities-servlet")
public class FacilitiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.connection();
        Session session = hibernateUtil.session();
        Transaction transaction = hibernateUtil.transaction();

        try {
            transaction.begin();
            Query query = session.createNativeQuery("SELECT * FROM facility ", Facility.class);

            List<Facility> entries = query.getResultList();
            transaction.commit();
            JsonObject object = new JsonObject();
            for (Facility e: entries) {
                object.addProperty("Reg.ID-"+e.getRegistrationId().toString(),e.getAddress() + ", w/h: from " + e.getWorkingHoursFrom().toString() + " until " + e.getWorkingHoursUntil().toString());
            }
            resp.getWriter().println(object);
        } catch (RuntimeException exception) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw exception;
        }catch (Exception e){
            //Потому что иначе вместо ошибок ДБ выдает $%!@*$%!^(#&%Q
            PrintStream printStream;
            printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
            printStream.println(e);
            throw e;
        }
    }
}
