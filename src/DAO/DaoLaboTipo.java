/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ModArquivoLabotipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jaguar
 */
public class DaoLaboTipo {
    private String db;
    
    private String sql;
    private String sqlselect;

    private PreparedStatement ps;
    private PreparedStatement psSelect;
    private ResultSet rs;
    
    public DaoLaboTipo(String bancoDb) {
        db = bancoDb;
    }

    public boolean salvar(ArrayList<ModArquivoLabotipo> arquivoLaboTipo) {
        this.sql = "PRAGMA SYNCHRONOUS=OFF";
        try {
            this.ps = LycanDB.getConexao(this.db).prepareStatement(this.sql);
            this.ps.execute();
            
            sql = "DELETE FROM LABOTIPO";
            ps = LycanDB.getConexao(this.db).prepareStatement(sql);
            ps.execute();

            this.sql = "INSERT INTO LABOTIPO (classe, identif, extensao, programa, saltaDc0) VALUES(?,?,?,?,?)";
            this.ps = LycanDB.getConexao(this.db).prepareStatement(this.sql);
            
            for (ModArquivoLabotipo arLab : arquivoLaboTipo) {
                
                ps.setString(1, arLab.getClasse());
                ps.setString(2, arLab.getIdentifi());
                ps.setString(3, arLab.getExtensao());
                ps.setString(4, arLab.getPrograma());
                ps.setString(5, arLab.getSaltaDc0());
                
                ps.execute();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
