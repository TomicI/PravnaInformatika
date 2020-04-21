package com.example.demo;

import com.example.demo.contracts.Pomocna;
import com.example.demo.contracts.web3j.UgovorKupoprodaja;
import com.example.demo.model.ContractR;
import com.example.demo.model.DeoRobe;
import com.example.demo.model.Roba;
import com.example.demo.model.Strane;
import com.example.demo.service.ContractRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.web3j.tx.gas.DefaultGasProvider.GAS_LIMIT;
import static org.web3j.tx.gas.DefaultGasProvider.GAS_PRICE;

@SpringBootApplication
public class PravnaInformatikaApplication {

    @Autowired
    ContractRService contractRService;

    public static void main(String[] args) {
        SpringApplication.run(PravnaInformatikaApplication.class, args);


    }


    public List<ContractR> getAllContractR(){
        return contractRService.getAll();
    }
//ganache-cli --account="0xdf1f4ecb742708b0d5a4c9df01d47d91d4967eb8ca42467c30270857204a1329, 30000000000000000000000000000000000000"


    @PostConstruct
    public void init() throws IOException, CipherException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, ExecutionException, InterruptedException {
        Web3j web3j;
        web3j = Web3j.build(new HttpService());
        Credentials credentials, credentials1;
        String credentials1Address="0xdf1f4ecb742708b0d5a4c9df01d47d91d4967eb8ca42467c30270857204a1329";
        for(ContractR c: contractRService.getAll()){
            credentials = WalletUtils.loadCredentials(c.getVlasnik().getPassword(), "w/" + c.getVlasnik().getAddress());


            try {
                credentials1=Credentials.create(credentials1Address);
                BigDecimal amountInEther = BigDecimal.valueOf(3.0);
                TransactionReceipt transactionReceipt = Transfer.sendFunds(
                        web3j, credentials1, credentials.getAddress(),
                        amountInEther, Convert.Unit.ETHER).send();
                EthGetBalance balance1 = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                UgovorKupoprodaja contract = UgovorKupoprodaja.deploy(  web3j, credentials, GAS_PRICE, GAS_LIMIT).send();
                Roba roba=c.getRoba();
                contract.setRoba(roba.getOpis(), BigInteger.valueOf(roba.getKolicina()), BigDecimal.valueOf(roba.getCena()).toBigInteger(),
                        BigInteger.valueOf(roba.getRokIsporuke()), BigInteger.valueOf(roba.getRokIsporukeMax()), roba.getKupacOdgovoran(),
                        roba.getUputstvo(), roba.getNesaobraznostZamenom(), BigInteger.valueOf(roba.getRokOdPrelaskaRizikaNaKupca()),
                        BigInteger.valueOf(roba.getRokOdustanak()), BigInteger.valueOf(DeoRobe.valueOf(roba.getDeoRobe()).ordinal()), BigInteger.valueOf(roba.getRokVracanjaRobe()),
                        BigInteger.valueOf(roba.getRokVracanjaNovca()), BigInteger.valueOf(roba.getBrojPrimeraka()), BigInteger.valueOf(roba.getBrojPrimeraKupac())).send();

                contract.setProdavac(c.getVlasnik().getFirstName()+" " + c.getVlasnik().getLastName(),c.getVlasnik().getCity()).send();
                contract.setIsporuka(roba.getIzvrsiteljIsporuke(), BigInteger.valueOf(Strane.valueOf(roba.getTroskoveSnosi()).ordinal()), BigInteger.valueOf(Strane.valueOf(roba.getTroskoviOdustanak()).ordinal())).send();
                contract.prodavacSaglasan();

                c.setAddress(contract.getContractAddress());
                contractRService.save(c);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        

    }
/*
    @GetMapping("/owner")
    public String getOwnerAccount() {
        return credentials.getAddress();
    }


    private List contracts = new ArrayList();
    @PostMapping
    public Contract createContract(@RequestBody Contract newContract) throws Exception {
        String file = WalletUtils.generateLightNewWalletFile("piot123", null);
        Credentials receiverCredentials = WalletUtils.loadCredentials("piot123", file);
        System.out.println("Credentials created: file={}, address={}"+ file+ credentials.getAddress());
        UgovorKupoprodaja contract = UgovorKupoprodaja.deploy(  web3j, credentials, GAS_PRICE, GAS_LIMIT).send();
        newContract.setContractAddress(receiverCredentials.getAddress());
        // newContract.setDeployedAddress(contract.getClass());
        contracts.add(credentials.getAddress());
        System.out.println("New contract deployed: address={}"+ newContract.getContractAddress());
        Optional tr = contract.getTransactionReceipt();

        if (tr.isPresent()) {
            System.out.println("Transaction receipt: from={}, to={}, gas={}"+tr.get().toString());
        }
        return newContract;
    }*/
}

