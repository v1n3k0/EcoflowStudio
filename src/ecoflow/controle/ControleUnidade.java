/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecoflow.controle;

import ecoflow.modelo.Remota;
import ecoflow.modelo.Unidade;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import net.wimpi.modbus.net.TCPMasterConnection;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import util.modbus.ModbusRegistro;
import util.outros.Arquivo;
import util.outros.Converte;

/**
 *
 * @author vinicius
 */
public class ControleUnidade {
    
    final int CONTADOR = 16; //Quantidade de unidades por remota
    final int REFERENCIAQTDREMOTA = 0; //Referencia para quantidade de remota
    final int REFERENCIALEITURA = 1; //Inicio da leitura 1 a 640 (2 words)
    final int REFERENCIASERVICO = 641; //Referencia tipo de leitura 641 a 961 (1-agua fria 2-Agua quente 3-gas)
    final int REFERENCIAMATRICULAHIDROMETRO = 962; //Referencia matricula 962 a 1601 (2 words)
    final int REFERENCIANUMEROHIDROMETRO = 1602; //Referencia Numero de hidrometro 1602 a 3521 (6 words)
    final int REFERENCIAUNIDADE = 3522; //Referencia nome das unidades 3522 a 5122 (5 words)
    final int REFERENCIAIDCENTRAL = 5123; //Referencia para quantidade de remota
    final int FATORMULTIPLICATIVO = 10000; //fator multiplicativo para o segundo registro
    
    TCPMasterConnection tcpMasterConnection;
   
    public void setTcpMasterConnection(TCPMasterConnection tcp ){
        this.tcpMasterConnection = tcp;
    }
    
    public void getUnidades(int remota, List<Unidade> unidades){
        getUnidadesLeituras(remota, unidades);
        getUnidadesServicos(remota, unidades);
        getUnidadasMatriculaHidrometro(remota, unidades);
        getUnidadesNumeroHidrometro(remota, unidades);
    }
    
    public void setUnidades(int remota, List<Unidade> unidades){
        setUnidadesServicos(remota, unidades);
        setUnidadesMatriculaHidrometro(remota, unidades);
        setUnidadesNumeroHidrometro(remota, unidades);
    }
    
    //Le na central todos as leituras de uma central
    public void getUnidadesLeituras(List<Unidade> unidades){
        int contador = CONTADOR * 2;
        int referencia = REFERENCIALEITURA;
        int contar = 0;
        
        int[] remotas = ModbusRegistro.ler(tcpMasterConnection, REFERENCIAQTDREMOTA, 1);
        
        //Leitura por quantidade de remotas
        for(int j = 0; j < remotas[0]; j++){
            
            //Leitura de uma remota
            int[] leituras = ModbusRegistro.ler(tcpMasterConnection, referencia, contador);
            
            //Converte o double word
            for(int i = 0; i < contador; i += 2){
                Unidade un = unidades.get(contar);
                un.setLeitura( Converte.doubleWordInt(leituras[i], leituras[i + 1], FATORMULTIPLICATIVO) );
                contar++;
            }
            referencia += contador;
        }
    }
    
    //Le na central as leituras de uma remota
    public void getUnidadesLeituras(int remota, List<Unidade> unidades){
        int contador = CONTADOR * 2;
        int[] leituras = new int[contador];
        int referencia;
        int contar = 0;
        
        //Calculo para inicio da leitura do registro
        referencia = REFERENCIALEITURA + contador * remota;

        //Leitura de uma remota
        leituras = ModbusRegistro.ler(tcpMasterConnection, referencia, contador);

        //Converte o double word
        for(int i = 0; i < contador; i += 2){
            Unidade un = unidades.get(contar);
            un.setLeitura( Converte.doubleWordInt(leituras[i], leituras[i + 1], FATORMULTIPLICATIVO) );
            contar++;
        }
    }
    
    //Le da central os servicos de uma remota
    public void getUnidadesServicos(int remota, List<Unidade> unidades){
        int contador = CONTADOR; // 16 por remota
        int[] servico = new int[contador];
        int referencia;
        
        //Calculo para inicio do registro de servicos
        referencia = REFERENCIASERVICO + contador * remota;
        
        System.out.println(referencia);

        //Leitura de uma remota
        servico = ModbusRegistro.ler(tcpMasterConnection, referencia, contador);

        //Altera lista unidades
        for(int i = 0; i < contador; i++){
            Unidade un = unidades.get(i);
            un.setServico( servico[i] );
        }
    }
    
    //Escreve na central os servicos de uma remota
    public void setUnidadesServicos(int remota, List<Unidade> unidades){
        int contador = CONTADOR; // 16 por remota
        int[] servico = new int[contador];
        int referencia;

        //Altera vetor servico
        for(int i = 0; i < contador; i++){
            Unidade un = unidades.get(i);
            servico[i] = un.getServico();
        }
        
        //Calculo para inicio do registro de servicos
        referencia = REFERENCIASERVICO + contador * remota;

        //Escrita de uma remota
        ModbusRegistro.escrever(tcpMasterConnection, referencia, servico);
    }
    
    //Le na central matriculas dos hidrometros de uma remota
    public void getUnidadasMatriculaHidrometro(int remota, List<Unidade> unidades){
        int contador = CONTADOR * 2;
        int[] matriculas = new int[contador];
        int referencia;
        int contar = 0;
        
        //Calculo para inicio da leitura do registro
        referencia = REFERENCIAMATRICULAHIDROMETRO + contador * remota;

        //Leitura de uma remota
        matriculas = ModbusRegistro.ler(tcpMasterConnection, referencia, contador);

        //Converte o double word
        for(int i = 0; i < contador; i += 2){
            Unidade un = new Unidade();
            
            un = unidades.get(contar);
            un.setLeitura( Converte.doubleWordInt(matriculas[i], matriculas[i + 1], FATORMULTIPLICATIVO) );
            contar++;
        }
    }
    
    //Escreve na central matriculas dos hidrometros de uma remota
    public void setUnidadesMatriculaHidrometro(int remota, List<Unidade> unidades){
        int contador = CONTADOR * 2;
        int[] matriculas = new int[contador];
        int referencia;
        int contar = 0;

        //Converte em double word
        for(Unidade un: unidades){
            int a, b;
            
            a = Converte.intWordMais(un.getMatriculaHidrometro(), FATORMULTIPLICATIVO);
            b = Converte.intWordMenos(un.getMatriculaHidrometro(), FATORMULTIPLICATIVO);
            matriculas[contar] = a;
            contar++;
            matriculas[contar] = b;
            contar++;
        }
        
        //Calculo para inicio da leitura do registro
        referencia = REFERENCIAMATRICULAHIDROMETRO + contador * remota;

        //Leitura de uma remota
        ModbusRegistro.escrever(tcpMasterConnection, referencia, matriculas);
    }
    
    //Le na central numero do hidrometro
    public void getUnidadesNumeroHidrometro(int remota, List<Unidade> unidades){
        int contador = CONTADOR * 6;
        int[] numeros = new int[contador];
        int referencia;
        int contar = 0;
        
        //Calculo para inicio da leitura do registro
        referencia = REFERENCIANUMEROHIDROMETRO + contador * remota;

        //Leitura de uma remota
        numeros = ModbusRegistro.ler(tcpMasterConnection, referencia, contador);

        //Converte o double word
        for(int i = 0; i < contador; i += 6){
            Unidade un = new Unidade();
            int[] numero = new int[6];
            
            numero[0] = numeros[i];
            numero[1] = numeros[i + 1];
            numero[2] = numeros[i + 2];
            numero[3] = numeros[i + 3];
            numero[4] = numeros[i + 4];
            numero[5] = numeros[i + 5];
            
            un = unidades.get(contar);
            un.setNumeroHidrometro(Converte.intString(numero) );
            contar++;
        }
    }
    
    //Escreve na central numero de hidrometro
    public void setUnidadesNumeroHidrometro(int remota, List<Unidade> unidades){
        int contador = CONTADOR * 6;
        int[] numeros = new int[contador];
        int referencia;
        int contar = 0;

        //Converte em double word
        for(Unidade un: unidades){
            int[] numero = Converte.stringInt(un.getNumeroHidrometro() );
            
            for(int n: numero){
                numeros[contar] = n;
                contar++;
            }
        }
        
        //Calculo para inicio da leitura do registro
        referencia = REFERENCIANUMEROHIDROMETRO + contador * remota;

        //Leitura de uma remota
        ModbusRegistro.escrever(tcpMasterConnection, referencia, numeros);
    }
    
    public void addUnidades(Remota r, String nome, int servico){
        List<Unidade> unidades = r.getUnidades();

       for(int i = 0; i < 16; i++ ){           
           Unidade un = new Unidade();
           String idRemota, idUnidade;
           
           //Formata string para 2 digitos
           idRemota = String.format("%02d", r.getId() );
           idUnidade = String.format("%02d", i + 1 );
           
           //Altera nome e as configurações da unidade
           un.setPorta(i + 1);
           un.setNome(nome + idRemota + idUnidade );
           un.setServico(servico);
           un.setMatriculaHidrometro(0);
           un.setNumeroHidrometro("");
           un.setLeitura(0);
           un.setHabilitado(true);
           
           //Adiciona unidade na lista
           unidades.add(un);
        }
       
    }
    
    //Cria uma lista de 16 unidades nulas
    public void criarListaUnidade(List<Unidade> unidades){
        Unidade un = new Unidade();
        for(int i = 0; i < 16; i++){
            unidades.add(un);
        }
    }
    
    public void saveUnidadesXLS(List<Unidade> unidades) throws FileNotFoundException, IOException{
        int contador = 1;
        
        //Ecolhe local do arquivo para salvar
        String url = Arquivo.escolher(2);
        
        if(url != null){
            // arquivo do excel
            HSSFWorkbook wb = new HSSFWorkbook();
            // cria a planilha
            HSSFSheet plan = wb.createSheet("Leitura");
            
            // cria a linha de titulos
            HSSFRow rowTitle = plan.createRow(0);
            // cria a célula com nomes
            rowTitle.createCell((short) 0).setCellValue("Nome");
            rowTitle.createCell((short) 1).setCellValue("Leitura");
            
            for(Unidade un: unidades){
                // cria a linha na planilha o parametro da função create row é a linha
                HSSFRow row = plan.createRow(contador);
                // cria a célula na planilha
                row.createCell((short) 0).setCellValue(un.getNome() );
                row.createCell((short) 1).setCellValue(un.getLeitura() );
                
                contador++;
            }
            
            // cria o arquivo do excel
            FileOutputStream stream = new FileOutputStream(url + ".xls");
            // escreve os dados na planilha
            wb.write(stream);
            //Fechar arquivo
            stream.flush();
            stream.close();
            wb.close();
        }        
    }
    
}
