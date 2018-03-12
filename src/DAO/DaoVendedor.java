/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ModArquivoVendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jaguar
 */
public class DaoVendedor {
    private String db;
    
    private String sql;
    private String sqlselect;

    private PreparedStatement ps;
    private PreparedStatement psSelect;
    private ResultSet rs;
    
    public DaoVendedor(String bancoDb) {
        db = bancoDb;
    }

    public boolean salvar(ArrayList<ModArquivoVendedor> arquivoVendedor) {
        this.sql = "PRAGMA SYNCHRONOUS=OFF";
        try {
            this.ps = LycanDB.getConexao(this.db).prepareStatement(this.sql);
            this.ps.execute();
            
            sql = "DELETE FROM VENDEDOR";
            ps = LycanDB.getConexao(this.db).prepareStatement(sql);
            ps.execute();

            this.sql = "INSERT INTO VENDEDOR VALUES(?,?,?,?,?)";
            this.ps = LycanDB.getConexao(this.db).prepareStatement(this.sql);
            
            for (ModArquivoVendedor arVen : arquivoVendedor) {
                
                /* Verifica se o codigo do produto já está cadastrado*/
                sqlselect = "SELECT vende_vendedor FROM VENDEDOR WHERE vende_vendedor = ?";
                psSelect = LycanDB.getConexao(this.db).prepareStatement(sqlselect);
                psSelect.setString(1, arVen.getCodVendedor());
                rs = psSelect.executeQuery();

                rs.next();
                if (rs.getRow() > 0) {
                    continue;
                }
                
                ps.setString(1, arVen.getCodVendedor());
                ps.setString(2, arVen.getNomeVendedor());
                ps.setString(3, arVen.getClaVendedor());
                ps.setString(4, arVen.getOperadorVende());
                ps.setString(5, arVen.getBloqueioVende());
                
                ps.execute();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
