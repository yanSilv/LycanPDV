/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ModArquivoFiliais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jaguar
 */
public class DaoFiliais {
    private String db;
    
    private String sql;
    private String sqlselect;

    private PreparedStatement ps;
    private PreparedStatement psSelect;
    private ResultSet rs;
    
    public DaoFiliais(String nomeDb) {
         db = nomeDb;
    }

    public boolean salvar(ArrayList<ModArquivoFiliais> arquivoFiliais) {
        this.sql = "PRAGMA SYNCHRONOUS=OFF";
        try {
            this.ps = LycanDB.getConexao(this.db).prepareStatement(this.sql);
            this.ps.execute();
            
            sql = "DELETE FROM FILIAIS";
            ps = LycanDB.getConexao(this.db).prepareStatement(sql);
            ps.execute();

            this.sql = "INSERT INTO FILIAIS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            this.ps = LycanDB.getConexao(this.db).prepareStatement(this.sql);
            
            for (ModArquivoFiliais arFil : arquivoFiliais) {
                
                ps.setString(1, arFil.getCodigo());
                ps.setString(2, arFil.getNome());
                ps.setString(3, arFil.getTelefone());
                ps.setString(4, arFil.getRegiao());
                ps.setString(5, arFil.getEndereco());
                ps.setString(6, arFil.getComplamento());
                ps.setString(7, arFil.getNumero());
                ps.setString(8, arFil.getBairro());
                ps.setString(9, arFil.getCep());
                ps.setString(10, arFil.getCidade());
                ps.setString(11, arFil.getEstado());
                ps.setString(12, arFil.getCgc());
                ps.setString(13, arFil.getIe());
                ps.setString(14, arFil.getIm());
                ps.setString(15, arFil.getCodmun());
                
                
                ps.execute();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
