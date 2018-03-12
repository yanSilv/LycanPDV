/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lycanpdv;

import Controle.ConManipulaArquivo;
import Controle.ConArquivoTxt;
import DAO.DaoArquivoPreco;
import DAO.DaoFiliais;
import DAO.DaoLaboTipo;
import DAO.DaoMedicos;
import DAO.DaoVendedor;
import DAO.LycanDB;
import Modelo.ModArquivoPreco;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaguar
 */
public class LycanPdv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String arquivo = "arquivo.txt";
        String medicos = "medicos.txt";
        String vendedo = "vendedor.txt";
        String labotip = "labotipo.txt";
        String filiais = "filiais.txt";
        String bancoDb = "database/arquivo.db";

        ArrayList<String> dadosArq = new ArrayList<String>();
        ArrayList<String> dadosMed = new ArrayList<String>();
        ArrayList<String> dadosVen = new ArrayList<String>();
        ArrayList<String> dadosLab = new ArrayList<String>();
        ArrayList<String> dadosFil = new ArrayList<String>();
        
        ConManipulaArquivo manArq = new ConManipulaArquivo();
        
        ConArquivoTxt lerArq = new ConArquivoTxt();
        
        DaoArquivoPreco daoPrec = new DaoArquivoPreco(bancoDb);
        DaoMedicos daoMed = new DaoMedicos(bancoDb);
        DaoVendedor daoVen = new DaoVendedor(bancoDb);
        DaoLaboTipo daoLab = new DaoLaboTipo(bancoDb);
        DaoFiliais daoFil = new DaoFiliais(bancoDb);
        
        System.out.println("Lendo os arquivos");
        dadosArq = manArq.lerArquivo(arquivo);
        dadosMed = manArq.lerArquivo(medicos);
        dadosVen = manArq.lerArquivo(vendedo);
        dadosLab = manArq.lerArquivo(labotip);
        dadosFil = manArq.lerArquivo(filiais);
        
        LycanDB lycanDb = new LycanDB();

        try {
            System.out.println("Criando banco");
            lycanDb.criaDB(bancoDb);

        } catch (SQLException ex) {
            Logger.getLogger(LycanPdv.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LycanPdv.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Verificando o arquivo.txt");
        if (dadosArq.size() > 0) {

            daoPrec.salvar(lerArq.arquivoPreco(dadosArq));

        } else {
            System.out.println("Arquivo vazio ou não existe");
        }
        
        System.out.println("Verificando o arquivo medicos.txt");
        if (dadosMed.size() > 0) {

            daoMed.salvar(lerArq.arquivoMedicos(dadosMed));

        } else {
            System.out.println("Arquivo vazio ou não existe");
        }
        
        System.out.println("Verificando o arquivo vendedor.txt");
        if (dadosVen.size() > 0) {

            daoVen.salvar(lerArq.arquivoVendedor(dadosVen));

        } else {
            System.out.println("Arquivo vazio ou não existe");
        }
        
        System.out.println("Verificando o arquivo labotipo.txt");
        if (dadosLab.size() > 0) {

            daoLab.salvar(lerArq.arquivoLaboTipo(dadosLab));

        } else {
            System.out.println("Arquivo vazio ou não existe");
        }
        
        System.out.println("Verificando o arquivo filiais.txt");
        if (dadosFil.size() > 0) {

            daoFil.salvar(lerArq.arquivoFiliais(dadosFil));

        } else {
            System.out.println("Arquivo vazio ou não existe");
        }
    }

}
