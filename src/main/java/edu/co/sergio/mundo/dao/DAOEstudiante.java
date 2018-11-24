/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.dao;

import edu.co.sergio.mundo.vo.Escuela;
import edu.co.sergio.mundo.vo.Estudiante;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabian.giraldo
 */
public class DAOEstudiante implements IBaseDatos<Estudiante>{

  
    public List<Estudiante> findAllByEscuela(int codEscuela) {
        List<Estudiante> estudiantes = null;
        String query = "select Estudiante.codigo, estudiante.nombre from Estudiante,Escuela where Estudiante.codEscuela=Escuela.codigo;";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DAOEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement preparedStmt = null;
            preparedStmt = connection.prepareStatement(query);
	     
            ResultSet rs = preparedStmt.executeQuery();
            int id = 0;
            String nombre = null, escuela = null;

            while (rs.next()) {
                if (estudiantes == null) {
                    estudiantes = new ArrayList<Estudiante>();
                }

                Estudiante estudiante = new Estudiante();
                id = rs.getInt("codigo");
                estudiante.setCodigo(id);

                nombre = rs.getString("nombre");
                estudiante.setNombre(nombre);
                
                estudiante.setEscuela("osfsd");
                
                estudiantes.add(estudiante);
            }
            preparedStmt.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return estudiantes;

    }

    @Override
    public boolean insert(Estudiante t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Estudiante t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Estudiante t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estudiante> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
