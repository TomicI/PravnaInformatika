package com.example.demo.contracts;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.http.HttpService;

import java.util.concurrent.ExecutionException;

public class Pomocna {

    Web3j web3j;

    public Pomocna() {
        web3j = Web3j.build(new HttpService());
    }

    public EthBlockNumber getBlockNumber()  {
        EthBlockNumber result = new EthBlockNumber();
        try {
            result = this.web3j.ethBlockNumber()
                    .sendAsync()
                    .get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

}
