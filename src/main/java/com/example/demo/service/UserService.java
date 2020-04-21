package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.*;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCoinbase;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    Web3j web3j;
    Credentials credentials, credentials1;

    @Value("10000")
    private int expires;

    @Value("secret")
    private String secret;

    String credentials1Address="0xdf1f4ecb742708b0d5a4c9df01d47d91d4967eb8ca42467c30270857204a1329";



    public boolean checkIfEmailExists(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    public boolean saveUser(User user){
        if(userRepository.existsByEmail(user.getEmail())==false && userRepository.existsByUsername(user.getUsername())==false){
            String pass=user.getPassword();
            user.setPassword(getEncoder().encode(pass));
            web3j = Web3j.build(new HttpService());
            try {
                File f=new File("w/");
                String file = WalletUtils.generateFullNewWalletFile(user.getPassword(), f);
                System.out.println("file " + f.getAbsolutePath());
               /* credentials = WalletUtils.loadCredentials(user.getPassword(), "w/" + file);
                EthCoinbase coinbase = web3j.ethCoinbase().send();
                EthGetTransactionCount transactionCount = web3j.ethGetTransactionCount(credentials.getAddress(), DefaultBlockParameterName.LATEST).sendAsync().get();
                Transaction transaction = Transaction.createEtherTransaction(credentials.getAddress(), transactionCount.getTransactionCount(), BigInteger.valueOf(20_000_000_000L), BigInteger.valueOf(21_000), credentials.getAddress(), BigInteger.valueOf(25_000_000_000_000_000L));
                web3j.ethSendTransaction(transaction).send();
                EthGetBalance balance = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                System.out.println("Balance: {}" + balance.getBalance().longValue());*/
                user.setAddress(file);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (NoSuchProviderException e) {
                e.printStackTrace();
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            } catch (CipherException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            userRepository.save(user);
            return true;
        } else
            return false;
    }

    public String loginCheck( User user) {

        if (userRepository.existsByUsername(user.getUsername())){
            User pom = userRepository.findByUsername(user.getUsername()).get();
            if(getEncoder().matches(user.getPassword(), pom.getPassword())) {
                String jwt = Jwts.builder()
                        .setIssuer("projekatPravna")
                        .setSubject((user.getUsername()))
                        .setIssuedAt(new Date())
                        .setExpiration(new Date((new Date()).getTime() + expires * 1000))
                        .signWith(SignatureAlgorithm.HS512, secret)
                        .compact();
                web3j = Web3j.build(new HttpService());
                try {
                    credentials = WalletUtils.loadCredentials(pom.getPassword(), "w/" + pom.getAddress());
                    credentials1=Credentials.create(credentials1Address);
                    BigDecimal amountInEther = BigDecimal.valueOf(3.0);
                    TransactionReceipt transactionReceipt = Transfer.sendFunds(
                            web3j, credentials1, credentials.getAddress(),
                            amountInEther, Convert.Unit.ETHER).send();
                    EthGetBalance balance1 = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                    System.out.println("Balance1: {}" + balance1.getBalance().longValue());

                    EthGetBalance balance = web3j.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();

                    System.out.println("Balance: {}" + balance.getBalance().longValue());
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
                return jwt;
            }else
                return "error";
        } else
            return "error";

    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username).get();
    }


    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
