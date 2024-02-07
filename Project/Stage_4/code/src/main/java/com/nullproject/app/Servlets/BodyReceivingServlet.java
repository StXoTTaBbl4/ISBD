package com.nullproject.app.Servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nullproject.app.Entries.BodyReceiving;
import com.nullproject.app.Entries.FuneralServicesAccData;
import com.nullproject.app.hibernate.HibernateUtil;
import com.nullproject.app.utility.JSONParser;
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

@WebServlet(name = "bodyReceivingServlet", value = "/body-receiving-servlet")
public class BodyReceivingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.connection();
        Session session = hibernateUtil.session();
        Transaction transaction = hibernateUtil.transaction();

        System.out.println(Integer.parseInt(req.getParameter("personID")));

        try {
            transaction.begin();
            Query query = session.createNativeQuery("SELECT * FROM body_receiving where receiver_id =?", BodyReceiving.class);
            query.setParameter(1, Integer.parseInt(req.getParameter("personID")));

            List<BodyReceiving> entries = query.getResultList();
            transaction.commit();

            if (entries.isEmpty()){
                resp.sendError(404);
            }
            else{
                Gson gson = new Gson();
                resp.setContentType("text/json");
                resp.getWriter().println(gson.toJson(entries.get(0)));
            }
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.connection();
        Session session = hibernateUtil.session();
        Transaction transaction = hibernateUtil.transaction();
        JsonObject object = JSONParser.fromJSON(req);
        try {
            transaction.begin();
            Query query = session.createNativeQuery("SELECT * from body_receiving where receiving_date=? and receiving_date=?", BodyReceiving.class);
            List<BodyReceiving> entries = query.getResultList();
            transaction.commit();
            if (entries.isEmpty()){
                transaction.begin();
                query = session.createNativeQuery("INSERT into body_receiving (facility_address," +
                        " receiving_date," +
                        " receiver_name," +
                        " receiver_second_name," +
                        " receiver_ID," +
                        " receiver_phone_number," +
                        " body_treatment_type," +
                        " graveyard_order_ID) values (?,?,?,?,?,?,?,?)", BodyReceiving.class);
                query.setParameter(1,object.get("facility_address"));
                query.setParameter(1,object.get("receiving_date"));
                query.setParameter(1,object.get("receiver_name"));
                query.setParameter(1,object.get("receiver_second_name"));
                query.setParameter(1, Integer.parseInt(String.valueOf(object.get("receiver_ID"))));
                query.setParameter(1,object.get("receiver_phone_number"));
                query.setParameter(1,object.get("body_treatment_type"));
                query.setParameter(1, Integer.parseInt(String.valueOf(object.get("graveyard_order_ID"))));
                transaction.commit();

                resp.setContentType("text/html");
                resp.getWriter().println("Done");

            }


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
