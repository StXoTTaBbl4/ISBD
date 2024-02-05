package com.nullproject.app.Servlets;

import com.google.gson.Gson;
import com.nullproject.app.Entries.FuneralServicesAccData;
import com.nullproject.app.Entries.RelativeData;
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

@WebServlet(name = "bodiesInfoServlet", value = "/bodies-info-servlet")
public class BodiesInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.connection();
        Session session = hibernateUtil.session();
        Transaction transaction = hibernateUtil.transaction();

//        try{
//            transaction.begin();
//            Query query = session.createNativeQuery("SELECT * FROM relative_data where personid =?", RelativeData.class);
//            query.setParameter(1, Integer.parseInt(req.getParameter("personID").replace("\"","")));
//
//            List<RelativeData> entry = query.getResultList();
//            transaction.commit();
//            Gson gson = new Gson();
//            resp.getWriter().println(gson.toJson(entry.get(0)));
//        }catch (RuntimeException e){
//            e.printStackTrace();
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//        }catch (Exception e){
//            //Потому что иначе вместо ошибок ДБ выдает $%!@*$%!^(#&%Q
//            PrintStream printStream;
//            printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
//            printStream.println(e);
//            throw e;
//        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HibernateUtil hibernateUtil = new HibernateUtil();
        hibernateUtil.connection();
        Session session = hibernateUtil.session();
        Transaction transaction = hibernateUtil.transaction();

//        try {
//            transaction.begin();
//            Query query = session.createNativeQuery("UPDATE relative_data SET name=? WHERE personid=?");
//            query.setParameter(1, data.get("login").toString().replace("\"",""));
//            query.setParameter(2, data.get("password").toString().replace("\"",""));
//            List<FuneralServicesAccData> entries = query.getResultList();
//            transaction.commit();
//
//            if (entries.isEmpty()){
//            }
//            else{
//
//            }
//        } catch (RuntimeException exception) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            throw exception;
//        }catch (Exception e){
//            //Потому что иначе вместо ошибок ДБ выдает $%!@*$%!^(#&%Q
//            PrintStream printStream;
//            printStream = new PrintStream(System.out, true, StandardCharsets.UTF_8);
//            printStream.println(e);
//            throw e;
//        }
    }
}
