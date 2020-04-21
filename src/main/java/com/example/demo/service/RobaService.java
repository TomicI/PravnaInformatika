package com.example.demo.service;

import com.example.demo.contracts.web3j.UgovorKupoprodaja;
import com.example.demo.model.*;
import com.example.demo.repository.RobaReposuitory;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.web3j.tx.gas.DefaultGasProvider.GAS_LIMIT;
import static org.web3j.tx.gas.DefaultGasProvider.GAS_PRICE;

@Service
public class RobaService {

    @Autowired
    RobaReposuitory robaReposuitory;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContractRService contractRService;

    Credentials credentials, credentials1;

    String credentials1Address="0xdf1f4ecb742708b0d5a4c9df01d47d91d4967eb8ca42467c30270857204a1329";

    Web3j web3j;

    public boolean saveRoba(Roba roba, String username){
        Optional<User> u = userRepository.findByUsername(username);
        if(u.isPresent()){
            robaReposuitory.save(roba);
            try {
                web3j = Web3j.build(new HttpService());

                credentials = WalletUtils.loadCredentials(u.get().getPassword(), "w/" + u.get().getAddress());
               /* System.out.println("address  "+ credentials.getAddress());


                System.out.println("ime vlasnik  "+ u.get().getFirstName());
                roba.setVlasnik(u.get());
                roba.setRobaProdata(false);
                credentials1=Credentials.create(credentials1Address);
                BigDecimal amountInEther = BigDecimal.valueOf(3.0);
                TransactionReceipt transactionReceipt = Transfer.sendFunds(
                        web3j, credentials1, credentials.getAddress(),
                        amountInEther, Convert.Unit.ETHER).send();
                EthGetBalance balance1 = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                System.out.println("Balance1: {}" + balance1.getBalance().longValue());

                EthGetBalance balance = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();

                System.out.println("Balance: {}" + balance.getBalance().longValue());*/
                UgovorKupoprodaja contract = UgovorKupoprodaja.deploy(  web3j, credentials, GAS_PRICE, GAS_LIMIT).send();
                System.out.println("contract  "+ contract.getContractAddress());
                contract.setRoba(roba.getOpis(), BigInteger.valueOf(roba.getKolicina()), BigDecimal.valueOf(roba.getCena()).toBigInteger(),
                        BigInteger.valueOf(roba.getRokIsporuke()), BigInteger.valueOf(roba.getRokIsporukeMax()), roba.getKupacOdgovoran(),
                        roba.getUputstvo(), roba.getNesaobraznostZamenom(), BigInteger.valueOf(roba.getRokOdPrelaskaRizikaNaKupca()),
                        BigInteger.valueOf(roba.getRokOdustanak()), BigInteger.valueOf(DeoRobe.valueOf(roba.getDeoRobe()).ordinal()), BigInteger.valueOf(roba.getRokVracanjaRobe()),
                        BigInteger.valueOf(roba.getRokVracanjaNovca()), BigInteger.valueOf(roba.getBrojPrimeraka()), BigInteger.valueOf(roba.getBrojPrimeraKupac())).send();
                System.out.println("roba  "+ contract.kolicinaRobe().send() + " cena " + contract.cena().send() + " " + contract.getSnosiTroskove().send());


                contract.setProdavac(u.get().getFirstName()+" " + u.get().getLastName(), u.get().getCity()).send();
                contract.setIsporuka(roba.getIzvrsiteljIsporuke(), BigInteger.valueOf(Strane.valueOf(roba.getTroskoveSnosi()).ordinal()), BigInteger.valueOf(Strane.valueOf(roba.getTroskoviOdustanak()).ordinal())).send();
                contract.prodavacSaglasan();
                roba=robaReposuitory.save(roba);

                ContractR contractR=new ContractR(contract.getContractAddress(), u.get(), roba);
                contractRService.save(contractR);

                /*System.out.println("Roba opis: " + roba.getOpis()+ "  kolicina " + BigInteger.valueOf(roba.getKolicina()) + " cena " + BigDecimal.valueOf(roba.getCena()).toBigInteger() + " rok ispo " +
                        BigInteger.valueOf(roba.getRokIsporuke()) + " rok isp max " + BigInteger.valueOf(roba.getRokIsporukeMax()) + " k odg " + roba.getKupacOdgovoran() + " uputstvo " +
                        roba.getUputstvo() + " zamena " + roba.getNesaobraznostZamenom() + " rok rizik " + BigInteger.valueOf(roba.getRokOdPrelaskaRizikaNaKupca()) + " rok odustanak " +
                        BigInteger.valueOf(roba.getRokOdustanak()) + " deo robe " + BigInteger.valueOf(DeoRobe.valueOf(roba.getDeoRobe().toUpperCase()).ordinal()) + " rok vracanja ro " + BigInteger.valueOf(roba.getRokVracanjaRobe()) + " rok vr n " +
                        BigInteger.valueOf(roba.getRokVracanjaNovca()) + " br prim " + BigInteger.valueOf(roba.getBrojPrimeraka()) + "  br prim k " + BigInteger.valueOf(roba.getBrojPrimeraKupac()));*/
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (CipherException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }else
            return false;

    }

    public List<Roba> findByVlasnik(String username){
        Optional<User> u = userRepository.findByUsername(username);
        if(u.isPresent()) {
            return robaReposuitory.findByVlasnikIdAndRobaProdata(u.get().getId(), false);
        }
        return null;
    }

    public List<Roba> findByVlasnikProdato(String username){
        Optional<User> u = userRepository.findByUsername(username);
        if(u.isPresent()) {
            return robaReposuitory.findByVlasnikIdAndRobaProdata(u.get().getId(), true);
        }
        return null;
    }

    public List<Roba> pretragaNaziv(String pretraga){

        return robaReposuitory.findByNazivContainingAndRobaProdata(pretraga, false);
    }

    public Roba getById (Long id){
        Optional<Roba> temp=robaReposuitory.findById(id);
        if(temp.isPresent())
            return temp.get();
        else
            return null;
    }

    public boolean kupovina(Long id, String username){
        Roba roba= getById(id);
        ContractR contractR=contractRService.findByRobaId(id);
        Optional<User> userO= userRepository.findByUsername(username);
        if (userO.isPresent() && !(userO.get().equals(roba.getVlasnik()))) {
            User user=userO.get();
           // credentials1 = Credentials.create(credentials1Address);
            BigDecimal amountInEther = BigDecimal.valueOf(3.0);
            web3j = Web3j.build(new HttpService());


            try {
                Credentials credentialsKupac = WalletUtils.loadCredentials(user.getPassword(), "w/" + user.getAddress());
               /* Credentials credentialsProdavac = WalletUtils.loadCredentials(roba.getVlasnik().getPassword(), "w/" + roba.getVlasnik().getAddress());

                TransactionReceipt transactionReceipt = Transfer.sendFunds(
                        web3j, credentials1, credentialsKupac.getAddress(),
                        amountInEther, Convert.Unit.ETHER).send();*/
                UgovorKupoprodaja contract = UgovorKupoprodaja.load(contractR.getAddress(), web3j, credentialsKupac, GAS_PRICE, GAS_LIMIT);
                contract.setKupac(credentialsKupac.getAddress(), user.getFirstName() + " " + user.getLastName(), user.getCity()).send();
                contract.saglasnostKupca().send();
                roba.setRobaProdata(true);
                robaReposuitory.save(roba);

                contractR.setKupac(user);
                contractRService.save(contractR);
            } catch (Exception e) {
                e.printStackTrace();
            }


            return true;
        }
        return false;
    }

    public boolean ukloni(Long id, String username){
        Roba roba= getById(id);
        Optional<User> userO= userRepository.findByUsername(username);
        if (userO.isPresent()){
            User user=userO.get();
            if (roba.getVlasnik().equals(user)){
                ContractR contractR=contractRService.findByRobaId(id);
                contractRService.delete(contractR);
                robaReposuitory.delete(roba);

            }

        }
        return false;
    }

    public boolean robaIsporucena(Long id, String username){
        Optional<User> userO= userRepository.findByUsername(username);
        if (userO.isPresent()){
            User user=userO.get();
            Roba roba= getById(id);
            ContractR contractR=contractRService.findByRobaId(id);

            if(contractR.getKupac().equals(user)){

                //  credentials1 = Credentials.create(credentials1Address);
                //  BigDecimal amountInEther = BigDecimal.valueOf(3.0);
                web3j = Web3j.build(new HttpService());
                Credentials credentialsKupac = null;
                try {
                    credentialsKupac = WalletUtils.loadCredentials(user.getPassword(), "w/" + user.getAddress());
                   /* TransactionReceipt transactionReceipt = Transfer.sendFunds(
                            web3j, credentials1, credentialsKupac.getAddress(),
                            amountInEther, Convert.Unit.ETHER).send();*/
                    UgovorKupoprodaja contract = UgovorKupoprodaja.load(contractR.getAddress(), web3j, credentialsKupac, GAS_PRICE, GAS_LIMIT);

                    contract.robaIsporucena().send();

                    roba.setRobaIsporucena(new Date());
                    robaReposuitory.save(roba);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CipherException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TransactionException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
        return false;
    }

    public boolean robaIsporucenaVracena(Long id, String username){
        Optional<User> userO= userRepository.findByUsername(username);
        if (userO.isPresent()){
            User user=userO.get();
            Roba roba= getById(id);
            ContractR contractR=contractRService.findByRobaId(id);

            if(contractR.getVlasnik().equals(user)){

                /*credentials1 = Credentials.create(credentials1Address);
                BigDecimal amountInEther = BigDecimal.valueOf(3.0);*/
                web3j = Web3j.build(new HttpService());
                Credentials credentialsProdavac = null;
                try {
                    credentialsProdavac = WalletUtils.loadCredentials(user.getPassword(), "w/" + user.getAddress());
                    /*TransactionReceipt transactionReceipt = Transfer.sendFunds(
                            web3j, credentials1, credentialsProdavac.getAddress(),
                            amountInEther, Convert.Unit.ETHER).send();*/
                    UgovorKupoprodaja contract = UgovorKupoprodaja.load(contractR.getAddress(), web3j, credentialsProdavac, GAS_PRICE, GAS_LIMIT);

                    contract.robaPrimljenaVracena().send();

                    roba.setRobaIsporucenaVracena(new Date());
                    robaReposuitory.save(roba);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CipherException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TransactionException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
        return false;
    }

    public boolean novacIsporucen(Long id, String username){
        Optional<User> userO= userRepository.findByUsername(username);
        if (userO.isPresent()){
            User user=userO.get();
            Roba roba= getById(id);
            ContractR contractR=contractRService.findByRobaId(id);

            if(contractR.getVlasnik().equals(user)){

                //credentials1 = Credentials.create(credentials1Address);
                BigDecimal amountInEther = BigDecimal.valueOf(3.0);
                web3j = Web3j.build(new HttpService());
                Credentials credentialsProdavac = null;
                try {
                    credentialsProdavac = WalletUtils.loadCredentials(user.getPassword(), "w/" + user.getAddress());
                    /*TransactionReceipt transactionReceipt = Transfer.sendFunds(
                            web3j, credentials1, credentialsProdavac.getAddress(),
                            amountInEther, Convert.Unit.ETHER).send();*/
                    UgovorKupoprodaja contract = UgovorKupoprodaja.load(contractR.getAddress(), web3j, credentialsProdavac, GAS_PRICE, GAS_LIMIT);

                    contract.novacUplacen().send();

                    roba.setNovacIsporucen(new Date());
                    robaReposuitory.save(roba);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CipherException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TransactionException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
        return false;
    }

    public boolean novacIsporucenVracen(Long id, String username){
        Optional<User> userO= userRepository.findByUsername(username);
        if (userO.isPresent()){
            User user=userO.get();
            Roba roba= getById(id);
            ContractR contractR=contractRService.findByRobaId(id);

            if(contractR.getKupac().equals(user)){

                //credentials1 = Credentials.create(credentials1Address);
               // BigDecimal amountInEther = BigDecimal.valueOf(3.0);
                web3j = Web3j.build(new HttpService());
                Credentials credentialsKupac = null;
                try {
                    credentialsKupac = WalletUtils.loadCredentials(user.getPassword(), "w/" + user.getAddress());
                    /*TransactionReceipt transactionReceipt = Transfer.sendFunds(
                            web3j, credentials1, credentialsKupac.getAddress(),
                            amountInEther, Convert.Unit.ETHER).send();*/
                    UgovorKupoprodaja contract = UgovorKupoprodaja.load(contractR.getAddress(), web3j, credentialsKupac, GAS_PRICE, GAS_LIMIT);

                    contract.novacVracen().send();

                    roba.setNovacIsporucenVracen(new Date());

                    roba.setRobaProdata(false);
                    roba.setNovacIsporucen(null);
                    roba.setRobaIsporucena(null);
                    roba.setRobaIsporucenaVracena(null);
                    robaReposuitory.save(roba);

                    contractR.setKupac(null);
                    contractRService.save(contractR);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CipherException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TransactionException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
        return false;
    }

    public boolean kupacNijePreuzeo(Long id, String username){
        Optional<User> userO= userRepository.findByUsername(username);
        if (userO.isPresent()){
            User user=userO.get();
            Roba roba= getById(id);
            ContractR contractR=contractRService.findByRobaId(id);

            if(contractR.getVlasnik().equals(user)){

                // credentials1 = Credentials.create(credentials1Address);
               // BigDecimal amountInEther = BigDecimal.valueOf(3.0);
                web3j = Web3j.build(new HttpService());
                Credentials credentialsProdavac = null;
                try {
                    credentialsProdavac = WalletUtils.loadCredentials(user.getPassword(), "w/" + user.getAddress());
                    /*TransactionReceipt transactionReceipt = Transfer.sendFunds(
                            web3j, credentials1, credentialsProdavac.getAddress(),
                            amountInEther, Convert.Unit.ETHER).send();*/
                    UgovorKupoprodaja contract = UgovorKupoprodaja.load(contractR.getAddress(), web3j, credentialsProdavac, GAS_PRICE, GAS_LIMIT);

                    contract.setKupacNijePreuzeo().send();

                    roba.setRobaProdata(false);
                    robaReposuitory.save(roba);

                    contractR.setKupac(null);
                    contractRService.save(contractR);

                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CipherException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TransactionException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
        return false;
    }

    public boolean kupacOdustanak(Long id, String username){
        Optional<User> userO= userRepository.findByUsername(username);
        if (userO.isPresent()){
            User user=userO.get();
            Roba roba= getById(id);
            ContractR contractR=contractRService.findByRobaId(id);

            if(contractR.getKupac().equals(user)){

               // credentials1 = Credentials.create(credentials1Address);
              //  BigDecimal amountInEther = BigDecimal.valueOf(3.0);
                web3j = Web3j.build(new HttpService());
                Credentials credentialsKupac = null;
                try {
                    credentialsKupac = WalletUtils.loadCredentials(user.getPassword(), "w/" + user.getAddress());
                   /* TransactionReceipt transactionReceipt = Transfer.sendFunds(
                            web3j, credentials1, credentialsKupac.getAddress(),
                            amountInEther, Convert.Unit.ETHER).send();*/
                    UgovorKupoprodaja contract = UgovorKupoprodaja.load(contractR.getAddress(), web3j, credentialsKupac, GAS_PRICE, GAS_LIMIT);

                    contract.odustanakKupac().send();
                    roba.setRobaIsporucena(null);
                    roba.setPravoSaobraznost(true);
                    robaReposuitory.save(roba);

                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CipherException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TransactionException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
        return false;
    }

    public boolean saobraznost(Long id, Boolean zamena, Boolean odustanak, Long umanjenje, String username){
        Optional<User> userO= userRepository.findByUsername(username);
        if (userO.isPresent()){
            User user=userO.get();
            Roba roba= getById(id);
            ContractR contractR=contractRService.findByRobaId(id);

            if(contractR.getKupac().equals(user) && roba.getPravoSaobraznost()==false){

                //credentials1 = Credentials.create(credentials1Address);
                //BigDecimal amountInEther = BigDecimal.valueOf(3.0);
                web3j = Web3j.build(new HttpService());
                Credentials credentialsKupac = null;
                try {
                    credentialsKupac = WalletUtils.loadCredentials(user.getPassword(), "w/" + user.getAddress());
                   /* TransactionReceipt transactionReceipt = Transfer.sendFunds(
                            web3j, credentials1, credentialsKupac.getAddress(),
                            amountInEther, Convert.Unit.ETHER).send();*/
                    UgovorKupoprodaja contract = UgovorKupoprodaja.load(contractR.getAddress(), web3j, credentialsKupac, GAS_PRICE, GAS_LIMIT);

                    contract.saobraznostKupac(odustanak, zamena, BigInteger.valueOf(umanjenje)).send();

                    if(odustanak){
                        kupacOdustanak(id, username);
                    }

                    if(umanjenje>0){
                        roba.setCena(roba.getCena()-umanjenje);
                    }

                    roba.setPravoSaobraznost(true);

                    robaReposuitory.save(roba);

                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (CipherException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TransactionException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

        }
        return false;
    }

    private boolean toBoolean(Long num){
        if(num==1)
            return true;
        else
            return false;
    }
}
