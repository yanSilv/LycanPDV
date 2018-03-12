/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ModArquivoPreco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author jaguar
 */
public class DaoArquivoPreco {

    private String db;

    private String sql;
    private String sqlselect;

    private PreparedStatement ps;
    private PreparedStatement psSelect;
    private ResultSet rs;

    public DaoArquivoPreco(String bancoDados) {
        db = bancoDados;
    }

    public boolean salvar(ArrayList<ModArquivoPreco> arrayModArq) {

        try {
            sql = "PRAGMA SYNCHRONOUS=OFF";
            ps = LycanDB.getConexao(this.db).prepareStatement(sql);
            ps.execute();
            
            sql = "DELETE FROM PRODUTOS";
            ps = LycanDB.getConexao(this.db).prepareStatement(sql);
            ps.execute();

            sql = "INSERT INTO PRODUTOS VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = LycanDB.getConexao(this.db).prepareStatement(sql);

            for (ModArquivoPreco modArq : arrayModArq) {
                /* Verifica se o codigo do produto já está cadastrado*/
                sqlselect = "SELECT codigo FROM produtos WHERE codigo = ?";
                psSelect = LycanDB.getConexao(this.db).prepareStatement(sqlselect);
                psSelect.setString(1, modArq.getCodigo());
                rs = psSelect.executeQuery();

                rs.next();
                if (rs.getRow() > 0) {
                    continue;
                }

                ps.setString(1, modArq.getCodigo());
                ps.setString(2, modArq.getNome());
                ps.setString(3, modArq.getBarras());
                ps.setFloat(4, modArq.getUnitario());
                ps.setString(5, modArq.getSd());
                ps.setString(6, modArq.getDmax());
                ps.setFloat(7, modArq.getPrecoReal());
                ps.setString(8, modArq.getNaoAnota());
                ps.setString(9, modArq.getAliquota());
                ps.setString(10, modArq.getBarras2());
                ps.setString(11, modArq.getDcCpl());
                ps.setString(12, modArq.getConvenio());
                ps.setString(13, modArq.getLabo());
                ps.setString(14, modArq.getTipo());
                ps.setString(15, modArq.getProgram());
                ps.setString(16, modArq.getUnidade());
                ps.setString(17, modArq.getTpProgram());
                ps.setString(18, modArq.getClassFisc());
                ps.setString(19, modArq.getGnr());
                ps.setString(20, modArq.getgTin());
                ps.setFloat(21, modArq.getAliquotaFed());
                ps.setFloat(22, modArq.getAliquotaEst());
                ps.setFloat(23, modArq.getAliquotaMun());
                ps.setFloat(24, modArq.getAliquotaImp());
                ps.setString(25, modArq.getFont());
                ps.setFloat(26, modArq.getPerDesc());
                ps.setString(27, modArq.getTipoDesc());
                ps.setString(28, modArq.getNomeComp());
                ps.setString(29, modArq.getFabricante());

                ps.execute();
                psSelect.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
