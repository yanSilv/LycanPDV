/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ModArquivoMedico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jaguar
 */
public class DaoMedicos {

    private String db;

    private String sql;
    private String sqlselect;

    private PreparedStatement ps;
    private PreparedStatement psSelect;
    private ResultSet rs;

    public DaoMedicos(String bancoDb) {
        db = bancoDb;
    }

    public boolean salvar(ArrayList<ModArquivoMedico> arquivoMedicos) {
        this.sql = "PRAGMA SYNCHRONOUS=OFF";
        try {
            this.ps = LycanDB.getConexao(this.db).prepareStatement(this.sql);
            this.ps.execute();
            
            sql = "DELETE FROM MEDICOS";
            ps = LycanDB.getConexao(this.db).prepareStatement(sql);
            ps.execute();

            this.sql = "INSERT INTO MEDICOS (nome, numero, conselho, uf, filial, deleted) VALUES(?,?,?,?,?,?)";
            this.ps = LycanDB.getConexao(this.db).prepareStatement(this.sql);
            
            for (ModArquivoMedico arMed : arquivoMedicos) {
                
                ps.setString(1, arMed.getNome());
                ps.setString(2, arMed.getNumero());
                ps.setString(3, arMed.getConselho());
                ps.setString(4, arMed.getUf());
                ps.setString(5, arMed.getFilial());
                ps.setString(6, arMed.getDelete());
                
                ps.execute();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
