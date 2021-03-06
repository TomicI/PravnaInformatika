package com.example.demo.contracts.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.5.14.
 */
@SuppressWarnings("rawtypes")
public class UgovorKupoprodaja extends Contract {
    public static final String BINARY = "60806040526001805460a060020a61ffff02191681556010805460ff191690911790556012805461ffff19908116909155601680549091166101001790556000601b819055601c819055601d819055601e5534801561005d57600080fd5b5060008054600160a060020a031916331790556116108061007f6000396000f30060806040526004361061023a5763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663112b38a7811461023f5780631cb572f814610256578063209822a1146102e0578063231d47a51461031957806326640d5f1461034057806326d7e8a01461035557806336bbd2fa146103b75780633c6521b0146103d957806348805254146103ee5780634ffca14a1461041757806351118c251461042c578063532dc27b1461044157806359fe01fd146104565780635e5f9ee61461046b5780636201b6411461048057806368982af6146104955780636e2601d11461052c5780636e8daa931461054157806371b921ad14610556578063760488eb1461056b5780637bdbe7cc146105805780637db368ac146105955780637feaa68e146105aa5780638aa593e1146105bf5780638e55a60f146105d45780638f20061a146105e95780638f782a06146105fe578063941ecf7f1461061357806398435a16146106285780639adda8cd1461063d578063a23cbc2414610652578063a5476ea014610667578063a67f63c614610719578063a75ce53d1461072e578063ab1694bf14610743578063b1e8c3f414610758578063b4ef55791461076d578063bcb66c3f14610782578063be05841214610797578063c411afe91461083c578063c5e5556f14610851578063dbb15e2514610866578063dc1f68641461087b578063f653b7ea14610890578063f9b4dc58146108a5578063fcd3f3ba146108ba578063ffebb7a8146108cf575b600080fd5b34801561024b57600080fd5b506102546108e4565b005b34801561026257600080fd5b5061026b61095f565b6040805160208082528351818301528351919283929083019185019080838360005b838110156102a557818101518382015260200161028d565b50505050905090810190601f1680156102d25780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b3480156102ec57600080fd5b506102f56109ed565b6040518082600181111561030557fe5b60ff16815260200191505060405180910390f35b34801561032557600080fd5b5061032e6109f7565b60408051918252519081900360200190f35b34801561034c57600080fd5b5061026b6109fd565b34801561036157600080fd5b506040805160206004803580820135601f8101849004840285018401909552848452610254943694929360249392840191908190840183828082843750949750508435955050506020909201359150610a589050565b3480156103c357600080fd5b5061025460043515156024351515604435610add565b3480156103e557600080fd5b5061032e610c2f565b3480156103fa57600080fd5b50610403610c35565b604080519115158252519081900360200190f35b34801561042357600080fd5b5061032e610c45565b34801561043857600080fd5b5061032e610c4b565b34801561044d57600080fd5b5061032e610c51565b34801561046257600080fd5b50610403610c57565b34801561047757600080fd5b5061032e610c60565b34801561048c57600080fd5b5061032e610c66565b3480156104a157600080fd5b506040805160206004803580820135601f810184900484028501840190955284845261025494369492936024939284019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a999881019791965091820194509250829150840183828082843750949750610c6c9650505050505050565b34801561053857600080fd5b50610403610c93565b34801561054d57600080fd5b5061026b610ca1565b34801561056257600080fd5b50610254610cf9565b34801561057757600080fd5b5061032e610dad565b34801561058c57600080fd5b5061032e610db3565b3480156105a157600080fd5b5061026b610db9565b3480156105b657600080fd5b50610403610e14565b3480156105cb57600080fd5b50610403610e22565b3480156105e057600080fd5b50610254610e2b565b3480156105f557600080fd5b50610254610ed0565b34801561060a57600080fd5b50610254610f60565b34801561061f57600080fd5b50610254610fb6565b34801561063457600080fd5b5061025461100c565b34801561064957600080fd5b506102546110cf565b34801561065e57600080fd5b50610403611170565b34801561067357600080fd5b506040805160206004803580820135601f8101849004840285018401909552848452610254943694929360249392840191908190840183828082843750949750508435955050506020830135926040810135925060608101359150608081013515159060a081013515159060c081013515159060e08101359061010081013590610120810135906101408101359061016081013590610180810135906101a00135611180565b34801561072557600080fd5b5061032e611255565b34801561073a57600080fd5b5061032e61125b565b34801561074f57600080fd5b5061026b611261565b34801561076457600080fd5b5061032e6112bc565b34801561077957600080fd5b5061032e6112c2565b34801561078e57600080fd5b5061026b6112c8565b3480156107a357600080fd5b5060408051602060046024803582810135601f8101859004850286018501909652858552610254958335600160a060020a031695369560449491939091019190819084018382808284375050604080516020601f89358b018035918201839004830284018301909452808352979a9998810197919650918201945092508291508401838280828437509497506113239650505050505050565b34801561084857600080fd5b5061032e611372565b34801561085d57600080fd5b50610254611378565b34801561087257600080fd5b5061026b6113ce565b34801561088757600080fd5b50610254611429565b34801561089c57600080fd5b5061032e61149f565b3480156108b157600080fd5b5061032e6114a5565b3480156108c657600080fd5b5061032e6114ab565b3480156108db57600080fd5b5061026b6114b1565b600154600160a060020a03163314610934576040805160e560020a62461bcd02815260206004820152601760248201526000805160206115c5833981519152604482015290519081900360640190fd5b6001805475ff000000000000000000000000000000000000000000191660a860020a17905542600855565b6011805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156109e55780601f106109ba576101008083540402835291602001916109e5565b820191906000526020600020905b8154815290600101906020018083116109c857829003601f168201915b505050505081565b60105460ff165b90565b601b5481565b6006805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156109e55780601f106109ba576101008083540402835291602001916109e5565b81600110158015610a6a575080600110155b1515610a7557600080fd5b816001811115610a8157fe5b6010805460ff191660018381811115610a9657fe5b0217905550806001811115610aa757fe5b6016805461ff001916610100836001811115610abf57fe5b02179055508251610ad790601190602086019061150c565b50505050565b600154600160a060020a03163314610b2d576040805160e560020a62461bcd02815260206004820152601760248201526000805160206115c5833981519152604482015290519081900360640190fd5b60015460a060020a900460ff168015610b4f575060015460a860020a900460ff165b1515610b5a57600080fd5b60135460155460085401014211158015610b7c5750601254610100900460ff16155b15610c2a57426009556001821515148015610ba45750601a5460ff6101009091041615156001145b15610bc6576000601e55426009556012805461ff001916610100179055610c2a565b60018315151415610c0857426009556001805475ff000000000000000000000000000000000000000000191690556012805461ff001916610100179055610c2a565b6000811115610c2a57600b805482900390556012805461ff0019166101001790555b505050565b60175481565b60015460a060020a900460ff1681565b600f5481565b60145481565b60155481565b601a5460ff1681565b60135481565b600d5481565b8151610c7f90600590602085019061150c565b508051610c2a90600790602084019061150c565b601254610100900460ff1681565b6002805460408051602060018416156101000260001901909316849004601f810184900484028201840190925281815292918301828280156109e55780601f106109ba576101008083540402835291602001916109e5565b600054600160a060020a03163314610d49576040805160e560020a62461bcd02815260206004820152601a60248201526000805160206115a5833981519152604482015290519081900360640190fd5b6000601e8190556001805475ff00ffffffffffffffffffffffffffffffffffffffff19169055604080516020810191829052829052610d8b916006919061150c565b50604080516020810191829052600090819052610daa9160049161150c565b50565b600e5481565b601c5481565b6007805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156109e55780601f106109ba576101008083540402835291602001916109e5565b601a54610100900460ff1681565b60125460ff1681565b600154600160a060020a03163314610e7b576040805160e560020a62461bcd02815260206004820152601760248201526000805160206115c5833981519152604482015290519081900360640190fd5b60015460a060020a900460ff168015610e9d575060015460a860020a900460ff165b1515610ea857600080fd5b601454600854014211610ece57426009556000601e556012805461ff0019166101001790555b565b600154600160a060020a03163314610f20576040805160e560020a62461bcd02815260206004820152601760248201526000805160206115c5833981519152604482015290519081900360640190fd5b60015460a060020a900460ff168015610f42575060015460a860020a900460ff165b1515610f4d57600080fd5b600f54600854014211610ece5742600955565b600054600160a060020a03163314610fb0576040805160e560020a62461bcd02815260206004820152601a60248201526000805160206115a5833981519152604482015290519081900360640190fd5b42601b55565b600054600160a060020a03163314611006576040805160e560020a62461bcd02815260206004820152601a60248201526000805160206115a5833981519152604482015290519081900360640190fd5b42601d55565b600054600160a060020a0316331461105c576040805160e560020a62461bcd02815260206004820152601a60248201526000805160206115a5833981519152604482015290519081900360640190fd5b60015460a060020a900460ff16801561107e575060015460a860020a900460ff165b151561108957600080fd5b60006009541115610ece5760008054604051600160a060020a0390911691303180156108fc02929091818181858888f19350505050158015610daa573d6000803e3d6000fd5b600154600160a060020a0316331461111f576040805160e560020a62461bcd02815260206004820152601760248201526000805160206115c5833981519152604482015290519081900360640190fd5b42601c556012805461ff00191690556000601e8190556001805475ff00ffffffffffffffffffffffffffffffffffffffff19169055604080516020810191829052829052610d8b916006919061150c565b60015460a860020a900460ff1681565b846001101561118e57600080fd5b8e600390805190602001906111a492919061150c565b50600a8e9055600b8d9055600c8c9055600d8b9055601a80546012805460ff199081168d151517909155168b15151761ff0019166101008a151502179055601587905560148690558460018111156111f857fe5b6016805460ff19166001838181111561120d57fe5b0217905550600f93909355600e9190915560175560185550506001805474ff0000000000000000000000000000000000000000191660a060020a179055505050505050505050565b600b5481565b601d5481565b6004805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156109e55780601f106109ba576101008083540402835291602001916109e5565b60095481565b601e5481565b6003805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156109e55780601f106109ba576101008083540402835291602001916109e5565b6001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a038516179055815161135e90600490602085019061150c565b508051610ad790600690602084019061150c565b60085481565b600154600160a060020a031633146113c8576040805160e560020a62461bcd02815260206004820152601760248201526000805160206115c5833981519152604482015290519081900360640190fd5b42601e55565b6005805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156109e55780601f106109ba576101008083540402835291602001916109e5565b600054600160a060020a03163314611479576040805160e560020a62461bcd02815260206004820152601a60248201526000805160206115a5833981519152604482015290519081900360640190fd5b6001805474ff0000000000000000000000000000000000000000191660a060020a179055565b600c5481565b600a5481565b60185481565b6019805460408051602060026001851615610100026000190190941693909304601f810184900484028201840190925281815292918301828280156109e55780601f106109ba576101008083540402835291602001916109e5565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061154d57805160ff191683800117855561157a565b8280016001018555821561157a579182015b8281111561157a57825182559160200191906001019061155f565b5061158692915061158a565b5090565b6109f491905b80821115611586576000815560010161159056006f6d6f6775c487656e6f206a6564696e6f2070726f64617663750000000000006f6d6f6775c487656e6f206a6564696e6f206b75706375000000000000000000a165627a7a72305820f7d30127a2f648d4ed776c6b2b1a42cfc0a803f4275ecced27f48535d772c8620029";

    public static final String FUNC_SAGLASNOSTKUPCA = "saglasnostKupca";

    public static final String FUNC_IZVRSITELJISPORUKE = "izvrsiteljIsporuke";

    public static final String FUNC_GETSNOSITROSKOVE = "getSnosiTroskove";

    public static final String FUNC_ROBAPRIMLJENAVRACENA = "robaPrimljenaVracena";

    public static final String FUNC_ADRESAKUPAC = "adresaKupac";

    public static final String FUNC_SETISPORUKA = "setIsporuka";

    public static final String FUNC_SAOBRAZNOSTKUPAC = "saobraznostKupac";

    public static final String FUNC_BROJPRIMERAKA = "brojPrimeraka";

    public static final String FUNC_PRODAVACSAGLASAN = "prodavacSaglasan";

    public static final String FUNC_ROKVRACANJAROBE = "rokVracanjaRobe";

    public static final String FUNC_ROKODUSTANAK = "rokOdustanak";

    public static final String FUNC_ROKODPRELASKARIZIKANAKUPCA = "rokOdPrelaskaRizikaNaKupca";

    public static final String FUNC_KUPACODGOVORANZASTETUNEPREUZIMANJA = "kupacOdgovoranZaStetuNepreuzimanja";

    public static final String FUNC_ROKSAOBRAZNOST = "rokSaobraznost";

    public static final String FUNC_ROKISPORUKEMAX = "rokIsporukeMax";

    public static final String FUNC_SETPRODAVAC = "setProdavac";

    public static final String FUNC_PRAVOSAOBRAZNOST = "pravoSaobraznost";

    public static final String FUNC_ROBA = "roba";

    public static final String FUNC_SETKUPACNIJEPREUZEO = "setKupacNijePreuzeo";

    public static final String FUNC_ROKVRACANJANOVCA = "rokVracanjaNovca";

    public static final String FUNC_NOVACVRACEN = "novacVracen";

    public static final String FUNC_ADRESAPRODAVAC = "adresaProdavac";

    public static final String FUNC_NESAOBRAZNOSTZAMENOM = "nesaobraznostZamenom";

    public static final String FUNC_UPUTSTVO = "uputstvo";

    public static final String FUNC_ODUSTANAKKUPAC = "odustanakKupac";

    public static final String FUNC_VRACANJEROBE = "vracanjeRobe";

    public static final String FUNC_SETROBAVRACENA = "setRobaVracena";

    public static final String FUNC_SETUPLACENO = "setUplaceno";

    public static final String FUNC_UPLATAPRODAVCAPOVRACAJ = "uplataProdavcaPovracaj";

    public static final String FUNC_SETUPLACENOVRACENO = "setUplacenoVraceno";

    public static final String FUNC_KUPACSAGLASAN = "kupacSaglasan";

    public static final String FUNC_SETROBA = "setRoba";

    public static final String FUNC_CENA = "cena";

    public static final String FUNC_NOVACUPLACEN = "novacUplacen";

    public static final String FUNC_PODACIKUPAC = "podaciKupac";

    public static final String FUNC_ROBAVRACENADANA = "robaVracenaDana";

    public static final String FUNC_ROBAISPORUCENA = "robaIsporucena";

    public static final String FUNC_OPISROBE = "opisRobe";

    public static final String FUNC_SETKUPAC = "setKupac";

    public static final String FUNC_ZAKLJUCENDANA = "zakljucenDana";

    public static final String FUNC_SETROBAISPORUCENA = "setRobaIsporucena";

    public static final String FUNC_PODACIPRODAVAC = "podaciProdavac";

    public static final String FUNC_SAGLASNOSTPRODAVCA = "saglasnostProdavca";

    public static final String FUNC_ROKISPORUKE = "rokIsporuke";

    public static final String FUNC_KOLICINAROBE = "kolicinaRobe";

    public static final String FUNC_BROJPRIMERAKAKUPAC = "brojPrimerakaKupac";

    public static final String FUNC_ZAKLJUCENU = "zakljucenU";

    @Deprecated
    protected UgovorKupoprodaja(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected UgovorKupoprodaja(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected UgovorKupoprodaja(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected UgovorKupoprodaja(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> saglasnostKupca() {
        final Function function = new Function(
                FUNC_SAGLASNOSTKUPCA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> izvrsiteljIsporuke() {
        final Function function = new Function(FUNC_IZVRSITELJISPORUKE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> getSnosiTroskove() {
        final Function function = new Function(FUNC_GETSNOSITROSKOVE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> robaPrimljenaVracena() {
        final Function function = new Function(FUNC_ROBAPRIMLJENAVRACENA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> adresaKupac() {
        final Function function = new Function(FUNC_ADRESAKUPAC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setIsporuka(String _izvrsiteljIsporuke, BigInteger strana, BigInteger _troskoviOdustanak) {
        final Function function = new Function(
                FUNC_SETISPORUKA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_izvrsiteljIsporuke), 
                new org.web3j.abi.datatypes.generated.Uint256(strana), 
                new org.web3j.abi.datatypes.generated.Uint256(_troskoviOdustanak)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> saobraznostKupac(Boolean _raskiniUgovor, Boolean _zamena, BigInteger umanjenjaCena) {
        final Function function = new Function(
                FUNC_SAOBRAZNOSTKUPAC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Bool(_raskiniUgovor), 
                new org.web3j.abi.datatypes.Bool(_zamena), 
                new org.web3j.abi.datatypes.generated.Uint256(umanjenjaCena)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> brojPrimeraka() {
        final Function function = new Function(FUNC_BROJPRIMERAKA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> prodavacSaglasan() {
        final Function function = new Function(FUNC_PRODAVACSAGLASAN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> rokVracanjaRobe() {
        final Function function = new Function(FUNC_ROKVRACANJAROBE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> rokOdustanak() {
        final Function function = new Function(FUNC_ROKODUSTANAK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> rokOdPrelaskaRizikaNaKupca() {
        final Function function = new Function(FUNC_ROKODPRELASKARIZIKANAKUPCA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Boolean> kupacOdgovoranZaStetuNepreuzimanja() {
        final Function function = new Function(FUNC_KUPACODGOVORANZASTETUNEPREUZIMANJA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> rokSaobraznost() {
        final Function function = new Function(FUNC_ROKSAOBRAZNOST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> rokIsporukeMax() {
        final Function function = new Function(FUNC_ROKISPORUKEMAX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setProdavac(String _podaciProdavac, String _adresaProdavac) {
        final Function function = new Function(
                FUNC_SETPRODAVAC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_podaciProdavac), 
                new org.web3j.abi.datatypes.Utf8String(_adresaProdavac)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> pravoSaobraznost() {
        final Function function = new Function(FUNC_PRAVOSAOBRAZNOST, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> roba() {
        final Function function = new Function(FUNC_ROBA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setKupacNijePreuzeo() {
        final Function function = new Function(
                FUNC_SETKUPACNIJEPREUZEO, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> rokVracanjaNovca() {
        final Function function = new Function(FUNC_ROKVRACANJANOVCA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> novacVracen() {
        final Function function = new Function(FUNC_NOVACVRACEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> adresaProdavac() {
        final Function function = new Function(FUNC_ADRESAPRODAVAC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> nesaobraznostZamenom() {
        final Function function = new Function(FUNC_NESAOBRAZNOSTZAMENOM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Boolean> uputstvo() {
        final Function function = new Function(FUNC_UPUTSTVO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> odustanakKupac() {
        final Function function = new Function(
                FUNC_ODUSTANAKKUPAC, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> vracanjeRobe() {
        final Function function = new Function(
                FUNC_VRACANJEROBE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setRobaVracena() {
        final Function function = new Function(
                FUNC_SETROBAVRACENA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setUplaceno() {
        final Function function = new Function(
                FUNC_SETUPLACENO, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> uplataProdavcaPovracaj() {
        final Function function = new Function(
                FUNC_UPLATAPRODAVCAPOVRACAJ, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> setUplacenoVraceno() {
        final Function function = new Function(
                FUNC_SETUPLACENOVRACENO, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> kupacSaglasan() {
        final Function function = new Function(FUNC_KUPACSAGLASAN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setRoba(String _opisRobe, BigInteger _kolicinaRobe, BigInteger _cena, BigInteger _rokIsporuke, BigInteger _rokIsporukeMax, Boolean _kupacOdg, Boolean _uputstvo, Boolean _nesaobraznostZamenom, BigInteger _rokOdPrelaskaRizikaNaKupca, BigInteger _rokOdustanak, BigInteger _deoRobe, BigInteger _rokVracanjaRobe, BigInteger _rokVracanjaNovca, BigInteger _brojPrimeraka, BigInteger _brojPrimerakaKupac) {
        final Function function = new Function(
                FUNC_SETROBA, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_opisRobe), 
                new org.web3j.abi.datatypes.generated.Uint256(_kolicinaRobe), 
                new org.web3j.abi.datatypes.generated.Uint256(_cena), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokIsporuke), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokIsporukeMax), 
                new org.web3j.abi.datatypes.Bool(_kupacOdg), 
                new org.web3j.abi.datatypes.Bool(_uputstvo), 
                new org.web3j.abi.datatypes.Bool(_nesaobraznostZamenom), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokOdPrelaskaRizikaNaKupca), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokOdustanak), 
                new org.web3j.abi.datatypes.generated.Uint256(_deoRobe), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokVracanjaRobe), 
                new org.web3j.abi.datatypes.generated.Uint256(_rokVracanjaNovca), 
                new org.web3j.abi.datatypes.generated.Uint256(_brojPrimeraka), 
                new org.web3j.abi.datatypes.generated.Uint256(_brojPrimerakaKupac)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> cena() {
        final Function function = new Function(FUNC_CENA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> novacUplacen() {
        final Function function = new Function(FUNC_NOVACUPLACEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> podaciKupac() {
        final Function function = new Function(FUNC_PODACIKUPAC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> robaVracenaDana() {
        final Function function = new Function(FUNC_ROBAVRACENADANA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> robaIsporucena() {
        final Function function = new Function(FUNC_ROBAISPORUCENA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> opisRobe() {
        final Function function = new Function(FUNC_OPISROBE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setKupac(String _kupac, String _podaciKupac, String _adresaKupac) {
        final Function function = new Function(
                FUNC_SETKUPAC, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _kupac), 
                new org.web3j.abi.datatypes.Utf8String(_podaciKupac), 
                new org.web3j.abi.datatypes.Utf8String(_adresaKupac)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> zakljucenDana() {
        final Function function = new Function(FUNC_ZAKLJUCENDANA, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> setRobaIsporucena() {
        final Function function = new Function(
                FUNC_SETROBAISPORUCENA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> podaciProdavac() {
        final Function function = new Function(FUNC_PODACIPRODAVAC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> saglasnostProdavca() {
        final Function function = new Function(
                FUNC_SAGLASNOSTPRODAVCA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> rokIsporuke() {
        final Function function = new Function(FUNC_ROKISPORUKE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> kolicinaRobe() {
        final Function function = new Function(FUNC_KOLICINAROBE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> brojPrimerakaKupac() {
        final Function function = new Function(FUNC_BROJPRIMERAKAKUPAC, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> zakljucenU() {
        final Function function = new Function(FUNC_ZAKLJUCENU, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static UgovorKupoprodaja load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new UgovorKupoprodaja(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static UgovorKupoprodaja load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new UgovorKupoprodaja(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static UgovorKupoprodaja load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new UgovorKupoprodaja(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static UgovorKupoprodaja load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new UgovorKupoprodaja(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<UgovorKupoprodaja> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UgovorKupoprodaja.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<UgovorKupoprodaja> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(UgovorKupoprodaja.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UgovorKupoprodaja> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UgovorKupoprodaja.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<UgovorKupoprodaja> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(UgovorKupoprodaja.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
