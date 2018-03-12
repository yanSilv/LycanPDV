/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.ModArquivoFiliais;
import Modelo.ModArquivoLabotipo;
import Modelo.ModArquivoMedico;
import java.util.ArrayList;
import Modelo.ModArquivoPreco;
import Modelo.ModArquivoVendedor;

/**
 *
 * @author jaguar
 */
public class ConArquivoTxt {
    
    public ArrayList<ModArquivoPreco> arquivoPreco (ArrayList<String> dadosArquivo) {
        
        ArrayList<ModArquivoPreco> arrayPreco = new ArrayList<ModArquivoPreco>();
        
        for (String linha : dadosArquivo) {
           
            ModArquivoPreco arPre = new ModArquivoPreco();
            
            if (linha.substring(0, 1).equals("#"))
                continue;
            
            arPre.setCodigo(linha.substring(0, 6));
            arPre.setNome(linha.substring(6, 19));
            arPre.setBarras(linha.substring(19, 48));
            arPre.setUnitario(Float.parseFloat(linha.substring(48, 59)));
            arPre.setSd(linha.substring(59, 60));
            arPre.setDmax(linha.substring(60, 62));
            arPre.setPrecoReal(Float.parseFloat(linha.substring(62, 73)));
            arPre.setNaoAnota(linha.substring(73, 74));
            arPre.setAliquota(linha.substring(74, 76));
            arPre.setBarras2(linha.substring(76, 89));
            arPre.setDcCpl(linha.substring(89, 94));
            arPre.setConvenio(linha.substring(94, 95));
            arPre.setLabo(linha.substring(95, 98));
            arPre.setTipo(linha.substring(98, 100));
            arPre.setProgram(linha.substring(100, 102));
            arPre.setUnidade(linha.substring(102, 104));
            arPre.setTpProgram(linha.substring(104, 105));
            arPre.setClassFisc(linha.substring(105, 113));
            arPre.setGnr(linha.substring(113, 115));
            arPre.setgTin(linha.substring(115, 129));
            arPre.setAliquotaFed(Float.parseFloat(linha.substring(129, 135)));
            arPre.setAliquotaEst(Float.parseFloat(linha.substring(135, 141)));
            arPre.setAliquotaMun(Float.parseFloat(linha.substring(141, 147)));
            arPre.setAliquotaImp(Float.parseFloat(linha.substring(147, 153)));
            arPre.setFont(linha.substring(153, 159));
            arPre.setPerDesc(Float.parseFloat(linha.substring(159, 169)));
            arPre.setTipoDesc(linha.substring(169, 171));
            arPre.setNomeComp(linha.substring(171, 322));
            arPre.setFabricante(linha.substring(322, 372));
            arrayPreco.add(arPre);
        }
        
        return arrayPreco;
    }

    public ArrayList<ModArquivoMedico> arquivoMedicos(ArrayList<String> dadosMed) {
       
        ArrayList<ModArquivoMedico> arrayMedico = new ArrayList<ModArquivoMedico>();
        
        for (String linha : dadosMed) {
           
            ModArquivoMedico arMedi = new ModArquivoMedico();
            
            if (linha.substring(0, 1).equals("#"))
                continue;
            
            arMedi.setNome(linha.substring(0, 45));
            arMedi.setNumero(linha.substring(45, 55));
            arMedi.setConselho(linha.substring(55, 59));
            arMedi.setUf(linha.substring(59, 61));
            arMedi.setFilial(linha.substring(61, 64));
            arMedi.setDelete(linha.substring(64, 65));
            arrayMedico.add(arMedi);
        }
        
        return arrayMedico;
    }

    public ArrayList<ModArquivoVendedor> arquivoVendedor(ArrayList<String> dadosVen) {
        
        ArrayList<ModArquivoVendedor> arrayVend = new ArrayList<ModArquivoVendedor>();
        
        for (String linha : dadosVen) {
            ModArquivoVendedor modVen = new ModArquivoVendedor();
            
            if (linha.substring(0, 1).equals("#"))
                continue;
            
            modVen.setCodVendedor(linha.substring(0, 5));
            modVen.setNomeVendedor(linha.substring(5, 25));
            modVen.setClaVendedor(linha.substring(25, 26));
            modVen.setOperadorVende(linha.substring(26, 27));
            modVen.setBloqueioVende(linha.substring(27, 28));
            arrayVend.add(modVen);
        }
        
        return arrayVend;
    }

    public ArrayList<ModArquivoLabotipo> arquivoLaboTipo(ArrayList<String> dadosLab) {
        
        ArrayList<ModArquivoLabotipo> arrayLab = new ArrayList<ModArquivoLabotipo>();
        
        for (String linha : dadosLab) {
            ModArquivoLabotipo modLab = new ModArquivoLabotipo();
            
            if (linha.substring(0, 1).equals("#"))
                continue;
            
            modLab.setClasse(linha.substring(0, 1));
            modLab.setIdentifi(linha.substring(1, 4));
            modLab.setExtensao(linha.substring(4, 28));
            modLab.setPrograma(linha.substring(28, 29));
            modLab.setSaltaDc0(linha.substring(29, 30));
            
            arrayLab.add(modLab);
        }
        
        return arrayLab;
    }

    public ArrayList<ModArquivoFiliais> arquivoFiliais(ArrayList<String> dadosFil) {
       
        ArrayList<ModArquivoFiliais> arrayLab = new ArrayList<ModArquivoFiliais>();
        
        for (String linha : dadosFil) {
            ModArquivoFiliais modFil = new ModArquivoFiliais();
            
            if (linha.substring(0, 1).equals("#"))
                continue;
            
            modFil.setCodigo(linha.substring(0, 3));
            modFil.setNome(linha.substring(3, 18));
            modFil.setTelefone(linha.substring(18, 30));
            modFil.setRegiao(linha.substring(30, 32));
            modFil.setEndereco(linha.substring(33, 66));
            modFil.setComplamento(linha.substring(67, 79));
            modFil.setNumero(linha.substring(80, 85));
            modFil.setBairro(linha.substring(86, 106));
            modFil.setCep(linha.substring(107, 114));
            modFil.setCidade(linha.substring(116, 136));
            modFil.setEstado(linha.substring(137, 139));
            modFil.setCgc(linha.substring(140, 153));
            modFil.setIe(linha.substring(155, 163));
            modFil.setIm(linha.substring(164, 178));
            modFil.setCodmun(linha.substring(179, 186));
            
            arrayLab.add(modFil);
        }
        
        return arrayLab;
    }
}
