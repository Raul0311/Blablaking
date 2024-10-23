/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import blablacarHibernate.HibernateUtil;
import blablacarHibernate.Reserva;
import blablacarHibernate.Usuario;
import blablacarHibernate.Viaje;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;

/**
 *
 * @author raulr
 */
public final class Controlador {
    
    public Usuario comprobarInicioSesion(String login) {
        Query query = HibernateUtil.getCurrentSession().
            createQuery("FROM Usuario u WHERE u.login = :login");
        query.setParameter("login", login);
        Usuario usuario = (Usuario) query.uniqueResult();
        
        return usuario;
    }
    
    public List<Viaje> getViajes() {
        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Viaje");
        List<Viaje> viajes = query.list();
        
        return viajes;
    }
    
    public List<Reserva> getReservas() {
        Query query = HibernateUtil.getCurrentSession().createQuery("FROM Reserva");
        List<Reserva> reservas = query.list();
        
        return reservas;
    }
    
    public void realizarReserva(Reserva reserva) {
        HibernateUtil.getCurrentSession().beginTransaction();
        HibernateUtil.getCurrentSession().save(reserva);
        HibernateUtil.getCurrentSession().getTransaction().commit();
    }
    
    public void conectar() {
        try {
            HibernateUtil.buildSessionFactory();
            HibernateUtil.openSession();
        } catch(HibernateException he) {
            he.printStackTrace();
        }
    }
    
    public void desconectar() {
        try {
            HibernateUtil.closeSessionFactory();
        } catch(HibernateException he) {
            he.printStackTrace();
        }
    }
}
