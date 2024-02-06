package com.nullproject.app.Servlets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nullproject.app.Entries.FuneralServicesAccData;
import com.nullproject.app.hibernate.HibernateUtil;
import com.nullproject.app.utility.JSONParser;
import jakarta.persistence.Query;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
@WebServlet(name = "authServlet", value = "/auth-servlet")
public class AuthServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.connection();
        Session session = hibernateUtil.session();
        Transaction transaction = hibernateUtil.transaction();


        JsonObject data = JSONParser.fromJSON(req);
//        System.out.println(data);


        try {
            transaction.begin();
            Query query = session.createNativeQuery("SELECT * FROM funeral_services_acc_data where login =? and password=?", FuneralServicesAccData.class);
            query.setParameter(1, data.get("login").toString().replace("\"",""));
            query.setParameter(2, data.get("password").toString().replace("\"",""));

            List<FuneralServicesAccData> entries = query.getResultList();
            transaction.commit();
            for (FuneralServicesAccData f: entries
                 ) {
                System.out.println(f.toString());
            }
            if (entries.isEmpty()){
                resp.sendError(404);
            }
            else{
                resp.setContentType("text/html");
                resp.getWriter().println(entries.get(0).person_id());
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
