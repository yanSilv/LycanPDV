/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controle.ConManipulaArquivo;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jaguar
 */
public class LycanDB {

    private Connection conn;
    private static Connection sconn;
    private Statement stm;
    
    
    public static Connection getConexao(String arquivo) throws SQLException {
        ConManipulaArquivo mani = new ConManipulaArquivo();
        File file_arquivo = new File(arquivo);
        File endereco = new File(mani.enderecoArquivo(file_arquivo.getAbsolutePath()));
        
        if (file_arquivo.exists()) {
            try{
                Class.forName("org.sqlite.JDBC");
                if(sconn == null){
                    sconn = DriverManager.getConnection("jdbc:sqlite:/" + file_arquivo.getAbsolutePath());
                }
                return sconn;
            }catch(Exception e){
                    return null;
            }
        }
        return null;
    }
    
    public void criaDB(String arquivo) throws SQLException, ClassNotFoundException {

        ConManipulaArquivo mani = new ConManipulaArquivo();
        File file_arquivo = new File(arquivo);
        File endereco = new File(mani.enderecoArquivo(file_arquivo.getAbsolutePath()));

        if (!file_arquivo.exists()) {
            endereco.mkdir();
            Class.forName("org.sqlite.JDBC");
            this.conn = DriverManager.getConnection("jdbc:sqlite:/" + file_arquivo.getAbsolutePath());
            this.stm = this.conn.createStatement();
            construirBD();
            System.out.println("Arquivo do banco criado com sucesso!!");
        }
    }

    private void construirBD() {

        StringBuilder produto = new StringBuilder();
        StringBuilder vendedor = new StringBuilder();
        StringBuilder medico = new StringBuilder();
        StringBuilder labotipo = new StringBuilder();
        StringBuilder filiais = new StringBuilder();
        StringBuilder farmPopu = new StringBuilder();
        //StringBuilder excluidos = new StringBuilder();
        
        String indexProdutos = "CREATE INDEX index_produtos on PRODUTOS (codigo, barras, barras_vel);";

        produto.append("CREATE TABLE PRODUTOS(");
        produto.append("codigo            CHAR(7) PRIMARY KEY,");
        produto.append("barras           CHAR(14),");
        produto.append("nome             CHAR(30),");
        produto.append("unitario         CHAR(12),");
        produto.append("sd                CHAR(2),");
        produto.append("dmax              CHAR(3),");
        produto.append("pr_real          CHAR(12),");
        produto.append("naoanota          CHAR(2),");
        produto.append("aliquota          CHAR(3),");
        produto.append("barras_vel       CHAR(14),");
        produto.append("dc_cp1            CHAR(6),");
        produto.append("convenio          CHAR(2),");
        produto.append("labo              CHAR(4),");
        produto.append("tipo              CHAR(3),");
        produto.append("program           CHAR(3),");
        produto.append("unidade           CHAR(3),");
        produto.append("tpprogram         CHAR(2),");
        produto.append("clas_Fisc         CHAR(9),");
        produto.append("gnr               CHAR(3),");
        produto.append("gTIN             CHAR(15),");
        produto.append("per_ali_fed       CHAR(7),");
        produto.append("per_ali_est       CHAR(7),");
        produto.append("per_ali_mun       CHAR(7),");
        produto.append("per_ali_imp       CHAR(7),");
        produto.append("font              CHAR(7),");
        produto.append("per_desc         CHAR(12),");
        produto.append("tipo_desc         CHAR(3),");
        produto.append("nomeComp        CHAR(300),");
        produto.append("fabricante      CHAR(300));");

        vendedor.append("CREATE TABLE VENDEDOR(");
        vendedor.append("vende_vendedor    CHAR(10) PRIMARY KEY,");
        vendedor.append("nome_vendedor     CHAR(25),");
        vendedor.append("cla_vendedor       CHAR(3),");
        vendedor.append("operador_vendedor  CHAR(3),");
        vendedor.append("blq_vendedor       CHAR(3));");

        medico.append("CREATE TABLE MEDICOS(");
        medico.append("id_medicos INTEGER PRIMARY KEY AUTOINCREMENT,");
        medico.append("nome      CHAR(3),");
        medico.append("numero    CHAR(4),");
        medico.append("conselho CHAR(30),");
        medico.append("uf        CHAR(4),");
        medico.append("filial    CHAR(4),");
        medico.append("deleted   CHAR(4));");

        labotipo.append("CREATE TABLE LABOTIPO(");
        labotipo.append("id_labotipo INTEGER PRIMARY KEY AUTOINCREMENT,");
        labotipo.append("classe      CHAR(3),");
        labotipo.append("identif     CHAR(4),");
        labotipo.append("extensao   CHAR(30),");
        labotipo.append("programa    CHAR(4),");
        labotipo.append("saltaDc0    CHAR(4));");

        filiais.append("CREATE TABLE FILIAIS(");
        filiais.append("codigo      CHAR   (4) PRIMARY KEY,");
        filiais.append("nome        CHAR  (16),");
        filiais.append("telefone    CHAR  (13),");
        filiais.append("regiao      CHAR   (3),");
        filiais.append("endereco    CHAR  (34),");
        filiais.append("complemento CHAR  (13),");
        filiais.append("numero      CHAR   (6),");
        filiais.append("bairro      CHAR  (21),");
        filiais.append("cep         CHAR   (9),");
        filiais.append("cidade      CHAR  (21),");
        filiais.append("estado      CHAR   (3),");
        filiais.append("cgc         CHAR  (15),");
        filiais.append("ie          CHAR   (9),");
        filiais.append("im          CHAR  (15),");
        filiais.append("codmun      CHAR   (8));");

        farmPopu.append("CREATE TABLE FARMACIA_POPULAR(");
        farmPopu.append("cod    CHAR  (8) PRIMARY KEY,");
        farmPopu.append("ean    CHAR (15),");
        farmPopu.append("qtd    CHAR  (8),");
        farmPopu.append("valt   CHAR (15));");
        
        /*
        excluidos.append("CREATE TABLE EXCLUIDOS(");
        excluidos.append("id_excluido       INTEGER PRIMARY KEY AUTOINCREMENT,");
        excluidos.append("dt_excl           CHAR  (8),");
        excluidos.append("barras            CHAR (15),");
        excluidos.append("codigo            CHAR  (5),");
        excluidos.append("nome              CHAR (29),");
        excluidos.append("unitario          CHAR  (9),");
        excluidos.append("clas_fisc         CHAR  (7),");
        excluidos.append("icm               CHAR  (2),");
        excluidos.append("gnr               CHAR  (2));");
        */
        
        try {
            this.stm.executeUpdate(produto.toString());
            this.stm.executeUpdate(indexProdutos);
            this.stm.executeUpdate(vendedor.toString());
            this.stm.executeUpdate(medico.toString());
            this.stm.executeUpdate(labotipo.toString());
            this.stm.executeUpdate(filiais.toString());
            this.stm.executeUpdate(farmPopu.toString());
            //this.stm.executeUpdate(excluidos.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
